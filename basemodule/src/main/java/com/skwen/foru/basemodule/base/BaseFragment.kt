package com.skwen.foru.basemodule.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    /**
     * view是否初始化完成
     */
    private var isViewPrepared: Boolean = false
    /**
     * 是否已经加载过
     */
    private var hasFetchData: Boolean = false


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        isViewPrepared = true
        lazyFetchDataIfPrepared()
    }

    private fun lazyFetchDataIfPrepared() {
        if (!hasFetchData && userVisibleHint && isViewPrepared) {
            hasFetchData = true
            lazyFetchData()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        isViewPrepared = false
        hasFetchData = false
    }


    /**
     * 布局
     */
    @LayoutRes
    abstract fun getLayoutRes(): Int

    /**
     * 初始化view
     */
    abstract fun initViews()


    /**
     * 加载数据
     */
    abstract fun lazyFetchData()

}