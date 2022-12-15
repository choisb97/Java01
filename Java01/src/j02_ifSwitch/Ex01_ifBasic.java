package j02_ifSwitch;

public class Ex01_ifBasic {

	public static void main(String[] args) {
		
		// < 삼항식 -> if >
		// => a, b 중 큰 수 출력하기
		
		int a = 10,
			b = 3;
		
		int max = (a > b) ? a : b; // a > b 이면 a, 아니면 b
		
		if (a > b) max = a; // 만약 a > b 이면 max = a
		else max = b; // 아니면 max = b
		
		// 모든 조건문은 관계식
		// 조건의 결과는 true / false
		
		boolean bool = (a > b) ? true : false; // a > b 이면 true, 아니면 false
		if (a > b) bool = true;
		else bool = false;
		
		// < 동일성 비교 >
		char cc = (a > b) ? 'T' : 'F';
		if (a > b) cc = 'T';
		else cc = 'F';
		
		// < 복합문 (compound statement)
		// - 여러 문장의 경우 중괄호{}를 사용하여 문장들을 그룹핑
		String ss = (a < b) ? "참" : "거짓"; // a < b 이면 참, 아니면 거짓
		if (a != b) { 	// a와 b가 같지 않다면
			ss = "다름"; 
			cc = 'T';
			bool = true;
		} else { 	// 아니면 (a와 b가 같다면)
			ss = "같음";
			cc = 'F';
			bool = false;
		}
		
		
		System.out.println("< 삼항식 결과 >");
		System.out.printf("max = %d, bool = %b, cc = %c, ss = %s \n", max, bool, cc, ss);
		
		System.out.println("-----------------------------------------------");
		
		//------------------------------------------------------------------------------
		
		// else 구문은 생략 가능(필요 시에만 사용)
		
		// a + b 가 100 보다 작으면 "당첨" 출력
		if (a + b < 100) 
			System.out.println("당첨"); // V
		else
			System.out.println("꽝!");
		
		System.out.println("");
		
		// a + b가 100보다 크면 당첨 아니면 꽝!
		if (a + b > 100)
			System.out.println("당첨");
		else
			System.out.println("꽝!"); // V
		
		// 연산자 중 우선순위 : '+', '-', '*', '/'
		
	} // main

} // class
