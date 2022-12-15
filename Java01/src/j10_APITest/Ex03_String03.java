package j10_APITest;

import java.util.Arrays;

/*
 < String 3 >
 => String의 메서드
 => 문자열 변경
   -> toLowerCase, toUpperCase, replace, split
   -> Type 변경 : int to String, String to int 
*/

public class Ex03_String03 {

	public static void main(String[] args) {
		
		String name = "홍길동";
		String city = "~~~~~SeoulKorea~~eee";
		String country = "     !I!Love!Korea!     ";
		
		System.out.printf("** Value 확인 => %s, %s, %s \n", name, city, country);
	
	//------------------------------------------------------------------------------------
	
		// < 1. 문자열 변경 >
		
		// 1-1) toLowerCase, toUpperCase
		// - 한글 : 변경 없이 출력
		// - 영문 : 대/소문자 변경
		
		System.out.printf("\n** toLowerCase => %s, %s \n"
				, city.toLowerCase(), name.toLowerCase());
		
		System.out.printf("** toUpperCase => %s, %s \n"
				, city.toUpperCase(), name.toUpperCase());
		
		// => 복습 : city에서 Korea만 모두 대문자로 출력하기
		System.out.printf("** Korea만 대문자로 출력 => %s \n"
				, city.substring(city.indexOf("K"), city.indexOf("a") + 1).toUpperCase());
		
	//------------------------------------------------------------------------------------
		
		// 1-2) replace
		
		System.out.printf("\n** replace => %s, %s, %s \n"
				, name.replace("홍", "김"), city.replace("e", "Apple")
				, country.replace("Korea", "대한민국"));
		// 없는 글자 replace 할 시 오류 없고 원본 출력
		// 예) name.replace("이", "김") -> return : 홍길동
		
	//------------------------------------------------------------------------------------
		
		// < 2. split >
		// - 인자로 전달된 기호를 기준으로 잘라 배열에 담아줌
		
		String[] ss = country.split("!");
		System.out.println("\n** split 1 => " + Arrays.toString(ss));
		
		// => 양 옆의 스페이스(공백) 제거하고 처리하기
		ss = country.trim().split("!");
		System.out.println("** split 2 => " + Arrays.toString(ss));
		
		// => SB Test
		ss = city.split("~");
		System.out.println("** SB Test split 3 => " + Arrays.toString(ss));
		
	//------------------------------------------------------------------------------------
		
		// < 3. 형변환 >
		// => String <-> int
		// => String <-> double, float
		
		// 3-1) String -> int, double, float (Wrapper Class 이용)
		
		String num1 = "12345";
		String num2 = "100";
		
		System.out.println("\n** Test 1 문자열 연산 => " + num1 + num2); // 12345100
		
		System.out.println("\n** Test 2 산술 연산(int) => " + 
				(Integer.parseInt(num1) + Integer.parseInt(num2))); // 12445
		
		/*
		num2 = "100a"; // 런타임오류 : java.lang.NumberFormatException
		
		System.out.println("** Test 2 산술 연산 => " + 
				(Integer.parseInt(num1) + Integer.parseInt(num2)));
		*/
		
		num1 = "123.456";
		num2 = "200.300"; // "200.300f" 아니어도 parseFloat 적용 시 정상 출력됨.
		// num2 = "200.300t"; // 런타임오류 : java.lang.NumberFormatException
		
		System.out.println("** Test 2 산술 연산(double) => " 
		+ (Double.parseDouble(num1) + Double.parseDouble(num2))); // 323.75600000000003
		
		System.out.printf("** Test 2 출력 확인 : double = %f, float = %f \n" 
				,Double.parseDouble(num1), Float.parseFloat(num2));
		// double = 123.456000, float = 200.300003
		
	//------------------------------------------------------------------------------------

		// 3-2) int, double..(숫자) -> String
		
		int i = 10,
			j = 20;
		// num1 = i + j; -> Type mismatch Error
		
		// 수식에 문자가 하나라도 포함되면 문자열 연산 가능 -> 문자열 위치에 따라 출력 값 달라짐
		num1 = i + j + ""; // "30" -> 숫자 연산 후 문자열로
		num2 = "" + i + j; // "1020" -> "" + i = "10" 문자열 변경 후 연산해서 1020 출력
		
		System.out.println("\n** Test 3 num1 => " + num1);
		System.out.println("** Test 3 num2 => " + num2);
		
	//------------------------------------------------------------------------------------

		// < ** 기본 자료형의 값을 문자열로 바꾸기 : valueOf() >
		// => 모든 기본 자료형 적용 가능.
		//    static String valueOf(boolean b)
		//    boolean, char, float, int, long...
		
		double d = 1234.567;
		// num1 = d; -> Type mismatch
		num1 = String.valueOf(d); // String Type으로 전달 가능
		num2 = "true"; // "true" -> boolean Type과 무관한 String
		num2 = String.valueOf(true);
		// 비교 : num2 = true; -> Type mismatch\
		
		num2 = String.valueOf((i > j));
		System.out.println("\nboolean Type Test : num2 = " + num2); // num2 = false
		
	//------------------------------------------------------------------------------------
		
		// < 4. 비교 : compareTo > - https://mine-it-record.tistory.com/133
		// - 사전 순서로 비교 
		//   같으면 0, 이전이면 음수, 이후면 양수 return
		// => 문자열의 순서가 일치하면 : 다른 글자 갯수를 표시함
		//   (예 : abc compareTo abcabc = -3)
		// => 완전히 다른 문자는 알파벳 첫 글자의 순서 차이 return
		
		//   ( comparTo는 같은 위치의 문자만 비교하기 때문에,
		//	 첫번째 문자부터 순서대로 비교해서 다를 경우 바로 아스키값을 기준으로 비교처리를 한다. )

		name = "abc";
		country = "korea";
		
		System.out.println("\n** compareTo 1 => " + name.compareTo("abc")); // 0
		System.out.println("** compareTo 2 => " + name.compareTo("ab")); // +1
		System.out.println("** compareTo 3 => " + name.compareTo("a")); // +2
		System.out.println("** compareTo 4 => " + name.compareTo("bc")); // -1
		System.out.println("** compareTo 5 => " + name.compareTo("c")); // -2
		System.out.println("** compareTo 6 => " + name.compareTo("abcabc")); // -3
		System.out.println("** compareTo 7 => " + name.compareTo("abcabcd")); // -4
		System.out.println("** SB Test compareTo => " + country.compareTo("efg")); // +6
		System.out.println("** SB Test compareTo => " + country.compareTo("love")); // -1
		System.out.println("** SB Test compareTo => " + country.compareTo("norea")); // -3
		System.out.println("** SB Test compareTo => " + country.compareTo("kore")); // 1
		
		/*
		 < if에 적용 시 주의 >
		 if (name.compareTo(num2) == 0) {
			** == 0  처럼 결괏값과 비교하는 연산자 필요 **
		 }
		*/
	//------------------------------------------------------------------------------------
		
		// < 5. 포함확인 >
		
		System.out.println("\n** 포함확인 1 => " + country.contains("Korea")); // true
		                                    // country가 "Korea"를 포함하고 있다면 True/False
		
		System.out.println("** 포함확인 2 => " + country.contains("korea")); // false
		                                                      // 대/소문자까지 구분
		
	} // main

} // class
