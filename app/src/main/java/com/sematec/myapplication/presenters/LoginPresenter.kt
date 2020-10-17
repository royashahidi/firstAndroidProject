package com.sematec.myapplication.presenters

import com.sematec.myapplication.api.WebService
import com.sematec.myapplication.entities.LoginRequestEntity
import com.sematec.myapplication.interfaces.LoginInterface
import com.sematec.myapplication.utils.AppUtils


class LoginPresenter(val view: LoginInterface.View) : LoginInterface.Presenter {

    override fun login(username: String, password: String) {
        Thread {
            val apiCall = WebService.api.login(
                LoginRequestEntity(
                    username = username, password = password
                )
            ).execute()

            when {
                apiCall.isSuccessful -> {
                    AppUtils.setData("token", apiCall.body()?.access_token)
                    view.onLoginSuccess(apiCall.body())
                    getVehicles()
                }
                apiCall.code() == 401 -> {
                    view.onLoginFailed("UNAUTHORIZED")
                }
                else -> {
                    view.onLoginFailed("INTERNAL SERVER ERROR")
                }
            }
        }.start()

    }


    private fun getVehicles() {
        val token = AppUtils.getData("token")
        val apiCall = WebService.api.getVehicles(
            token = "Bearer $token"
        ).execute()
        if (apiCall.isSuccessful) {
            val vehicles = apiCall.body()
            view.onVehicles(vehicles)
        }else{
            view.onLoginFailed("LOGIN FAILED")
        }
    }
}