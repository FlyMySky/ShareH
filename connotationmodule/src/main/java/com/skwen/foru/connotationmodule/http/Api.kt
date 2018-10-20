package com.skwen.foru.connotationmodule.http

import com.skwen.foru.connotationmodule.model.ResultBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET("/satinGodApi")
    fun getDataByType(@Query("type") type: Int, @Query("page") page: Int): Call<ResultBean>


}