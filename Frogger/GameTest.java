import junit.framework.TestCase;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameTest extends TestCase {
    public void testMovePlayer() {
        Game game = new Game("TestFrog", new Point(100, 100));
        game.movePlayer(KeyEvent.VK_UP, 20);

        assertEquals(80, game.getPlayer().getCurrentPosition().y);
    }

    public void testMoveCars() {
        Game game = new Game("TestFrog", new Point(100, 100));
        game.moveCars(400);

        int carX = game.getCars().get(0).getCurrentPosition().x;
        assertTrue(carX < 100 || carX > 400);
    }
}
