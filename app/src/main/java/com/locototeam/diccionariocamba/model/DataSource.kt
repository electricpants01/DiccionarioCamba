package com.locototeam.diccionariocamba.model

import com.locototeam.diccionariocamba.R

class DataSource {

    fun loadImages(): List<ImageSC> = listOf<ImageSC>(
        ImageSC(R.drawable.image1),
        ImageSC(R.drawable.image2),
        ImageSC(R.drawable.image3),
        ImageSC(R.drawable.image4),
        ImageSC(R.drawable.image5),
    )
}