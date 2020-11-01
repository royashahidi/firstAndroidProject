package com.sematec.myapplication.interfaces

import com.sematec.myapplication.entities.HitsEntity

interface RecyclerInterface {

    interface View {
        fun onImagesResult(images: List<HitsEntity>)
        fun onError(msg: String?)
        fun onActionsResult(actions: List<String>)
    }

    interface Presenter {
        fun onViewCreated()
        fun onImagesResult(images: List<HitsEntity>)
        fun onActionsResult(actions: List<String>)
        fun onError(msg: String?)
    }

    interface Model {
        fun getImages()
        fun getActions()

    }


}