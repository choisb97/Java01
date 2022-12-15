package j05_classMethod;

/*
 < 클래스에 포함 가능한것 (멤버) >
 - 속성(변수, 필드_Field, Column), 기능.동작(메서드)
 => 멤버변수(전역변수), 맴버메서드 
 => 멤버메서드 종류 (역할이 정해져있는 메서드들)
   - main, 생성자(Constructor), toString, setter, getter
     main => public static void main(String[] args) {} =>> 무조건 이렇게 써야됨.
     toString => 현재 무슨 값을 가지고 있는 지 편리하게 볼 수 있음.

 < 클래스명 >                                                                                 
 - 대문자로 시작, 예약어 사용불가 , API 라이브러리의 클래스명을 사용하는 것은 비추
 => 클래스는 객체의 설계도
 -> 클래스명의 첫 글자를 대문자로 하지 않아도 오류가 나진 않지만 대문자를 쓰자

 < 객체의 주기 (LifeCycle) >
 - 생성 -> 사용 -> 소멸(in Memory)
 => 클래스(in HDD) -> 생성(in Memory) -> 객체화 (인스턴스 생성)
    -> 사용 -> 소멸(Memory 반납)

 < 클래스, 객체, 인스턴스(instance : 사례, 경우) > 
 - 클래스와 인스턴스는 설계도와 제품이라고 할수있다.

 Q. 그럼 객체는 클래스일까 인스턴스일까? 
 > Java 프로그래밍에서는 설계도인 클래스가
   메모리상의 구체적 실체인 인스턴스가 되었을 때 객체라고 부른다. 
 
 그러므로 클래스와 인스턴스는 구별되고, 클래스와 객체도 구별되지만
 객체와 인스턴스는 구분없이 포괄적으로 객체라는 말을 쓰기도 한다.
*/

public class Ex01_Car {
	
  // < 멤버변수, 필드(field) : 속성 > 
  // => 클래스의 전역변수
  //    클래스내에서는 모든 메서드에서 사용가능
	
	public int speed; // 속도
	public int mileage; // 주행거리
	public String color = "Purple"; // 색상

	// 실행문은 클래스에 바로 넣을 수 없음.
	// => 메서드 내부에만 작성 가능.
	// color = "White"; XXXXX - 실행문
	// System.out.println("speed = " + speed); XXXXX - 실행문
	
	//-----------------------------------------------------------------------
	
	// < 멤버메서드 (Method, function, procedure) >
	// => 동작 또는 기능을 구현
	public void speedUp() { // 속도 증가 메서드
		// void -> return 값 Type의 자리인데 없는 경우 void
		
		// ** 지역변수
		// => 메서드 내부에서만 사용 가능.
		// => 전역변수와 동일명 가능 (내부에서는 지역변수 우선)
		
		//-------------------------------------------------------------------
		
		int price = 5000;	// 멤버 아니고 지역변수 => speedUp 메서드 안에서만 사용 가능
		String color = "Yellow";
		System.out.printf("price = %d, color = %s \n", price, color);
		// price = 5000, color = Yellow 
		
		speed += 10;
		System.out.println("speed = " + speed); // speed = 210
		// Ex01_CarUser - #17 myCar.speed = 200; + 10 = 210
		
		// return 10; -> void 타입이기 때문에 Error => int Type에는 가능.
		// return Type이 다른 return 값을 넣으면 Error
		
		// return; -> void 메서드 종료.
		// void 의 경우 return; 을 입력하지 않아도 자동 추가됨.
		
		System.out.println("--------------------------------------------");
	
	} // speedUp
	
	public void speedDown() { // 속도 감소 메서드
		speed -= 10;
		
	} // speedDown
	
	
	// toString (메서드명) : 객체의 속성(멤버필드, 멤버변수)의 값을 문자로 제공하는 역할에 주로 사용됨.
	// String (return Type) : 문자열을 반환(return) -> 메서드 처리 결과로 문자열을 제공.
	public String toString() { // 객체의 상태를 문자열로 반환하는 메서드
		return "[ 속도 : " + speed + ", 주행거리 : " + mileage + ", 색상 : " + color + " ]";
	
	} // toString
	
} // class
