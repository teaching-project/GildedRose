package com.gildedrose

class GildedRose {

    var items: Array<Item> = arrayOf()

    constructor(vararg item: Item) {
        items = arrayOf(*item)
    }

    private fun updateQuality(item: Item, number: Int) {
        item.quality += number
    }

    fun decay() {
        for (i in items.indices) {
                items[i].decay()
        }
    }
}

