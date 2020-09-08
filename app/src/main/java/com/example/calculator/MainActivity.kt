package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonCLick(view: View) {
        if (isNewOp) {
            Entry.setText("")
            lastDot = false
        }
        isNewOp = false
        val buSelect = view as Button
        var buClickValue: String = Entry.text.toString()
        when (buSelect.id) {
            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            budot.id -> {
                if(lastDot==false){
                    buClickValue += "."
                    lastDot=true
                }
            }
            bupm.id -> {
                buClickValue = "-" + buClickValue
            }
        }
        Entry.setText(buClickValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true
    var lastDot = false
    fun buttonOp(view: View) {
        val buSelect = view as Button
        when (buSelect.id) {
            bumult.id -> {
                op = "*"
            }
            budiv.id -> {
                op = "/"
            }
            busub.id -> {
                op = "-"
            }
            buadd.id -> {
                op = "+"
            }
        }
        oldNumber = Entry.text.toString()
        isNewOp = true
    }

    fun buttonEqual(view: View) {
        lastDot = false
        val newNumber = Entry.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber = oldNumber.toDouble() *newNumber.toDouble()
            }
            "/"->{
                finalNumber = oldNumber.toDouble() /newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() +newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() -newNumber.toDouble()
            }
        }
        Entry.setText(finalNumber.toString())
        isNewOp = true
    }

    fun buttonPercent(view: View) {
        val number:Double = Entry.text.toString().toDouble()/100
        Entry.setText(number.toString())
    }

    fun buttonDelete(view: View) {
        Entry.setText("0")
        isNewOp=true
    }

}
