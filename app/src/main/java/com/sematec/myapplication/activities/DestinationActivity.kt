package com.sematec.myapplication.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sematec.myapplication.R
import kotlinx.android.synthetic.main.activity_destination.*

class DestinationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        val country = intent.getStringExtra("country")
        val age = intent.getIntExtra("age", 0)

        txtCountry.text = country
        txtAge.text = age.toString()


        btnBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }


    }


}