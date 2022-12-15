package jv1_2345_test; // p.127

// int타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
// 만일 변수 num의 값이 12345라면, '1 + 2 + 3 + 4 + 5'의 결과인 15를 출력하라.
// (1)에 알맞은 코드를 넣으시오.
// 주의 - 문자열로 변환하지 말고 숫자로만 처리해야 한다.

// 결과 = 15

public class Chap04_09 {

	public static void main(String[] args) {
		
		int num = 12345;
		int sum = 0;
		
		// (1) 알맞은 코드를 넣어 완성하시오.
		while (num > 0) {
			
			sum += num % 10; // sum = sum + num % 10
			// num을 10으로 나눈 나머지를 sum에 더한다.
			
			num /= 10; // num = num / 10
			// num을 다시 10으로 나눈다. (int라서 소수점은 없어짐)
			
		} // while
		
		System.out.println("sum = " + sum);

	} // main

} // class
