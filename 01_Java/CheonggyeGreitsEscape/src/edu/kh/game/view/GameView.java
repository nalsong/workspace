package edu.kh.game.view;

import java.util.Objects;
import java.util.Scanner;

public class GameView {
	
	
	public static void clearScreen() {
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	  }

		
	
   public void displayMenu() {
      
      System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
      System.out.println("┃                                    ┃");
      System.out.println("┃     Survive in zombie building     ┃");
      System.out.println("┃                                    ┃");
      System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
      System.out.println("┃  /     /       / /   /         /   ┃");
      System.out.println("┃1. 게임 시작   GAME START   /      /┃");
      System.out.println("┃2. 게임 종료   EXIT  /     /        ┃");
      System.out.println("┃    / /      /        /      /   /  ┃");
      System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
      System.out.println("┃                     dev_20230302   ┃");
      System.out.println("┃                     JYH/PJW/JBS    ┃");
      System.out.println("┃                     JSY/CGT/LSJ    ┃");
      System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
      
      Scanner sc = new Scanner(System.in);
         
      System.out.println("[게임을 시작하려면 1을 입력해주세요.]");
      System.out.println("[게임을 종료하려면 2를 입력해주세요.]");
      boolean startCheck = true;
      
      while(startCheck) {
         System.out.print("입력: ");
         String startInput = sc.nextLine();
         if(startInput.equals("1")) {
        	 clearScreen();
        	System.out.println("[게임을 시작합니다.]"); break;
         }else if(startInput.equals("2")) {
        	 clearScreen();
            System.out.println("[게임을 종료합니다.]"); break;
         }else if(!(startInput.equals("1") || startInput.equals("2"))) {
            System.out.println("[1 또는 2를 입력해주세요.]");
            startCheck = true;
         }
      }
   }
}