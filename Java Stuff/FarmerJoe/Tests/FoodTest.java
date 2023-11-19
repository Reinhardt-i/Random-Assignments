package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void testGetRequiredArea() {
        Food carrot = new Vegetable("Carrot", 750.32, 15, 100);
        assertEquals(100, carrot.getRequiredArea());
    }

    @Test
    void testIsReadyToHarvest() {
        Food apple = new Fruit("Apple", 1250.00, 15, 275);
        for (int i = 0; i < 15; i++) {
            apple.grow();
        }
        assertTrue(apple.isReadyToHarvest());
    }

    @Test
    void testGetDaysSincePotted() {
        Food cabbage = new Vegetable("Cabbage", 239.75, 10, 50);
        for (int i = 0; i < 5; i++) {
            cabbage.grow();
        }
        assertEquals(5, cabbage.getDaysSincePotted());
    }
}
