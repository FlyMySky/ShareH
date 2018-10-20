package com.skwen.foru.connotationmodule.model

data class ResultBean(
        var code: Int,
        var msg: String,
        var data: List<ContentBean>
)