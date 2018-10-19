package com.skwen.foru.recommendmodule.model.category

data class Result(
        var adExist: Boolean,
        var total: Int,
        var nextPageUrl: Any,
        var count: Int,
        var itemList: List<Item>
)