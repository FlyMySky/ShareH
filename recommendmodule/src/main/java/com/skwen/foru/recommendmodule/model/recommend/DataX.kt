package com.skwen.foru.recommendmodule.model.recommend

data class DataX(
        var date: Long,
        var shareAdTrack: Any,
        var releaseTime: Long,
        var description: String,
        var remark: String,
        var collected: Boolean,
        var title: String,
        var type: String,
        var favoriteAdTrack: Any,
        var waterMarks: Any,
        var playUrl: String,
        var cover: Cover,
        var duration: Int,
        var library: String,
        var descriptionEditor: String,
        var provider: Provider,
        var id: Int,
        var descriptionPgc: String,
        var titlePgc: String,
        var adTrack: Any,
        var subtitles: List<Any>,
        var src: Any,
        var author: Author,
        var dataType: String,
        var searchWeight: Int,
        var playlists: Any,
        var consumption: Consumption,
        var label: Any,
        var played: Boolean,
        var tags: List<Tag>,
        var webAdTrack: Any,
        var labelList: List<Any>,
        var lastViewTime: Any,
        var playInfo: List<Any>,
        var ifLimitVideo: Boolean,
        var webUrl: WebUrl,
        var campaign: Any,
        var category: String,
        var idx: Int,
        var slogan: Any,
        var thumbPlayUrl: Any,
        var resourceType: String,
        var promotion: Any
)