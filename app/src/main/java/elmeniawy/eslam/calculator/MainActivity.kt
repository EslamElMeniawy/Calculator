package elmeniawy.eslam.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numbersEvents(view: View) {
        val selectedButton = view as Button
        var currentData: String = tvResult.text.toString()

        if (currentData == "0") {
            currentData = ""
        }

        when (selectedButton.id) {
            bt0.id -> currentData += "0"
            bt1.id -> currentData += "1"
            bt2.id -> currentData += "2"
            bt3.id -> currentData += "3"
            bt4.id -> currentData += "4"
            bt5.id -> currentData += "5"
            bt6.id -> currentData += "6"
            bt7.id -> currentData += "7"
            bt8.id -> currentData += "8"
            bt9.id -> currentData += "9"

            btDot.id -> {
                if (currentData.isEmpty()) {
                    currentData = "0"
                }

                if (!currentData.contains(".")) {
                    currentData += "."
                }
            }
            
            btPlusMinus.id -> {
                currentData = if (currentData.isEmpty()) {
                    "0"
                } else {
                    if (currentData.contains("-")) {
                        currentData.replace("-", "")
                    } else {
                        "-$currentData"
                    }
                }
            }
        }

        tvResult.text = currentData
    }
}
