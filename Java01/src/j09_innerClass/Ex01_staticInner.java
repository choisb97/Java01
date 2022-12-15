package j09_innerClass;

// < static Inner Class >

class Outer2 {
	
	class InstanceInner {
		int iv = 100;
	} // ic_InstanceInner
	

	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	} // ic_StaticInner
	

	void myMethod() {
		
		class LocalInner { // myMethod에 종속되어있는 클래스
			int iv = 400;
		} // myMethod_LocalInner
		
		LocalInner li = new LocalInner();
		System.out.println("** myMethod의 iv = " + li.iv);
		
	} // myMethod
	
} // c_Outer2

//=======================================================================================

public class Ex01_staticInner {

	public static void main(String[] args) {

		// 1) Instance 클래스 생성
		// => 외부 클래스의 인스턴스에 종속된 인스턴스를 생성
		Outer2.InstanceInner ic = new Outer2().new InstanceInner();
		System.out.println("** InstanceInner ic의 iv = " + ic.iv);
		
		
		// 2) static 내부 클래스의 static 멤버
		// 2.1) 내부 클래스 인스턴스는 필요 없지만, 외부 클래스를 통해 접근해야 한다.
		System.out.println("** StaticInner의 cv = " + Outer2.StaticInner.cv);
		
		// 2.2) static 내부 클래스의 인스턴스 멤버
		// => static 내부 클래스의 인스턴스가 필요함
		Outer2.StaticInner sc = new Outer2.StaticInner();
		System.out.println("** static class sc의 iv = " + sc.iv);
		
		
		// 3) Local inner 클래스
		new Outer2().myMethod();
		
	} // main

} // class 
