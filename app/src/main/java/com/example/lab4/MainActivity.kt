package com.example.lab4

import android.app.Activity
import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toAct2Intent = Intent(this, MainActivity2::class.java)
        val bun =  Bundle()
        bun.putInt("key1", 123)
        bun.putString("key2", "abc")
        toAct2Intent.putExtras(bun)
        startActivityForResult(toAct2Intent, 1)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        super.onActivityResult(requestCode, resultCode, data, caller)
        data?.extras?.let{
            if(requestCode==1 && resultCode== Activity.RESULT_OK){
                Toast.makeText(this, "onActivityResult, key2:"+ it.getString("key2"), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
