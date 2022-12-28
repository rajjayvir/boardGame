/**
 * This class describes a board on which the game is going to be played
 * This class contains the method like adding a piece, moving a piece and printing the board
 * <p>
 * Author: Jayvirsinh Raj
 * B00907110
 */

import java.awt.*;

public class Board {

    //initialise a board
    public Piece[][] gameBoard;

    //constructor
    public Board() {
        gameBoard = new Piece[8][8];
    }


    //getters and setters
    public Piece[][] getBoard() {
        return gameBoard;
    }

    public void setBoard(Piece[][] board) {
        this.gameBoard = board;
    }


    /**
     * This method adds a piece to the board
     * @param A - Adds this piece to the board
     */
    public void addPiece(Piece A) {

        //if there is a piece on the board then we can not add another piece on the same position
        if (gameBoard[A.getPosition().x][A.getPosition().y] != null) {
            System.out.println("There is a piece on this position");

        }
        //Adds the piece of the specific type to the board
        if (gameBoard[A.getPosition().x][A.getPosition().y] == null) {
            if (A instanceof SlowPiece) {
                if (A instanceof SlowFlexible) {
                    gameBoard[A.getPosition().x][A.getPosition().y] = A;

                }
                gameBoard[A.getPosition().x][A.getPosition().y] = A;
            } else if (A instanceof FastPiece) {
                if (A instanceof FastFlexible) {
                    gameBoard[A.getPosition().x][A.getPosition().y] = A;
                }
                gameBoard[A.getPosition().x][A.getPosition().y] = A;

            }

        }
    }

    //moves the piece on the board to the specific location as per the input
    public void move(Point A, String direction, int steps) {

        //if there is no piece on the location
        if (gameBoard[A.x][A.y] == null) {
            System.out.println("Error: no piece at " + "(" + A.x + "," + A.y + ")");
        }
        if (!(gameBoard[A.x][A.y] == null)) {
            Piece check = gameBoard[A.x][A.y];

            if ((check instanceof SlowPiece) && steps == 1) {

                if (check instanceof SlowFlexible) {
                    check = new SlowFlexible(check.getName(), check.getColour(), new Point(A.x, A.y));
                    ((SlowFlexible) check).move(direction);
                    addPiece(check);
                    gameBoard[A.x][A.y] = null;
                    System.out.println("Piece at " + "[" + A.getX() + "," + A.getY() + "] " + " moved " + direction + " by " + steps + " spaces ");
                } else {
                    check = new SlowPiece(check.getName(), check.getColour(), new Point(A.x, A.y));
                    ((SlowPiece) check).move(direction);
                    if (direction.equals("left") || direction.equals("right")) {
                        addPiece(check);
                        gameBoard[A.x][A.y] = null;
                        System.out.println("Piece at " + "[" + A.getX() + "," + A.getY() + "] " + " moved " + direction + " by " + steps + " spaces ");
                    }
                }
            } else if (check instanceof FastPiece) {
                if (check instanceof FastFlexible) {
                    check = new FastFlexible(check.getName(), check.getColour(), new Point(A.x, A.y));
                    ((FastFlexible) check).move(direction, steps);
                    if (steps + A.y <= 7 || steps + A.x <= 7) {
                        addPiece(check);
                        gameBoard[A.x][A.y] = null;
                        System.out.println("Piece at " + "[" + A.getX() + "," + A.getY() + "] " + " moved " + direction + " by " + steps + " spaces ");
                    }
                } else {
                    check = new FastPiece(check.getName(), check.getColour(), new Point(A.x, A.y));
                    ((FastPiece) check).move(direction, steps);
                    if ((direction.equals("left") || direction.equals("right")) && steps + A.y <= 7 || steps + A.x <= 7) {
                        addPiece(check);
                        gameBoard[A.x][A.y] = null;
                        System.out.println("Piece at " + "[" + A.getX() + "," + A.getY() + "] " + " moved " + direction + " by " + steps + " spaces ");
                    }
                }

            } else {
                System.out.println("move method error or wrong type checked");
            }

        }

    }

    //print the board with the pieces
    public void display() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gameBoard[i][j] == null) {
                    System.out.print("-\t\t");
                } else {
                    System.out.print(gameBoard[i][j]);
                }
            }
            System.out.println();
        }
    }


}