package codingDojo.refactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    @DisplayName("Aged Brie with 1 day to sell and quality 1 when successful.")
    public void agedBriUpdateTest(){
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 0)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Assertions.assertEquals(1, items[0].sellIn);
        Assertions.assertEquals(1, items[0].quality);
        Assertions.assertEquals("Aged Brie", items[0].name);
    }

    @Test
    @DisplayName("Sulfuras sell days and quality doesn't chenge when successful.")
    public void sulfurasUpdateTest(){
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Assertions.assertEquals(-1, items[0].sellIn);
        Assertions.assertEquals(80, items[0].quality);
        Assertions.assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
    }

}