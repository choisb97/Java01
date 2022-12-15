package j01_basic;

/*
 < 기본자료형의 종류와 Wrapper Class, 치환 > **

=> 용어정리
 - identifier : 직접작명하는 식별자 (프로젝트, 클래스, 메서드, 변수, 상수 등의 이름): 예약어는 쓸 수 없음.
 - modifier : 특징을 제한하는 한정자 (public, static..등 예약어의 일종) 
 - literal : 변수 우측의 값(Value)

 < identifier 작명의 일반적 규칙 >

 - project, class 명은 대문자로 시작.
 - 상수명은 전체 대문자로 작성. 
 - 위외는 모두 소문자로 시작. ( 합성: setName => 낙타(camel) 표기법)
 - 한글 : 허용은 되지만 권장하지 않음
 - 연산자(+, -, *, /, %) 는 식별자에 포함할 수 없음
 - 한 번 선언된 변수명은 재선언 할수 없음 
   ( 동일한 identifier 를 중복 선언할 수 없음 )

 - 변수명의 규칙 (ppt J03_01 , 8p)
 */

public class Ex02_Variable02 {		// public class => modifier

	public static void main(String[] args) {	// public static void => modifier
		// ** < 한글 Test >

		String 이름 = "껌딱지";		// 한글 쓰지 말기!
		System.out.println(" 남자친구 : " + 이름);

		// String irum = "최수빈";	// 한글 발음대로 영어쓰기 금지!!

		System.out.println("----------------------");

		// ** < 정수형 >

		// => byte(8), short(16_2byte), int(32_4byte), long(64_8byte)

		byte b = 10;	// 선언과 동시에 값을 할당 : 초기화
		short s = 123;	// 선언, 선언과 동시에 초기화
		int i;			// 선언.
		i = 1234567890;	// 값을 할당.
		// Java 는 정수 literal 을 int 로 취급.
		// => int 를 초과하는 정수 literal을 표현 못 함.
		long l = 1234567890123L;	// => L/l : 반드시 long Type literal 임을 표시해야 함.

		System.out.println("int i = " + i);
		System.out.println("long l = " + l);

		System.out.println("----------------------");

		//=====================================================

		// ** < 실수형 >
		// => float(32_4byte), double(64_8byte)
		// => 실수 literal 의 기본형은 double;

		double d = 123.456;
		// float f = 123.456;	// 4byte = 8byte : Error
		float f = 123.456F;		// F/f 모두 허용.

		System.out.println("double d = " + d);
		System.out.println("float f = " + f);

		System.out.println("----------------------");

		//=====================================================

		// ** < Wrapper Class >

		// => 기본자료형을 지원해주는 클래스 (모든 기본자료형에 있음)
		//	  해당 클래스명은 기본자료형의 첫 글자를 대문자로 하면 됨.

		System.out.println("** 정수형의 Literal 범위 **");
		System.out.println("** byte => " + Byte.MIN_VALUE+ " ~ " + Byte.MAX_VALUE);
		System.out.println("** short => " + Short.MIN_VALUE+ " ~ " + Short.MAX_VALUE);
		System.out.println("** int => " + Integer.MIN_VALUE+ " ~ " + Integer.MAX_VALUE);	// int = Integer 사용.
		System.out.println("** long => " + Long.MIN_VALUE+ " ~ " + Long.MAX_VALUE);

		System.out.printf("** long_printf => %d ~ %d \n", Long.MIN_VALUE, Long.MAX_VALUE); // printf (줄바꿈 없음) = 포맷이 있는 출력물 / %d - 정수(d)
		System.out.println("----------------------"); // \n => escape 문자..?


		System.out.println("** 실수형의 Literal 범위 **");
		System.out.printf("** float => %f ~ %f \n", Float.MIN_VALUE, Float.MAX_VALUE);	// %f - 실수(f)
		System.out.printf("** double => %f ~ %f \n", Double.MIN_VALUE, Double.MAX_VALUE);

		System.out.println("----------------------");

		// ** < boolean > - 관계식 -> 결과는 true/false 둘 중 하나, 늘 boolean Type

		boolean bool; 	// true(1), false(0)
		bool = b > s;	// false(0)
		System.out.printf("** boolean Test => %b \n " , bool);	// %b - boolean(b)

		System.out.println("----------------------");


		// ** < char >

		// => 한글, 영문 모두 한 글자를 의미, 2byte
		// => 2byte int Type 으로도 사용 가능.(형변환 - 양 쪽의 Type 이 같아야 사용 가능)
		// => ASCII Code (American Standard Code for Information Interchange) - 아스키 코드
		char aa = 'A', bb = 'B', cc = 'C';
		cc = '가';	// 한 글자 이상은 불가능. (ex '가1')

		String ss = "한 글자 이상 가능";

		System.out.println("** String + char => " + ss + cc);			// 문자열 연산 가능.
		System.out.println("** char + char1 => " + aa + bb + cc);		// 문자열 연산 가능.
		System.out.println("** char + char2 => " + (aa + bb + cc));		// (우선순위) 적용 : int 연산

		// System.out.printf("** aa=%d, bb=%d, cc=%d \n " , aa, bb, cc);	// Error
		System.out.printf("** aa=%d, bb=%d, cc=%d \n" , (int)aa, (int)bb, (int)cc);	// (int)ss => Error / char = 같은 타입의 int 사용 가능.(형변환)
		System.out.printf("** aa=%s, bb=%s, cc=%s \n" , aa, bb, cc);	// %s => 문자로 확인 가능.

		System.out.println("----------------------");

		// ** < 치환 >

		// => 값의 맞교환 (cup1 의 값과 cup2 의 값을 교환)
		// => box 내에 여러 값이 들어있는데 그 중 어떤값이 cup1 , cup2 의 값이 될 지 모른다고 가정
		// => 중간 보관을 위한 같은 타입의 임시 변수가 필요함
		// => "=" 동일성을 의미하는 것이 아니고 대입연산자

		String cup1 = "콜라";
		String cup2 = "사이다";

		// temp 또는 tmp : Temporary(일시적인, 임시적인)의 준말

		String temp = cup1;	// temp : 임시 변수로 자주 사용함. => cup1 의 값을 보관.

		cup1 = cup2;
		cup2 = temp;

	}	// main

}	// class
