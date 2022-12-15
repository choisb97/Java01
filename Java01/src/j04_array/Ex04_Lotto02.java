package j04_array; // < 로또 번호 생성기 >

import java.util.Arrays;
import java.util.Random;

// < Lotto 번호 생성기 만들기 >

// => 찾기(search) & 정렬(sort)

public class Ex04_Lotto02 {

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
			//                  최댓값	   최솟값
			// 정수 / 45 => 나머지(%) 값의 범위 0, 1, 2, 3, ... , 44
			
			//--------------------------------------------------------
			
			// 2-2) 중복값 확인하기
			// 	 => 값이 동일한 자료가 존재하는 지 확인 (동일 자료 찾아보기 : search)
			
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					
					--i;
					
					break;
				} // if
			
			} // for_j
			
		} // for_i
		
		//---------------------------------------------------------------------
		
		// 3) 정렬 전 출력
		System.out.println("< 정렬 전 출력 >");
		
		System.out.println("!!! Lotto : " + Arrays.toString(lotto));
		
		System.out.println("-----------------------------------------------");
		
		//----------------------------------------------------------------------
		
		// 4) 오름차순 정렬
		// => 최솟값 찾는 방식이랑 유사
		// * 내림차순 -> 최댓값 찾는 방식이랑 유사
		
		// < 순차정렬 (Sequence Sort) >
		// - 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
		// 	 배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘.
		
		// < 정렬 알고리즘 >
		// - 삽입(insert)정렬, 합병(merge)정렬, 퀵(quick)정렬 ...
		
		// => https://blog.naver.com/tepet/221690306235
		
		for (int i = 0; i < lotto.length; i++) {
			// 맨 처음 숫자로 비교 시작 -> i = 0
			for (int j = i + 1; j < lotto.length; j++) {
				// 맨 첫 번째 비교 숫자 다음 숫자부터 -> j = i + 1
				
				if (lotto[i] > lotto[j]) {
					// < 오름차순 >
					// => i 보다 작은 j 가 있으면 서로 맞바꾼다 (치환)
					// => 끝까지 하면 오름차순 정렬됨.
					
					//----------------------------------------
				
					// * 성적순 : 내림차순
					// if (lotto[i] < lotto[j]){}
					
					int temp = lotto[i]; // 임시변수(temp) 에 lotto[i] 값 잠시 담아두고
					lotto[i] = lotto[j]; // 비어있는 [i] 에 [j] 담고
					lotto[j] = temp; // [j] 에 위에서 잠시 옮겨놨던 임시변수([i] 담기 => 치환

				} // if
				
			} // for_j
		} // for_i
		
		//----------------------------------------------------------------------
		
		// 5) 정렬 후 출력
		System.out.println("< 오름차순 정렬 후 출력 >");
		
		System.out.println("!!! Lotto 2 : " + Arrays.toString(lotto));
		
		System.out.println("================================================");
		
		//----------------------------------------------------------------------
		
		// 6) Wrapper Class
		// - toString(), sort(), equals(), ...
		
		int[] myLotto = {5, 15, 25, 35, 45, 17};
		
		Arrays.sort(lotto); // default : 오름차순 정렬 / 내림차순은 없음.
		
		System.out.println("< sort & equals - myLotto >");
		System.out.println("myLotto : " + Arrays.toString(myLotto));

		System.out.println("");
		
		//------------------------------------------------------------------------
		
		if (Arrays.equals(lotto, myLotto)) // equals => 배열 두 개 비교. (lotto, myLotto)
			System.out.println("!! 당첨 !!");
		
		else
			System.out.println("!! 꽝 !!");
		
		System.out.println("===============================================");
		
		//----------------------------------------------------------------------
		
		
		// 7) 최댓값 & 최솟값 출력하기
		System.out.println("< 최댓값 & 최솟값 출력 >");
		
		int max = lotto[0],
			min = lotto[0];
		
		for (int i = 1; i < lotto.length; i++) {

			// 7-1) 최댓값
			if (lotto[i] > max)
				max = lotto[i];
			
			// 7-2) 최솟값
			if (lotto[i] < min)
				min = lotto[i];
			
		} //for
		
		System.out.printf("최댓값 = %d, 최솟값 = %d \n", max, min);
		
		// System.out.println("최댓값 = " + max);
		// System.out.println("최솟값 = " + min);
		
		//--------------------------------------------------------------------------------
		
	} // main

} // class
