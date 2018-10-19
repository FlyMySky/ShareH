package com.skwen.foru.recommendmodule.model.recommend

data class Tag(
        var childTagIdList: Any,
        var tagRecType: String,
        var headerImage: String,
        var name: String,
        var actionUrl: String,
        var communityIndex: Int,
        var id: Int,
        var childTagList: Any,
        var bgPicture: String,
        var adTrack: Any,
        var desc: Any
)