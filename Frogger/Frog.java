import java.awt.*;
import java.awt.Point;


/**
 * Author: Arpii - [Your Banner Number]
 * This class represents a frog in a simple version of the Frogger game.
 * The frog's name and current position are stored, and it can be moved and
 * calculate its distance from a point.
 */

public class Frog {
    // Instance variables
    private final String name;
    private Point currentPosition;

    /**
     * Constructor for a Frog object with a given name and starting position.
     *
     * @param name The name of the frog.
     * @param currentPosition The starting position of the frog.
     */
    public Frog(String name, Point currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    /**
     * Constructor for a Frog object with a given name and a default starting position (0, 0).
     *
     * @param name The name of the frog.
     */
    public Frog(String name) {
        this(name, new Point(0, 0));
    }

    /**
     * Returns the current position of the frog object.
     *
     * @return The current position of the frog object.
     */
    public Point getCurrentPosition() {
        return currentPosition;
    }

    public int getY() {
        return currentPosition.y;
    }

    /**
     * Moves the frog by given x and y translations.
     *
     * @param dx The x translation.
     * @param dy The y translation.
     */
    public void move(int dx, int dy) {
        currentPosition.translate(dx, dy);
    }

    /**
     * Computes the distance between the frog object and a given point.
     *
     * @param point The point to which the distance will be calculated.
     * @return The distance between the frog object and the given point.
     */
    public double distanceFromPoint(Point point) {
        return point.distance(currentPosition);
    }

    public boolean intersects(Car car) {
        Rectangle frogBounds = new Rectangle(currentPosition.x, currentPosition.y, 20, 20);
        Rectangle carBounds = new Rectangle(car.getX(), car.getY(), car.getxSize(), car.getySize());
        return frogBounds.intersects(carBounds);
    }


    /**
     * Returns a string representation of the frog.
     *
     * @return A string representation of the frog in the format: "The frog named [name] is at ([x],[y])"
     */
    @Override
    public String toString() {
        return "The frog named " + name + " is at " + currentPosition;
    }
}
