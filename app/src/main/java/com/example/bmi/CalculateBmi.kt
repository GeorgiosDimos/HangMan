package com.example.bmi

class CalculateBmi{
    companion object {
        fun calculate(wei: Double, hei: Double): Image{
            var result=(wei/hei/hei)*10000
            var z=image(result)
            return Image(result,z)
        }

        fun image(result : Double):Int{
            if(result<18.5){
                return 0
            }
            else if (result>=18.5 && result<=24.9){
                return 1
            }
            else if (result>=25 && result<=29.9){
                return 2
            }
            else if (result>=30 && result<=34.9){
                return 3
            }
            else{
                return 4
            }
    }
}
}
data class Image (var result :Double,var z : Int){}