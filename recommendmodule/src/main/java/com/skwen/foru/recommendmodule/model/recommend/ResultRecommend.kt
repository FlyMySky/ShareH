package com.skwen.foru.recommendmodule.model.recommend

data class ResultRecommend(
        var code: Int,
        var message: String,
        var result: List<Result>
)