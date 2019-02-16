package com.github.char_i3.memochar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonTwitter = findViewById<ImageButton>(R.id.button_twitter)

        buttonTwitter.setOnClickListener {
            Toast.makeText(this@MainActivity, "ついった！", Toast.LENGTH_LONG).show()
            Log.d("char", "ついった！！")
        }
    }
}
