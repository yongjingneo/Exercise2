package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener() {
            try {
                val height = heightInput.text.toString().toDouble()
                val weight = weightInput.text.toString().toDouble()

                val bmi = calculateBMI(height, weight)

                if(bmi<18.5) {
                    image.setImageResource(R.drawable.under)
                    bmiResult.setText(String.format("%.2f",bmi) + "(Under)")
                }
                else if(bmi>=18.5 && bmi<=24.9) {
                    image.setImageResource(R.drawable.normal)
                    bmiResult.setText(String.format("%.2f",bmi) + "(Normal)")
                }
                else {
                    image.setImageResource(R.drawable.over)
                    bmiResult.setText(String.format("%.2f",bmi) + "(Over)")
                }
            }
            catch (ex:Exception){
                //Toast.makeText(applicationContext,"Please input value.", Toast.LENGTH_SHORT).show()
                val toast:Toast = Toast.makeText(applicationContext,"Please input value.", Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }


        btnReset.setOnClickListener() {
            heightInput.setText("")
            weightInput.setText("")
            bmiResult.setText("")
            image.setImageResource(R.drawable.empty)
        }
    }

    private fun calculateBMI(height:Double, weight:Double):Double{
        return weight/(height*height)
    }
}
