import junit.framework.TestCase;
import java.awt.*;

public class FrogTest extends TestCase {
    public void testMove() {
        Frog frog = new Frog("TestFrog", new Point(100, 100));
        frog.move(20, 30);

        Point currentPosition = frog.getCurrentPosition();
        assertEquals(120, currentPosition.x);
        assertEquals(130, currentPosition.y);
    }

    public void testDistanceFromPoint() {
        Frog frog = new Frog("TestFrog", new Point(100, 100));
        Point pointToCheck = new Point(120, 130);
        double distance = frog.distanceFromPoint(pointToCheck);

        assertEquals(28.284271247461902, distance, 0.01);
    }
}
