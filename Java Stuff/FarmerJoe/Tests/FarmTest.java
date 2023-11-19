package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FarmTest {

    @Test
    void testHasEnoughSpace() {
        Farm farm = new Farm(1000, Soil.Loam);
        Food apple = new Fruit("Apple", 1250.00, 15, 275);
        assertTrue(farm.hasEnoughSpace(apple));
        farm.seedFood(apple);
        assertFalse(farm.hasEnoughSpace(new Fruit("Apple", 1250.00, 15, 800)));
    }
}
