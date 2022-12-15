package j04_array; // < 로또 번호 생성기 >

import java.util.Arrays;
import java.util.Random;

/*
 < Lotto 번호 생성기 만들기 >
 => int 를 6개 담을 수 있는 배열 생성 : lotto
 => Random 으로 1 ~ 45 범위의 숫자를 생성해서 배열 초기화하기.
 	 (추가 : 단, 중복은 허용하지 않음)
 => 출력
*/
public class Ex04_Lotto01 {

	public static void main(String[] args) {

		// 1) 배열 정의
		int lotto[] = new int[6];
		
		//----------------------------------------------------------------------
		
		// 2) Random으로 배열 초기화
		// => 중복 허용 X
		
		Random rn = new Random();
		
		for (int i = 0; i < lotto.length; i++) {
			
			// 2-1) random number 추출 & 배열에 담기
			
			lotto[i] = rn.nextInt(45) + 1; 
			//                   최댓값  최솟값
			// 정수 / 45 => 나머지(%) 값의 범위 0, 1, 2, 3, ... , 44 => + 1 = 1, 2, 3, 4, ..., 45
			
			//--------------------------------------------------------
			
			// 2-2) 중복값 확인하기
			// 	 => 값이 동일한 자료가 존재하는 지 확인 (동일 자료 찾아보기 : search)
			
			for (int j = 0; j < i; j++) {
				// 처음부터 중복 값이 있는 지 확인해야 해서 j = 0
				if (lotto[i] == lotto[j]) {
					
					--i;
					
					break;
				} // if
			
			} // for_j
			
		} // for_i
		
		//---------------------------------------------------------------------
		
		// 3) 출력
		
		System.out.println("!!! Lotto : " + Arrays.toString(lotto));
		
		System.out.println("-----------------------------------------------");
		
		//----------------------------------------------------------------------
		
		// 4) 최댓값 & 최솟값 출력하기
		System.out.println("< 최댓값 & 최솟값 출력 >");
		
		int max = lotto[0],
			min = lotto[0];
		
		for (int i = 1; i < lotto.length; i++) {

			// 4-1) 최댓값
			if (lotto[i] > max)
				max = lotto[i];
			
			// 4-2) 최솟값
			if (lotto[i] < min)
				min = lotto[i];
			
		} //for
		
		System.out.printf("최댓값 = %d, 최솟값 = %d \n", max, min);
		
		// System.out.println("최댓값 = " + max);
		// System.out.println("최솟값 = " + min);
		
		//----------------------------------------------------------------------
		
		// 5) 오름차순 정렬
		// => Lotto02 > 4), 5)
		
	} // main

} // class
