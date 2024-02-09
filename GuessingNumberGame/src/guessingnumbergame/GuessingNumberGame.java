/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessingnumbergame;

import java.util.Scanner;

/**
 *
 * @author Emir Sapmaz
 */
public class GuessingNumberGame {
        
        final static int randomNum = (int) ((Math.random()*9000)+1000);
        final static int firstDigit = randomNum/1000%10;
        final static int secondDigit = randomNum/100%10;
        final static int thirdDigit = randomNum/10%10;
        final static int forthDigit = randomNum%10;
        
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\u001B[47mYour job is to guess the number which is randomly generated!");
        System.out.println("\u001B[47mEnter a 4 digit number to your desire. You will only have \u001B[32m5\u001B[0m\u001B[47m chances to guess!\u001B[0m");
        int lives = 5;
        OUT:
        while (lives>0) {
            String usernumString = input.next();
            if(isInteger(usernumString)){
                int usernum = Integer.parseInt(usernumString);
                if (usernumString.length()!=4) {
                    System.out.println("The number you entered is not 4 digits, please try again.");
                } 
                else {
                    checkPosition(usernum);
                    if(checkFoundNum(usernum)){
                        System.out.println("\u001B[32mCONGRATULATIONS YOU WON!");
                        break;
                    }
                    lives--;
                    switch (lives) {
                        case 1:
                            System.out.println("\u001B[36mLast chance!\u001B[0m");
                            break;
                        case 0:
                            System.out.println("\u001B[31mUNFORTUNATELY YOU LOST! The number was "+randomNum+".\u001B[0m");
                            break OUT;
                        default:
                            System.out.println("\u001B[36m"+lives+"\u001B[0m Chances left, please try again!");
                            break;
                    }
                }
            }else
                System.out.println("Enter an integer please.");
        }
        
    }
    public static void checkPosition(int usernum){
        int p1 = usernum/1000%10;
        int p2 =usernum/100%10;
        int p3 = usernum/10%10;
        int p4 =usernum%10;
        
        if(p1==firstDigit)
            System.out.println(p1+" is in the \u001B[32mCORRECT\u001B[0m position and \u001B[32mIN\u001B[0m the number"); 
        else
            if(checkNumber(usernum,p1) )
                System.out.println(p1+" is in the \u001B[31mWRONG\u001B[0m position but \u001B[32mIN\u001B[0m the number");
            else
                System.out.println(p1+" is in the \u001B[31mWRONG\u001B[0m position also \u001B[31mNOT\u001B[0m in the number");
        if(p2==secondDigit)
            System.out.println(p2+" is in the \u001B[32mCORRECT\u001B[0m position and \u001B[32mIN\u001B[0m the number");
        else
            if(checkNumber(usernum,p2))
                System.out.println(p2+" is in the \u001B[31mWRONG\u001B[0m position but \u001B[32mIN\u001B[0m the number");
            else
                System.out.println(p2+" is in the \u001B[31mWRONG\u001B[0m position also \u001B[31mNOT\u001B[0m in the number");
        if(p3==thirdDigit)
            System.out.println(p3+" is in the \u001B[32mCORRECT\u001B[0m position and \u001B[32mIN\u001B[0m the number");
        else
            if(checkNumber(usernum,p3))
                System.out.println(p3+" is in the \u001B[31mWRONG\u001B[0m position but \u001B[32mIN\u001B[0m the number");
            else
                System.out.println(p3+" is in the \u001B[31mWRONG\u001B[0m position also \u001B[31mNOT\u001B[0m in the number");
        if(p4==forthDigit)
            System.out.println(p4+" is in the \u001B[32mCORRECT\u001B[0m position and \u001B[32mIN\u001B[0m the number");
        else
            if(checkNumber(usernum,p4))
                System.out.println(p4+" is in the \u001B[31mWRONG\u001B[0m position but \u001B[32mIN\u001B[0m the number");
            else
                System.out.println(p4+" is in the \u001B[31mWRONG\u001B[0m position also \u001B[31mNOT\u001B[0m in the number");
    }
    public static boolean checkNumber(int usernum,int p){
        if(p == firstDigit || p == secondDigit || p == thirdDigit || p == forthDigit )
            return true;
        else
            return false;
    }
    public static boolean checkFoundNum(int usernum){
        return usernum==randomNum;
    }
    public static boolean check4digits(String usernum){
        return usernum.length()!=4;
    }
      public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
     
}
