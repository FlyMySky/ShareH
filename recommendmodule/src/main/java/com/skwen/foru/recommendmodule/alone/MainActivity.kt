package com.skwen.foru.recommendmodule.alone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.skwen.foru.recommendmodule.R
import com.skwen.foru.recommendmodule.RecommendFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recommend_module_activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, RecommendFragment())
                .commit()
    }
}
