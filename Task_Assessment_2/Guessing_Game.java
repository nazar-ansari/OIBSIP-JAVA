package Task_Assessment_2;

/**
 * Guessing_Game
 */

// Importing Utility Package for Random Module & Scanner Library
import java.util.*;

import javax.swing.text.TabStop;

public class Guessing_Game {
    static ArrayList<Integer> Score_List = new ArrayList<>();
    static ArrayList<Integer> Random_Store = new ArrayList<>();

    public static void main(String[] args) {
        Guessing_Game First_Game = new Guessing_Game();
        First_Game.Game_Menu(Score_List);
    }

    public void Game_Menu(ArrayList<Integer> Score_Reference) {
        Guessing_Game Second_Game = new Guessing_Game();
        Scanner User_Input = new Scanner(System.in);
        System.out.println();
        System.out.println("\t\t - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\t\t|\tWelcome To Number Guessing Game \t|");
        System.out.println("\t\t - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\t\t * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\t\t|\t\t 1: Start The Game \t\t|");
        System.out.println("\t\t|\t\t 2: Display Score Board \t|");
        System.out.println("\t\t|\t\t 3: Exit The Game \t\t|");
        System.out.println("\t\t * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\n");
        try {
            System.out.print("\t\t\tEnter The Required Move : ");
            int User_Choice = User_Input.nextInt();
            switch (User_Choice) {
                case 1:
                    System.out.print("\t\t\tEnter Max Threshold of Range of Number : ");
                    int Range_Number = User_Input.nextInt();
                    Random Random_Range = new Random();
                    int Random_Number = Random_Range.nextInt(Range_Number) + 1;
                    Second_Game.Check_User_Random_Equality(Random_Number);
                    break;
                case 2:
                    Second_Game.Display_Score_List();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    throw new InputMismatchException("Enter From Available Move ONLY !!");

            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("\n" + e.getMessage() + "\n");
            Game_Menu(Score_Reference);
        }

    }

    public void Check_User_Random_Equality(int Random_Pass_Number) {
        Scanner User_Choice = new Scanner(System.in);
        Random_Store.add(Random_Pass_Number);
        int User_Guess, Total_Guess = 0;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("\t\t\tEnter Your Guess :\t");
            User_Guess = User_Choice.nextInt();
            Total_Guess = Total_Guess + 1;
            System.out.println();
            if (User_Guess > Random_Pass_Number) {
                System.out.println("\t\t * * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("\t\t|\t Guess Number Lower Than it \t\t|");
                System.out.println("\t\t * * * * * * * * * * * * * * * * * * * * * * * *");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e.getMessage());
                }
            } else if (User_Guess < Random_Pass_Number) {
                System.out.println("\t\t * * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("\t\t|\t Guess Number Higher Than it \t\t|");
                System.out.println("\t\t * * * * * * * * * * * * * * * * * * * * * * * *");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e.getMessage());
                }

            }

        } while (User_Guess != Random_Pass_Number);
        Score_List.add(Total_Guess);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Game_Menu(Score_List);
    }

    public void Display_Score_List() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
        System.out.println("\t\t - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\t\t|\t\t  Score List\t\t  |");
        System.out.println("\t\t - - - - - - - - - - - - - - - - - - - - -\n");
        Collections.sort(Score_List);
        int Total_Score = 0;
        for (Integer Scores : Score_List) {
            System.out.println("\t\tIn Game No :" + (Total_Score + 1) + "You Guess The Number \'"
                    + Random_Store.get(Total_Score) + "\' in " + Scores + " Tries");
            Total_Score = Total_Score + 1;
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        Game_Menu(Score_List);
    }
}