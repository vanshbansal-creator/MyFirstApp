package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt = findViewById<TextView>(R.id.txtTitle)
        val btn = findViewById<Button>(R.id.btnClick)

        btn.setOnClickListener {
            count++
            txt.text = "Clicked $count times"

            if (count == 5) {
                btn.isEnabled = false
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("msg", "WELCOME THE REVERIE")
                intent.putExtra("countValue", count)
                startActivityForResult(intent, 100)
            }
        }
    }

           override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            count = 0
            val txt = findViewById<TextView>(R.id.txtTitle)
            val btn = findViewById<Button>(R.id.btnClick)

            txt.text = "Clicked 0 times"
            btn.isEnabled = true
        }
    }
        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putInt("COUNT_KEY", count)
        }
    }
