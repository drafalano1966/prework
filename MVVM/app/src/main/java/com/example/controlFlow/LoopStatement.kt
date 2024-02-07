package com.example.controlFlow

fun main(args: Array<String>) {

    val cakes = listOf("carrot", "cheese", "chocolate")

    println("***** FOR LOOP *****")
    for (cake in cakes) {                               // 1
        println("Yummy, it's a $cake cake!")
    }

    var cakesEaten = 0
    var cakesBaked = 0

    println("\n***** WHILE LOOP *****")

    while (cakesEaten < 5) {
        print("${cakesEaten} ")// 1
        eatACake()
        cakesEaten ++
    }

    println("\n***** DO LOOP *****")
    do {
        print("${cakesBaked} ") // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

    println("\n***** ITERATORS *****")
    for (animal in zoo) {                                   // 3
        println("Watch out, it's a ${animal.name}")
    }


}

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {             // 1
        return animals.iterator()                           // 2
    }
}