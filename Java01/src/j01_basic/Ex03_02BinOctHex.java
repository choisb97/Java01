package j01_basic;

/*
 < 2진수, 8진수 , 16진수 표기 >

 - 2진수 : 0b 로시작 -> '0b'1111
 - 8진수 : 0  Octal Number -> '0'17
 - 16진수: 0x Hexadecimal Number -> '0x'f
*/

public class Ex03_02BinOctHex {

	public static void main(String[] args) {

		int bin = 0b1111;	// 1 + 2 + 4 + 8 = 15
		int oct = 017;		// 8 + 7 = 15 -> 10(8) + 7
		int hex = 0xf;		// 9, 10_A, 11_B, 12_C, 13_D, 14_E, 15_F, 16 -> 10 / = 15 = f
		
		System.out.println("** Binary : " + bin);
		System.out.println("** Hexadecimal : " + hex);
		
		System.out.println("------------------------------");
		
		// < Integer 를 2, 8, 16 진법으로 출력하기 >
		
		System.out.println("** Binary : " + Integer.toBinaryString(bin)); // 1111
		System.out.println("** Octal : " + Integer.toOctalString(oct)); // 17
		System.out.println("** Hexadecimal : " + Integer.toHexString(hex)); // f
		
		System.out.println("------------------------------");

		// < int to String >
		// 문자열에 연결되면 문자로 취급
		
		System.out.println("** int to String1 : " + bin + oct + hex); //	문자열로 151515
		System.out.println("** int to String1 : " + (bin + oct + hex)); // 소괄호() 묶어서 숫자 합계 45
		
		System.out.println("------------------------------");

		// < String to int >
		
		String s = "12345";
		
		System.out.println("** String to int1 : " +(s + 100)); // 문자열 s 와 100 => 12345100
		System.out.println("** String to int2 : " +(Integer.parseInt(s) + 100)); //12445(12345 + 100)
                                              // Integer.parseInt 이용해서 숫자로 형변환 ("안에 숫자만 있는 경우" 가능)
		
		s = "가나다라";
		// System.out.println(" String to int3 : " +(Integer.parseInt(s) + 100)); Error
		// -> java.lang.NumberFormatException: for input string: "가나다라" // "안에 숫자가 아닌 문자" 인 경우 에러
		
		System.out.println("------------------------------");
		
		// < String to double >
		
		s = "123.4567";
		
		System.out.println("** String to double1 : " + (Double.parseDouble(s) + 100)); // 223.4567(123.4567 + 100)
		                                      // Integer.parseDouble 이용해서 숫자로 형변환 ("안에 숫자만 있는 경우" 가능)
		s = "abcd.4567";
		// System.out.println(" String to double2 : " + (Double.parseDouble(s) + 100));
		// java.lang.NumberFormatException: For input string: "abcd.4567" // "안에 문자와 숫자 같이" 있는 경우에도 에러 
		
		System.out.println("------------------------------");
		
	}	// main

}	// class
