package j09_innerClass;

/*
 < 익명클래스 (Anonymous 클래스) >
 => 이름이 없는 클래스이며, 한 번만 사용하고 버려지는 객체를
    사용할 때 유용하게 쓰이는 내부 클래스로서,
    다른 클래스를 상속받는 경우 또는 인터페이스를 구현하는 경우 이용됨  
*/


interface Flyer {
	void fly();
} // i_Flyer


// < 1. 일반적인 방법 >
// => 용도가 많을 때는 구현 클래스를 작성해놓고 필요할 때 사용.
class Flyer1 implements Flyer {
	
	@Override
	public void fly() {
		System.out.println("< 1. 일반적인 방법 : 구현 클래스 작성 -> 언제든 재사용 가능 >");	
	}
	
} // c_Flyer1

//=======================================================================================

public class Ex04_AnonyFly {

	public static void main(String[] args) {
		
		// 1. 일반적인 방법
		// => 구현 클래스로 생성
		Flyer f1 = new Flyer1();
		
		f1.fly();
	
	//------------------------------------------------------------------------------------
		
		/*
		 < 2. 익명클래스 >
         - Flyer fi = new Flyer(); XXXX
           인터페이스는 직접 생성(new)될 수 없고 implements 하는 클래스를 통해 생성 후 사용 되어짐.
           인터페이스의 구현 클래스를 new 다음에 직접 기술.
        => 그러므로 익명 클래스는 추상클래스를 상속받거나, 인터페이스를 구현하는 형태만 가능하며,
           강제성을 부여한 일회성 코드에 주로 이용됨 (예, 이벤트 핸들러 또는 이벤트 리스너 구현)  
        => Anonymous 클래스에서는 인터페이스이름으로 new 하고 { ...}; 블럭에서 구현.
           마지막에는 반드시 ;
        => 내부적으로 Flyer 를 구현한 익명의 클래스가 생성되며 이를 Anonymous 클래스라고 함.  
		*/
		
		// 2. 익명클래스
		Flyer f2 = new Flyer() {
			
			@Override
			public void fly() {
				System.out.println("\n< 2. 익명 클래스 : 직접 오버라이딩 메서드 작성 >");
			}
			
		}; // 익명클래스 종료 시 세미콜론(;) 필요함.
		
		f2.fly();;
		
	//------------------------------------------------------------------------------------
		
		// 3. Object를 상속받는 익명클래스
		Object ob = new Object() {
			
			@Override
			public String toString() {
				return "Object를 상속받는 익명클래스";
			}
			
			// => 오버라이딩이 아닌 메서드는 작성 가능하고 오류는 발생하지 않지만
			//    조상의 인스턴스로는 실행 불가능 -> 작성의 의미가 없음
			// => 이 경우 Object에 해당하지 않는 오버라이딩
			// public void test() {
			// 	System.out.println("\n< 4. Object Test = test() >");
			// }
			
		}; // a_Object
		
		System.out.println("\n< 3. Object Test = " + ob + " >");
		
		// ob.test(); => 조상의 인스턴스로는 실행 불가능
	
	} // main

} // class
