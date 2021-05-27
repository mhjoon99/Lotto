package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val btnGoResultConstell = findViewById<Button>(R.id.btnGoResultConstell)
        btnGoResultConstell.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }
}