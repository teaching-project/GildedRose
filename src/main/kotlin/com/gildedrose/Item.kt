package com.gildedrose

class AgedBrie(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {
    override fun decay() {
        if (quality < 50) {
            if (sellIn > 0) {
                ++quality
            } else {
                quality += 2
            }
        }
        --sellIn
    }
}

class Sulfuras(sellIn: Int) : Item("Sulfuras, Hand of Ragnaros", sellIn, 80) {
    override fun decay() {

    }
}

class ConcertTicket(sellIn: Int, quality: Int) : Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    override fun decay() {
        if (sellIn <= 0) {
            quality = 0
        } else if (sellIn <= 5) {
            quality += 3
        } else if (sellIn <= 10) {
            quality += 2
        } else {
            quality++
        }
        --sellIn
    }
}


open class Item(var name: String, var sellIn: Int, var quality: Int) {
    init {
        if (quality < 0)
            throw RuntimeException("The quality is negative")
        if (name != "Sulfuras, Hand of Ragnaros" && quality > 50)
            throw RuntimeException("You must declare a quality less than 50")
    }

    open fun decay() {
        if (sellIn > 0 && quality > 0)
            --quality
        else if (sellIn <= 0 && quality > 0)
            quality -= 2
        --sellIn
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is Item || other == null) false
        else name == other.name && sellIn == other.sellIn && quality == other.quality
    }

    override fun toString(): String {
        return "$name -Sellin : $sellIn -Quality : $quality"
    }
}


