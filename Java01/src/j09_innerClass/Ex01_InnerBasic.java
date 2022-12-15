package j09_innerClass;

import j07_classExtends.Ex02_Animal;

/*
 < 클래스 멤버 >
 => 멤버(전역)변수, 
 => 메서드 : 생성자, main, setter/getter, toString, 일반메서드
 => 초기화블럭 : { } / static { }
 => 내부(inner) 클래스 : 클래스 내부에 다른 클래스를 정의
*/

// < Inner Class 기본형식과 특성 >

class OuterClass {
	
	// 1) 멤버(전역)변수
	int age = 100;
	private String name = "홍길동";
	static String grade = "A++";
	
	// ** 멤버변수로 클래스 사용 **
	// => has-a 관계 : 재사용성이 많은 경우
	// => inner 클래스와 비교 : 해당 클래스에서만 필요한 경우
	Ex02_Animal animal; // 자동 import => ctrl + shift + o

//--------------------------------------------------------------------
	
	// 2) 생성자 및 메서드
	OuterClass() {
		System.out.println("< OuterClass Default 생성자 >");
	} // OuterClass default
	
	// => 위 외의 메서드 : main, setter/getter, toString, 일반메서드...

//--------------------------------------------------------------------
	
	// 3) 클래스
	// => 내부(inner) 클래스
	// => 외부(outer) 클래스의 모든멤버(private 포함)에 접근 가능
	class InnerClass {
	/*
	//static class InnerClass {
		//static String country = "Korea";
		// => 내부 클래스 안에서 static 변수를 사용하려면, 해당 내부 클래스도 static 타입이어야 함
		//  -> static 내부클래스
		// => 단, JavaSE-16부터는 일반 내부클래스도 static 변수 허용함.
	*/
		InnerClass() {
			System.out.println("< InnerClass Default 생성자 >");
		} // InnerClass default
		
		public void printData() {
			System.out.println("** InnerClass printData : age = " + age);
			System.out.println("** InnerClass printData : name = " + name);
			System.out.println("** InnerClass printData : grade = " + grade);
			
		} // printData
		
	} // ic_InnerClass
	
} // c_OuterClass


//======================================================================================

public class Ex01_InnerBasic {

	public static void main(String[] args) {

		// => Outer 클래스만 생성 : Outer에 정의한 멤버만 접근 가능.(Inner의 멤버에는 접근 불가능)
		OuterClass out1 = new OuterClass();

		// => Inner 클래스 생성
		// InnerClass in1 = new InnerClass(); -> Outer에 종속되어 있기 때문에 독립적 생성 불가능.
		OuterClass.InnerClass in1 = out1.new InnerClass();
		
		in1.printData();
		
		System.out.println("");
		
	//----------------------------------------------------------------------------------
		
		// < Inner 클래스 직접 생성 >
		// OuterClass.InnerClass in2 = new OuterClass.InnerClass(); -> Error
		OuterClass.InnerClass in2 = new OuterClass().new InnerClass();
		
		in2.printData();
		
		System.out.println("");
		
	//----------------------------------------------------------------------------------

		// < static 멤버 Test >
		// 클래스명으로 접근!
		System.out.println("** OuterClass.grade = " + OuterClass.grade);
		// System.out.println("< Inner country = " + OuterClass.InnerClass.country);
		
	} // main

} // class
