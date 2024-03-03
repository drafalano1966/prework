package com.example.specialclasses
import java.util.Random

class LuckDispatcher {                    //1
    fun getNumber() {                     //2
        val objRandom = Random()
        println("Lucky Dispatcher number: ${objRandom.nextInt(90)}")
    }
}

class BigBen {                                  //1
    companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ($i) ")
            }
            println()
        }
    }
}

fun main() {
    val d1 = LuckDispatcher()             //3
    val d2 = LuckDispatcher()

    d1.getNumber()                     //4
    d2.getNumber()                       //4

    rentPrice(10, 2, 1)

    DoAuth.takeParams("foo", "qwerty")                          //3

    BigBen.getBongs(12)                         //4

}
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int) {  //1

    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total\n")                                               //4
}

object DoAuth {                                                 //1
    fun takeParams(username: String, password: String) {        //2
        println("input Auth parameters = $username:$password")
    }
}