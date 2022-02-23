package com.gildedrose

interface Animal {
    fun shout(): String
}

class Dog(): Animal {
    override fun shout() = "Bark bark"
}
class Cat(): Animal {
    override fun shout() = "Meow"
}
class Bird(): Animal {
    override fun shout() = "Pew pew"
}
class Lion(): Animal {
    override fun shout() = "roarrrrr !"
}

fun main() {
    listOf<Animal>(Dog(), Cat(), Dog(), Bird(), Lion(), Bird())
        .onEach { `fais ton numero`(it) }
}

fun `fais ton numero`(animal: Animal) {
    println(animal.shout())
}