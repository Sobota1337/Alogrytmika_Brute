package com.example.alogrytmika_brute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.system.measureTimeMillis

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
                else if (dlugosc_wzoru <= ilosc_elementow.toInt()) {

                    findViewById<TextView>(R.id.textView_error).text = ""

                    // Generowanie łańcucha
                    val losowa = java.util.Random()
                    val stringBuilder = StringBuilder()
                    for (i in 1..ilosc_elementow.toInt()) {
                        stringBuilder.append(losowa.nextInt(10))
                    }

                    val lancuch = stringBuilder.toString()
                    if (ilosc_elementow.toInt() > 15) {
                        findViewById<TextView>(R.id.textView_lancuch).text = "Zbyt długi łańcuch"
                    } else if (ilosc_elementow.toInt() <= 15) {
                        findViewById<TextView>(R.id.textView_lancuch).text = lancuch
                    }
                }
                // Wzorzec
                findViewById<TextView>(R.id.textView_wzorzec).text = wzor

                // Czas
                val BF_czas = findViewById<TextView>(R.id.BF_czas)
                val KMP_czas = findViewById<TextView>(R.id.KMP_czas)
                val BM_czas = findViewById<TextView>(R.id.BM_czas)
                val RK_czas = findViewById<TextView>(R.id.RK_czas)





                val BF_wynik_textView = findViewById<TextView>(R.id.BF_wynik)
                val wynikBF = BF(lancuch, wzor)

                if (wynikBF.first != null)
                {
                    BF_wynik_textView.text = "Wzorzec występuję w łańcuchu"
                }

                else
                {
                    BF_wynik_textView.text = "Nie znaleziono wzorca"
                }

                var czas  = measureTimeMillis{
                    BF(lancuch, wzor)
                }
                BF_czas.text = String.format("%s ms", czas)



                val KMP_wynik_textView = findViewById<TextView>(R.id.KMP_wynik)
                val wynikKMP = KMP(lancuch, wzor)

                if (wynikKMP != -1)
                {
                    KMP_wynik_textView.text = "Wzorzec występuję w łańcuchu"
                }

                else if (wynikKMP == -1)
                {
                    KMP_wynik_textView.text = "Nie znaleziono wzorca"
                }

                czas = measureTimeMillis {
                    KMP(lancuch, wzor)
                }
                KMP_czas.text = String.format("%s ms", czas)



                val BM_wynik_textView = findViewById<TextView>(R.id.BM_wynik)
                val wynikBM = BM(lancuch, wzor)

                if (wynikBM != -1)
                {
                    BM_wynik_textView.text = "Wzorzec występuję w łańcuchu"
                }

                else if (wynikBM == -1)
                {
                    BM_wynik_textView.text = "Nie znaleziono wzorca"
                }

                czas = measureTimeMillis {
                    BM(lancuch, wzor)
                }
                BM_czas.text = String.format("%s ms", czas)



                val RK_wynik_textView = findViewById<TextView>(R.id.RK_wynik)
                val wynikRK = RK(lancuch, wzor)

                if (wynikRK != -1)
                {
                    RK_wynik_textView.text = "Wzorzec występuję w łańcuchu"
                }

                else if (wynikRK == -1)
                {
                    RK_wynik_textView.text = "Nie znaleziono wzorca"
                }

                czas = measureTimeMillis {
                    RK(lancuch, wzor)
                }
                RK_czas.text = String.format("%s ms", czas)
            }
        }

        else
        {
            findViewById<TextView>(R.id.textView_error).text = "Podaj dane!"

            findViewById<TextView>(R.id.textView_lancuch).text = "Łańcuch:"
            findViewById<TextView>(R.id.textView_wzorzec).text = "Wzorzec:"

            findViewById<TextView>(R.id.BF_wynik).text = "Wynik:"
            findViewById<TextView>(R.id.KMP_wynik).text = "Wynik:"
            findViewById<TextView>(R.id.BM_wynik).text = "Wynik:"
            findViewById<TextView>(R.id.RK_wynik).text = "Wynik:"
        }
    }
            }
// Algorytm: Brute Force
fun BF(tekst: String, wzor: String): Pair<Int?, Long> {
    val x = tekst.length
    val y = wzor.length

    for (i in 0..x - y) {
        var j = 0
        while (j < y && wzor[j] == tekst[i + j]) {
            j++
        }
        if (j == y) {
            return Pair(i, 0)
        }
    }

    return Pair(null, 0)
}
