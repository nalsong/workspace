package edu.kh.operator.practice;

import java.util.Scanner;

public class operatorpraitice3FIX {
	
	public static void main(String[] agrs) {
		
		Scanner sc = new Scanner(System.in);
		
//		정수를 하나 입력 받아 양수/음수/0 을 구분하세요.
		
		
		
		
		System.out.print("정수 입력 : ");
		int input1 = sc.nextInt();
		
		String result = input1 == 0 ? "0입니다." : input1 > 0 ? "양수입니다." : "음수입니다.";
		
		System.out.printf(result);
		
		
	}

}
