package com.example.calculator

import com.example.calculator.calculator.CalculatorOutputInterface
import com.example.calculator.calculator.CalculatorOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class CalculatorOutputTest{
    private val mPresenter = CalculatorOutputPresenter
    private val mMockView = Mockito.mock(CalculatorOutputInterface::class.java)

    @Test
    fun `1 plus 1 is 2`(){
        //Given that the view is attached
        mPresenter.attach(mMockView)

        //when a number is added
        mPresenter.add("1")

        //Then correct equation should be set
        then(mMockView).should().setEquation("1")

        //when an operator is added
        mPresenter.add("+")

        //Then correct equation should be set
        then(mMockView).should().setEquation("1+")

        //when a number is added
        mPresenter.add("1")

        //Then correct equation should be set
        then(mMockView).should().setEquation("1+1")

        //Then correct equation should be set
        then(mMockView).should().setOutput("2")

        //clear equation
        mPresenter.clear()
    }

    @Test
    fun `2 plus 2 minus 1 is 3`(){
        //Given that the view is attached
        mPresenter.attach(mMockView)

        //when a number is added
        mPresenter.add("2")

        //Then correct equation should be set
        then(mMockView).should().setEquation("2")

        //when an operator is added
        mPresenter.add("+")

        //Then correct equation should be set
        then(mMockView).should().setEquation("2+")

        //when a number is added
        mPresenter.add("2")

        //Then correct equation should be set
        then(mMockView).should().setEquation("2+2")

        //Then correct equation should be set
        then(mMockView).should().setOutput("4")

        //when an operator is added
        mPresenter.add("-")

        //Then correct equation should be set
        then(mMockView).should().setEquation("2+2-")

        //when a number is minus
        mPresenter.add("1")

        //Then correct equation should be set
        then(mMockView).should().setEquation("2+2-1")

        //Then correct equation should be set
        then(mMockView).should().setOutput("3")

        //clear equation
        mPresenter.clear()
    }
}