import java.awt.*;


/**
 * Author: Arpii - [Your Banner Number]
 *
 * This class represents the game logic of Frogger. It controls the player, cars, and game outcome.
 */
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Game {

    private Frog player;
    private ArrayList<Car> cars;

    /**
     * Constructs a Frogger game with a player and cars.
     *
     * @param name  The name of the player's frog.
     * @param start The starting position of the player's frog.
     */
    public Game(String name, Point start) {
        player = new Frog(name, start);
        cars = new ArrayList<>();

        // Add cars to the game
        cars.add(new Car(new Point(100, 400), Color.BLACK, 10, 120, 75, false));
        cars.add(new Car(new Point(0, 300), Color.BLUE, 30, 200, 75, false));
        cars.add(new Car(new Point(100, 150), Color.BLACK, 10, 120, 75, true));
        cars.add(new Car(new Point(0, 80), Color.BLACK, 20, 120, 75, true));
    }

    /**
     * Returns the player frog.
     *
     * @return The player frog.
     */
    public Frog getPlayer() {
        return player;
    }

    /**
     * Returns the list of cars in the game.
     *
     * @return The list of cars in the game.
     */
    public ArrayList<Car> getCars() {
        return cars;
    }

    /**
     * Moves the player frog in response to keyboard input.
     *
     * @param keyCode The key code representing the direction of movement.
     * @param step    The distance (in pixels) the player should move.
     */
    public void movePlayer(int keyCode, int step) {
        switch (keyCode) {
            case KeyEvent.VK_UP -> player.move(0, -step);
            case KeyEvent.VK_DOWN -> player.move(0, step);
            case KeyEvent.VK_LEFT -> player.move(-step, 0);
            case KeyEvent.VK_RIGHT -> player.move(step, 0);
        }
    }

    /**
     * Moves the cars in the game and handles car wrapping at the game edge.
     *
     * @param edge The edge of the game area.
     */
    public void moveCars(int edge) {
        for (Car car : cars) {
            car.move();
            if (car.getX() < 0 || car.getX() > edge) {
                car.moveBack(edge);
            }
        }
    }

    /**
     * Checks if the player frog is hit by any car in the game.
     *
     * @return true if the player frog is hit by a car, false otherwise.
     */
    public boolean isPlayerHit() {
        for (Car car : cars) {
            if (player.intersects(car)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Determines if the player frog has won the game.
     *
     * @return true if the player frog has crossed the game area, false otherwise.
     */
    public boolean hasPlayerWon() {
        return player.getY() < 20;
    }
}
