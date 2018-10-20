package com.skwen.foru.connotationmodule.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.skwen.foru.connotationmodule.model.CommonBean

class ConnotationPagerAdapter(fm: FragmentManager?, private var mList: MutableList<CommonBean>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mList[position].fragment
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mList[position].title
    }
}