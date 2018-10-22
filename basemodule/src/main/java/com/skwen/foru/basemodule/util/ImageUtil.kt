package com.skwen.foru.basemodule.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.skwen.foru.basemodule.R

class ImageUtil private constructor() {

    /**
     * RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.ic_launcher)	//加载成功之前占位图
                    .error(R.mipmap.ic_launcher)	//加载错误之后的错误图
                    .override(400,400)	//指定图片的尺寸
                    //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                    .fitCenter()
                    //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                    .centerCrop()
                    .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
                    .skipMemoryCache(true)	//跳过内存缓存
                    .diskCacheStrategy(DiskCacheStrategy.ALL)	//缓存所有版本的图像
                    .diskCacheStrategy(DiskCacheStrategy.NONE)	//跳过磁盘缓存
                    .diskCacheStrategy(DiskCacheStrategy.DATA)	//只缓存原来分辨率的图片
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)	//只缓存最终的图片
                    ;
     */

    private object Holder {
        val instance = ImageUtil()
    }

    companion object {
        fun getInstance() = Holder.instance
    }

    fun getDefaultOption(): RequestOptions {
        return RequestOptions()
                .placeholder(R.drawable.base_module_pic_default)
                .error(R.drawable.base_module_pic_failed)
    }


    fun loadSimpleImage(imageView: ImageView, path: String) {
        val options = RequestOptions()
                .placeholder(R.drawable.base_module_pic_default)
                .error(R.drawable.base_module_pic_failed)
                .centerCrop()
                .skipMemoryCache(true)

        Glide
                .with(imageView.context)
                .load(path)
                .apply(options)
                .into(imageView)

    }

    fun loadImageWithOption(imageView: ImageView, path: String, requestOptions: RequestOptions) {
        Glide
                .with(imageView.context)
                .load(path)
                .apply(requestOptions)
                .into(imageView)
    }


}