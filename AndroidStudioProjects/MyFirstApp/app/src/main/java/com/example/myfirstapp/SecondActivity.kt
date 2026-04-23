package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val txt = findViewById<TextView>(R.id.txtResult)

        val message = intent.getStringExtra("message")
        val count = intent.getIntExtra("countValue", -1)

        txt.text = "Message: ${message ?: "NULL"}\nCount: $count"

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("resultData", "Data from SecondActivity")
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

