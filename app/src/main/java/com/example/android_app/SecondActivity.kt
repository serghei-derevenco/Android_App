package com.example.android_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // get data from first screen
        val received_data = intent.getStringExtra("data").toString()
        edit_data.setText(received_data)

        // go back button (sends edited data to first screen)
        go_back_btn.setOnClickListener {
            val input = edit_data.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("edited data", input)
            startActivity(intent)
        }
    }
}