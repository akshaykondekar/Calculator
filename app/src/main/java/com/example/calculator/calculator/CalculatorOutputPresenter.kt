package com.example.calculator.calculator

import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresenter {

    private var mView : CalculatorOutputInterface ? = null
    private var currentEquation : String = ""
    private var currentOutput : String = ""
    private val interpreter = Interpreter()

    fun attach(view : CalculatorOutputInterface){
        mView = view
        updateEquation()
        updateOutput()
    }

    fun detach(){
        mView = null
    }

    fun add(item : String){
        currentEquation = currentEquation.plus(item)
        updateEquation()
        calculateOutput()
        updateOutput()
    }

    fun remove(){
        currentEquation = if(currentEquation.length > 1){
            currentEquation.substring(0, currentEquation.length -1)
        } else{
            ""
        }
        updateEquation()
        calculateOutput()
        updateOutput()
    }

    fun solve(){
        if(currentOutput.isNotEmpty()){
            currentEquation = currentOutput
            currentOutput = ""
        }
        updateEquation()
        updateOutput()
    }

    fun clear(){
        currentEquation = ""
        currentOutput = ""
        updateEquation()
        updateOutput()
    }

    private fun calculateOutput(){
        if(currentEquation.isNotEmpty()){
            try {
                interpreter.eval("result = $currentEquation")
                val result = interpreter.get("result")

                if(result != null && result is Int){
                    currentOutput = result.toString()
                }
            }
            catch(e : Exception) {
                currentOutput = ""
            }
        }
        else{
            currentOutput = ""
        }
    }

    private fun updateEquation(){
        mView?.setEquation(currentEquation)
    }

    private fun updateOutput(){
        mView?.setOutput(currentOutput)
    }
}