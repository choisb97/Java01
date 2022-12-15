package j12_Exception;

import java.util.Scanner;

/*
 < AgeException 만들기 2 -> UnChecked Exception >
 - extends RuntimeException
 - 즉, 컴파일러가 예외처리(try~catch~)를 확인하지 않음
 - 주로 프로그래머의 실수로 발생 가능한 오류들
*/

class AgeExceptionU extends RuntimeException {
	private static final long serialVersionUID = 1L; // 에러는 없지만 넣어주는 것을 권장
	
	AgeExceptionU() {
		super("나이가 범위를 벗어납니다.");
	} // AgeExceptionU default
	
} // c_AgeExceptionU


//======================================================================================

public class Ex08_MyExExceptionUn {
	// 나이 입력받아 return하는 메서드 만들기
	// => 예외처리 코드를 컴파일 시 확인 안 함
	
	public static int readAge() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("** 나이를 입력하세요 => ");
		int age = sc.nextInt(); // 정수 외 실수나 문자입력 시 InputMismatchException 오류 발생
		sc.close();
		
		if (age < 1 || age > 150) 
			throw new AgeExceptionU(); 
		else return age;
		
	} // m_readAge
	
//======================================================================================

	public static void main(String[] args) {

		// < 예외처리 적용하지 않는 경우 >
		
		// ** RuntimeException 사용해서 컴파일 시 예외처리 확인을 하지 않아 오류는 없지만
		//    실행 시 런타임 오류 발생 -> 비정상 종료
		//System.out.println("** main_Runtime : Age = " + readAge());
		
	//-----------------------------------------------------------------------------
		
		// < 예외처리 적용 >
		
		try {
			System.out.println("** main : Age = " + readAge());
			
		// ** AgeExceptionU 없어도 Exception에서 처리 가능
		//} catch (AgeExceptionU e) {
		//	System.out.println("** AgeExceptionU => " + e.toString());
			
		} catch (Exception e) {
			System.out.println("** Exception => " + e.toString());
			// ** Exception => j12_Exception.AgeExceptionU: 나이가 범위를 벗어납니다.
		}
		
		
		System.out.println("\n< Program 정상 종료 >");
		
	} // main

} // class
