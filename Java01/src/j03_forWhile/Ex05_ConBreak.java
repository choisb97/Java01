package j03_forWhile;

/*
 < Continue >
 - Continue 문 이하의 구문을 실행하지 않고 다음 반복문 실행

 < Break >
 - 반복문 탈출

 < Label > - continue, break 만 사용.
 - continue, break 가 적용될 반복문을 지정할 수 있도록 해줌.
 - 위치를 표시함
   반드시 " : " 표시,
   반드시 반복문 바로 위에 위치함.
   -> Label 다음에 반복문 외의 문장이 오면 break, continue 에서 인식 안 됨 오류


//-------------------------------------------------------------------

/*
< 과제 >
=> 5층건물에 각 층마다 7개의 방이 있고 이것을 [층,호실] 출력하기 
=> 4층 4호는 창고이기 때문에 출력하지 않는다.
*/

public class Ex05_ConBreak {

	public static void main(String[] args) {
		
		// 1) 모든 방 출력하기
		System.out.println("< 모든 방 출력 >");
		
		// => [1, 1호] [1, 2호] ... [1, 7호]
		//	  [2, 1호] [2, 2호] ... [2, 7호]
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.printf("[%d, %d호] ", i, j);
			} // for_j
			System.out.println(""); // 줄 바꿈
		} // for_i
		
		System.out.println("---------------------------------------------------------");
		
		//-------------------------------------------------
		
		// 2) 4층 4호는 창고이기 때문에 출력하지 않는다.
		System.out.println("< 4층 4호 제외 - continue >");
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				
				if (i == 4 && j == 4) continue; // i 가 4이고 j 가 4이면 해당 구문 실행하지 않고 다음 반복문 실행
				
				System.out.printf("[%d, %d호] ", i, j);
			} // for_j
			System.out.println(""); // 줄 바꿈
		} // for_i
		
		System.out.println("---------------------------------------------------------");
		
		//-------------------------------------------------
		
		// 3) 4층은 3호까지만 있다.
		System.out.println("< 4층은 3호까지만 - break >");
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				
				if (i == 4 && j == 4) break; // i 가 4이고 j 가 4이면 해당되는 반복문(j) 종료, 탈출 후 (i)로 
				
				System.out.printf("[%d, %d호] ", i, j);
			} // for_j
			System.out.println(""); // 줄 바꿈
		} // for_i
		
		System.out.println("---------------------------------------------------------");
		
		//-------------------------------------------------
		
		// 4) Label 적용
		// => continue, break 를 원하는 반복문에 적용
	    // => 원하는 반복문 위에 Labeling, 사용
		
		System.out.println("< Label - continue >");
		
		banana: // Labeling -> 반드시 콜론(:) 붙이고, 이후에 무조건 반복문이 있어야 함.
		// Label 일름은 맘대로 사용 가능!
			
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				
				if (i == 4 && j == 4) continue banana;
				// i 가 4이고 j 가 4이면 해당 구문 실행하지 않고 다음 반복문으로 -> 줄 바꿈도 실행 없이 바로 다음 i 반복문 실행
				
				System.out.printf("[%d, %d호] ", i, j);
			} // for_j
			System.out.println(""); // 줄 바꿈
		} // for_i
		
		System.out.println("---------------------------------------------------------");
		
		//-------------------------------------------------
		
		System.out.println("< Label - break >");
		
		leejaeyeong: // Labeling -> 반드시 콜론(:) 붙이고, 이후에 무조건 반복문이 있어야 함.
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				
				if (i == 4 && j == 4) break leejaeyeong;
				// i 가 4이고 j 가 4이면 해당 구문부터 이후 남은 반복문까지 모두 종료.
				
				System.out.printf("[%d, %d호] ", i, j);
			} // for_j
			System.out.println(""); // 줄 바꿈
		} // for_i
		
	} // main

} // class
