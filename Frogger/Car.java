import java.awt.Color;
import java.awt.Point;


/**
 * This class models cars in the Frogger game. Cars move horizontally on the game screen,
 * either from left to right or right to left. Objects of this class store their current
 * position, color, size, movement speed, and direction of movement.
 *
 * @author Arpii - [Banner Num!]
 */


public class Car {
    private Point currentPosition;
    private Color bodyColour;
    private int movementSpeed;
    private int xSize;
    private int ySize;
    private boolean moveLeft;


    /**
     * Creates a new car with the specified attributes.
     *
     * @param currentPosition The initial position of the car.
     * @param bodyColour      The color of the car.
     * @param movementSpeed  The speed at which the car moves.
     * @param xSize          The width of the car.
     * @param ySize          The height of the car.
     * @param moveLeft       Set to true if the car should move from right to left, false if left to right.
     */
    public Car(Point currentPosition, Color bodyColour, int movementSpeed, int xSize, int ySize, boolean moveLeft) {
        this.currentPosition = currentPosition;
        this.bodyColour = bodyColour;
        this.movementSpeed = movementSpeed;
        this.xSize = xSize;
        this.ySize = ySize;
        this.moveLeft = moveLeft;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Color getBodyColour() {
        return bodyColour;
    }

    public void setBodyColour(Color bodyColour) {
        this.bodyColour = bodyColour;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getX() {
        return currentPosition.x;
    }

    public int getY() {
        return currentPosition.y;
    }


    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void move() {
        if (moveLeft) {
            currentPosition.x -= movementSpeed;
        } else {
            currentPosition.x += movementSpeed;
        }
    }

    public void moveBack(int gameScreenWidth) {
        if (moveLeft) {
            currentPosition.x = gameScreenWidth;
        } else {
            currentPosition.x = -xSize;
        }
    }

}
