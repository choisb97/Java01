package jv1_67_test; // p.219

// 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

// 결과 = 5의 절댓값 : 5
//	    -10의 절댓값 : 10

public class Chap06_21 {

	/*
	 메서드명 : abs
	 기능 : 주어진 값의 절댓값을 반환한다.
	 반환타입 : int
	 매개변수 : int value
	 */
// (1) abs메서드를 작성하시오.
	public static int abs(int value) {
		return value >= 0 ? value : -value;
		
		/*
		 if문 사용
		 
		 if (value >= 0) {
			return value;
		} else {
			return -value; // value가 음수인 경우, 부호를 변경한다.
		}
		 */
		
	} // abs
	
	
	public static void main(String[] args) {

		int value = 5;
		System.out.println(value + "의 절댓값 : " + abs(value));
		
		value = -10;
		System.out.println(value + "의 절댓값 : " + abs(value));
		
		
	} // main

} // class
