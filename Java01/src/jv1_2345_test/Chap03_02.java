package jv1_2345_test; // p.95

// 다음 연산의 결과를 적으시오.

public class Chap03_02 {

	public static void main(String[] args) {
		
		int x = 2;
		int y = 5;
		char c = 'A';	// 'A' 의 문자 코드는 65
		
		System.out.println(y >= 5 || x < 0 && x > 2); // true
		// && 가 || 보다 우선순위가 높기 때문에 && 먼저 연산.
		
		System.out.println(y += 10 - x++); // 13
		// y = y + 10 == 15 /  15 - x =13 -> x는 출력 후 연산(후위형)되기 때문에 출력 후 x = 3
		
		System.out.println(x += 2); // 5
		// 위에서 출력 된 x = 3 => 3 + 2 = 5
		
		System.out.println(!( 'A' <= c && c <= 'Z')); // false
		// 'Z' 의 문자 코드가 'A'의 문자 코드보다 크기 때문에 true -> !(not) => false
		
		System.out.println('C' - c); // 2
		// 67('C') - 65('A') = 2
		
		System.out.println('5' - '0'); // 5
		// 문자 형태의 숫자 연산은 숫자로 자동 형변환 됨.
		
		System.out.println(c + 1); // 66
		// 'A' 가 int(숫자) 로 형변환 되어 연산.
		
		System.out.println(++c); // B
		// 전위형 - 연산 후 출력 => ++'A' = 'B'
		
		System.out.println(c++); // B
		// 후위형 - 출력 후 연산 => 위에서 연산된 'B' 먼저 출력 후 연산되어 'C'
		
		System.out.println(c); // C
		// 위에서 출력된 'C' 그대로 출력

	}

}
