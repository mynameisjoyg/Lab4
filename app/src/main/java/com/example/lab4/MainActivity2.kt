package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        intent?.extras?.let{
            val data = it.getInt("key1")
            val data2 = it.getString("key2")
            Toast.makeText(this, "key1:"+ data, Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "key2:"+ data2, Toast.LENGTH_SHORT).show()
        }

        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener {
            val bun= Bundle()
            bun.putString("key2", "cde")
            val i = Intent().putExtras(bun)
            setResult(RESULT_OK, i)
            finish()
        }



    }
}