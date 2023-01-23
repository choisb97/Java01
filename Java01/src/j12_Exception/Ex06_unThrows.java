package j12_Exception; // UnChecked Exception throws

/*
 < UnChecked Exception throws Test >
 - RunTimeException 하위 ~~ : UnChecked Exception 
 - java의 컴파일러가 Exception 처리 확인하지 않음
   즉, 반드시 try ~ catch 구문을 적용하지 않아도 됨.
   그러나 필요시엔 throws로 처리 가능.
     
 - 주로 프로그래머의 실수로 발생 가능한 오류들
 - 상위의 메서드에서도 Exception 처리가 의무조항은 아님
   즉, 반드시 try ~ catch 구문 구현하지 않아도 컴파일 오류 없음.
*/

public class Ex06_unThrows {

	public static void intByZero() throws ArithmeticException  {
		int i = 10 / 0;
		
		System.out.println(i);
	}
	
	
	public static void arrayIndex() throws ArrayIndexOutOfBoundsException  {
		int[] a = new int[3];
		a[3] = 100;
	}
	
	
	// 의무조항은 아니지만 계속 상위의 메서드로 throws 할 수 있음
	// public static void callTest() {   // => 오류 없음
	public static void callTest() throws ArrayIndexOutOfBoundsException {
		intByZero(); // ArithmeticException
		arrayIndex();
	}
	
	
	public static void nullPointer() throws NullPointerException {
		String s = null;
		//int l = s.length();
		// 오류떠서 주석 걸어놨음
		
		System.out.println(s);
	}
	
	
	public static void classCast() throws ClassCastException {
		Object o = new int[5];
		String s = (String)o; // 조상(Object) -> 후손(String)
		// => Down_Casting : 가능한 경우에만 명시적으로 허용

		System.out.println(s);
	}
	
	
	// ** ClassNotFoundException -> Checked Exception
	public static void classNotFound() throws ClassNotFoundException {
		// < Class라는 클래스 >
		// => JVM에서 동작할 클래스들의 정보를 묘사하는 일종의 메타 클래스(Meta-Class)
		//    클래스의 이름, 멤버 필드와 메소드, 클래스 종류 등의 정보
		// => forName() 메소드에 의해 반환된 Class 클래스의 인스턴스에는 "클래스명"의 정보가 담겨 있음.
		Class<?> c = Class.forName("j12_Exception.Ex05_IOthrows");
		//Class<?> c = Class.forName("j12_Exception.Ex05_IOthrows00");
		System.out.println(" Find Class => " + c.getName());
	}
	
	// class - 클래스를 정의하는 Java의 예약어
	// Class - 클래스를 관리하는 클래스
	   
	
//======================================================================================
	
	public static void main(String[] args) {

		// 1) unChecked Method Call
		// => throws 했어도 try 블럭은 의무사항 X
		//    컴파일 오류는 없지만 런타임 오류 발생으로 비정상 종료
		//callTest(); // ArithmeticException
		//nullPointer(); // NullPointerException
		//classCast(); // ClassCastException
		
		try {
			callTest();
			// => try블럭 안에 있어도 해당 Exception을 처리할 catch구문이 없으면
			//    실행 시 Exception 발생 후 비정상 종료
			classNotFound();
			
		} catch (ClassNotFoundException e) {
			System.out.println("\n** main ClassNotFoundException = " + e.toString());
		} catch (Exception e) {
			System.out.println("\n** main Exception = " + e.toString());
		}
		
		System.out.println("\n< Program 정상 종료 >");
		
	} // main

} // class
