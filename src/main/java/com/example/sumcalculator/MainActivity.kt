package com.example.sumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataView: EditText
    var operator = "-"
    var oldCount=""
    var newOperator=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataView = findViewById(R.id.dataView)
    }

    fun btn_Click(view: View) {
        if (newOperator) {
            dataView.setText("")
        }
        newOperator = false
        var btnSelect = view as Button
        var btnClickValue: String = dataView.text.toString()
        if (view.id == R.id.buttonzero) {
            btnClickValue += "0"
        }
        if (view.id ==R.id. buttonone) {
            btnClickValue += "1"
        }
        if (view.id ==R.id. buttontwo) {
            btnClickValue += "2"
        }
        if (view.id ==R.id. buttonthree) {
            btnClickValue += "3"
        }
        if (view.id == R.id.buttonfour) {
            btnClickValue += "4"
        }
        if (view.id == R.id.buttonfi) {
            btnClickValue += "5"
        }
        if (view.id == R.id.button6) {
            btnClickValue += "6"
        }
        if (view.id == R.id.button7) {
            btnClickValue += "7"
        }
        if (view.id == R.id.button8) {
            btnClickValue += "8"
        }
        if (view.id == R.id.button9) {
            btnClickValue += "9"
        }
        dataView.setText(btnClickValue)
    }

    fun butonOperation(view:View) {
        var select = view as Button
        if ((select.id) == R.id.button_sum)
            operator = "+"




        oldCount = dataView.text.toString()
        newOperator = true
    }
    fun Equals(view: View) {
        var newCount= dataView.text.toString()
        var result:Double?=null
        //when işlemi ile operator butonların işlevlerini sağladık
        when(operator){
            "+"->{
                result=oldCount.toDouble()+newCount.toDouble()
            }
        }
        dataView.setText(result.toString())
        newOperator=true}

    fun Ac(view: View) {
       dataView.setText("0")
        newOperator=true
    }
    fun onDecimalPointClick(view: View) {
        if (newOperator) {
            dataView.setText("0.")
            newOperator = false
        } else if (!dataView.text.contains(".")) {
            dataView.append(".")
        }
    }
    fun Number.formatWithComma(): String {
        return NumberFormat.getNumberInstance(Locale.US).format(this)
    }
}



