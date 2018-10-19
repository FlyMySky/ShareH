package com.skwen.foru.recommendmodule.model.category

data class Data(
        var subTitle: Any,
        var dataType: String,
        var iconType: String,
        var icon: String,
        var actionUrl: String,
        var ifPgc: Boolean,
        var description: String,
        var id: Int,
        var title: String,
        var follow: Follow,
        var adTrack: Any
)