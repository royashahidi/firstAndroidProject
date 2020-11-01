package com.sematec.myapplication.models

import com.sematec.basic.utils.Constants
import com.sematec.myapplication.api.WebService
import com.sematec.myapplication.interfaces.RecyclerInterface

class RecyclerModel(val presenter: RecyclerInterface.Presenter) : RecyclerInterface.Model {

    override fun getImages() {

        val imagesCall = WebService.api.getImages(
            word = "computer",
            key = Constants.PIXABAY_API_KEY
        ).execute()

        if (imagesCall.isSuccessful)
            if (imagesCall.body()?.hits?.isNotEmpty() == true) {
                presenter.onImagesResult(imagesCall.body()?.hits!!)
                return
            }
        presenter.onError("error in Server")

    }

    override fun getActions()  {
         val actions = listOf(
             "Sport" , "Entertainment" , "History" , "Magazine" , "Economy","Politic"
         )
        presenter.onActionsResult(actions)
    }
}