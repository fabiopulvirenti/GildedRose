package com.gildedrose;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class GildedRoseTest {

    @Test
    public void testAgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 4, 10),
                new Item("Aged Brie", 8, 2),
                new Item("Aged Brie", -2, 1),
                new Item("Aged Brie", -1, 50),
                new Item("Aged Brie", 0, 10),
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(3,           app.items[0].sellIn);
        Assertions.assertEquals(11,          app.items[0].quality);

        Assertions.assertEquals("Aged Brie", app.items[1].name);
        Assertions.assertEquals(7,           app.items[1].sellIn);
        Assertions.assertEquals(3,           app.items[1].quality);

        Assertions.assertEquals("Aged Brie", app.items[2].name);
        Assertions.assertEquals(-3,           app.items[2].sellIn);
        Assertions.assertEquals(3,           app.items[2].quality);

        Assertions.assertEquals("Aged Brie", app.items[3].name);
        Assertions.assertEquals(-2,           app.items[3].sellIn);
        Assertions.assertEquals(50,           app.items[3].quality);

        Assertions.assertEquals("Aged Brie", app.items[4].name);
        Assertions.assertEquals(-1,           app.items[4].sellIn);
        Assertions.assertEquals(12,           app.items[4].quality);

    }

    @Test
    public void updateAgedBrieTest() {
        GildedRose app = new GildedRose(new Item[]{});
        Item item1 = new Item("Aged Brie", 4, 10);

        app.updateAgedBrie(item1);

        Assertions.assertEquals("Aged Brie", item1.name);
        Assertions.assertEquals(4,           item1.sellIn);
        Assertions.assertEquals(11,          item1.quality);

    }

    @Test
    void testBackstagePasses() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50),
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Assertions.assertEquals(14, items[0].sellIn);
        Assertions.assertEquals(21, items[0].quality);

        Assertions.assertEquals(9, items[1].sellIn);
        Assertions.assertEquals(32, items[1].quality);

        Assertions.assertEquals(4, items[2].sellIn);
        Assertions.assertEquals(45, items[2].quality);

        Assertions.assertEquals(-2, items[3].sellIn);
        Assertions.assertEquals(0, items[3].quality);

    }



    @Test
    void testUpdateBackstagePasses() {
        GildedRose app = new GildedRose(new Item[]{});

        // --- Item 1
        Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        app.updateBackstagePasses(item1);

        Assertions.assertEquals(15, item1.sellIn);
        Assertions.assertEquals(21, item1.quality);

        // --- Item 2
        Item item2 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        app.updateBackstagePasses(item2);

        Assertions.assertEquals(10, item2.sellIn);
        Assertions.assertEquals(22, item2.quality);

        // --- Item 3
        Item item3 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20);
        app.updateBackstagePasses(item3);

        Assertions.assertEquals(4, item3.sellIn);
        Assertions.assertEquals(25, item3.quality);

        // --- Item 4
        Item item4 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50);
        app.updateBackstagePasses(item4);

        Assertions.assertEquals(4, item4.sellIn);
        Assertions.assertEquals(50, item4.quality);

        // --- Item 4
        Item item5 = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50);
        app.updateBackstagePasses(item5);

        Assertions.assertEquals(-1, item5.sellIn);
        Assertions.assertEquals(0, item5.quality);


    }

    @Test
    public void sulfuresTest (){
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 4, 10),
                new Item("Sulfuras, Hand of Ragnaros", 8, 2),
                new Item("Sulfuras, Hand of Ragnaros", -2, 1),
                new Item("Sulfuras, Hand of Ragnaros", -1, 50),
                new Item("Sulfuras, Hand of Ragnaros", 0, 10),
                new Item("Sulfuras, Hand of Ragnaros", -5, 80),
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Assertions.assertEquals(4,           app.items[0].sellIn);
        Assertions.assertEquals(10,          app.items[0].quality);

        Assertions.assertEquals(8,           app.items[1].sellIn);
        Assertions.assertEquals(2,           app.items[1].quality);

        Assertions.assertEquals(-2,           app.items[2].sellIn);
        Assertions.assertEquals(1,           app.items[2].quality);

        Assertions.assertEquals(-1,           app.items[3].sellIn);
        Assertions.assertEquals(50,           app.items[3].quality);

        Assertions.assertEquals(0,           app.items[4].sellIn);
        Assertions.assertEquals(10,           app.items[4].quality);

        Assertions.assertEquals(-5,           app.items[5].sellIn);
        Assertions.assertEquals(80,           app.items[5].quality);

    }

}
