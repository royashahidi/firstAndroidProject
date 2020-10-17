package com.sematec.myapplication.utils

import com.orhanobut.hawk.Hawk

class AppUtils {
    companion object {

        fun setData(key: String, value: String?) {
            Hawk.put(key, value)
        }

        fun getData(key: String) = Hawk.get<String>(key)
    }
}