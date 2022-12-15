package j03_forWhile;

/*
 < 반복문의 3요소 >
 반복자의 초기값, 조건식(true or false), 증감식

 => for : for(초기값; 조건식; 증감식);		// 숫자 값을 정확하게 판단할 수 있는 경우 사용
 => while, do~while : 초기값(before while_Loop (루프 전에)), 
                      조건식(true or false -> while 조건문), 
                      증감식(in while_Loop (루프 안에))

 < 반복자(iterator) >
 - 반복문에서 횟수를 count 하는 변수
*/

public class Ex01_LoopBasic {

	public static void main(String[] args) {
		
		// < 과제 >
		// -> 1 ~ 100 까지의 합 출력하기
		// -> 1 + 2 + 3 + .....+ 100
		// -> int sum = 1 + 2 + 3 + ..... + 100;
		
		//----------------------------------------------------------------
		
		// 1) for
		int sum = 0;
		int i = 0;
		
		for (i = 1; i <= 100; i++) {		// 초기값, 조건, 증감식 한 번에 들어있음
			sum += i; // sum = sum + i
			// => i 는 1부터 100까지 1씩 즘가하면서 반복실행
			// 0 = 0 + 1 -> sum(1) = 1 + 2 -> sum(1 + 2) = (1 + 2) + 3 -> ......
			//                     sum + i                   sum   + i
		
		} // for
		
		System.out.println("after i : " + i); // 101 -> 100까지 돌고 101에서 조건에 맞지 않아 반복 종료
		System.out.println("for문 -> 1 ~ 100 합계 : " + sum); // 5050
		
		System.out.println("-------------------------------------------");
		
		//===============================================================================
		
		// 2) while - 조건에 맞지 않으면 실행하지 않음.
		// => 1 ~ 100 까지의 합 출력하기
		
		sum = 0;							// 초기화 필수
		i = 0;			  	// i = 1; 
		
		while (i < 100) { 	// (i <= 100)	// 관계식으로 조건 작성 true of false
			i++;	 	  	// sum += 1;	// 증감식
			sum += i;	  	// i++;
			
		} // while
		
		System.out.println("while문 -> 1 ~ 100 합계 : " + sum);
		
		System.out.println("-------------------------------------------");
		
		//===============================================================================
		
		// 3) do ~ while - 조건에 맞지 않아도 최소 한 번은 무조건 실행함.
		// => 1 ~ 100 까지의 합 출력하기
		
		sum = 0;				// 초기화
		i = 0; 	// i = 101; 비교
		
		do {
			sum += i;
			i++;				// 증감식
		} while (i <= 100);		// 조건에 맞지 않아도 최소 한 번은 실행 후 확인.
		
		System.out.println("do while문 -> 1 ~ 100 합계 : " + sum);
		
	} // main

} // class