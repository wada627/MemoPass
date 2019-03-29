package com.github.wada627.memopass

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // インスタンス化
        val textArea = findViewById<EditText>(R.id.text_area)
        val textCount = findViewById<TextView>(R.id.text_count)

        val buttonTwitter = findViewById<ImageButton>(R.id.button_twitter)
        val buttonLine = findViewById<ImageButton>(R.id.button_line)
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
            val url = "https://twitter.com/share?text=${textArea.text}"
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse(url))

            startActivity(intent)
        }

        // LINEボタンを押下したときの処理
        buttonLine.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("line://msg/text/" + Uri.encode(textArea.text.toString()))
            startActivity(intent)
        }

        // shareボタンを押下したときの処理
        buttonShare.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, textArea.text)
            startActivity(intent)

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
