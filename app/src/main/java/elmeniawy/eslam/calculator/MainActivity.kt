package elmeniawy.eslam.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var op = ""
    private var oldNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numbersEvents(view: View) {
        val selectedButton = view as Button
        var currentData: String = tvResult.text.toString()

        if (currentData == getString(R.string.zero)) {
            currentData = ""
        }

        if (oldNumber == "0") {
            currentData = ""
            oldNumber = ""
        }

        when (selectedButton.id) {
            bt0.id -> currentData += getString(R.string.zero)
            bt1.id -> currentData += getString(R.string.one)
            bt2.id -> currentData += getString(R.string.two)
            bt3.id -> currentData += getString(R.string.three)
            bt4.id -> currentData += getString(R.string.four)
            bt5.id -> currentData += getString(R.string.five)
            bt6.id -> currentData += getString(R.string.six)
            bt7.id -> currentData += getString(R.string.seven)
            bt8.id -> currentData += getString(R.string.eight)
            bt9.id -> currentData += getString(R.string.nine)

            btDot.id -> {
                if (currentData.isEmpty()) {
                    currentData = getString(R.string.zero)
                }

                if (!currentData.contains(getString(R.string.dot))) {
                    currentData += getString(R.string.dot)
                }
            }

            btPlusMinus.id -> {
                currentData = if (currentData.isEmpty()) {
                    getString(R.string.zero)
                } else {
                    if (currentData.contains(getString(R.string.minus))) {
                        currentData.replace(getString(R.string.minus), "")
                    } else {
                        getString(R.string.minus) + currentData
                    }
                }
            }
        }

        tvResult.text = currentData
    }

    fun operationsEvents(view: View) {
        oldNumber = tvResult.text.toString()

        if (!oldNumber.isEmpty() && oldNumber != getString(R.string.zero)) {
            val selectedButton = view as Button

            when (selectedButton.id) {
                btDiv.id -> {
                    op = "/"
                }
                btMul.id -> {
                    op = "*"
                }
                btSub.id -> {
                    op = "-"
                }
                btSum.id -> {
                    op = "+"
                }
            }

            tvResult.text = ""
        }
    }

    fun equalClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        val newNumber = tvResult.text.toString()
        var result: Double? = null

        if (!newNumber.isEmpty()) {
            when (op) {
                "/" -> {
                    result = oldNumber.toDouble() / newNumber.toDouble()
                }
                "*" -> {
                    result = oldNumber.toDouble() * newNumber.toDouble()
                }
                "-" -> {
                    result = oldNumber.toDouble() - newNumber.toDouble()
                }
                "+" -> {
                    result = oldNumber.toDouble() + newNumber.toDouble()
                }
            }

            tvResult.text = result.toString()
            op = ""
            oldNumber = "0"
        }
    }
}
