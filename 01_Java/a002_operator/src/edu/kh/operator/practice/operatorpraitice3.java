package edu.kh.operator.practice;

import java.util.Scanner;

public class operatorpraitice3 {
	
	public static void main(String[] agrs) {
		
		Scanner sc = new Scanner(System.in);
		
	
		System.out.println("[실행화면]");
		
		System.out.print("정수 입력 : ");
		int input1 = sc.nextInt();
		
		String result = input1 == 0 ? "0입니다." : input1 % 2 == 0 ? "짝수입니다." : "홀수입니다.";
		
		System.out.printf(result);
		
		
	}

}
