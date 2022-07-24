package com.locotoDevTeam.diccionariocamba.model

import com.locotoDevTeam.diccionariocamba.R

class DataSource {

    fun loadImages(): List<ImageSC> = listOf<ImageSC>(
        ImageSC(R.drawable.image1),
        ImageSC(R.drawable.image2),
        ImageSC(R.drawable.image3),
        ImageSC(R.drawable.image4),
        ImageSC(R.drawable.image5),
    )

    fun loadDatabaseFirstTime(): List<Dictionary> = listOf<Dictionary>(
        Dictionary(1, "Acopaibao", "Se le dice al individuo torpe, de reacciones tardías."),
        Dictionary(2, "Afiltracao", "Bien vestido."),
    )

}