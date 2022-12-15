package jv1_2345_test; // p.126

// 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하시오.
// 만일 문자열이 "12345" 라면, '1 + 2 + 3 + 4 + 5'의 결과인 15가 출력되어야 한다.
// (1)에 알맞은 코드를 넣으시오.

// Hint : String 클래스의 charAt(int i) 사용.

// 결과 : sum = 15

public class Chap04_07 {

	public static void main(String[] args) {

		String str = "12345";
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			// (1) 알맞은 코드를 넣어 완성하세요.
			
			sum += str.charAt(i) - '0'; // 15
			
			// str.charAt(i) = '1', '2', '3', '4', '5'
			//      '0' = 48 /  49,  50   51   52   53
			
			/*
			뺄셈과 같은 이항연산자는 int타입보다 작은 타입인 피연산자(byte, short, char)은 int로 변환한다.
			'1' - '0' = int 자동형변환 49 - 48 = 1
			'2' - '0' = int 자동형변환 50 - 48 = 2
			'3' - '0' = int 자동형변환 51 - 48 = 3
			'4' - '0' = int 자동형변환 52 - 48 = 4
			'5' - '0' = int 자동형변환 53 - 48 = 5
			*/
			
		} // for
		
		System.out.println("sum = " + sum);
	
	} // main

} // class


