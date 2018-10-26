package com.skwen.foru.connotationmodule.child

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.skwen.foru.basemodule.base.BaseFragment
import com.skwen.foru.basemodule.base.inter.OnRecyclerViewClick
import com.skwen.foru.connotationmodule.R
import com.skwen.foru.connotationmodule.adapter.CommonAdapter
import com.skwen.foru.connotationmodule.http.HttpUtil
import com.skwen.foru.connotationmodule.model.ContentBean
import com.skwen.foru.connotationmodule.model.ResultBean
import kotlinx.android.synthetic.main.connotation_module_fragment_child.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommonFragment : BaseFragment() {

    private var mutableList = mutableListOf<ContentBean>()
    private var type = 1
    private var page = 1
    private var mAdapter: CommonAdapter? = null

    override fun getLayoutRes(): Int {
        return R.layout.connotation_module_fragment_child
    }

    override fun initViews() {
        type = arguments?.get("type") as Int
        mAdapter = CommonAdapter(mutableList)
        recyclerView.adapter = mAdapter
        mAdapter!!.addItemClickListener(object : OnRecyclerViewClick {
            override fun onItemClick(position: Int, obj: Any?) {
                print(obj.toString())
            }
        })

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE //滚动停止
                    -> {
                    }
                    RecyclerView.SCROLL_STATE_DRAGGING //手指拖动
                    -> {
                    }
                    RecyclerView.SCROLL_STATE_SETTLING //惯性滚动
                    -> {
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                val firstVisibleItem = linearLayoutManager!!.findFirstVisibleItemPosition()
                val lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()

                //大于0说明有播放
                if (GSYVideoManager.instance().playPosition >= 0) {
                    //当前播放的位置
                    val position = GSYVideoManager.instance().playPosition
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().playTag == CommonAdapter.TAG && (position < firstVisibleItem || position > lastVisibleItem)) {
                        if (GSYVideoManager.isFullState(activity)) {
                            return
                        }
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        GSYVideoManager.releaseAllVideos()
                        mAdapter!!.notifyDataSetChanged()
                    }
                }

            }

        })

    }

    override fun lazyFetchData() {

        HttpUtil.instance.getDataByType(type, page, object : Callback<ResultBean> {
            override fun onFailure(call: Call<ResultBean>, t: Throwable) {
                throw t
            }

            override fun onResponse(call: Call<ResultBean>, response: Response<ResultBean>) {
                if (response.isSuccessful) {
                    mutableList.addAll(0, response.body()!!.data)
                    mAdapter!!.notifyDataSetChanged()
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        GSYVideoManager.onPause()
    }

    override fun onResume() {
        super.onResume()
        GSYVideoManager.onResume()
    }


}