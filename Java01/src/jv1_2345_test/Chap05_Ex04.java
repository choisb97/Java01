package jv1_2345_test;	// p.139 5-4

// < Shuffle >

import java.util.Arrays;

// < 배열 활용 (섞기 shuffle) >

// => 길이가 10인 배열을 정의하고, 0 ~ 9 로 초기화
// => random 을 이용해서 배열의 임의의 위치에 있는 배열의 값과
//    배열의 첫 번째([0]) 값과 교환하는 일을 100번 반복해서 배열을 뒤섞이도록 한다.

//--------------------------------------------------------------------------

// 길이가 10인 배열 numArr 을 생성하고 0 ~ 9의 숫자로 차례대로 초기화하여 출력한다.
// 그 다음 random() 을 이용해서 배열의 임의의 위치에 있는 값과 배열의 첫 번째 요소 'numArr[0]'의
// 값을 교환하는 일을 100번 반복해서 배열의 요소가 뒤섞이게 한다.
// 만일 random()을 통해 얻은 값 n이 3이라면, 아래의 그림처럼 두 값이 서로 바뀐다.

public class Chap05_Ex04 {

	public static void main(String[] args) {
		
		// 1) 배열 정의 & 초기화
		
		int[] numArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println("< numArr 정의 > = " + Arrays.toString(numArr));

		//--------------------------------------------------------------
		
		// 2) 섞기 Shuffle 100번

		for (int i = 0; i < 100; i++) { // i < 100 => 0 ~ 99 까지
			
			// random 을 이용해서 배열의 임의의 위치 얻기
			int n = (int)(Math.random() * 10); // 0 ~ 9 중의 한 값을 임의로 얻는다. 
			// (Math.random() * n) => n 보다 작지만 무한히 가까운 수들이 만들어진다.
			// 예제가 0 부터라서 그냥 10 썼지만 1부터 구하려면 random() * n + 1 해야됨.
			// => 정수로 형변환 시 처음 숫자가 0 이기 때문에
			// Math.random => double(실수 타입) -> (int) 정수로 형변환
		
			int temp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = temp;
		
		} // for_i
		
		System.out.println("< numArr Shuffle > = " + Arrays.toString(numArr));
		
	} // main

} // class
