/**
 * This class has been extended from the Piece class and contains the information and methods regarding a specific type of Piece(Slow Piece)
 * Slow Piece can move left or right 1 step only.
 * Author: Jayvirsinh Raj
 * B00907110
 */

import java.awt.*;

public class SlowPiece extends Piece {

    //constructor
    public SlowPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }

//    public SlowPiece() {
//        super();
//    }

    /**
     * This methods moves the Slow piece by one step from its position either in right or in left direction.
     * @param direction - in which the user wants to move the piece
     */
    public void move(String direction) {

        //if the input is left, set the position of the piece to the one left to it
        if (direction.equals("left") && this.getPosition().y >= 1 && this.getPosition().y <= 7) {
            this.setPosition(new Point(getPosition().x, getPosition().y - 1));
        }
        //if the input is left, set the position of the piece to the one lef to it
        else if (direction.equals("right") && this.getPosition().y <= 6 && this.getPosition().y >= 0) {
            super.setPosition(new Point(getPosition().x, getPosition().y + 1));
        } else if (direction.equals("up") || direction.equals("down")) {
            System.out.println("This movement is invalid for this type of piece.");
        } else {
            System.out.println("This slow piece will be out of the board.");
        }

    }

    @Override
    //This will print the piece on the board
    public String toString() {
        return super.getName() + super.getColour() + 'S';
    }


}
