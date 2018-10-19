package com.skwen.foru.recommendmodule.holder

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.skwen.foru.recommendmodule.R
import com.skwen.foru.recommendmodule.model.recommend.Result
import java.io.File
import java.io.FileOutputStream


class RecommendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var itemTitle: TextView? = null
    private var itemDesc: TextView? = null
    private var itemVideo: VideoView? = null
    private var itemImage: ImageView? = null
    private var itemBtn: Button? = null

    init {
        itemTitle = itemView.findViewById(R.id.item_title)
        itemDesc = itemView.findViewById(R.id.item_desc)
        itemVideo = itemView.findViewById(R.id.video_view)
        itemImage = itemView.findViewById(R.id.item_play_img)
        itemBtn = itemView.findViewById(R.id.item_play_btn)
    }


    fun bindData(position: Int, result: Result) {

        itemTitle?.text = result.data.content.data.title
        itemDesc?.text = result.data.content.data.description

        val uri = Uri.parse(result.data.content.data.playUrl)

        itemImage?.setImageBitmap(getFirstFrame(result.data.content.data.playUrl))

        itemVideo?.setMediaController(MediaController(itemVideo?.context))

        itemVideo?.setVideoURI(uri)

        itemBtn?.setOnClickListener {
            if (itemVideo?.isPlaying!!) {
                itemVideo?.visibility = View.INVISIBLE
                itemImage?.visibility = View.VISIBLE
                itemBtn?.visibility = View.VISIBLE
                itemVideo?.stopPlayback()
            } else {
                itemVideo?.visibility = View.VISIBLE
                itemImage?.visibility = View.GONE
                itemBtn?.visibility = View.GONE
                itemVideo?.start()
            }
        }

        itemView?.setOnClickListener {
            if (itemBtn?.visibility == View.GONE) {
                itemBtn?.visibility = View.VISIBLE
            }
        }
    }


    private fun getFirstFrame(url: String): Bitmap {
        val retriever = MediaMetadataRetriever()
        //获取网络视频
        retriever.setDataSource(url, HashMap())
        //获取本地视频
        //retriever.setDataSource(url);
        val bitmap = retriever.frameAtTime
        var outStream: FileOutputStream? = null
        outStream = FileOutputStream(File(itemView.context.applicationContext.externalCacheDir.absolutePath + "/" + System.currentTimeMillis() + ".jpg"))
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, outStream)
        outStream.close()
        retriever.release()
        return bitmap
    }

}