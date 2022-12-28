/**
 * This method extends the Fast Piece and describes the Fast Flexible Piece
 * Fast Flexible Piece can move up, down, left, right n number of steps
 * <p>
 * Author Jayvirsinh Raj
 * B00907110
 */

import java.awt.*;

public class FastFlexible extends FastPiece {

    public FastFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

//    public FastFlexible() {
//
//    }

    /**
     * This method moves the fast flexible piece as per the input in left or right direction n number of step
     * @param direction - in which the user wants to move the piece
     * @param n - number of steps that need to be moved
     */
    public void move(String direction, int n) {

        int x, y;
        if (direction.equals("left") && this.getPosition().y >= n && this.getPosition().y <= 7) {
            this.setPosition(new Point(getPosition().x, getPosition().y - n));
        } else if (direction.equals("up") && this.getPosition().x >= n && this.getPosition().x <= 7) {
            this.setPosition(new Point(getPosition().x - n, getPosition().y));
        } else if (direction.equals("down") && this.getPosition().x >= 0 && this.getPosition().x <= 7-n) {
            this.setPosition(new Point(getPosition().x + n, getPosition().y));
        } else if (direction.equals("right") && this.getPosition().y >= 0 && this.getPosition().y <= 7-n) {
            this.setPosition(new Point(getPosition().x, getPosition().y + n));
        } else {
            System.out.println("This fast flexible piece will be out of the board.");
        }
    }


    @Override
    //This prints the piece on the board
    public String toString() {
        return super.getName() + super.getColour() + "FF";
    }
}
