package com.exam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac To Game...");
        TicTacToeGameManager gameManager = new TicTacToeGameManager(3,3);


        String target;
        gameManager.drawGameTable();
        while (!gameManager.isGameEnd())
        {
            System.out.print("Enter the coordinates O : ");
            target = scan.nextLine();
            while(!gameManager.playerOnePlay(target)) {
                System.out.print("Enter the coordinates O : ");
                target = scan.nextLine();
            }
            gameManager.drawGameTable();
            if(gameManager.checkWin() == BlockEntry.BlockStage.O)
            {
                System.out.println("O WIN!!!!!");
                break;
            }
            System.out.print("Enter the coordinates X : ");
            target = scan.nextLine();
            while(!gameManager.playerTwoPlay(target)) {
                System.out.print("Enter the coordinates X : ");
                target = scan.nextLine();
            }
            gameManager.drawGameTable();
            if(gameManager.checkWin() == BlockEntry.BlockStage.X)
            {
                System.out.println("X WIN!!!!!");
                break;
            }
        }
    }




}
