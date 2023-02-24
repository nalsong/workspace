package ed.kh.test1;

public class Day3_1 {
	
	public static void main(String[] args) { //실행을 위한 메인메서드
		
		
//		1번
		String[] fruits = new String[5]; // String형태의 자료를 담을 fruits배열 5칸을 만듬
		fruits[0] = "사과";  // fruits 0번에는 사과를 대입. [1부터 시작할 시 ArrayIndexOutOfBoundsException 발생!]
		fruits[1] = "바나나"; // fruits 1번에는 바나나를 대입.
		fruits[2] = "오렌지"; // fruits 2번에는 오렌지를 대입.
		fruits[3] = "키위";  // fruits 3번에는 키위를 대입.
		fruits[4] = "수박";  // fruits 4번에는 수박를 대입.
		for(String fruit : fruits) {  // String fruit라는 변수에 fruits를 대입.
			System.out.println(fruit); // fruit변수 안의 내용을 출력.
		}
		
	}
	
	
	
}
