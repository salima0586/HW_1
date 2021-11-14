package com.example.kotlin_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val data: String? = intent.getStringExtra(MainActivity.KEY_RES).toString()
        data?.let { st_send.setText(data) }

        btn_2.setOnClickListener {
            if (!st_send.text.isNullOrBlank()) {
                setResult(
                    Activity.RESULT_OK,
                    Intent().putExtra(MainActivity.KEY_RES, st_send.text?.toString())
                )
                finish()

            } else {
                Toast.makeText(this, "Заполните поля!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}