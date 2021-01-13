package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calc(view: View) {
        var x = weightInKg.text.toString().replace(',','.').replace(" ","")
        var y=  heightInCm.text.toString().replace(',','.').replace(" ","")
        if (x.length > 0 && y.length > 0 ){
            var weight = x.toDouble()
            var height = y.toDouble()
            if (weight>0 && height>0){
                var bmi=CalculateBmi.calculate(weight,height).result
                val rounded = String.format("%.2f", bmi)
                var image=CalculateBmi.calculate(weight,height).z
                result.setText(rounded)
                result.visibility=View.VISIBLE
                display(image)}
            else{
                Error()
            }
        }
        else{
            Error()
        }

    }
    fun display(c:Int){
        when(c){
            0->imageView.setImageResource(R.drawable.underweight)
            1->imageView.setImageResource(R.drawable.healthy)
            2->imageView.setImageResource(R.drawable.overweight)
            3->imageView.setImageResource(R.drawable.obesity)
            else->imageView.setImageResource(R.drawable.obesity)
        }
     weightInKg.setText("")
     heightInCm.setText("")
     imageView.visibility=View.VISIBLE
    }

    fun Error(){
        result.setText("try again ")
        result.visibility=View.VISIBLE
    }

}