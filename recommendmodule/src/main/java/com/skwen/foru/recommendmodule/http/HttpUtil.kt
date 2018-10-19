package com.skwen.foru.recommendmodule.http

import com.skwen.foru.basemodule.util.SimpleHttpUtil
import com.skwen.foru.recommendmodule.model.category.Item
import com.skwen.foru.recommendmodule.model.category.ResultCateGory
import com.skwen.foru.recommendmodule.model.recommend.ResultRecommend
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HttpUtil {

    private var id = 28

    private var hasGetId = false

    private var list: List<Item>? = null

    private object Holder {
        var instance = HttpUtil()
    }

    companion object {
        fun getInstance(): HttpUtil {
            return Holder.instance
        }
    }

    init {
        if (!hasGetId) {
            getRecommendListData(object : Callback<ResultCateGory> {
                override fun onFailure(call: Call<ResultCateGory>, t: Throwable) {
                    hasGetId = false
                    id = 14
                }

                override fun onResponse(call: Call<ResultCateGory>, response: Response<ResultCateGory>) {
                    if (response.isSuccessful) {
                        hasGetId = true
                        list = response.body()!!.result.itemList
                    } else {
                        hasGetId = false
                    }
                }

            })
        }
    }

    private fun getRandomId(): Int {
        return if (hasGetId) {
            val i: Int = (Math.random() * list?.size!!).toInt()
            list!![i].id
        } else {
            id
        }
    }


    private fun getRecommendListData(callback: Callback<ResultCateGory>) {
        SimpleHttpUtil
                .getInstance()
                .getApi(Api::class.java)
                .getRecommendListData()
                .enqueue(callback)
    }

    fun getRecommendData(callback: Callback<ResultRecommend>) {
        SimpleHttpUtil
                .getInstance()
                .getApi(Api::class.java)
                .getRecommendData(getRandomId())
                .enqueue(callback)
    }

}