package jv1_2345_test; // p.96

// 아래는 변수 num 의 값에 따라 '양수', '음수', '0' 을 출력하는 코드이다.
// 삼항 연산자를 이용해서  (1)에 알맞은 코드를 넣으시오.
// Hint : 삼항 연산자를 두 번 사용하세요.

public class Chap03_05 {

	public static void main(String[] args) {

		int num = 0;
		
		// (1) 알맞은 코드를 넣으세요.
		System.out.println(num == 0 ? 0 : (num > 0 ? "양수" : "음수")); // =(대입연산자) / ==(비교연산자)
		// num 이 0 인 경우 0, 아니면 (0보다 클 경우 "양수", 0보다 작을 경우 "음수")
		
		// 쌤 풀이
		// System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : 0));
	} 

}
