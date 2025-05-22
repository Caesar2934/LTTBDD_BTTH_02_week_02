package com.example.email_check

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
import com.example.email_check.ui.theme.Email_CheckTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.edtName)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val checkButton = findViewById<Button>(R.id.btnCheck)

        checkButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            when {
                email.isEmpty() -> {
                    resultTextView.text = "Email không hợp lệ !"
                }
                !email.contains("@") -> {
                    resultTextView.text = "Email không đúng định dạng !"
                }
                else -> {
                    resultTextView.setTextColor(getColor((R.color.teal_700)))
                    resultTextView.text = "Bạn đã nhập email hợp lệ !"
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Email_CheckTheme {
        Greeting("Android")
    }
}