package com.sematec.myapplication.interfaces

import com.sematec.myapplication.entities.UserEnity
import com.sematec.myapplication.entities.VehicleEntity

interface LoginInterface {

    interface View {
        fun onLoginSuccess(data: UserEnity?)
        fun onLoginFailed(msg: String)
        fun onLoading(show: Boolean)
        fun onVehicles(vehicles: List<VehicleEntity>?)
    }

    interface Presenter {
        fun login(username: String, password: String)
    }
}