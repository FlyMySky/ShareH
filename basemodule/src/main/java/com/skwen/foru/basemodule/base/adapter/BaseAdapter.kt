package com.skwen.foru.basemodule.base.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skwen.foru.basemodule.base.holder.BaseHolder
import com.skwen.foru.basemodule.base.inter.OnRecyclerViewClick

abstract class BaseAdapter<T>(var mutableList: MutableList<T>): RecyclerView.Adapter<BaseHolder<T>>(){

    private var onRecyclerViewClick:OnRecyclerViewClick? = null

    @LayoutRes
    abstract fun getLayoutRes(viewType: Int): Int

    abstract fun getItemViewTypeByData(position: Int, item: T): Int

    abstract fun getViewHolderByType(view: View, viewType: Int): BaseHolder<T>

    fun addItemClickListener(onRecyclerViewClick: OnRecyclerViewClick){
        this.onRecyclerViewClick = onRecyclerViewClick
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseHolder<T> {
        val view:View = LayoutInflater.from(viewGroup.context).inflate(getLayoutRes(viewType),viewGroup,false)
        return getViewHolderByType(view,viewType)
    }

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.bindData(mutableList[position],position)
        holder.itemView.setOnClickListener {
            onRecyclerViewClick!!.onItemClick(position,mutableList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItemViewTypeByData(position,mutableList[position])
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

}