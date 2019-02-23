package com.github.char_i3.memochar

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // インスタンス化
        val textArea = findViewById<EditText>(R.id.text_area)
        val textCount = findViewById<TextView>(R.id.text_count)

        val buttonTwitter = findViewById<ImageButton>(R.id.button_twitter)
        val buttonInstagram = findViewById<ImageButton>(R.id.button_instagram)
        val buttonShare = findViewById<ImageButton>(R.id.button_share)
        val buttonCopy = findViewById<ImageButton>(R.id.button_copy)
        val buttonSave = findViewById<ImageButton>(R.id.button_save)


        // 入力されたテキストをカウントする
        textArea.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val length = s?.length ?: 0
                textCount.text = length.toString()
            }

        })

        // Twitterボタンを押下したときの処理
        buttonTwitter.setOnClickListener {
            Toast.makeText(this@MainActivity, "ついった！", Toast.LENGTH_LONG).show()
            Log.d("char", "ついった！！")
        }

        // Instaguramボタンを押下したときの処理
        buttonInstagram.setOnClickListener {

        }

        // shareボタンを押下したときの処理
        buttonShare.setOnClickListener {

        }

        // copyボタンを押下したときの処理
        buttonCopy.setOnClickListener {

            // クリップボードにコピー
            val clipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboardManager.primaryClip = ClipData.newPlainText("", textArea.text)

        }

        // saveボタンを押下したときの処理
        buttonSave.setOnClickListener {

        }
    }
}
