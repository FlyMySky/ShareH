package com.skwen.foru.connotationmodule.http

import com.skwen.foru.basemodule.util.Const
import com.skwen.foru.basemodule.util.SimpleHttpUtil
import com.skwen.foru.connotationmodule.model.ResultBean
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HttpUtil {

    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(Const.getBaseUrl(Const.connotationType))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private object Holder {
        var instance = HttpUtil()
    }

    companion object {
        var instance = Holder.instance
    }

    private fun <T> getApi(service: Class<T>): T {
        return retrofit!!.create(service)
    }


    fun getDataByType(type: Int, page: Int, callback: Callback<ResultBean>) {
        getApi(Api::class.java)
                .getDataByType(type, page)
                .enqueue(callback)
    }

}