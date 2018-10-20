package com.skwen.foru.connotationmodule.util

import android.os.Bundle
import com.skwen.foru.basemodule.base.BaseFragment
import com.skwen.foru.connotationmodule.child.CommonFragment
import com.skwen.foru.connotationmodule.model.CommonBean

object TabUtil {

    private val titles = arrayListOf("推荐", "文字", "图片", "动图", "视频")

    private val types = arrayListOf(1, 2, 3, 4, 5)

    private val typeNames = arrayListOf("recommend", "text", "image", "gif", "video")

    private val fragments = getFragments(types)

    private var mutableList: MutableList<CommonBean> = mutableListOf()

    const val type_all = 1
    const val type_text = 2
    const val type_img = 3
    const val type_gif = 4
    const val type_video = 5

    const val typeTextName = "text" //: 文字
    const val typeImgeName = "image" //: 图片
    const val typeGifName = "gif" //: Gif
    const val typeVideoName = "video"//: 视频

    fun getMainTabData(): MutableList<CommonBean> {
        mutableList.clear()
        fragments.forEachIndexed { index, baseFragment ->
            val commonBean = CommonBean(titles[index], typeNames[index], types[index], baseFragment)
            mutableList.add(commonBean)
        }
        return mutableList
    }

    private fun getFragments(types: ArrayList<Int>): MutableList<BaseFragment> {

        val list = mutableListOf<BaseFragment>()
        list.clear()
        types.forEach {
            val commonFragment: BaseFragment = CommonFragment()
            val bundle = Bundle()
            bundle.putInt("type", it)
            commonFragment.arguments = bundle
            list.add(commonFragment)
        }
        return list
    }
}