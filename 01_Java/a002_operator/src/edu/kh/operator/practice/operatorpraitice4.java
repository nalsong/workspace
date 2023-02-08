package edu.kh.operator.practice;

import java.util.Scanner;

public class operatorpraitice4 {
	
	public static void main(String[] agrs) {
		
		Scanner sc = new Scanner(System.in);
		
	
		System.out.println("ex.");
		
		
		System.out.print("국어 : ");
		int input1 = sc.nextInt();

		System.out.print("영어 : ");
		int input2 = sc.nextInt();
		
		System.out.print("수학 : ");
		int input3 = sc.nextInt();
		
		System.out.print("\n");
		
		
		System.out.printf("합계: %d \n", input1 + input2 + input3 );
		System.out.printf("평균: %d \n", (input1 + input2 + input3)/3);
		
		
		boolean result1 = input1 >= 40 && input2 >=40 && input3 >= 40 ;
		boolean result2 = (input1 + input2 + input3)/3 >= 60;
		
		String result3 = result1 && result2 ? "합격" : "불합격" ;
		
		System.out.printf(result3);
		
			
		
		
	}

}
