package com.skwen.foru.connotationmodule.alone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.skwen.foru.connotationmodule.ConnotationFragment
import com.skwen.foru.recommendmodule.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ConnotationFragment())
                .commit()
    }
}
