package com.example.kotlin_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startForResult: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                    if (result.resultCode == Activity.RESULT_OK) {
                        val intent = result.data
                        ed_send.setText(intent?.getStringExtra(KEY_RES))
                    }
                }

        btn_send.setOnClickListener {
            if (!ed_send.text.isNullOrBlank()) {
                startForResult.launch(
                        Intent(this, MainActivity2::class.java)
                                .putExtra(KEY_RES, ed_send.text?.toString())
                )
            } else {
                Toast.makeText(this, "Поля пустые!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val KEY_RES = "res"
    }
}


