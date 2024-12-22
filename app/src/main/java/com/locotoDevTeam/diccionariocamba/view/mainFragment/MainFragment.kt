package com.locotoDevTeam.diccionariocamba.view.mainFragment

import android.Manifest
import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.broadcast.AlarmSchedulerImpl
import com.locotoDevTeam.diccionariocamba.databinding.FragmentMainBinding
import com.locotoDevTeam.diccionariocamba.utils.viewBinding
import com.locotoDevTeam.diccionariocamba.view.detail.DetailFragment
import com.locotoinnovations.core.model.Dictionary
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment(), ItemDictionaryAdapter.OnItemClickListener {

    private val viewmodel: MainFragmentViewModel by viewModels()
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val adapter get() = binding.recyclerView.adapter as ItemDictionaryAdapter

    // Launcher for the notification permission request
    val launcher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // permission granted
            // Update the button state to hide it
        } else {
            // permission denied or forever denied
        }
    }

    // Launcher for the SCHEDULE_EXACT_ALARM permission request
    val alarmPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // After returning from the settings, check if the permission is granted
        val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && alarmManager.canScheduleExactAlarms()) {
            // Permission was granted, schedule the alarm
            checkAndScheduleAlarm()
        } else {
            // Permission was denied or not granted
            Toast.makeText(requireContext(), "Permiso de alarma denegado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initSearchView()
        initSubscriptions()
        requestNotificationPermission()
        if (shouldShowAlarmExactPermission()) {
            showAlarmPermissionRationaleDialog()
        }
    }

    private fun initSearchView() {
        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
            binding.searchView.onActionViewExpanded()
        }

        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewmodel.updateSearchText(newText!!)
                return false
            }
        })
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        ItemDictionaryAdapter(this, emptyList()).apply {
            binding.recyclerView.adapter = this
        }
    }

    override fun onItemClick(item: Dictionary) {
        val dialog = DetailFragment.newInstance(item.id)
        dialog.show(childFragmentManager, "detailFragment")
    }

    private fun requestNotificationPermission() {
        if (requireContext().checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            // permission already granted
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // show rationale and then launch launcher to request permission
            } else {
                // first request or forever denied case
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        }
    }

    private fun showAlarmPermissionRationaleDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Permiso para enviar notificaciones")
            .setMessage("Este permiso es necesario para tener la full experience de Diccionario Camba. ¿Quieres otorgar el permiso?")
            .setPositiveButton("Sí") { dialog, which ->
                checkAndRequestExactAlarmPermission()
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    private fun shouldShowAlarmExactPermission(): Boolean {
        val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Return false if the permission is granted, otherwise true
            !alarmManager.canScheduleExactAlarms()
        } else {
            false // For older versions, assume permission is always granted
        }
    }

    // Method to check and request the exact alarm permission
    private fun checkAndRequestExactAlarmPermission() {
        val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
        alarmPermissionLauncher.launch(intent)
    }

    // Method to schedule the alarm (if permission is granted)
    private fun checkAndScheduleAlarm() {
        AlarmSchedulerImpl(requireContext()).schedule()
        Toast.makeText(
            requireContext(),
            "Alarma programada con éxito",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun initSubscriptions() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewmodel.uiState.collectLatest {
                adapter.updateList(it.dictionaryList)
            }
        }
    }
}