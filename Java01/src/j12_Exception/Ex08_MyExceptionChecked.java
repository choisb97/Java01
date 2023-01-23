package j12_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 < AgeException 만들기 1 -> Checked >
 - 나이의 값이 범위를 벗어나면 Exception 발생
 - 예외처리를 강제함 -> try ~ catch 처리하지 않으면 컴파일 오류 발생 
 - Exception을 상속
*/


class AgeException extends Exception {
	private static final long serialVersionUID = 1L; // 에러는 없지만 넣어주는 것을 권장
	// + Add default serial version ID
	
	AgeException() {
		super("나이가 범위를 벗어납니다.");
	} // AgeException default
	
} // c_AgeException

//======================================================================================

public class Ex08_MyExceptionChecked {
	
	// 나이 입력받아 return하는 메서드 만들기
	// => 예외처리 코드를 컴파일 시 반드시 확인함
	
	//public static int readAge() throws AgeException {
	public static int readAge() throws AgeException, InputMismatchException {
	// catch에 Exception 있어서 실행결과 동일
		
		Scanner sc = new Scanner(System.in);
		System.out.println("** 나이를 입력하세요 => ");
		int age = sc.nextInt(); // 정수 외 실수나 문자입력 시 InputMismatchException 오류 발생
		sc.close();
		
		if (age < 1 || age > 150) 
			//throw new AgeException(); // Unhandled exception
			// readAge() throws (blahblah)Exception 없이 그냥 쓰면 오류
			throw new AgeException(); 
		else return age;
		
	} // m_readAge
	
//======================================================================================

	public static void main(String[] args) {

		// Checked Exception을 throw -> throws 했기 때문에
		// 예외처리(try ~ catch)를 반드시 해야 함
		
		// System.out.println("** main : Age = " + readAge());
		// => 컴파일 오류 -> Unhandled exception
		
		try {
			System.out.println("** main : Age = " + readAge());
			
		} catch (AgeException e) {
			System.out.println("** AgeException => " + e.toString());
		} catch (Exception e) {
			System.out.println("** Exception => " + e.toString());
		}
		
		
		System.out.println("\n< Program 정상 종료 >");
		
	} // main

} // class
