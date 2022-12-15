package j10_APITest;
// API = Application Program Interface

/* 
 < String 1 >
 1) 선언(정의)와 인스턴스
 => 묵시적, 명시적
 => 참조형변수 : 주소값을 가지고 있음 
 => 불변(immutable)의 속성을 가짐.
*/

public class Ex01_String01 {

	public static void main(String[] args) {
		
		// 1) 묵시적 선언
		String s1 = "그린";
		String s2 = "그린";
		
	//------------------------------------------------------------------------------------
		
		// 2) 명시적 선언(new 연산자)
		String s3 = new String("그린");
		String s4 = new String("그린");
		
		// => 값(value) 출력 비교
		System.out.printf("s1 = %s, s2 = %s, s3 = %s, s4 = %s \n", s1, s2, s3, s4);
		
		System.out.println("");
		
	//------------------------------------------------------------------------------------
		
		// => 값 변경 전/후 비교
		s1 = "홍길동";
		s3 = "홍길동";
				
		// 3) 인스턴스 비교 : == 연산자는 주소값 비교
		//       값 변경 전 / 후
		// 묵시 == 묵시 : T / F
		if (s1 == s2)
			System.out.println("s1 == s2 : True");
		else
			System.out.println("s1 == s2 : False");
		
		// 묵시 == 명시 : F / T
		if (s1 == s3)
			System.out.println("s1 == s3 : True");
		else
			System.out.println("s1 == s3 : False");

		// 명시 == 명시 : F / F
		if (s3 == s4)
			System.out.println("s3 == s4 : True");
		else
			System.out.println("s3 == s4 : False");
		
		System.out.println("");
		
	//------------------------------------------------------------------------------------
		
		// 4) 값(리터럴)의 비교 : equals()메서드는 대상의 내용 자체를 비교
		//           값 변경 전 / 후
		// 묵시 equals 묵시 : T / F
		if (s1.equals(s2))
			System.out.println("s1.equals(s2) : True");
		else
			System.out.println("s1.equals(s2) : False");
		
		// 묵시 equals 명시 : T / T
		if (s1.equals(s3))
			System.out.println("s1.equals(s3) : True");
		else
			System.out.println("s1.equals(s3) : False");
		
		// 명시 equals 명시 : T / F
		if (s3.equals(s4))
			System.out.println("s3.equals(s4) : True");
		else
			System.out.println("s3.equals(s4) : False");
		
		System.out.println("");
		
	//------------------------------------------------------------------------------------

		// 5) length(글자 수), 문자열연산('+'만 가능)
		s2 = "My name is Green";
		s3 = "안녕하세요 ~ !";
	
		System.out.println("** 영문 글자 수 = " + s2.length()); // 16
		System.out.println("** 한글 글자 수 = " + s3.length()); // 9
		
		int i = 100,
			j = 123;
		
		System.out.println("** 문자열 연산 = " + s1 + s2 + s3 + s4 + i + j);
		// 홍길동My name is Green안녕하세요 ~ !그린100123
		
		System.out.println("** 문자열 연산(우선순위) = " + s1 + s2 + s3 + s4 + (i + j));
		// 홍길동My name is Green안녕하세요 ~ !그린223
		
	} // main

} // class
