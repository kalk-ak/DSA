//Import Section
import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

/*
 * Provided in this class is the neccessary code to get started with your game's implementation
 * You will find a while loop that should take your minefield's gameOver() method as its conditional
 * Then you will prompt the user with input and manipulate the data as before in project 2
 * 
 * Things to Note:
 * 1. Think back to project 1 when we asked our user to give a shape. In this project we will be asking the user to provide a mode. Then create a minefield accordingly
 * 2. You must implement a way to check if we are playing in debug mode or not.
 * 3. When working inside your while loop think about what happens each turn. We get input, user our methods, check their return values. repeat.
 * 4. Once while loop is complete figure out how to determine if the user won or lost. Print appropriate statement.
 */

public class main{

    public static void main(String[] args) {
        Minefield minefield;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("enter difficulty level\n" +
                    "1. for Easy\n" +
                    "2. for Medium\n" +
                    "3. for Hard");
            String level = scanner.next();

            if (level.equals("1")) {
                minefield = new Minefield(5, 5, 5);
                minefield.createMines(5, 5, 5);
                break;
            } else if (level.equals("2")) {
                minefield = new Minefield(9, 9, 12);
                minefield.createMines(9, 9, 12);
                break;
            } else if (level.equals("3")) {
                minefield = new Minefield(20, 20, 40);
                minefield.createMines(9, 9, 12);
                break;
            } else {
                System.out.println("Invalid input");
                System.out.println("enter difficulty level\n" +
                        "1. for Easy\n" +
                        "2. for Medium\n" +
                        "3. for Hard");
                level = scanner.next();
            }
        }
        System.out.println("input\n" +
                "1. if you want to play in debug mode\n" +
                "2. if don't want to");

        int i = scanner.nextInt();
        while (i != 1 && i != 2) {
            System.out.println("invalid input");
            System.out.println("input\n" +
                    "1. if you want to play in debug mode\n" +
                    "2. if don't want to");
            i = scanner.nextInt();
        }
        Boolean debug;
        if (i == 1)
            debug = true;
        else
            debug = false;


        System.out.println("Enter X start");
        int x = scanner.nextInt();
        System.out.println("Enter Y start");
        int y = scanner.nextInt();
        while (!(minefield.isInbound(x, y))) {
            System.out.println("Invalid input");
            System.out.println("Enter X start");
            x = scanner.nextInt();
            System.out.println("Enter Y start");
            y = scanner.nextInt();
        }
        minefield.revealStartingArea(x, y);
        System.out.println(minefield);

        while (!(minefield.gameOver())) {
            System.out.println("Enter X start");
            x = scanner.nextInt();
            System.out.println("Enter Y start");
            y = scanner.nextInt();

            while (!(minefield.isInbound(x, y))) {
                System.out.println("Invalid input");
                System.out.println("Enter X start");
                x = scanner.nextInt();
                System.out.println("Enter Y start");
                y = scanner.nextInt();
            }

            int z = 0;
            while (z != 1 && z != 2) {
                System.out.println("Do you want to flag\n" +
                        "1. for yes\n" +
                        "2 for no");
                z = scanner.nextInt();
            }
            boolean flag;
            if (z == 1) {
                flag = true;
            }
            else {
              flag = false;
            }
            minefield.guess(x, y, flag);
            if (debug)
                minefield.debug();

            System.out.println(minefield);
        }
        if (minefield.gameOver())
            System.out.println("You hit a mine, better luck next time");
        else
            System.out.println("Good game, you won");


    }




    
}
