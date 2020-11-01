package com.sematec.myapplication.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.sematec.myapplication.MyApplication
import com.sematec.myapplication.R

fun String.toast(){
    Toast.makeText(MyApplication.context , this , Toast.LENGTH_LONG).show()
}

fun ImageView.load(ctx: Context, url: String) {
    Glide
        .with(ctx)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.material)
        .into(this)
}