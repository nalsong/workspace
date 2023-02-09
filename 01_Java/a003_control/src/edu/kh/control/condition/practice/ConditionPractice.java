package edu.kh.control.condition.practice;

import java.util.Scanner;

// 실습문제 작성 클래스
public class ConditionPractice {
	
	 public void practice1(){
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("숫자를 한 개 입력하세요 : ");
		 int number = sc.nextInt();
		 
		 String result;
		 
		 if(number <= 0) {
			 result = "양수만 입력해주세요";
		 }else if(number % 2 == 0) {
			 result = "짝수입니다.";
		 }else 
		 	result = "홀수입니다.";
		 System.out.println(result);
	 }

	 
	 
	 public void practice2(){
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("국어점수 : ");
		 int ko = sc.nextInt();
		 
		 System.out.print("수학점수 : ");
		 int math = sc.nextInt();
		 
		 System.out.print("영어점수 : ");
		 int eng = sc.nextInt();
		 
		 int sum = ko + math + eng;
		 double avg = sum/3.0f;
		 
		 
		 if( ko >= 40 && math >= 40 && eng >= 40 && avg >= 60.0 ) {
			 System.out.printf("국어 : %d \n수학 : %d \n영어 : %d \n합격 : %d \n평균 : %.1f \n축하합니다, 합격입니다!", ko, math, eng, sum, avg);			 
		 }else {
			 System.out.print("불합격입니다.");
		 } 
	 }
	 
	 
	 
	 public void practice3(){
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("1~12 사이의 정수 입력 : ");
		 int moon = sc.nextInt();
		 
		 
		 
		 
		 int result;
		 
		 switch(moon) {
		 case(1) : result = 31 ; break;
		 case(2) : result = 28 ; break;
		 case(3) : result = 31 ; break;
		 case(4) : result = 30 ; break;
		 case(5) : result = 31 ; break;
		 case(6) : result = 30 ; break;
		 case(7) : result = 31 ; break;
		 case(8) : result = 31 ; break;
		 case(9) : result = 30 ; break;
		 case(10) : result = 31 ; break;
		 case(11) : result = 30 ; break;
		 case(12) : result = 31 ; break;
		 default  : System.out.printf("%d는 잘못 입력된 달입니다." ); break;		 
		 }
		 
		 System.out.printf("%d월은 %d일까지 있습니다.", moon, result );
		 		 
		 
	 }
	 
	 
	 
	 public void practice4(){
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("키(m)를 입력해 주세요 : ");
		 Double h = sc.nextDouble();
		 
		 System.out.print("몸무게(kg)를 입력해 주세요: ");
		 Double w = sc.nextDouble();
		 
		 Double bmi = w / (h * h);
		 
		 String result;
		 
		 
		 if(bmi < 18.5) {
			 result = "저체중";
		 }else if ( bmi >= 18.5 && bmi < 23 ) {
			 result = "정상체중";
		 }else if (bmi >= 23 && bmi < 25) { 
			 result = "과체중";
		 }else if (bmi >= 25 && bmi < 30) {
			 result = "비만";
		 }else {
			 result = "고도비만";
		 }
		 
		 System.out.printf("BMI지수: %.14f \n%s", bmi, result);
		 
	 }
	 
	 
	 
	 public void practice5(){
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("중간 고사 점수 : ");
		 int ms = sc.nextInt();
		 
		 System.out.println("기말 고사 점수 : ");
		 int ls = sc.nextInt();
		 
		 System.out.println("과제 점수 : ");
		 int hw = sc.nextInt();
		 
		 System.out.println("출석 횟수 : ");
		 int c = sc.nextInt();
		 
		 
		 double ts = (ms * 0.2) + (ls * 0.3) + (hw * 0.3) + (c * 0.2);
				 
		 
		 
		 String result;
		 
		 
		 if(ts <= 70.0 || c >= 20-(20*0.3)) {
			 result = "Fail[점수미달]";
		 }else 
			 result = "PASS";
		 System.out.printf("중간 고사 점수(20) : %.f \n기말 고사 점수(30) : %.f \n과제 점수 : %.f \n출석 점수: %.f \n총점 : %.f \n%s", ms, ls, hw, c, ts, result);
		 
		
		 
		 
		 
		 
	 }

	
	

}
