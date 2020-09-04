package com.example.calculator.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.calculator.R
import kotlinx.android.synthetic.main.cv_calculator_input.view.*

class CalculatorInputView(context: Context, attributeSet: AttributeSet)
    : RelativeLayout(context, attributeSet){

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.cv_calculator_input,
            this,
            true)

        attributeSet.run {
            val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CalculatorInputView)

            val textResource = typedArray.getString(R.styleable.CalculatorInputView_item_text)
            val iconResource = typedArray.getResourceId(R.styleable.CalculatorInputView_item_icon, -1)

            when {
                iconResource != -1 -> {
                    tvInputElement.visibility = GONE
                    ivInputElement.apply {
                        visibility = VISIBLE
                        setImageResource(iconResource)
                    }
                }
                !textResource.isNullOrBlank() -> {
                    ivInputElement.visibility = GONE
                    tvInputElement.apply {
                        visibility = VISIBLE
                        text = textResource
                    }
                }
                else -> {
                    ivInputElement.visibility = GONE
                    tvInputElement.visibility = GONE
                }
            }

            typedArray.recycle()
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        vInputElementClick.setOnClickListener(l)
    }
}