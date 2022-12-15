package j05_classMethod; // Constructor(생성자)

/*
 < 생성과정 >
 => new 연산자가 해당되는 클래스를 메모리에 로드해서 생성함.
 => 이때 생성직후 생성자 메서드를 호출함

 < 생성자(Constructor) 메서드 >
 - 클래스와 이름 동일하고, return 값이 없음. (void 조차도 생략됨)
   그러나 매개변수는 개수, Type 제한 없음
 => 생성시에 단 한 번 호출가능 

 => 한 클래스의 생성자는 여러개 가능 (생성자 오버로딩) 
 => 생성자를 작성하지 않으면 컴파일러가 자동으로 기본생성자를 만들어줌(Default Constructor)
 (단, 하나라도 생성자 메서드를 작성하면 Default 생성자는 자동으로 만들어지지 않음)
 
 < 생성자 메서드에서 생성자 메서드 호출 가능 > 
 => this(?,?,...)
 => this(...) 은 반드시 생성자 메서드 내에서 첫줄에 위치해야함.
*/

//========================================================================

// Car class => 해당 패키지(Package) 안에서만 사용 가능
class Car { // class 에 public 안 붙여도 됨.
	
	public int speed; // 인스턴스 종속
	public int mileage; // 인스턴스 종속
//	public String color; // 인스턴스 종속
	public static String color = "White"; // 클래스 종속
	
	//----------------------------------------------
	
	// 1) 기본(Default) 생성자
	// - 매개변수 없고, 생성자를 전혀 작성하지 않으면 자동 제공됨.
	//  (컴파일 시 추가해줌)
	
	// => 그러나 생성자를 한 개라도 작성하면 생성자 자동 생성은 안 됨.
	
	Car() { // 아래에 생성자 여러개 만들 경우 맨 위에 기본 생성자 있어야 됨.
		
		System.out.println("< 기본 생성자 호출 > = Car() {}");
	} // Car - 오버로딩
	// 클래스와 동일한 이름, 클래스명 제외하고 모든 변수명이나 메서드명은 소문자로 시작.
	// 생성자명은 클래스명과 동일하기 때문에 대문자로 시작
	
	//----------------------------------------------
	/*
	 2) 변수를 초기화하는 생성자
	    => this : 지역변수, 전역변수 구별
	            - 현재 클래스의 인스턴스
	    => this()
	     - 생성자메서드에서 생성자메서드 호출
	     - 생성자의 반복적인 코드의 재사용성
	
	     - 생성자 메서드 내에서 반드시 첫 줄에 위치해야하고,
	     -> 한 번만 호출할 수 있다.
	
	     - 한 생성자 내에서 this(...)를 여러개 사용하는 것은 불가능.
	 */ 
	//----------------------------------------------

	// this.어쩌구 => 전역변수
	// Car(현재 클래스)의 인스턴스 => this
	
	Car(int speed) { // header, 선언부
	
		// this.speed = speed; => c2.speed 와 같다
		
		this(speed, 0, null); // body, 실행부
		
		System.out.println("< speed 초기화 생성자 호출 >");
		// this(speed, 0, null); -> 첫 줄에 위치하지 않으면 컴파일 오류
		
	} // Car_speed

	//----------------------------------------------
	
	/*
	// 매개변수의 Type이 동일하므로 오버로딩 허용 안 됨.
	
	Car(int mileage) {
	// 같은 타입(int)의 한 가지는 넣을 수 없음.
	 * 
		this.mileage = mileage;
	}
	*/

	//----------------------------------------------
	
	Car(int speed, int mileage) {
		// this.speed = speed; => c3.speed 와 같다
		// this.mileage = mileage;
		
		// this(speed, mileage, null); // => 색상 null 값 반환
	
		// 전역(멤버) 변수 color의 초기값(default)을 전달하는 경우
		// -> static으로 정의해야 가능하다.
		this(speed, mileage, color); // #28 public 'static' String color;

	} // Car_speed, mileage

	//----------------------------------------------
	
	Car(String color) {
		// this.color = color;
		
		this(0, 0, color);
		
	} // Car_color

	//----------------------------------------------
	
	Car(int speed, int mileage, String color) {
		this.speed = speed;
		this.mileage = mileage;
		// this.color = color;
		Car.color = color; // => static 변수는 static 접근방법으로 접근할 것을 권장.
		
	} // Car_speed, mileage, color

	//----------------------------------------------

	public void speedDown() { // 속도 감소 메서드
		speed -= 10;
	
	} // speedDown
	
	//----------------------------------------------

	public String toString() { // 객체의 상태를 문자열로 반환하는 메서드
		return "[ 속도 : " + speed + ", 주행거리 : " + mileage + ", 색상 : " + color + " ]";
	
	} // toString

} // class Car


//=====================================================================================
//=====================================================================================

public class Ex06_Constructor {

	public static void main(String[] args) {
		
		// 1) Default 생성자
		// => 생성 시 단 한 번만 호출 가능
		//    일반 메서드는 필요 시 언제든지 호출 가능
		
		// 인스턴스화 (c1 = 인스턴스명)
		Car c1 = new Car();
		// 매개변수나 내용이 없는 Car() - 생성자 넣어줌 -> default
		// 아래 값들을 초기화하기 위해 많이 사용.
		
		System.out.println("------------------------------------------------");

		// c1.color = "White";
		Car.color = "White"; // => static 변수는 static 접근방법으로 접근할 것을 권장.
		c1.speed = 100;
		c1.mileage= 5000;
		c1.speedDown();
		// c1.Car(); => Error -> undefined
		
		//-----------------------------------------------------------------------------
		
		System.out.println("* c1 = " + c1);
		// [ 속도 : 90, 주행거리 : 5000, 색상 : White ]
		// c1.speed = 100, speedDown = -10 => 90
		
		System.out.println("------------------------------------------------");
		
//		Car c2 = new Car(1000);
//		System.out.println("* c2 = " + c2);
//		// [ 속도 : 1000, 주행거리 : 0, 색상 : null ]
		
//		System.out.println("------------------------------------------------");

		Car c3 = new Car(300, 30000);
		System.out.println("* c3 = " + c3);
		// [ 속도 : 300, 주행거리 : 30000, 색상 : null ]
		
		// < c2 가 아래에 있는 경우 >
		// [ 속도 : 300, 주행거리 : 30000, 색상 : White ]
		
		System.out.println("------------------------------------------------");
		
		Car c2 = new Car(1000);
		System.out.println("* c2 = " + c2);
		// [ 속도 : 1000, 주행거리 : 0, 색상 : null ]
		
		System.out.println("------------------------------------------------");
		
		Car c4 = new Car("Purple");
		System.out.println("* c4 = " + c4);
		// [ 속도 : 0, 주행거리 : 0, 색상 : Purple ]

		System.out.println("------------------------------------------------");
		
		Car c5 = new Car(500, 50000, "Pink");
		System.out.println("* c5 = " + c5);
		// [ 속도 : 500, 주행거리 : 50000, 색상 : Pink ]

		System.out.println("------------------------------------------------");
		
		Car c6 = new Car("Blue");
		System.out.println("* c6 = " + c6); 
		// [ 속도 : 0, 주행거리 : 0, 색상 : Blue ]
		
		// 마지막으로 할당된 색상은 "Blue"
		// 모든 c1 ~ c5 인스턴스의 color 값은 동일하게 "Blue" 이다.
		
		System.out.println("------------------------------------------------");
		
		System.out.println("< static color Test >");
		
		
		System.out.printf("c1 = %s, c2 = %s, c3 = %s, c4 = %s, c5 = %s \n"
		//		, c1.color, c2.color, c3.color, c4.color, c5.color);
				// 위처럼 사용 시 에러는 아니지만 오류(노란 밑줄) 발생.
				, Car.color, Car.color, Car.color, Car.color, Car.color);
		
	} // main

} // class
