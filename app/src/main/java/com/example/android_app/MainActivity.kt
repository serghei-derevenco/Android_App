package com.example.android_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // show edited data, if it exists
        if(intent.hasExtra("edited data")) {
            val edited_data = intent.getStringExtra("edited data").toString()
            recieved_data.setText(edited_data)
        }

        // send data to second screen
        send_btn.setOnClickListener {
            val input = input_data.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", input)
            startActivity(intent)
        }
    }
}