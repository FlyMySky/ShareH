package com.skwen.foru.basemodule.base.holder

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun <T : View> getView(@IdRes id: Int): T {
        return itemView.findViewById(id)
    }

    abstract fun bindData(item: T)

}