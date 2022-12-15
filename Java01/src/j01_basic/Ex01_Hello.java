package j01_basic;

/*
 < 이클립스 단축키 >
 자동 import : Ctrl+Shift+O
 Line삭제 : Ctrl + d

 들여쓰기 : Ctrl + Shift + f
 들여쓰기 : Ctrl+A , Ctrl+I 
 => 한번에 Ctrl+Shift+F

 클래스 Ctrl+클릭 => 클래스 소스보기 
 클래스 Ctrl+T => 클래스 계층도 

 < 클래스 >
 => 클래스명은 파일명과 동일함.
 => 멤버   
  변수:value, 
  메서드 (함수 function , 프로시져 procedure) : 동작

 < 문장(Statement) >
 => 사용자가 컴퓨터에게 작업을 지시하는 단위
 => 문장의 끝은 항상 세미콜론 (;)
 => 선언문과 실행문(메소드 안에 작성) 

 < Java Coding >
 => 대.소 문자 구별함
*/

//------------------------------------------------------------------

/* 주석(comment)의 종류
  => 한줄 주석
 	=> 여러줄 주석
*/

/** documentation
  => 선언문 (클래스 또는 메서드의 선언부_Header) 앞에만 사용가능하고 
     JDK에 포함된 javadoc 프로그램이 주석을 추출하여
     소스를 설명하는 HTML 문서를 만들어줌 
  => 활용법은 아래 참고 
     https://johngrib.github.io/wiki/java/javadoc/     
*/

public class Ex01_Hello {

	public static void main(String[] args) {
		
		System.out.println("Hello Java !!");		// System => method -> function
		System.out.println("안녕하세요 !!");
		System.out.println("최수빈입니당 !!");
		System.out.println("바보코드입니다 ^^ !!");
		System.out.println("합계 =>"+100 + 200); 		// 문자열 다음에 + 숫자 써도 문자열로 인식 -> 합계 아니고 그냥 100 200 출력
		System.out.println("합계 =>"+(100 +200));	// 소괄호로 숫자 묶어 놓으면 숫자로 인식 -> 합계 구할 수 있음.
	
	} // main

} // class
