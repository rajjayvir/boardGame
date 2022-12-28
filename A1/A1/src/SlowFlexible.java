/**
 * This method extends the Slow Piece and describes the Slow Flexible Piece
 * Slow Flexible Piece can move up, down, left, right 1 step only
 *
 * Author Jayvirsinh Raj
 * B00907110
 */

import java.awt.*;

public class SlowFlexible extends SlowPiece {

//    public SlowFlexible() {
//    }

    //constructor
    public SlowFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

    /**
     * This method moves the Slow flexible piece as per the input in left or right direction 1 step
     * @param direction - in which the user wants to move the piece
     */
    public void move(String direction) {

        if (direction.equals("left") && this.getPosition().y >= 1 && this.getPosition().y <= 7) {
            this.setPosition(new Point(getPosition().x, getPosition().y - 1));
        } else if (direction.equals("up") && this.getPosition().x >= 1 && this.getPosition().y <=7) {
            this.setPosition(new Point(getPosition().x-1, getPosition().y));
        } else if (direction.equals("down") && this.getPosition().x <= 6 && this.getPosition().x >= 0) {
            this.setPosition(new Point(getPosition().x + 1, getPosition().y));
        } else if (direction.equals("right") && this.getPosition().y <= 6 && this.getPosition().y >= 0) {
            this.setPosition(new Point(getPosition().x, getPosition().y + 1));
        } else {
            System.out.println("This SlowFlexible piece will be out of the board.");
        }
    }

    @Override
    //Prints the required to be output on the board
    public String toString() {
        return super.getName() + super.getColour() + "SF";
    }
}
