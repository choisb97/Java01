package j01_basic;

/*
 < 변수(Variable) 정의 >
 - type, 변수명, value
 - type은 불변, value는 변경가능


 < 상수(Constant)>
 - type 불변, value도 불변
 - 주로 고정값에 사용 (ex. pi = 3.141592)
 - 전체 대문자로 표기


 < 기본자료형 >
 - 예약어로 정의된 Type
 - 더이상 나누어질 수 없는 기본자료형
 - int, double, boolean, char
 - 정수형(int) : byte(8), short(16_2byte), int(32_4byte), long(64_8byte)
 - 실수형(double) : float(32_4byte), double(64_8byte)


 < 참조자료형 >
 - String
 - 모든 class는 참조자료형이 될 수 있음.
   주소를 가지고 참조함.
   값을 바꿔도 주소만 변경해서 추가되고 값 자체가 수정되지는 않는다.
 */

public class Ex02_Variable01 {

	public static void main(String[] args) {
		// ** 상수
		// final double PI = 3.141592;	// 불변 = final
		// PI = 2.12345; // Error -> 위에서 final 로 사용했기 때문에 값 변경 불가.

		// ** 변수
		String job = "강사";
		String name; 
		name = "최수빈";
		int age = 20;			// 정수
		double height = 170.99;	// 실수
		// age = 26.6;
		// height = 100;

		// ** Type mismatch
		// height = " 가나다라";
		// name = 12345;
		// name = 'A';
		// grade = "A";

		// name = "123.45";		// 문자열 안에 숫자쓰면 문자로 읽힘.

		System.out.println("** test1 => " + (age + height));	// 190.99 => 120.0 -> height 100 때문.
		System.out.println("** test2 => " + (age + name));		// 20123.45

		boolean tf = true;		// true/false

		char grade = 'A';

		grade = '가';

		System.out.println("** 직업 => " + job);
		System.out.println("** 이름 => " + name);
		System.out.println("** 나이 => " + age);
		System.out.println("** 신장 => " + height);
		System.out.println("** 진위 => " + tf);
		System.out.println("** 점수 => " + grade);

	} // main

} // class
