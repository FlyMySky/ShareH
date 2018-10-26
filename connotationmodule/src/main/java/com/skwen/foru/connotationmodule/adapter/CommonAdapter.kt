package com.skwen.foru.connotationmodule.adapter

import android.view.View
import com.skwen.foru.basemodule.base.adapter.BaseAdapter
import com.skwen.foru.basemodule.base.holder.BaseHolder
import com.skwen.foru.connotationmodule.R
import com.skwen.foru.connotationmodule.holder.GifHolder
import com.skwen.foru.connotationmodule.holder.ImageHolder
import com.skwen.foru.connotationmodule.holder.TextHolder
import com.skwen.foru.connotationmodule.holder.VideoHolder
import com.skwen.foru.connotationmodule.model.ContentBean
import com.skwen.foru.connotationmodule.util.TabUtil

class CommonAdapter(mutableList: MutableList<ContentBean>) : BaseAdapter<ContentBean>(mutableList) {

    override fun getLayoutRes(viewType: Int): Int {
        return when (viewType) {
            TabUtil.type_text -> R.layout.connotation_module_fragment_child_text
            TabUtil.type_img -> R.layout.connotation_module_fragment_child_img
            TabUtil.type_gif -> R.layout.connotation_module_fragment_child_gif
            TabUtil.type_video -> R.layout.connotation_module_fragment_child_video
            else -> R.layout.connotation_module_fragment_child_text
        }
    }

    override fun getItemViewTypeByData(position: Int, item: ContentBean): Int {
        return when (item.type) {
            TabUtil.typeTextName -> TabUtil.type_text
            TabUtil.typeImgeName -> TabUtil.type_img
            TabUtil.typeGifName -> TabUtil.type_gif
            TabUtil.typeVideoName -> TabUtil.type_video
            else -> TabUtil.type_text
        }
    }

    override fun getViewHolderByType(view: View, viewType: Int): BaseHolder<ContentBean> {
        return when (viewType) {
            TabUtil.type_text -> TextHolder(view)
            TabUtil.type_img -> ImageHolder(view)
            TabUtil.type_gif -> GifHolder(view)
            TabUtil.type_video -> VideoHolder(view)
            else -> TextHolder(view)
        }
    }

    companion object {
        const val TAG = "CommonAdapter"
    }

}