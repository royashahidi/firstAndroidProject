package com.sematec.myapplication.utils

import android.widget.Toast
import com.sematec.myapplication.MyApplication

fun String.toast(){
    Toast.makeText(MyApplication.context , this , Toast.LENGTH_LONG).show()
}