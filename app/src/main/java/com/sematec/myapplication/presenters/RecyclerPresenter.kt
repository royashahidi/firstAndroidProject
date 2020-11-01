package com.sematec.myapplication.presenters

import com.sematec.myapplication.entities.HitsEntity
import com.sematec.myapplication.interfaces.RecyclerInterface
import com.sematec.myapplication.models.RecyclerModel

class RecyclerPresenter(val view: RecyclerInterface.View) : RecyclerInterface.Presenter {

    lateinit var model: RecyclerInterface.Model

    init {
        model = RecyclerModel(this)
    }

    override fun onViewCreated() {
        Thread{
            model.getImages()
            model.getActions()
        }.start()
    }

    override fun onImagesResult(images: List<HitsEntity>) {
        view.onImagesResult(images)
    }

    override fun onActionsResult(actions: List<String>) {
         view.onActionsResult(actions)
    }

    override fun onError(msg: String?) {
        view.onError(msg)
    }
}