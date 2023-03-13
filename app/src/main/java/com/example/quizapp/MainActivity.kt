package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnNext: Button
    private lateinit var etName: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btnNext = findViewById(R.id.btnNext)
        etName = findViewById(R.id.etName)

        btnNext.setOnClickListener{
            if(etName.text.toString().isEmpty())
            {
                Toast.makeText(this,"Enter Your Name",Toast.LENGTH_SHORT).show()
            }else
            {
                var intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("${setData.name}" , etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}