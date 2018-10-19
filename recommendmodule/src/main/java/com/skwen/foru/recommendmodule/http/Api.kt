package com.skwen.foru.recommendmodule.http

import com.skwen.foru.recommendmodule.model.category.ResultCateGory
import com.skwen.foru.recommendmodule.model.recommend.ResultRecommend
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api{

    /**
     * 视频分类推荐接口
     */
    @GET("/videoCategory")
    fun getRecommendListData():Call<ResultCateGory>

    /**
     * 视频分类推荐接口（通过id获取内容）
     */
    @GET("/videoCategoryDetails")
    fun getRecommendData(@Query("id") id:Int):Call<ResultRecommend>

}