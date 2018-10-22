package com.skwen.foru.connotationmodule.child

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
}