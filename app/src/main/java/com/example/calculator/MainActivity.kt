package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        key_0.setOnClickListener { calculatorOutputView.addItem("0") }
        key_1.setOnClickListener { calculatorOutputView.addItem("1") }
        key_2.setOnClickListener { calculatorOutputView.addItem("2") }
        key_3.setOnClickListener { calculatorOutputView.addItem("3") }
        key_4.setOnClickListener { calculatorOutputView.addItem("4") }
        key_5.setOnClickListener { calculatorOutputView.addItem("5") }
        key_6.setOnClickListener { calculatorOutputView.addItem("6") }
        key_7.setOnClickListener { calculatorOutputView.addItem("7") }
        key_8.setOnClickListener { calculatorOutputView.addItem("8") }
        key_9.setOnClickListener { calculatorOutputView.addItem("9") }
        key_percent.setOnClickListener { calculatorOutputView.addItem("%") }

        key_clear.setOnClickListener { calculatorOutputView.clear() }
        key_remove.setOnClickListener { calculatorOutputView.removeItem() }
        key_equal.setOnClickListener { calculatorOutputView.solve() }

        key_divide.setOnClickListener { calculatorOutputView.addItem("/") }
        key_multiply.setOnClickListener { calculatorOutputView.addItem("*") }
        key_add.setOnClickListener { calculatorOutputView.addItem("+") }
        key_minus.setOnClickListener { calculatorOutputView.addItem("-") }
    }
}