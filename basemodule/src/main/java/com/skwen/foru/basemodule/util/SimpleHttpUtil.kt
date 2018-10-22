package com.skwen.foru.basemodule.util

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SimpleHttpUtil private constructor() {

    private var retrofit:Retrofit? = null

    private object Holder {
        var instance = SimpleHttpUtil()
    }

    companion object {
        fun getInstance() = Holder.instance
    }

    init {
        initHttp()
    }

    private fun initHttp() {
        retrofit = Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    fun <T> getApi(service:Class<T>) : T{
        return retrofit!!.create(service)
    }

}