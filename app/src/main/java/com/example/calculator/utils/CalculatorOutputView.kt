package com.example.calculator.utils

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.calculator.R
import com.example.calculator.calculator.CalculatorOutputInterface
import com.example.calculator.calculator.CalculatorOutputPresenter
import kotlinx.android.synthetic.main.cv_calculator_output.view.*

class CalculatorOutputView(context: Context, attributeSet: AttributeSet)
    : LinearLayout(context, attributeSet), CalculatorOutputInterface {

    init {

        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL

        LayoutInflater.from(context)
            .inflate(
                R.layout.cv_calculator_output,
                this,
                true
            )
    }

    fun addItem(item : String){
        CalculatorOutputPresenter.add(item)
    }

    fun removeItem(){
        CalculatorOutputPresenter.remove()
    }

    fun solve(){
        CalculatorOutputPresenter.solve()
    }

    fun clear(){
        CalculatorOutputPresenter.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        CalculatorOutputPresenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        CalculatorOutputPresenter.detach()
    }

    override fun setEquation(equation: String) {
        tvUserInputEquation.text = equation
    }

    override fun setOutput(output: String) {
        tvInputEquationAnswer.text = output
    }
}