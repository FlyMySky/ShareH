package com.skwen.foru.recommendmodule.model.recommend

data class Data(
        var dataType: String,
        var header: Header,
        var content: Content,
        var adTrack: Any
)