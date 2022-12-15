package jv1_67_test; // p.218

// 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

// 결과  = [ 3, 2, 9, 4, 7 ]
//       최댓값 : 9
//       최댓값 : -999999
//       최댓값 : -999999

public class Chap06_20 {
	
	/*
	 메서드명 : max
	 기능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
	      만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
	 반환타입 : int
	 매개변수 : int[] arr - 최댓값을 구할 배열
	 */

	// (1) max메서드를 작성하시오.
	public static int max (int[] arr) {
		if (arr == null || arr.length == 0) // arrdl null이거나 arr배열의 크기가 0이면
			return -999999; // -999999를 반환한다.
		
		int max = arr[0]; // 배열의 첫 번째 값으로 최댓값을 초기화한다.
		
		for (int i = 1; i < arr.length; i++) { // 배열의 두 번째 값부터 비교한다. (int i = 1)
			if(arr[i] > max) { // arr배열 i 번째 값이 max보다 크면
				max = arr[i];
			} // if
		} // for - 반복문을 다 돌고나면 최댓값이 max에 저장되어 있을 것.
		
		return max; // 저장된 최댓값을 반환한다.
	} // max
	
	
	public static void main(String[] args) {
		
	int[] data = { 3, 2, 9, 4, 7 };
	System.out.println(java.util.Arrays.toString(data));
	// [3, 2, 9, 4, 7]
	
	System.out.println("최댓값 : " + max(data));
	// 최댓값 : 9
	
	System.out.println("최댓값 : " + max(null));
	// 최댓값 : -999999
	System.out.println("최댓값 : " + max(new int[] {})); // 크기가 0인 배열
	// 최댓값 : -999999
	
	} // main

} // class
