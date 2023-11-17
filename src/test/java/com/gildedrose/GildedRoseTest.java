package com.gildedrose;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class GildedRoseTest {



    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertEquals("foo", app.items[0].name);
    }

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
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Assertions.assertEquals(14, items[0].sellIn);
        Assertions.assertEquals(21, items[0].quality);
        Assertions.assertEquals(9, items[1].sellIn);
        Assertions.assertEquals(32, items[1].quality);
        Assertions.assertEquals(4, items[2].sellIn);

    }



}
