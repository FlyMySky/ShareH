package com.skwen.foru.recommendmodule.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.skwen.foru.recommendmodule.R
import com.skwen.foru.recommendmodule.holder.RecommendHolder
import com.skwen.foru.recommendmodule.model.recommend.Result

class RecommendAdapter(private var list: MutableList<Result>) : RecyclerView.Adapter<RecommendHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecommendHolder {
        return RecommendHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.recommend_list_item,viewGroup,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecommendHolder, position: Int) {
        holder.bindData(position, list[position])
    }

}