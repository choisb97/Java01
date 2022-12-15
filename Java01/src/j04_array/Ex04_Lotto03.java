package j04_array;

import java.util.Arrays;
import java.util.Random;

/*
 < 과제 >
 => Lotto 배열 2개 준비.
    당첨번호, myNumber
 => 두 배열 모두 Random 으로 초기화
 => 중복확인, 정렬(직접작성)
 => 당첨확인 (일치 여부만 확인)

====================================================================

 < Random 클래스 >
 - java.util 에 있으므로 import 필요하고, new 선언 후 사용 가능함.

 => Random() : 호출시마다 현재 시간을 이용한 종자값이 자동 설정됨 
 => Random(long seed) : 인자값으로 주어진 종자값이 설정됨 
 * 종자값 : 난수 만드는 알고리즘에서 사용되는 값
         ( 같으면 같은 난수 얻음 )

 => Random().nextInt(큰 수 - 작은 수 + 1) + 작은 수 
 Random().nextInt() , Random().nextLong() , Random().nextBoolean()
 Random().nextDouble() ,  Random().nextFloat()
*/

public class Ex04_Lotto03 {

	public static void main(String[] args) {
		
		// 1. Lotto 배열 2개 준비
		
		int lotto[] = new int[6];
		int myLotto[] = new int[6];
		
		Random rn = new Random(7);
		
		//----------------------------------------------------
		
		// 2. 당첨번호 만들기
		// => 중복확인, 오름차순 정렬 직접 작성하기

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rn.nextInt(45) + 1;
			
			//----------------------------------------
			
			// 2-1 중복 값 확인하기
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					
					--i;
					
					break;
				} // if
			} // for_j
		} // for_i
		
		//----------------------------------------------------
		
			// 2-2 오름차순 정렬
		
			for (int i = 0; i < lotto.length; i++) {
				for (int j = i + 1; j < lotto.length; j++) {
					if (lotto[i] > lotto[j]) {
					
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
						
					} // if
				} // for_j
			} // for_i
		
		System.out.println("!!! 당첨 Lotto : " + Arrays.toString(lotto));
		
		System.out.println("--------------------------------------------------");
		
		//----------------------------------------------------
		
		// 3. myNumber 만들기
		// => 중복확인, 오름차순 정렬 (Arrays.sort 이용)
		
		rn = new Random(7);
		
		for (int i = 0; i < myLotto.length; i++) {
			myLotto[i] = rn.nextInt(45) + 1;
			
		//-----------------------------------------------------
		
			// 3-1 중복 값 확인하기
			
			for (int j = 0; j < i; j++) {
				if (myLotto[i] == myLotto[j]) {
								
					--i;
								
					break;
					
				} // if
			} // for_j
		} // for_i
					
		//----------------------------------------------------
					
			// 3-2 오름차순 정렬
					
		for (int i = 0; i < myLotto.length; i++) {
			for (int j = i + 1; j < myLotto.length; j++) {
				if (myLotto[i] > myLotto[j]) {
								
					Arrays.sort(myLotto);
					
				} // if
			} // for_j
		} // for_i
		
		System.out.println("!!! myLotto : " + Arrays.toString(myLotto));
		
		System.out.println("--------------------------------------------------");
		
		//----------------------------------------------------
		
		// 4. 당첨 확인
		
		if (Arrays.equals(lotto, myLotto))
			System.out.println("*** 축하합니다~~~!! 당첨 ***");
		
		else
			System.out.println("!! 아쉽습니다ㅠㅠㅠㅠ 꽝 !!");

	} // main

} // class
