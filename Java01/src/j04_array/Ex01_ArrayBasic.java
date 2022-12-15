package j04_array; // < 배열 >

/*
 < 배열 >
 - 동일성격의 동일Type 의 자료를 하나의 묶음으로 처리 

 장점 : 일괄처리 (반복문 적용)
 특징 : 동일타입, 모든 자료형에 적용 가능

 방법
 => 선언 후 사용 : 명시적선언, 묵시적선언      
 => 크기(length), 인덱스(0 부터 length-1)

 1. 명시적 선언 (new 연산자 이용)
  => 크기를 반드시 지정
*/

public class Ex01_ArrayBasic {

	public static void main(String[] args) {
		
		// < 과제 >
		// - 5명의 성적을 처리한다고 가정.
		
		int s1 = 11,
			s2 = 22,
			s3 = 30,
			s4 = 40,
			s5 = 50;

		int sum = s1 + s2 + s3 + s4 + s5;
		
		double avg = (double)sum / 5;
		
		System.out.println("점수 평균 = " + avg);
		
		System.out.println("---------------------------------");
		
		//----------------------------------------
		
		// 1. 명시적 선언 (new 연산자 이용)
		// => 크기를 반드시 지정
		
		// int[] score = new int[5]; // 선언
		// int[] score => int Type의 배열인 score
		// new int[5] : 반드시 크기 지정 -> [5] -> 4byte * 5 만큼 공간확보
		
		// => [] 위치 : 변수 뒤에도 사용 가능.
		//			  int test[] = new int[5];
		int score[];	// 변수명만 정의 -> score 를 int Type의 배열로 사용하겠다.
		score = new int[5];
				
		// 정확한 크기가 있지 않은 경우 사용 불가능
		// int score[];
		// int len;
		// score = new int[len]; ex) int i ; i = 100;
		
		// => 변수가 값을 가지고 있는 경우에는 그 변수로 크기지정 가능.
		
		//--------------------------------------------------------------------
		
		// 2. 초기화
		
		score[0] = 10;
		score[1] = 11;
		score[2] = 12;
		score[3] = 13;
		score[4] = 14;
		// score[5] = 15; // 런타임 오류 발생 -> java.lang.ArrayIndexOutOfBoundsException
		// 배열 길이보다 더 길면 오류
		
		//--------------------------------------------------------------------
		
		// 3. 합계 출력
		System.out.println("< 합계 출력 >");
		
		sum = score[0] + score[1] + score[2] + score[3] + score[4];
		
		System.out.println("score 의 크기 = " + score.length);
		System.out.println("sum1 = " + sum);
		
		System.out.println("---------------------------------");
		
		//----------------------------------------------------------------------
		
		// 4. 일괄처리 (반복문)
		// => 학생들 점수 출력과 합계 계산
		System.out.println("< 학생들 점수와 합계 출력 - 일괄처리 >");
		
		sum = 0;
		
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			
			System.out.printf("%d번, %d점 \n", i + 1, score[i]);
		}
		System.out.println("sum2 합계 = " + sum);
		
		System.out.println("---------------------------------");
		
		//----------------------------------------------------------------------
		
		// 5. 묵시적 선언
		// => new 연산자 사용하지 않고, 선언과 동시에 초기화
		
		System.out.println("< 묵시적 선언 >");
		
		sum = 0;
		
		int[] score2 = {50, 60, 70, 80, 90}; // 배열 중괄호{} 사용.
		
		for (int i = 0; i < score2.length; i++) {
			sum += score2[i];
			
			System.out.printf("%d번, %d점 \n", i + 1, score2[i]);
		}
		System.out.println("sum3 합계 = " + sum);
		
		System.out.println("---------------------------------");
		
		//----------------------------------------------------------------------
		
		// 6. eachFor (쉬운, 간편한 for 구문)
		
	    // < for each 문 >
		// - JDK5.0 부터 지원되는 향상된 for 문 => index 없음.
		
	    // for ( 변수타입 변수명 : 배열 이름 ) { 실행부 }
	    // => 배열의 요소의 개수(배열의 크기)만큼 반복하며,
	    //    배열 score 가 가지고있는 값을 순차적으로 변수(sc)에 전달 
		
	    // => 주의사항
	    //    배열의 값만 순차적으로 사용가능하며 read만 가능. write 불가능 -> index 없기 때문에 접근(수정) 불가능.
	    //   (순차처리, readOnly)
		
		System.out.println("< eachFor - 간편한 for구문 >");
		
		sum = 0;
		
		for (int sc : score2) {	// 배열의 타입과 동일하게 int, char, String 등 변경해야 함.
			
			sum += sc;

			System.out.printf("점수 = %d점 \n", + sc);
		} // eachFor
		
		System.out.println("sum4 합계 = " + sum);
		
	} // main

} // class
