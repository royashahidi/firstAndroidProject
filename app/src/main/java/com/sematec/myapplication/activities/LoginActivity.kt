package com.sematec.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.myapplication.R
import com.sematec.myapplication.interfaces.LoginInterface
import com.sematec.myapplication.entities.UserEnity
import com.sematec.myapplication.entities.VehicleEntity
import com.sematec.myapplication.presenters.LoginPresenter
import com.sematec.myapplication.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginInterface.View {

    lateinit var presenter: LoginInterface.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(this)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            presenter.login(
                username = txtUserName.text.toString(), password = txtPassword.text.toString()
            )
        }
    }

    override fun onLoginSuccess(data: UserEnity?) {
        runOnUiThread {
            data?.access_token?.toast()
        }
    }

    override fun onLoginFailed(msg: String) {
        runOnUiThread {
            msg.toast()
        }
    }

    override fun onLoading(show: Boolean) {

    }

    override fun onVehicles(vehicles: List<VehicleEntity>?) {
        runOnUiThread {
            vehicles?.get(0).toString().toast()
        }
    }
}