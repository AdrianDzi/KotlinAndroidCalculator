package com.example.startwithkotlin

import android.graphics.Color.red
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.lang.StringBuilder
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener{
            input.text = ""
            output.text = ""
        }
        buttonLeftBracket.setOnClickListener{
            input.text = addToInputText("(")
        }
        buttonRightBracket.setOnClickListener {
            input.text = addToInputText(")")
        }
        buttonDivision.setOnClickListener {
            input.text = addToInputText(":")
        }
        buttonMulti.setOnClickListener {
            input.text = addToInputText("x")
        }
        buttonMinus.setOnClickListener {
            input.text = addToInputText("-")
        }
        buttonPlus.setOnClickListener {
            input.text = addToInputText("+")
        }
        buttonDot.setOnClickListener {
            input.text = addToInputText(".")
        }
        button0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button9.setOnClickListener {
            input.text = addToInputText("9")
        }
        buttonEquals.setOnClickListener {
            showResult()
            getHistoryText()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String{
        var expression = input.text.replace(Regex(":"), "/")
        expression = expression.replace("x", "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression();
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
            }else{
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
            }
        }catch (e: Exception){
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
        }
    }
    private fun getHistoryText(){
        val expression = getInputExpression();
        val result = Expression(expression).calculate()
        val historyText = input.text.toString() + "=" + DecimalFormat("0.######\n").format(result).toString()
        history.text = historyText
    }
}