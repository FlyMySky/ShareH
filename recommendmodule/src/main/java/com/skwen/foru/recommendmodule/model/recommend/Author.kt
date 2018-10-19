package com.skwen.foru.recommendmodule.model.recommend

data class Author(
        var shield: Shield,
        var approvedNotReadyVideoCount: Int,
        var icon: String,
        var name: String,
        var link: String,
        var ifPgc: Boolean,
        var description: String,
        var latestReleaseTime: Long,
        var id: Int,
        var videoNum: Int,
        var follow: Follow,
        var adTrack: Any
)