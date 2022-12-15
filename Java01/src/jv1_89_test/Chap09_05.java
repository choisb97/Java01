package jv1_89_test; // p.362

// 다음과 같이 정의도니 메서드를 작성하고 테스트하시오.

// Hint : StringBuffer, String, charAt(int i), indexOf(int ch)를 사용하라.

// 결과 = (1!2@3^4~5) -> 12345
//      (1 2 3 4 	5) -> (12345)

/*
 메서드명 : delChar
 기능 : 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
 반환타입 : String
 매개변수 : String src - 변환할 문자열
 		 String delCh - 제거할 문자들로 구성된 문자열
*/


public class Chap09_05 {
	
	// (1) delChar메서드를 작성하시오.
	public static String delChar(String src, String delCh) {
		
		StringBuffer sb = new StringBuffer(src.length());
		// 변환할 문자열의 길이만큼 StringBuffer에 크기지정
		
		for (int i = 0; i < src.length(); i++) {
		
		// => src의 character를 차례대로 꺼내어 금지어인 지 확인
		//    indexOf(c)에서 c가 없는 문자면 -1 return
			char c = src.charAt(i);
			if (delCh.indexOf(c) < 0)
				sb.append(c);
			
		} // for
		
			return sb.toString(); // sb(StringBuffer)를 String Type으로 return
		
	} // delChar
	
//========================================================================================

	public static void main(String[] args) {

		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		
		System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
		
	} // main

} // class
