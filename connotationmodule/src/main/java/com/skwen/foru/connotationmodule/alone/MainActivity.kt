package com.skwen.foru.connotationmodule.alone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.skwen.foru.connotationmodule.ConnotationFragment
import com.skwen.foru.connotationmodule.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connotation_module_activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ConnotationFragment())
                .commit()
    }

    override fun onBackPressed() {
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        GSYVideoManager.releaseAllVideos()
    }
}
