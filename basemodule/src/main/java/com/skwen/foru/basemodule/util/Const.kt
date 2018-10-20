package com.skwen.foru.basemodule.util

object Const {

    var recommendType = 0
    var connotationType = 1

    var BASE_URL: String = "http://api.apiopen.top/"


    var CATEGORY_PATH: String = "/videoCategory"


    var CATEGORY_LIST_DATA_PATH: String = "/videoCategoryDetails"


    fun getBaseUrl(type:Int):String{
        return when (type){
            recommendType -> "http://api.apiopen.top/"
            connotationType -> "https://www.apiopen.top/"
            else -> "http://api.apiopen.top/"
        }
    }

}