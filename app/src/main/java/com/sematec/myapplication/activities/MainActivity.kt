package com.sematec.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sematec.basic.utils.Constants.Companion.MIN_FIRSTNAME_VALID_SIZE
import com.sematec.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegister.setOnClickListener {
         val myNameValue = txtFirstName.text.toString()

            if (myNameValue.length < MIN_FIRSTNAME_VALID_SIZE) {
                txtFirstName.error = getString(R.string.firstname_invalid)
                return@setOnClickListener
            }

            val destinationIntent = Intent(this, DestinationActivity::class.java)
            destinationIntent.putExtra("country", R.string.country)
            destinationIntent.putExtra("age", 34)

            startActivity(destinationIntent)
     }

        Log.d("ActivityLifeCycle: ", "onCreate")
        Timber.tag("ActivityLifeCycle: ").d("onCreate");
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifeCycle: ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifeCycle: ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifeCycle: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifeCycle: ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifeCycle: ", "onDestroy")
    }
}