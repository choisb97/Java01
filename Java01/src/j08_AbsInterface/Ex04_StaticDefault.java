package j08_AbsInterface;

/*
 < interface 3 >
 - 상수, 추상메서드
 - static, default 메서드 (구현부(Body)가 있는 메서드, Java8부터 추가됨)
 
 < static, default >
 - 반드시 Body를 구현해야 함
 - 구현 클래스의 오버라이딩 의무 없음.
*/

interface NewInter {
	
	// 추상메서드 : 반드시 헤더만 정의, 구현부(바디)는 없어야 함.
	void test(); // -> public abstract 생략
	// == public abstract void test();
	
	
	// < * static > - static은 반드시 body{}가 있어야 함
	
	// static void staticTest(); // => Error
	static void staticTest() {
		System.out.println("** interface : staticTest()");
	}
	
	
	// < default > - default는 반드시 body{}가 있어야 함
	// - interface에만 허용, 오버라이딩 의무는 없으나 필요 시 사용함.

	// default void defaultTest(); // => Error 
	default void defaultTest() {
		System.out.println("** interface : defaultTest()");
	}
	
} // i_NewInter

//------------------------------------------------------------------------------------

class NewTest implements NewInter {
	
	@Override
	public void test() {
		System.out.println("** NewTest : test() 오버라이드");
	}
	
	
	// < default 메서드 오버라이딩 >
	// - 필요 시 default 없이 오버라이딩 허용, 의무 X
	// - 오버로드 허용 됨
	@Override
	public void defaultTest() {
	
		// * 조상이 interface인 경우 접근 방법
		NewInter.super.defaultTest();
		System.out.println("** NewTest : defaultTest() 오버라이드");
	}
	
	
	public void defaultTest(int i) {
		System.out.println("** NewTest : defaultTest() 오버로드, i = " + i);
	}
	
	
	// < static >
	// - 클래스 또는 인터페이스 종속이므로 동일 메서드명 허용됨
	//   static 또는 인스턴스 메서드 모두 가능.
	//  ( 비교 : 조상이 클래스인 경우 인스턴스 메서드는 불가능 )
	
	static void staticTest() {
	//void staticTest() {
		System.out.println("** NewTest : staticTest()");
	}
	
	
	// < 조상 인터페이스와 무관한 static 메서드 >
	static void staticTest2() {
	//void staticTest() {
		System.out.println("** NewTest : staticTest2()");
	}
	
} // c_NewTest


//====================================================================================

public class Ex04_StaticDefault {

	public static void main(String[] args) {
		
		// 1) 클래스 인스턴스
		NewTest n1 = new NewTest();
		
		n1.test(); // NewTest
		// ** NewTest : test() 오버라이드
		
		System.out.println("");
		
		
		// interface의 default 메서드 접근 (인스턴스로)
		n1.defaultTest(); // NewInter
		// ** interface : defaultTest()
		// ** NewTest : defaultTest() 오버라이드
		
		n1.defaultTest(123); // ** NewTest : defaultTest() 오버로드, i = 123
		
		System.out.println("");
		
		
		// < interface의 static 메서드 접근 (static 접근 방법으로) >
		NewInter.staticTest(); // ** interface : staticTest()
		
		System.out.println("");
		
		
		// 동일한 이름의 static 또는 인스턴스 메서드 모두 가능함
		NewTest.staticTest(); // ** NewTest : staticTest()
		//n1.staticTest(); 
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		// 2) 인터페이스 타입으로 생성
		// - 인터페이스에 정의된 만큼만 접근 가능.
		NewInter n2 = new NewTest();
		
		n2.defaultTest();
		// ** interface : defaultTest()
		// ** NewTest : defaultTest() 오버라이드
		
		n1.test(); // ** NewTest : test() 오버라이드
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		// static은 static 접근 방법으로 접근 가능
		NewInter.staticTest(); // ** interface : staticTest()
		NewTest.staticTest(); // ** NewTest : staticTest()
		NewTest.staticTest2(); // ** NewTest : staticTest2()
		
		System.out.println("");
		
	} // main

} // class
