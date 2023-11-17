package com.gildedrose;

class GildedRose {
    Item[] items;

    private static String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static void main(String[] args) {

    }

    public void updateQuality() {
        for( Item item : items) {

            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":

                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(item);
                    break;
                default:
                    item.quality = item.quality - 1;
            }

            if (item.quality < 0) {
                item.quality = 0;
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }
        }
    }


    public void updateAgedBrie(Item item) {
        if (item.sellIn <= 0) {
            item.quality = Math.min(item.quality + 2, 50);
        } else {
            item.quality = Math.min(item.quality + 1, 50);
        }
    }

    public void updateBackstagePasses(Item item) {
        if (item.sellIn <= 10) {
            item.quality = Math.min(item.quality + 2, 50);
        }
        if (item.sellIn <= 6) {
            item.quality = Math.min(item.quality + 3, 50);
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }

        if( item.sellIn > 10) {
            item.quality = Math.min(item.quality + 1, 50);
        }
    }
}
