/**
 * This is the piece class where all the information regarding the piece are stored and accessed.
 *
 * Author: Jayvirsinh Raj
 * B00907110
 */

import java.awt.*;

public class Piece {

    //instance variables
    private String name;
    private String colour;
    private Point position;

    //constructor
    public Piece(String name, String colour, Point position) {
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

//    public Piece() {
//    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    //toString method that is used in the other extended classes
    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", position=" + position +
                '}';
    }
}


