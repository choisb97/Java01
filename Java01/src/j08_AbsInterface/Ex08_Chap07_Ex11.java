package j08_AbsInterface; // p.269

// 정석기초 - 디폴트 메서드와 static메서드 예제

// => interface의 default, static 메서드

// 결과 = method1() in Child3
//      method2() in Parent3
//      staticMethod() in MyInterface1
//      staticMethod() in MyInterface2


interface MyInterface1 {
	
	default void method1() { 
		System.out.println("method1() in MyInterface1");
	}

	default void method2() { 
		System.out.println("method2() in MyInterface1");
	} // i_MyInterface1 - method2 default

	static void staticMethod() { 
		System.out.println("staticMethod() in MyInterface1");
	}
	
} // i_MyInterface1


interface MyInterface2 {
	
	default void method1() { 
		System.out.println("method1() in MyInterface2");
	}

	static void staticMethod() { 
		System.out.println("staticMethod() in MyInterface2");
	}
	
} // i_MyInterface2

//-------------------------------------------------------------------------------------

class Parent3 {
// < 메서드간의 충돌 Test >
// 1. interface와 조상 class간의 충돌
//- default 메서드(method2())와 조상의 메서드(method2()) 충돌
//  조상 메서드가 상속되고(조상이 더 가까움), default 메서드가 무시됨.
//=> 에디터의 자동완성 시 interface의 정보가 우선 표시될 수 있음.

// ** class(extends)메서드가 > interface(implements)메서드보다 우선됨 **
	
	public void method2() {   
		System.out.println("method2() in Parent3");
	} // c_Parent3 - method2 default
	
} // c_Parent3


//-------------------------------------------------------------------------------------

class Child3 extends Parent3 implements MyInterface1, MyInterface2 {
// 2. < interface간의 충돌 - method1() >
// => 동일한 default 메서드명을 가지고 있는 MyInterface1, MyInterface2를 동시에 구현했더니
//    Duplicate Default Methods Name... Error 발생
//    그러나 동일한 이름의 메서드를 오버라이딩하면 오류는 발생하지 않는다.
//    이유는 오버라이딩과 동시에 조상의 동일이름 메서드를 더이상 참조하지 않기 때문
	
	@Override
	public void method1() {
		System.out.println("method1() in Child3"); // 오버라이딩
	}
	
} // c_Child


//=====================================================================================

public class Ex08_Chap07_Ex11 {

	public static void main(String[] args) {
		
		Child3 c = new Child3();
		
		c.method1(); // in Child3
		c.method2(); // c.ctrl+space : MyInterface1 표시됨 -> 실행 : Parent3
		
		
		// static메서드 접근 방법으로!
		MyInterface1.staticMethod();
		MyInterface2.staticMethod();
		
	} // main

} // class
