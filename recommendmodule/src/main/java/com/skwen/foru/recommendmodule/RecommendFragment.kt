package com.skwen.foru.recommendmodule

import com.skwen.foru.basemodule.base.BaseFragment
import com.skwen.foru.recommendmodule.adapter.RecommendAdapter
import com.skwen.foru.recommendmodule.http.HttpUtil
import com.skwen.foru.recommendmodule.model.recommend.Result
import com.skwen.foru.recommendmodule.model.recommend.ResultRecommend
import kotlinx.android.synthetic.main.recommend_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecommendFragment : BaseFragment() {

    private var list: MutableList<Result> = mutableListOf()

    override fun getLayoutRes(): Int {
        return R.layout.recommend_fragment
    }


    override fun initViews() {
        recommend_list.adapter = RecommendAdapter(list)
    }

    override fun lazyFetchData() {

        HttpUtil
                .getInstance()
                .getRecommendData(object : Callback<ResultRecommend> {
                    override fun onFailure(call: Call<ResultRecommend>, t: Throwable) {
                        print(t.message)
                    }

                    override fun onResponse(call: Call<ResultRecommend>, response: Response<ResultRecommend>) {
                        if (response.isSuccessful) {
                            list.clear()
                            list.addAll(response.body()!!.result)
                            recommend_list.adapter?.notifyDataSetChanged()
                        }
                    }

                })

    }


}