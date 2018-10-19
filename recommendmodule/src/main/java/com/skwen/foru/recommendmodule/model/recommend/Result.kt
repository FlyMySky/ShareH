package com.skwen.foru.recommendmodule.model.recommend

data class Result(
        var data: Data,
        var adIndex: Int,
        var tag: Any,
        var id: Int,
        var type: String
)