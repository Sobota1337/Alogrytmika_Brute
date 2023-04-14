package com.example.alogrytmika_brute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button
        findViewById<Button>(R.id.btn).setOnClickListener {

            val ilosc_elementow = findViewById<EditText>(R.id.editText).text.toString()
            val wzor = findViewById<EditText>(R.id.editText2).text.toString()

            if (!ilosc_elementow.toString().isEmpty() && !wzor.isEmpty()) {

                val dlugosc_wzoru = wzor.length

                if (dlugosc_wzoru > ilosc_elementow.toInt()) {
                    findViewById<TextView>(R.id.textView_error).text =
                        "Wzorzec nie może być dłuższy od łańcucha!"

                    findViewById<TextView>(R.id.textView_lancuch).text = "Łańcuch:"
                    findViewById<TextView>(R.id.textView_wzorzec).text = "Wzorzec:"

                    findViewById<TextView>(R.id.BF_wynik).text = "Wynik:"
                    findViewById<TextView>(R.id.KMP_wynik).text = "Wynik:"
                    findViewById<TextView>(R.id.BM_wynik).text = "Wynik:"
                    findViewById<TextView>(R.id.RK_wynik).text = "Wynik:"
                }
            }
        }
    }
}