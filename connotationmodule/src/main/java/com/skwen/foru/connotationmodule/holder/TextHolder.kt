package com.skwen.foru.connotationmodule.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.skwen.foru.basemodule.base.holder.BaseHolder
import com.skwen.foru.basemodule.util.ImageUtil
import com.skwen.foru.connotationmodule.R
import com.skwen.foru.connotationmodule.model.ContentBean
import de.hdodenhof.circleimageview.CircleImageView

class TextHolder(itemView: View) : BaseHolder<ContentBean>(itemView){

    private var item_image: CircleImageView? = null
    private var item_name: TextView? = null
    private var item_time: TextView? = null
    private var item_content: TextView? = null
    private var item_digger: TextView? = null
    private var item_bury: TextView? = null
    private var item_comment: TextView? = null
    private var item_share: TextView? = null

    init {
        item_image = getView(R.id.item_image)
        item_name = getView(R.id.item_name)
        item_time = getView(R.id.item_time)
        item_content = getView(R.id.item_content)
        item_digger = getView(R.id.item_digger)
        item_bury = getView(R.id.item_bury)
        item_comment = getView(R.id.item_comment)
        item_share = getView(R.id.item_share)
    }


    override fun bindData(item: ContentBean, position: Int) {
        ImageUtil.getInstance().loadSimpleImage(item_image!!, item.header)
        item_name?.text = item.username
        item_time?.text = item.passtime
        item_content?.text = item.text
        item_digger?.text = item.up.toString()
        item_bury?.text = item.down.toString()
        item_comment?.text = item.comment.toString()
        item_share?.text = item.forward.toString()

    }

}