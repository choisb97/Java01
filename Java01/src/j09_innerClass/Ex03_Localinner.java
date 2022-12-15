package j09_innerClass;

/*
 < LocalInner Class >
 - 메서드의 내부에 정의 되는 InnerClass.
 - 메서드내에 정의되는 지역변수와 같다 (즉, 메서드내에서만 사용됨)
 => static InnerClass는 허용되지 않음
    단, 상수(final)는 허용
*/

public class Ex03_Localinner {

	int a = 100;
	
	Ex03_Localinner() { // 1.
		System.out.println("< Ex03_Localinner Default 생성자 >");
	}
	
	public void innerTest(int n) {
		int b = 200; // 지역변수
		final int C = n; // 지역변수-상수
		
		
		// < Local Inner 클래스 정의 >
		// - static Inner인 경우에만 static 멤버 허용(JRE 15까지!)
		// static class Inner{	
		// 		static int d = 400;
		
		class Inner {
			
			int d = 400;
			
			Inner() { // 2.
				System.out.println("< Inner Default 생성자 >");
			}
			
			public void printData() { // 3.
				System.out.printf("** Inner printData : a = %d, b = %d, C(상수) = %d, d = %d \n",
						a, b, C, d);
			}
			
			public int adder() { // 4.
				return d += 123;
			}
			
		} // ic_Inner
		
		
		// < Local Inner 클래스 사용 >
		Inner in = new Inner(); // 2. Inner 기본생성자 호출

		in.printData(); // 3. printData 호출
		
		System.out.println("** innetTest in.adder() = " + in.adder()); // 4. adder 호출
		
	} // innerTest
	

//======================================================================================
	
	public static void main(String[] args) {

		// < Outer 클래스 인스턴스 생성 >
		// => Inner 클래스 생성 시점 : Inner 메서드 호출 시 생성
		Ex03_Localinner ex03 = new Ex03_Localinner(); // 1. Ex03_Localinner 기본생성자 호출
		// 1. < Ex03_Localinner Default 생성자 >
		
		
		// final int C = n;
		ex03.innerTest(300); // 2., 3., 4. innerTest 순차적으로 호출 
		// 2. < Inner Default 생성자 >
		// 3. ** Inner printData : a = 100, b = 200, C(상수) = 300, d = 400 
		// 4. ** innetTest in.adder() = 523
		
	} // main

} // class
