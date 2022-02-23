package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `Name are found`() {
        //Given
        val items = Item("foo", 0, 0)
        val gildedRose = GildedRose(items, items)

        //When
        gildedRose.decay()

        //Then
        assertEquals("foo", gildedRose.items[0].name)

    }

    @Test
    fun `Quality should always be positive`() {
        //given
        //when
        val executable: () -> Unit = {Item("sword", 0, -5)}
        //then
        Assertions.assertThrows(RuntimeException::class.java, executable)
    }

    @Test
    fun `Quality should always remain positive`() {
        //given
        val item = Item("sword", 0, 0)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(0, item.quality)
    }

    @Test
    fun `Quality && sellIn diminue de 1 chaque jour`() {
        //given
        val item = Item("sword", 10, 12)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(Item("sword", 9, 11), item)
    }

    @Test
    fun `Once sellIn = 0, Quality degrade by twice`() {
        //given
        val item = Item("sword", 0, 12)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(Item("sword", -1, 10), item)
    }

    @Test
    fun `Aged Brie quality increase by time`() {
        //given
        val item = AgedBrie(5, 12)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(AgedBrie(4, 13), item)
    }

    @Test
    fun `After peremption date, quality raise +2`() {
        //given
        val item = AgedBrie(-1, 12)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(AgedBrie(-2, 14), item)
    }

    @Test
    fun `Quality never more than 50`() {
        //given
        val item = AgedBrie(5, 50)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(AgedBrie(4, 50), item)
    }

    @Test
    fun `Quality alway the same and sellin remains for Sulfuras item`(){
        //given
        val item = Sulfuras(5)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(Sulfuras(5), item)
    }

    @Test
    fun `We cannot declare quality over 50`() {
        //given
        //when
        val executable: () -> Unit = {Item("sword", 0, 60)}
        //then
        Assertions.assertThrows(RuntimeException::class.java, executable)
    }

    @Test
   fun `La qualité augmente de 2 quand il reste 10 jours ou moins`()
   {
       //given
       val item = ConcertTicket( 10, 12)
       val gildedRose = GildedRose(item)
       //when
       gildedRose.decay()
       //then
       assertEquals(ConcertTicket(9, 14), item)
   }

    @Test
   fun `La qualité augmente de 3 quand il reste 5 jours ou moins`()
   {
       //given
       val item = ConcertTicket(5, 12)
       val gildedRose = GildedRose(item)
       //when
       gildedRose.decay()
       //then
       assertEquals(ConcertTicket(4, 15), item)
   }

    @Test
   fun `La qualité tombe à 0 après le concert`()
   {
       //given
       val item = ConcertTicket(0, 12)
       val gildedRose = GildedRose(item)
       //when
       gildedRose.decay()
       //then
       assertEquals(ConcertTicket(-1, 0), item)
   }

    @Test
    fun `La qualité est au dessus de 10`()
    {
        //given
        val item = ConcertTicket( 12, 12)
        val gildedRose = GildedRose(item)
        //when
        gildedRose.decay()
        //then
        assertEquals(ConcertTicket(11, 13), item)
    }


}


