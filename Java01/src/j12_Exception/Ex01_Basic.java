package j12_Exception;

/*
 < 예외처리 (Exception) >
 
 - InputMismatchException
  : 정수로 입력해야 하는데 문자나 실수를 입력한 경우 예외 발생
 
 - ArithmeticException
  : 정수를 0으로 나눌 경우 예외 발생
  
 - NullPointerException
  : null reference를 참조할 경우 예외 발생
  
 - ArrayIndexOutOfBoundException
  : 배열의 범위를 벗어나서 접근한 경우 예외 발생
  
 - FileNotFoundException
  : 파일을 찾을 수 없을 경우 예외 발생
  
 - NumberFormatException
  : 문자를 숫자로 변경시도하다가 에러가 발생하는 경우 예외 발생
  
 - ClassCastException
  : 적절치 못하게 클래스를 형변환하는 경우 예외 발생
  
 - NegatieArraySizeException
  : 배열의 크기가 음수인 경우 예외 발생
  
 - ArrayStoreException
  : 배열 유형이 허락하지 않는 객체를 배열에 저장하려는 경우 예외 발생
  
 - NoClassDefFoundException
  : 클래스를 찾을 수 없는 경우 예외 발생
  
 - IndexoutOfBoundsException
  : 객체의 범위를 벗어난 색인(Index)를 사용하는 경우 예외 발생
  
  등등
  
*/

public class Ex01_Basic {

	public static void main(String[] args) {

		int x = 6,
			y = 3,
			result = 0;
		String s = "123000";
		String[] names = {"Apple", "Banana", "Green"};
		
		// < 비교 >
		// ** Exception 처리하지 않은 경우 **
		//   Exception 발생 위치에서 비정상 종료
		
		result = x / y;
		System.out.println("* result = " + result); // 2
		
		/*
		result1 = x / 0; // Exception 발생
		System.out.println("* result1 = " + result1);
		// java.lang.ArithmeticException: / by zero
		*/
		
	//------------------------------------------------------------------------------------
		
		// ** Exception 처리한 경우 **
		//   Exception 발생되어도 정상진생 가능
		try {
			
			result = x / 0;
			System.out.println("* result2 = " + result); // 오류 시 출력 X
			
		} catch (ArithmeticException e) {

			System.out.println("\n** ArithmeticException = " + e.toString());

		} catch (Exception e) {
			
			System.out.println("\n** Exception = " + e.toString());
			// ** Exception = java.lang.ArithmeticException: / by zero
		} 
		
	//------------------------------------------------------------------------------------
		
		try {

			result = x / y;
			System.out.println("\n* result3 = " + result);
			System.out.println("\n* result4 = " + (result += Integer.parseInt(s)));
			System.out.println("\n* names 배열 Test = " + names[2]); // ArrayIndexOutOfBounds?Exception
			
			// => 배열크기 음수지정
			//names = new String[-1]; // Exception - NegativeArraySizeException(음수배열크기)
			
			s = null;
			//System.out.println("\n* NullPointerException Test = " + s.length());
			// 오류떠서 주석 걸어놨음
			
		} catch (NumberFormatException e) {

			System.out.println("\n** NumberFormatException = " + e.toString());

			
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("\n** ArrayIndexOutOfBoundsException = " + e.toString());

			
		} catch (NullPointerException e) {

			System.out.println("\n** NullPointerException = " + e.toString());

			
		} catch (Exception e) {

			System.out.println("\n** Exception = " + e.toString());
			// ** Exception = java.lang.ArithmeticException: / by zero

		} finally {

			System.out.println("\n < finally => 무조건 실행 >");

		}
		
		System.out.println("< 정상종료. 안녕히 가세요 >");
		
	} // main

} // class
