package com.locotoDevTeam.diccionariocamba.view.mainFragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.locotoDevTeam.diccionariocamba.R
import com.locotoDevTeam.diccionariocamba.adapter.ItemDictionaryAdapter
import com.locotoDevTeam.diccionariocamba.databinding.FragmentMainBinding
import com.locotoDevTeam.diccionariocamba.model.Dictionary
import com.locotoDevTeam.diccionariocamba.utils.viewBinding
import com.locotoDevTeam.diccionariocamba.view.detail.DetailFragment
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

//    // Launcher for the SCHEDULE_EXACT_ALARM permission request
//    val alarmPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            // Permission was granted, schedule the alarm
//            checkAndScheduleAlarm()
//        } else {
//            // Permission was denied
//            Toast.makeText(requireContext(), "Permiso de alarma denegado", Toast.LENGTH_SHORT).show()
//        }
//    }

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

//    private fun showAlarmPermissionRationaleDialog() {
//        MaterialAlertDialogBuilder(requireContext())
//            .setTitle("Permiso de Alarma Requerido")
//            .setMessage("Este permiso es necesario para programar alarmas precisas. ¿Quieres otorgar el permiso?")
//            .setPositiveButton("Sí") { dialog, which ->
//                checkAndRequestExactAlarmPermission()
//                dialog.dismiss()
//            }
//            .setNegativeButton("No") { dialog, which ->
//                dialog.dismiss()
//            }
//            .show()
//    }
//
//    private fun hasExactAlarmPermission(): Boolean {
//        val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            alarmManager.canScheduleExactAlarms()
//        } else {
//            true // Older versions don't require this permission
//        }
//    }
//
//    // Method to check and request the exact alarm permission
//    private fun checkAndRequestExactAlarmPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            if (!alarmManager.canScheduleExactAlarms()) {
//                // Launch the settings to request the permission
//                val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
//                alarmPermissionLauncher.launch(intent)
//            } else {
//                // Permission already granted, schedule the alarm
//                checkAndScheduleAlarm()
//            }
//        } else {
//            // Older versions don't require this permission, schedule the alarm
//            checkAndScheduleAlarm()
//        }
//    }
//
//    // Method to schedule the alarm (if permission is granted)
//    private fun checkAndScheduleAlarm() {
//        AlarmSchedulerImpl(requireContext()).schedule()
//        Toast.makeText(
//            requireContext(),
//            "Alarma programada con éxito",
//            Toast.LENGTH_SHORT
//        ).show()
//    }

    private fun initSubscriptions() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewmodel.uiState.collectLatest {
                println("chris entro a collect")
                adapter.updateList(it.dictionaryList)
            }
        }
    }
}