package jv1_67_test; // p.214

// 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

// 결과 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//		 [4, 6, 8, 3, 2, 9, 7, 1, 5]
// 주의 - Math.random()을 사용하는 경우 실행결과와 다를 수 있음.

public class Chap06_17 {
	
	/*
	 메서드명 : shuffle
	 기능 : 주어진 배열에 담긴 값의 위치를 바구는 작업을 반복하여 뒤섞이게 한다.
	 	   처리한 배열을 반환한다.
	 반환타입 : int[]
	 매개변수 : int[] arr - 정수값이 담긴 배열
	 */

	// (1) shuffle 메서드를 작성하시오
	public static int[] shuffle(int[] arr) {
		if(arr == null || arr.length == 0)
			return arr;
		
		for (int i = 0; i < arr.length; i++) {
			int j = (int)(Math.random() * arr.length);
			// arr[i]와 arr[j]의 값을 서로 바꾼다.
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		} // for
		
		return arr;
		
	} // shuffle

	
	public static void main(String[] args) {

		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		// [ 1 ~ 9 랜덤 ]
		
	} // main

} // class
