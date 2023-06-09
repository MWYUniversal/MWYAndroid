package com.owner.recycler_view.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.owner.recycler_view.R
import com.owner.recycler_view.view.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val intent: Intent = Intent(
                this,
                HomeActivity::class.java
            )
            startActivity(intent)
            finish()
        }, 1000)
    }
}