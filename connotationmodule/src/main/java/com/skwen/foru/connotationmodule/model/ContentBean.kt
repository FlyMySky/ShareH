package com.skwen.foru.connotationmodule.model

data class ContentBean(
        var type: String,
        var text: String,
        var username: String,
        var uid: String,
        var header: String,
        var comment: Int,
        var top_commentsVoiceuri: String,
        var top_commentsContent: String,
        var top_commentsHeader: String,
        var top_commentsName: String,
        var passtime: String,
        var soureid: Int,
        var up: Int,
        var down: Int,
        var forward: Int,
        var image: String,
        var gif: String,
        var thumbnail: String,
        var video: String
)