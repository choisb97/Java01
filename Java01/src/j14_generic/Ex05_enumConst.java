package j14_generic; // enum = 상수를 편리하게 사용할 수 이있도록!
/*
 < 열거형(enum) 상수 사용 >
 : 기초2 p.691
 - 정의 : 열거형은 서로 연관된 상수들의 집합
/        => interface 와 비교

 < 열거형의 특징 >
 - 상수의 사용을 편리하게 지원.
 - 의미가 있는 단어를 상수로 사용하기 편리함.
 - 열거형의 이름 자체가 Type으로 사용됨.
   -> 값과 타입을 동시에 확인하기 때문에 안전한 코딩 가능.
 - 열거형 내부에 생성자, 필드, 메소드를 가질 수 있어서 단순히 상수가 아니라 더 많은 역할이 가능함.
 * 
*/

enum ScaleE {
	DO, RE, MI, FA, SOL, RA, SI, DO2, RE2
} // enum_ScaleE


//============================================================================================================

public class Ex05_enumConst {

	public static void main(String[] args) {

		ScaleE key = ScaleE.RA;
		System.out.println("** key = " + key);
		
		key = ScaleE.DO2; // Do2는 case에 포함되지 않았기 때문에 default 출력
		
		// key = null;
		// => switch 문에서 java.lang.NullPointerException 발생
	    //    enum 의 장점 :  정의된 값만 사용가능
		
		switch (key) {
			case DO :
				System.out.println("~~ 도 ~~");
				break;

			case RE :
				System.out.println("~~ 레 ~~");
				break;

			case MI :
				System.out.println("~~ 미 ~~");
				break;

			case FA :
				System.out.println("~~ 파 ~~");
				break;

			case SOL :
				System.out.println("~~ 솔 ~~");
				break;

			case RA :
				System.out.println("~~ 라 ~~");
				break;

			case SI :
				System.out.println("~~ 시 ~~");
				break;

			default :
				System.out.println("~~ 도, 레, 미, 파, 솔, 라, 시 ~~");

		} // switch~case
		
	} // main

} // class
