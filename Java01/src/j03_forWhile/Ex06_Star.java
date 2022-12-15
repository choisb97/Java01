package j03_forWhile;

public class Ex06_Star {

	public static void main(String[] args) {
		
		// 1) 반삼각형
		
		// => * 을 1개부터 시작해서 개수를 늘려가면서 9 line 출력
		// => 각 행 별로 행 번호 개수만큼 출력하기
		System.out.println("< 1) 반삼각형 >");
		
		for (int i = 1; i <= 9; i++) {	// (int i = 1; i < 10; i++)
			for (int j = 1; j <= i; j++) {
				System.out.printf("*");
			} // for_j
			
			System.out.println("");
		} // for_i
		
		System.out.println("------------------------------");
		
		//------------------------------------------------------------
		
		// 2) 피라미드
		
		// => 5행, 9열 (line * 2 - 1)
		System.out.println("< 2) 피라미드 >");
		
		int line = 5;
		
		for (int i = 1; i <= line; i++) {
			
			// 반복문 1 : space(공백)
			for (int j = 1; j <= line - i; j++) { // line = 5
				System.out.printf(" ");
			} // for_j1
			
			// 반복문 2 : * (별 찍기)
			for (int j = 1; j < (i*2); j++) {
				// 1행 : 1, 2행 : 3, 3행 : 5 ....
				System.out.printf("*");
			} // for_j2
			
			System.out.println("");
		} // for_i
		
		System.out.println("------------------------------");
		
		//------------------------------------------------------------
		
		// 3) 다이아몬드
		System.out.println("< 3) 다이아몬드 >");
		
		// 상부 출력
		
		for (int i = 1; i <= line; i++) {
			
			// 반복문 1 : space(공백)
			for (int j = 1; j <= line - i; j++) { // line = 5
				System.out.printf(" ");
			} // for_j1
			
			// 반복문 2 : * (별 찍기)
			for (int j = 1; j < (i*2); j++) {
				// 1행 : 1, 2행 : 3, 3행 : 5 ....
				System.out.printf("*");
			} // for_j2
			
			System.out.println("");
		} // for_i
		
		//--------------------------------------------------
		
		// 하부 출력
		// => 총 그리는 line 개수(위의 line - 1 = 4) ~ 1 까지 감소
		
		for (int i = line - 1; i >= 1; i--) {
			
			// 반복문 1 : space(공백)
			for (int j = 1; j <= line - i; j++) { // line = 5
				System.out.printf(" ");
			} // for_j1
			
			// 반복문 2 : * (별 찍기)
			for (int j = 1; j < (i*2); j++) {
				// 4 : 7, 3 : 5, 2 : 3, 1 : 1
				System.out.printf("*");
			} // for_j2
			
			System.out.println("");
		} // for_i
		
		System.out.println("------------------------------");

//------------------------------------------------------------
		
		// 4) 모래시계
		System.out.println("< 4) 모래시계 >");
		
		// => 3) 다이아몬드를 반대로 출력
		
		// 상부 출력
		
		for (int i = line; i > 1; i--) {
			// 피라미드(i = line - 1; i >= 1;) 와 다르게 i = line; i > 1;
			
			// 반복문 1 : space(공백)
			for (int j = 1; j <= line - i; j++) { // line = 5
				System.out.printf(" ");
			} // for_j1
			
			// 반복문 2 : * (별 찍기)
			for (int j = 1; j < (i*2); j++) {
				// 4 : 7, 3 : 5, 2 : 3, 1 : 1
				System.out.printf("*");
			} // for_j2
			
			System.out.println("");
		} // for_i
		
		//--------------------------------------------------
		
		// 하부출력
		
		for (int i = 1; i <= line; i++) {
			
			// 반복문 1 : space(공백)
			for (int j = 1; j <= line - i; j++) { // line = 5
				System.out.printf(" ");
			} // for_j1
			
			// 반복문 2 : * (별 찍기)
			for (int j = 1; j < (i*2); j++) {
				// 1행 : 1, 2행 : 3, 3행 : 5 ....
				System.out.printf("*");
			} // for_j2
			
			System.out.println("");
		} // for_i

	} // main

} // class
