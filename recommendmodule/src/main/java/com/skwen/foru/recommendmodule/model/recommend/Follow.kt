package com.skwen.foru.recommendmodule.model.recommend

data class Follow(
        var itemId: Int,
        var itemType: String,
        var followed: Boolean
)