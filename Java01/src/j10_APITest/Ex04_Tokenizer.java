package j10_APITest;

import java.util.StringTokenizer;

// < StringTokenizer >
// - 문자열을 토큰으로 구분
//   순차처리 지원 (hasMoreTokens, nextToken)
// new StringTokenizer("데이터", "구분자");

public class Ex04_Tokenizer {

	public static void main(String[] args) {
		
		StringTokenizer st = new StringTokenizer("AM:11:40:12", ":");
		                                         
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		System.out.println("----------");
		
		// => 둘 이상의 구분자, 공백도 구분자에 포함 가능
		st = new StringTokenizer("1 2+3 4-5*6/7", " +-*/");
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("----------");
		
		// SB Test
		st = new StringTokenizer("최 수+빈 / 이 % 재영", " +/%");
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	} // main

} // class
