import junit.framework.TestCase;
import java.awt.*;
import java.awt.Color;

public class CarTest extends TestCase {
    public void testMove() {
        Car car = new Car(new Point(100, 100), Color.RED, 5, 100, 50, false);
        car.move();

        Point currentPosition = car.getCurrentPosition();
        assertEquals(105, currentPosition.x);
    }

    public void testIsMovingLeft() {
        Car car = new Car(new Point(100, 100), Color.RED, 5, 100, 50, true);
        assertTrue(car.isMoveLeft());
    }
}
