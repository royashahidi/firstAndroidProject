package com.sematec.myapplication.api

import com.sematec.myapplication.entities.LoginRequestEntity
import com.sematec.myapplication.entities.PixabayEntity
import com.sematec.myapplication.entities.UserEnity
import com.sematec.myapplication.entities.VehicleEntity
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("http://amirteymoori.ir/parkup/public/api/login")
    fun login(
        @Body request: LoginRequestEntity
    ): Call<UserEnity>


    @GET("http://amirteymoori.ir/parkup/public/api/vehicles")
    fun getVehicles(
        @Header("Authorization") token: String
    ): Call<List<VehicleEntity>>

    @GET("https://pixabay.com/api/")
    fun getImages(
        // @Path("api_version") apiVersion: String
        @Query("key") key: String,
        @Query("q") word: String
    ): Call<PixabayEntity>
}