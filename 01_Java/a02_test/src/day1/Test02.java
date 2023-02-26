package day1;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) { //메인메서드
		
		Scanner sc = new Scanner(System.in); 
		
		while(true){ // while문의 조건식 true일 동안 반복
			
			System.out.print("2~9사이 정수 입력 : "); // '2~9사이 정수 입력 : '출력
			int input = sc.nextInt(); // 사용자가 console창에 int형의 값을 입력하면 input변수에 대입
			
			if ( input >= 2 && input <=9 ) { // 만약 input이 2보다 크거나 같고, 9보다 작거나 같으면 
				for(int num = 1; num<=9 ; num++) { // int num의 값을 1부터 9까지 늘린다.
					System.out.printf("%d * %d = %d\n", input, num, input * num); //input * num = input*num 값을 출력
				}break; // 위 조건을 만족하여 실행되었으면 종료
			}else { // if의 조건이 성립하지 않으면 
				System.out.println("2이상 9이하의 정수만 입력해주세요."); // "2이상 9이항의 정수만 입력해주세요" 문구 출력
			}
		}
	}
}
