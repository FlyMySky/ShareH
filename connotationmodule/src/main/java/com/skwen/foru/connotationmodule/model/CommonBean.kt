package com.skwen.foru.connotationmodule.model

import com.skwen.foru.basemodule.base.BaseFragment

data class CommonBean(
        var title: String,//中文名称
        var name: String,//typeName
        var type: Int,//type
        var fragment: BaseFragment
)