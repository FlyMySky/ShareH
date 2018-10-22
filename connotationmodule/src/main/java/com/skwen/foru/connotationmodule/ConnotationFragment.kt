package com.skwen.foru.connotationmodule

import android.support.design.widget.TabLayout
import com.skwen.foru.basemodule.base.BaseFragment
import com.skwen.foru.connotationmodule.adapter.ConnotationPagerAdapter
import com.skwen.foru.connotationmodule.util.TabUtil
import kotlinx.android.synthetic.main.connotation_module_fragment_connotation.*

class ConnotationFragment : BaseFragment() {

    private var mutableList = TabUtil.getMainTabData()

    override fun getLayoutRes(): Int {
        return R.layout.connotation_module_fragment_connotation
    }

    override fun initViews() {
        tabLayout.tabMode = TabLayout.MODE_FIXED
        mutableList.forEach {
            tabLayout.addTab(tabLayout.newTab().setText(it.title))
        }
        viewPager.adapter = ConnotationPagerAdapter(childFragmentManager, mutableList)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun lazyFetchData() {

    }

}