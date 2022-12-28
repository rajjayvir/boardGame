/**
 * This class is the extension of the Piece class that specifies the Fast piece.
 * Fast Piece can move n number of steps in left or right direction unless it in on the board
 *
 * Author: Jayvirsinh Raj
 * B00907110
 */

import java.awt.*;

public class FastPiece extends Piece {

    //constructor
    public FastPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }

//    public FastPiece() {
//
//    }


    /**
     * This method moves the fast piece as per the input
     * @param direction - is where the piece should be moved
     * @param n - steps that is needs to be moved
     */
    public void move(String direction, int n) {

        //set the position as per the steps in left direction
        if (direction.equals("left") && this.getPosition().y >= n && this.getPosition().y <= 7) {
            this.setPosition(new Point(getPosition().x, getPosition().y - n));
        }
        // set the position as per the steps in the right direction
        else if (direction.equals("right") && this.getPosition().y >= 0 && this.getPosition().y <= 7-n) {
            this.setPosition(new Point(getPosition().x, getPosition().y + n));

        }
        //Fast piece can not move in vertical direction
        else if (direction.equals("up") || direction.equals("down")) {
            System.out.println("This movement is invalid for this type of piece.");

        } else {
            System.out.println("This fast piece will be out of the board.");
        }
    }

    @Override
    //This method will print the piece on the board
    public String toString() {
        return super.getName() + super.getColour() + 'F';
    }


}
