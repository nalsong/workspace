package edu.kh.array.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice2 {

	
	
	
//	실습문제1
//	길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
//	
//	[실행 화면]
//	1 2 3 4 5 6 7 8 9
//	 : 25
	
		public void practice1(){
		
		int[] arr = new int[9];
		
		int sum = 0;
		
		
		
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			
			
			if(i % 2 == 0 ) {  
				
				sum += arr[i];   //1, 3, 5, 7, 9????
			}
			
		}
		System.out.printf("\n짝수 번째 인덱스 합 : %d ", sum);
	}
	
	
		
		
	
//	실습 문제2
//	길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
//	
//	[실행 화면]
//	9 8 7 6 5 4 3 2 1 
//	홀수 번째 인덱스 합 : 20
	public void practice2(){	
		
		int[] arr = new int[9];
		
		int sum = 0;
		for( int i = arr.length-1  ; i >= 0 ; i-- ) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			
			
			if(i % 2 != 0) {  // 8 6 4 2????
				sum += arr[i]; 
			}
		}
		System.out.printf("\n홀수 번째 인덱스 합 : %d ", sum);
		
	}
	
	
	

	// 실습문제3
//	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
//	1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요
//	
//	[실행 화면]
//	양의 정수 : 5
//	1 2 3 4 5 
//	
//	[실행 화면]
//	양의 정수 : 8
//	1 2 3 4 5 6 7 8

	public void practice3(){	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = i+1;

			
			System.out.print(arr[i] + " ");
		}
	
	}
	
	
	
	
	
//	실습문제 4
//	정수 5개를 입력 받아 배열을 초기화 하고
//	검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
//	배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
//	
//	[실행 화면 1]
//	입력 0 : 5
//	입력 1 : 8
//	입력 2 : 9
//	입력 3 : 10
//	입력 4 : 4
//	검색할 값 : 8
//	인덱스 : 1
//	
//	[실행 화면 2]
//	입력 0 : 5
//	입력 1 : 8
//	입력 2 : 9
//	입력 3 : 10
//	입력 4 : 4
//	검색할 값 : 1
//	일치하는 값이 존재하지 않습니다.

	public void practice4(){	
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		for(int i = 0 ; i <arr.length ; i++ ) {
		
			System.out.printf("입력 %d : ", i );
			arr[i] = sc.nextInt();
		
		}
		
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		
		int index = -1;
		
		for(int x = 0; x<arr.length;x++) {
			if(search == arr[x]) {
				index = x;
			}
		}
		
		if(index <0 ) {
			System.out.print("일치하는 값이 존재하지 않습니다.");	
		}else {
			System.out.println(index);
		}

	}
	
	
	
	
//	실습문제 5
//	문자열을 입력 받아 문자 하나 하나를 char배열에 대입하고
//	검색할 문자가 문자열에 몇 개 들어가 있는지, 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
//
//	[실행 화면]
//	문자열 : application
//	문자 : i
//	application에 i가 존재하는 위치(인덱스) : 4 8 
//	i 개수 : 2
	public void practice5(){	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String x = sc.next();
		
		char[] arr = x.toCharArray();
		
		
		System.out.print("문자 : ");
		char inputStr = sc.next().charAt(0);

		int sum = 0;
		
		System.out.printf("%s 에 %c가 존재하는 위치(인덱스) : ", x, inputStr);
		
		for(int y= 0; y < arr.length ; y++ ) {  // 1 2 3 4 5 6 7 8 9 10
			
			if( inputStr == arr[y] ) {     
					sum += 1;
					System.out.print(y + " ");
			}
			
				
		}
		System.out.printf("\n%c 개수 : %d", inputStr, sum );
	}
	
	
	
	





//	실습문제 6
//	사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
//	배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
//	그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
//	
//	[실행 화면]
//	정수 : 5
//	배열 0번째 인덱스에 넣을 값 : 4
//	배열 1번째 인덱스에 넣을 값 : -4
//	배열 2번째 인덱스에 넣을 값 : 3
//	배열 3번째 인덱스에 넣을 값 : -3
//	배열 4번째 인덱스에 넣을 값 : 2
//	4 -4 3 -3 2 
//	총 합 : 2

	public void practice6(){	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		int sum=0;
		
		for(int i = 0 ; i < arr.length ; i++ ) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			
		}
		for(int i = 0 ; i < arr.length ; i++ ) {
			sum += arr[i];
			System.out.print(arr[i] + " ");	
		}
		System.out.printf("\n총합 : %d", sum);
	}
	
	
	
	
	
	
//	실습문제 7
//	주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
//	단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
//	
//	[실행 화면]
//	주민등록번호(-포함) : 123456-1234567
//	123456-1******
	
	public void practice7(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String rrn = sc.next();
		
		char[] arr = new char[13];
		
		for( int i = 0; i<arr.length ; i++ ) {
			arr[i] = rrn.charAt(i);
			if(i>7) {
				arr[i] = '*';
			}
							
		}	
		for( int i = 0; i<arr.length ; i++ ) {	
		System.out.print(arr[i]);
		}
		
	}
	
	
	
	
	
	
//	실습문제 8
//	3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
//	중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
//	단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
//	다시 정수를 받도록 하세요.
//	
//	[실행 화면]
//	정수 : 4
//	다시 입력하세요.
//	정수 : -6
//	다시 입력하세요.
//	정수 : 5
//	1, 2, 3, 2, 1
	
	public void practice8(){  	
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
		
			System.out.print("정수 : ");
			int num = sc.nextInt();
		
			if (num >= 3 && num % 2 == 1) {
				int[] number = new int[num]; 
				
				
				int count = 0;
				
				for( int i =0 ; i < (number.length)/2+1; i++ ) {
					count +=1;
					System.out.print(count+", ");
				}
				for( int i=0; i<(number.length)/2 ; i++ ) {
					count -= 1;
					System.out.print(count+", ");  //쉼표처리...?
				}break;
			}else {
				System.out.print("다시 입력하세요.\n");
			}
		}
	}
	
	
	
	
	
	
	
//	실습문제 9
//	10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//	1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
//	
//	[실행 화면]
//	발생한 난수 : 9 7 6 2 5 10 7 2 9 6
	
	public void practice9(){	
		
		int[] arr = new int[10];
		
		System.out.print("발생한 난수 : ");
		
		for(int i = 0; i < arr.length ; i++ ) {
			 
			arr[i] = (int)(Math.random()*10)+1; 
			
			System.out.print(arr[i]+" ");  
		}
	}
	
	
	
	
	
	
	
//	실습문제 10
//	10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//	1~10 사이의 난수를 발생시켜 배열에 초기화 후
//	배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
//	
//	[실행 화면]
//	발생한 난수 : 5 3 2 7 4 8 6 10 9 10 
//	최대값 : 10
//	최소값 : 2

	public void practice10(){	
		
		int[] arr = new int[10];
		
		int max = -1;
		int min = 10;
		
		System.out.print("발생한 난수 : ");
		for( int i =0 ; i<arr.length ; i++ ) {
			
			arr[i] = (int)(Math.random()*10)+1;
			
			System.out.print(arr[i] + " ");

			if(max < arr[i]) {
				max = arr[i];
			}
				
			if(min > arr[i]) {
				min = arr[i]; 
			}
			
		}
		System.out.printf("\n최대값 : %d", max);
		System.out.printf("\n최소값 : %d", min);
	}
	
	
	
	
	
	
	
//	실습문제 11
//	10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//	1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
//	
//	[실행 화면]
//	4 1 3 6 9 5 8 10 7 2
	public void practice11(){	
		
		
		int[] arr = new int[10];
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = (int)(Math.random()*10)+1;
			
			for( int j = 0 ; j< i ; j++ ) {
				if(arr[i] == arr[j]) {
					i--;
				}
			}
			
		}
		for( int i = 0 ; i < arr.length ; i++ ) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	
	
	
	
	
	
//	실습문제 12
//	로또 번호 자동 생성기 프로그램을 만들기.
//	(중복 값 없이 오름차순으로 정렬하여 출력하세요.)
//	
//	[실행 화면]
//	3 4 15 17 28 40
	
	public void practice12(){	
		
		int[] arr = new int[6];
		
		for( int i = 0; i < arr.length ; i++ ) {
			arr[i] = (int)(Math.random()*45)+1;
			
			for( int j = 0 ; j < i ; j++) {
				if(arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}	
		Arrays.sort(arr);
		
		for( int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] +" ");
		}
	}
	
	
	
	
	
	
	
//	실습문제 13 
//	문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//	문자의 개수와 함께 출력하세요. (중복 제거)
//	
//	[실행 화면]
//	문자열 : application
//	문자열에 있는 문자 : a, p, l, i, c, t, o, n
//	문자 개수 : 8

	public void practice13(){	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String inputstr = sc.next();
		
		char[] arr = inputstr.toCharArray();

		int sum = 0;
		
		System.out.print("\n문자열에 있는 문자 : ");
		for( int i = 0 ; i<arr.length ; i++) {
			sum += 1;
			System.out.print(arr[i] + ", ");
		}
		System.out.printf("\n문자 개수 : %d", sum);
	}
	
	
	
	
	
//	실습문제 14
//	사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
//	배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
//	단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
//	늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
//	사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
//	(배열의 얕은 복사, 깊은 복사를 이용하는 문제)
//	
//	얕은 복사 : 배열의 시작 주소만을 복사하여 두 참조 변수가 하나의 배열을 참조.
//	깊은 복사 : 원본 배열이 가지고 있는 데이터를 그대로 복사한 새로운 배열 (복제)
//	→ tip : 깊은 복사를 위한 새로운 배열은 꼭 원본 배열과 같은 크기일 필요는 없다!
//	
//	[실행 화면]
//	배열의 크기를 입력하세요 : 3
//	1번째 문자열 : 자바의 정석
//	2번째 문자열 : 알고리즘
//	3번째 문자열 : C프로그래밍
//	더 값을 입력하시겠습니까?(Y/N) : y
//	더 입력하고 싶은 개수 : 2
//	4번째 문자열 : 인간관계
//	5번째 문자열 : 자기계발
//	더 값을 입력하시겠습니까?(Y/N) : y
//	더 입력하고 싶은 개수 : 1
//	6번째 문자열 : 영단어600
//	더 값을 입력하시겠습니까?(Y/N) : n
//	[자바의 정석, 알고리즘, C프로그래밍, 인간관계, 자기계발, 영단어600]

	
	public void practice14(){	
		Scanner sc = new Scanner(System.in);
		
		// 1. 첫 배열 크기 지정
		System.out.print("배열의 크기를 입력하세요 : ");
		String size = sc.next(); // 입력 버퍼에 개행 문자 (엔터)가 남음
		
		sc.nextLine(); //입력 버퍼에 남은 개행문자(엔터) 제거
		
		//2. 첫 배열 생성
		String[] books = new String[size];
		
		
		//3. 첫 배열에 저장할 문자열 입력 받기
		for(int i = 0; i<books.length; i++) {
			System.out.println((i+1) + "번째 문자열 : ");
			
			books[i] = sc.nextLine(); //입력 버퍼에서 다음 엔터까지 읽어옴
			
		}
		
		
		// 4. n이 입력될 때까지 무한 반복 -> n입력 시 break
		while(true) {
			
			System.out.println("더 값을 입력하시겠습니까?(Y/N) : ");
			char ch = sc.nextLine().charAt(0);
			
			if(ch == 'N') {
				break;
			}
			
			
			//5. 더입력 받을 개수 입력
			System.out.println("더 입력 하고 싶은 개수 : ");
			int addSize = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			
			
			//6. 기존 배열보다 늘어난 개수만큼 큰 새 배열 생성
			
			String newBooks[] = new String[books.length + addSize];
			
			
			//7. 깊은 복사를 통해 기존 배열 내용을 새 배열로 복사
			System.arraycopy(books, 0, newBooks, 0, books.length);
			
			//8. 새 배열의 빈칸 부터 새로운 입력을 받아서 저장
			for(int i =books.length ; i<newBooks.length ; i++) {
				System.out.print( (i+1) + "번째 문자열 : " );
				
				newBooks[i] = sc.nextLine();
				
			}
			
			
			//9. 기존 참조배열 books에 newBooks의 주소를 얕은 복사
			books = newBooks;
			
			
			
			
			
		}//while종료
		
		
		//10. 배열에 저장된 모든 값 출력
		System.out.println(Arrays.toString(books));
		
		
		
	
		
		
		
			
		
		
	}
	
	public void scannerEx(){
		Scanner sc = new Scanner(System.in);
		//1) next() : 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
		//   nextLine() : 한  문장( 엔터를 만나면 입력 종료)
		
		String str = sc.next();
		
		System.out.print("입력 : ");  // hello world
		System.out.println(str);
//      String str = sc.next();
		String str = sc.nextLine();
		
		
		System.out.println(str); // next() : hello
									// nextLine() : hello world
		
		
		//2) 스캐너 입력 버퍼와 nextXXX의 의미
		
		
		// 입력 -> 입력버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
		// 		  hello world(엔터)
		
		
		//					입력버퍼			nextXXX()		  후처리
		// nextLine() : hello world(엔터) -> hello world(엔터) ->엔터 제거
		// (다음 엔터)
		
		//nextInt() :     100( 앤터)      ->      100        
		//(다음 정수) 
		// ** next(), nextDouble(), nextInt()등
		//    모두 입력 버퍼에서 (엔터)를 제외하고 내용만 읽어옴 **
		
		System.out.println("=====================================");
		
		System.out.println("nextInt() : "); //입력 버퍼 : [ 100(엔터) ]
		int a = sc.nextInt();
		// 100     //입력버퍼 : [    (엔터)    ]
		
		
		// !문제 해결!
		sc.nextLine(); //입력버퍼 : [   ]
		
		
		System.out.println("nextLine() : "); // a b c
		String s = sc.nextLine();
		// a b c   //입력 버퍼 : [    ]
		
		System.out.println("종료");
		
		//[문제점]
		// nextInt() 이후 입력 버퍼에 남아있는 (앤터) 때문에 
		// 다음 nextLine() 수행시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에
		// 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 발생
		
		
		//[해결방법]
		//입력을 위한 nextLine() 수행 전
		// 입력 버퍼에서 (엔터)를 제거
		// -> 빈 공간에 sc.nextLine()구문을 한 번 작성하면 (엔터)가 제거됨
		
	}
	
	
	
	
	
	
	
//	실습문제 15
//	3행 3열짜리 문자열 배열을 선언 및 할당하고
//	인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
//
//	[실행 화면]
//	(0, 0)(0, 1)(0, 2)
//	(1, 0)(1, 1)(1, 2)
//	(2, 0)(2, 1)(2, 2)

	public void practice15(){	
		
		String[][] arr= new String[3][3];
		
		
		for(int row =0  ;row < arr.length ; row++ ) {
			
			for( int col = 0 ; col< arr[row].length ; col++ ) {
				
				System.out.print("(" + row + ", "+ col +")");
				
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
//	실습문제 16
//	메소드 명 : public void practice16(){}
//	4행 4열짜리 정수형 배열을 선언 및 할당하고
//	1) 1 ~ 16까지 값을 차례대로 저장하세요.
//	2) 저장된 값들을 차례대로 출력하세요.
//	
//	[실행 화면]
//	1 2 3 4 
//	5 6 7 8 
//	9 10 11 12 
//	13 14 15 16

	public void practice16(){	
		
		int[][] arr = new int[4][4];
		
		int count = 0;
		
		for( int i = 0 ; i < arr.length ;i++ ) {
			for( int j = 0; j <arr[i].length ; j++) {
				count +=1;
				arr[i][j] = count; 
				
				System.out.print(arr[i][j]+ " ");  
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
//	실습문제 17
//	4행 4열짜리 정수형 배열을 선언 및 할당하고
//	1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
//	2) 저장된 값들을 차례대로 출력하세요.
//
//	[실행 화면]
//	16 15 14 13 
//	12 11 10 9 
//	8 7 6 5 
//	4 3 2 1
	
	public void practice17(){	
		
		int[][] arr = new int[4][4];
		
		int count = 16;
		
		for( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0;j<arr[i].length ;j++ ) {
				count -= 1;
				arr[i][j] = count +1;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
//	실습문제 18
//	4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
//	아래의 내용처럼 처리하세요. (PDF표 확인)
//	
//	[실행 화면]
//	9 3 7 19 
//	3 6 9 18 
//	6 10 10 26 
//	18 19 26 63
	public void practice18(){	// 합계 어케함????????????
		
		int[][] arr = new int[4][4];
		
		
		final int sumrow = arr.length-1;
		final int sumcol = arr[0].length-1;
		
		for( int row =0; row < arr.length ; row++ ) {
			for ( int col =0; col < arr[row].length ;col++ ) {
				
				if( row != sumrow && col != sumcol) {
				
					arr[row][col] = (int)(Math.random()*10)+1;
				
					arr[row][sumcol] += arr[row][col];
					arr[sumrow][col] += arr[row][col];
					arr[sumrow][sumcol] += arr[row][col];
					
					
					
					System.out.printf("%4d",arr[row][col]);	
				}
			}
			System.out.println();
			
		}
		
	}
	
	
	
	
	
	
//	실습문제 19
//	메소드 명 : public void practice19(){}
//	2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
//	“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
//	크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
//	(char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
//
//	[실행 화면]
//	행 크기 : 5
//	열 크기 : 4
//	T P M B 
//	U I H S 
//	Q M B H 
//	H B I X 
//	G F X I
	public void practice19(){	
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("행크기 : ");
			int row = sc.nextInt();
			
			System.out.print("열크기 : ");
			int col = sc.nextInt();
			
			if((row < 1 || row >10) || (col < 1 || col > 10)){
				System.out.print("반드시 1~10 사이의 정수를 입력해야 합니다.\n");
				continue;
			}
			
			char[][] arr = new char[row][col];
			
			
			for(int i =0 ; i < arr.length ; i++ ) {
				for( int j = 0; j< arr[i].length ; j++ ) {
					
					arr[i][j] = (char)((int)(Math.random()*26)+65);
					
					System.out.print(arr[i][j] + " ");
					
				}
				System.out.println();
			}
			break;
		}
	}
	

	
	
	
	
//	실습문제 20
//	사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
//	문자형 가변 배열을 선언 및 할당하세요.
//	그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
//	
//	[실행 화면]
//	행의 크기 : 4
//	0열의 크기 : 2
//	1열의 크기 : 6
//	2열의 크기 : 3
//	3열의 크기 : 5
//	a b 
//	c d e f g h 
//	i j k 
//	l m n o p 

	public void practice20(){	
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int num = sc.nextInt();
		
		char[] al = new char[num]; 
		
		for( int i = 0 ; i < al.length ; i++ ) {
			
			while(true) {
				System.out.printf("%d열의 크기 : \n", i);
				int num2 = sc.nextInt();
				
				char[] arr = new char[num2];
				
				for(char j = 0; j< arr.length ; j++ ) {  
				
//					arr [j]= (int)(Math.random()*26)+45;  ??????
			
				}
				
				break;
			}
			
		}
		
	}
	
	
	
	
	
	
//	실습문제 21
//	1차원 문자열 배열에 학생 이름 초기화되어 있다.
//	3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
//	학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
//	(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
//	String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
//	"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
//	[실행 화면]
//	== 1분단 ==
//	강건강 남나나
//	도대담 류라라
//	문미미 박보배
//	== 2분단 ==
//	송성실 윤예의
//	진재주 차천축
//	피풍표 홍하하

	public void practice21(){	
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] students1 = new String[3][2];
		
		String[][] students2 = new String[3][2];
		
		for( int i =0; i < students1.length ; i++ ) {
			for(int j = 0; j<students1[i].length ;j++ ) {
//				students1[i][j] = students;  ???????
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
//	실습문제 22
//	위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
//	해당 학생이 어느 자리에 앉았는지 출력하세요
//	
//	[실행 화면]
//	== 1분단 ==
//	강건강 남나나
//	도대담 류라라
//	문미미 박보배
//	== 2분단 ==
//	송성실 윤예의
//	진재주 차천축
//	피풍표 홍하하
//	============================
//	검색할 학생 이름을 입력하세요 : 차천축
//	검색하신 차천축 학생은 2분단 2번째 줄 오른쪽에 있습니다.

	
	public void practice22(){	
		
	}
	
	
	
	
	
	
//	실습문제23
//	String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
//	그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 “X”로 변환해 2차원 배열을 출력하세요.
//	[실행 화면]
//	행 인덱스 입력 : 4
//	열 인덱스 입력 : 2
//	0 1 2 3 4
//	0 
//	1
//	2
//	3
//	4   X

	
	public void practice23(){	
		
	}
	
	
	
	
	
	
	
	
//	실습문제24
//	실습문제9와 내용은 같으나 행 입력 시 99가 입력되지 않으면 무한 반복이 되도록 구현하세요.
//	
//	[실행 화면]
//	행 인덱스 입력 : 2 
//	열 인덱스 입력 : 2
//	  0 1 2 3 4 
//	0
//	1
//	2	  x
//	3
//	4
//	
//	
//	행 인덱스 입력 : 3
//	열 인덱스 입력 : 1
//	  0 1 2 3 4 
//	0
//	1
//	2	  x
//	3   x
//	4
//	
//	행 인덱스 입력 >> 99
//	프로그램 종료

	
	public void practice24(){	
		
	}
	
	
	
	
	
	
	
	
	
	
//	Java Project : BingoGame
//	1. 빙고판 크기를 입력 받아, 그 크기 만큼의 행과 열을 가지는 2차원 배열(빙고판)을 생성하고
//	1부터 크기*크기 사이의 정수 난수를 무작위 배치.
//	2. 정수를 입력 받아 빙고판에서 일치하는 부분을 찾아 해당 부분의 숫자를 “★“로 변경하고
//	현재 빙고 카운트가 몇인지 출력.
//	단, 빙고판에 없는 정수를 입력한 경우 “다시 입력해주세요.“ 출력
//	3. 가로, 세로, 대각선 한 줄이 모두 “★“로 변경되어 있을 경우 빙고 카운트를 1 증가
//	4. 빙고카운트가 3이상이 되면 “***Bingo!***” 를 출력하고 프로그램 종료.
//	(PDF 참고)
	
	public void BingoGame(){	
		
	}
	
	
	
	
}
