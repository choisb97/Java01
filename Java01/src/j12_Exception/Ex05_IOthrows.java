package j12_Exception;

import java.io.IOException;

/*
 < Checked Exception 처리 >
 1) 직접처리
   - 해당 메서드 내에서 try ~ catch 블럭처리
   
 2) 위임처리
   - Exception 처리를 상위 메서드로 위임(떠넘기기)
*/

public class Ex05_IOthrows {
	
	// 1) 직접처리
	public static String readString1() {
		
		byte[] bf = new byte[100];
		System.out.println("** 문자열을 입력하세요 1 = ");
		
		// System.in.read(bf);
		// Checked -> 컴파일 오류 발생 : Unhandled exception type IOException
		// try ~ catch 안에 넣으면 오류 X
		try {
			System.in.read(bf);
		} catch (IOException e) {
			System.out.println("** IOException = " + e.toString());
		}
		
		return new String(bf); // String Type으로 생성
		
	} // m_readString1
	
//--------------------------------------------------------------------------------------
	
	// 2) 위임처리(떠넘기기)
	// - throws IOException
	//   IOException의 처리를 상위의 메서드(현제메서드를 call한 메서드)로 떠넘김
	// - throws하는 Exception은 모두 Checked 방식으로 처리해야 함
	// - throws하는 Exception을 처리하는 구문에서는 Exception 적용범위가 더 넓어야 함
	//   즉, throws Exception -> main의 catch (IOException e) : 오류
	
	public static String readString2() throws Exception {
	// public static String readString2() { => 컴파일 오류 발생	
		
		byte[] bf = new byte[100];
		System.out.println("** 문자열을 입력하세요 2 = ");

		System.in.read(bf);
		// 메서드명() throws Exception 또는 throws IOException 사용
		/*
		try {
			System.in.read(bf);
		} catch (Exception e) {
			
		}
		*/
		
		return new String(bf); // String Type으로 생성

	} // m_readString2
	
	
//======================================================================================

	public static void main(String[] args) throws Exception {
	//public static void main(String[] args) {

		// 1) 직접처리
		System.out.println("** main readString1 = " + readString1());
		                                           // readString1 static이라 바로 호출

	//--------------------------------------------------------------------------------------
		
		// 2) 위임처리(떠넘기기)
		
		try {
			System.out.println("** main readString2 = " + readString2());
		} catch (IOException e) {
			System.out.println("** main IOException = " + e.toString());
		} catch (Exception e) {
			System.out.println("** main IOException = " + e.toString());
		}
		
		
		// 3) main도 throws 가능
		//System.out.println("** main readString2 = " + readString2());
		
		System.out.println("\n< Program 정상 종료 >");
	} // main

} // class
