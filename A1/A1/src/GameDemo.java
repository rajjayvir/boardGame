/**
 * CSCI 2110 Assignment 1
 * <p>
 * This is the main class of the whole assignment where I have taken input and played the whole game
 * <p>
 * Author: Jayvirsinh Raj
 * B00907110
 */

import java.awt.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameDemo {

    public static void main(String[] args) {

        //insialise a scanner class
        Scanner kb = new Scanner(System.in);

        //create a board where the game is to be played
        Board board = new Board();


        System.out.println("Enter a command (type help for details):");
        String command = "";


        //take the repeated input until the input is done
//        while (!(command.equals("exit"))) {
        while (kb.hasNext()) {
            command = kb.next();

            //if the command is help
            if (command.equals("help")) {
                System.out.println("Possible commands are as follows: \n" +
                        "create location [fast][flexible]: Creates a new piece.\n" +
                        "move location direction [spaces]: Moves a piece. \n" +
                        "print: Displays the board. \n" +
                        "help: Displays help. \n" +
                        "exit: Exits the program.");

            }
            //if the command is print
            else if (command.equals("print")) {
                board.display();
            }
            //if the command is create
            else if (command.equals("create")) {

                //I have used tokenizer where I have divided the input into Piece type, Point Position.
                StringTokenizer total = new StringTokenizer(kb.nextLine());

                String type = "";
                String xPosS = total.nextToken();
                String yPosS = total.nextToken();

                //This will be used if we enter fast flexible, and it is not necessary that there will be 2 inputs every time.
                if (total.hasMoreTokens()) {
                    type = total.nextToken();
                }
                //combine fast and flexible at the end and check if it fast flexible
                if (total.hasMoreTokens()) {
                    type = type + " " + total.nextToken();
                }

                //convert the String to int for the point position
                int xPos = Integer.parseInt(xPosS);
                int yPos = Integer.parseInt(yPosS);

                if (xPos < 0 || xPos > 7 || yPos < 0 || yPos > 7) {
                    System.out.println("Out of Bound");
                    System.out.println("Enter a command (type help for details):");

                    continue;
                }

                //check the type of the Piece and then add the piece on the board
                switch (type) {
                    case "fast flexible" -> {
                        System.out.println("Input a name for the new piece:");
                        String name = kb.nextLine();
                        System.out.println("Input a colour for the new piece:");
                        String colour = kb.nextLine();
                        FastFlexible ff = new FastFlexible(name, colour, new Point(xPos, yPos));
                        board.addPiece(ff);
                    }
                    case "fast" -> {
                        System.out.println("Input a name for the new piece:");
                        String name = kb.nextLine();
                        System.out.println("Input a colour for the new piece:");
                        String colour = kb.nextLine();
                        FastPiece f = new FastPiece(name, colour, new Point(xPos, yPos));
                        board.addPiece(f);
                    }
                    case "flexible" -> {
                        System.out.println("Input a name for the new piece:");
                        String name = kb.nextLine();
                        System.out.println("Input a colour for the new piece:");
                        String colour = kb.nextLine();
                        SlowFlexible sf = new SlowFlexible(name, colour, new Point(xPos, yPos));
                        board.addPiece(sf);
                    }
                    case "" -> {
                        System.out.println("Input a name for the new piece:");
                        String name = kb.nextLine();
                        System.out.println("Input a colour for the new piece:");
                        String colour = kb.nextLine();
                        SlowPiece s = new SlowPiece(name, colour, new Point(xPos, yPos));
                        board.addPiece(s);

                    }
                    default -> System.out.println("Invalid create type input: try again");
                }

            }
            // move the piece on the board
            else if (command.equals("move")) {

                //divide the whole statement
                StringTokenizer total = new StringTokenizer(kb.nextLine());
                String xPosS = total.nextToken();
                String yPosS = total.nextToken();
                String direction = "";

                //steps is initialised as 1 in case the piece is slow and the steps is not included in the input
                String stepsS = "1";

                if (total.hasMoreTokens()) {
                    direction = total.nextToken();
                }
                if (total.hasMoreTokens()) {
                    stepsS = total.nextToken();
                }

                int xPos = Integer.parseInt(xPosS);
                int yPos = Integer.parseInt(yPosS);
                int steps = Integer.parseInt(stepsS);
                if (xPos > 7 || yPos > 7) {
                    System.out.println("out of board input");
                    break;
                }

                //at the end move the
                board.move(new Point(xPos, yPos), direction, steps);

            }else if(command.equals("exit")){
                System.out.println("Done");
                break;
            }
            else {
                System.out.println("Invalid Input");
            }
            System.out.println("Enter a command (type help for details):");

        }
    }
}
