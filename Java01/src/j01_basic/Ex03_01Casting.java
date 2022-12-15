package j01_basic;

/*
 < Type Casting (형변환) >

 1. 자동 (프로모션 promotion , 확대 형변환)
	=> 큰 자료형에 작은 자료형을 대입하면 : 자동으로 이루어짐.

 2. 강제 (디모션 demotion, 축소 형변환)
 	=> 작은 자료형에 큰 자료형을 대입 : 자동으로 이루어지지 않음.
 	=> 자료의 Type 이 다른 경우
 	=> 명시적 형변환
*/

public class Ex03_01Casting {

	public static void main(String[] args) {
		
		// < 1. 자동 (프로모션 promotion, 확대 형변환) >
		
		double d = 123.456;	// 8byte
		int i = 123456;		// 4byte
		
		d = i;				// 프로모션 ( 큰 자료형(i) 에 작은 자료형 (d) 대입 )
		
		System.out.println("** i = " + i);
		System.out.println("** d = i => " + d);
		
		System.out.println("------------------------------");
		 
		// < 2. 강제 (디모션 demotion, 축소 형변환) >
	    // 		=> 동일 Type의 경우에도 받는쪽 크기가 작은경우 
	    // 		=> 자료의 Type이 다른경우
		
		char c = 'C';	// 2byte
		
		System.out.println("** char c = " + c + ", " + (int)c); // (int)c : 67
		
		i = c + 1;	// char 가 숫자와 연산을 하게되면 산술 연산으로 자동 적용됨.
	 // i = 67 + 1 = 68
		
		System.out.println("** int i = " + i + ", " + (char) i + ", c = " + c);
		                             // 68      // 문자 'C' + 1 => 'D'    c = 'C'
		
		System.out.println("------------------------------");
		
		// < 같은 크기 다른 Type (int, float)>
		
		float f =456.78F;	// 4byte
		int n = 100;		// 4byte
				
		// n = f : Error(Type mismatch)-> 디모션(demotion) 형변환 필요.
		n = (int)f;
		System.out.println("** int n => " + n); // int n = 정수형 => 456
		
		f = n;		// 자동 형변환, 프로모션
		System.out.println("** int f => " + f); // float f = 실수형이지만 n 대입해서 456.0
		
		System.out.println("------------------------------");
		
		// < 3. 정수형 연산 >
		// 	=> 4byte 이하 type 의 정수영 연산의 경우 무조건 그 결과는 int(4byte)로 처리
		
		short s1 = 10, s2 = 20, s3 = 0;
		// s3 = s1 + s2;	// Error(Type mismatch) -> s1 + s2 결과는 int, 그러므로 형변환 필요.
		s3 = (short)(s1 + s2);	// 소괄호()로 묶어야 s1, s2 모두 short 적용.
		
		System.out.println("** short s3 = " + s3);
		
		System.out.println("------------------------------");
		
		//------------------------------------------------------------------------------
		
		// < 4. by 0 ERROR, 오버플로우(Overflow) / 언더플로우(Underflow) >
		
		// 4.1) 정수형
		
		// 	=> 컴파일 오류 없음.
	    //    실행(런타임)오류 : java.lang.ArithmeticException: / by zero
		
		n = 11;
		System.out.println("** 정수형 by 0, 나누기 : " + (n / 2));	// 2를 0 으로 했을 때 실행(런타임) 오류.
		System.out.println("** 정수형 by 0, 나머지 : " + (n % 2)); // 1
		
		System.out.println("------------------------------");
		
	    // 4.2) 실수형
		
	    // 	=> 컴파일, 런타임(Exception) 오류 없음
		
		f = 123.567f;
		System.out.println("** 실수형 by 0, 나누기 : " + (f / 0));	// Infinity(무한수) -> 오버플로우
		System.out.println("** 실수형 by 0, 나머지 : " + (f % 0));	// NaN(Not a Number) -> 언더플로우
		
		System.out.println("------------------------------");
	 
		// 4.3) 정수형 연산의 오버플로우(Overflow) / 언더플로우(Underflow)
		
		short sMax = Short.MAX_VALUE;
		short sMin = Short.MIN_VALUE;
		
		// 오버플로우(Overflow) Test : 최솟값과 동일
		System.out.println("** i : sMax = " + sMax + ", sMax + 1 = " + (sMax + 1)); // 정상적 int 연산
	    System.out.println("** s : sMax = " + sMax + ", sMax + 1 = " + (short)(sMax + 1));
	    // 최댓값(32767)의 2진 표현 : 1111 1111 1111 1111 + 1
	    //						-> 1 0000 0000 0000 0000 -> 2byte 만 남게됨.
	    
	    System.out.println("------------------------------");
	    
	    // 언더플로우(Underflow) Test : 최댓값과 동일 
	    System.out.println("** i : sMin = " + sMin + ", sMin - 1 = " + (sMin -1)); // 정상적 int 연산      
	    System.out.println("** s : sMin = " + sMin + ", sMin - 1 = " + (short)(sMin -1));
		
	}	// main

}	// class
