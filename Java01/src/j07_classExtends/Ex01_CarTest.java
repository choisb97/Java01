package j07_classExtends;

/*
 < 상속 : extends >
 - 기능을 확장해서 업그레이드 버전 만듦.
 - 기존(조상) 클래스의 멤버들(필드와 메소드)을 재사용 & 일부변경도 가능 

 < 생성순서 >
 - JVM은 extends 키워드가 있으면 조상생성 후 후손생성
   이 때 기본은 조상의 default 생성자를 실행하고,
   특별히 후손 생성자에서 조상생성자_super(...)를 호출해 놓으면 그 생성자를 실행함.
 => 상속을 허용하는 클래스는 default 생성자를 반드시 작성하는 것이 바람직함.

 < 조상 : Super (Parent, Base) class >  
 => super. : 조상의 인스턴스를 의미 (조상의 멤버에 접근 가능)
 => super()
   : 조상의 생성자를 의미 (조상의 생성자에 접근 가능).
     this()처럼 생성자 메서드 내에서 첫 줄에 위치해야 함.

 => 생성자메서드_super(), this() 호출은 생성자 내에서만 가능 

 < 후손 : Sub ( Child, Derived [diráivd] ) class >
 => super class를 포함
*/

class Car { // 클래스 Car의 조상은 Object class -> 모든 클래스의 조상은 Object
	int speed;
	int mileage;
	String color;
	
	public Car() {
		// super(); // 조상의 생성자 호출
		System.out.println("< Car Default 생성자 >");
	} // Car default

	
	public Car(int speed, int mileage, String color) {
		// super(); // 조상의 생성자 호출 - Java의 모든 클래스는 Object를 상속받음
		
		this.speed = speed;
		this.mileage = mileage;
		this.color = color;
	
		System.out.println("< Car 초기화 생성자 >");

	} // Car_speed, mileage, color

	public void speedUp() {
		this.speed += 100;
		
	} // speedUp

//-------------------------------------------------------------------------------
	/*
	 < 메서드 오버라이딩 Overriding >
	 - 부모 클래스의 메소드의 동작 방법을 변경(재정의)하여 우선적으로 사용하는 것.
	 => 상속받은 메서드의 내용만 변경(change, modify).
	 => 사전적 의미는 '~위에 덮어쓰다(overwrite)'
	 - 조상과 완전히 동일한 이름, 매개변수, return Type을 가진 메서드 작성 허용.
	   메서드 재작성 -> 우선 호출됨.
	   조상 메서드 호출 시 -> super로 접근
	
	 < 메서드 오버로딩과 구별할 것 >
	 오버로딩(overloading) : 메서드의 이름은 같고 매개변수의 개수나 타입이 다른 함수를 정의하는 것을 의미한다.
	 => 기존에 없던 새로운 메서드를 정의(new).
	*/
	
	@Override
	public String toString() {
		return "Car [speed = " + speed + ", mileage = " + mileage + 
				", color = " + color + "]";
	
	} // toString

} // c_Car


//-------------------------------------------------------------------------------

class SportsCar extends Car {
	
	int turbo;
	int speed; // 조상의 speed는 super.로 접근하고 본인은 this.로 접근하기 때문에 오류 아님.
	
	// < super() >
	// - 조상의 생성자를 지정하지 않으면 조상의 default 생성자를 넣어줌.
	// => 필요한 조상의 생성자 호출 가능.
	// => 단, this() 와 마찬가지로 반드시 첫 줄에 작성해야 함.
	
	public SportsCar() {
		// super();
		System.out.println("< SportsCar Default 생성자 >");
		// super(); -> Error => 반드시 첫 줄에 작성해야 함.
	
	} // SportsCar default

	
	public SportsCar(int turbo) {
		// super(); // => super()를 이용해서 조상의 생성자를 호출 가능.
		super(0, 0, null);
		this.turbo = turbo;
		System.out.println("< SportsCar 멤버만 초기화 생성자 >");

	} // SportsCar_turbo
	
	
	// < 조상의 멤버와 현재 멤버를 초기화하는 생성자 >
	// super.~~ -> 조상의 멤버에 접근 (생성자와 인스턴스 메서드에서 this. 처럼 사용가능)
	public SportsCar(int speed, int mileage, String color, int turbo) {
		super(speed, mileage, color); // 조상의 생성자를 호출해서 매개변수 전달 가능
		                              // => 가장 바람직하다.
		this.turbo = turbo; // 현재멤버 초기화
		
		System.out.println("< 조상의 멤버와 현재 멤버 초기화 생성자 >");
		
		// this.speed = speed; // SportsCar의 멤버변수로 speed가 없기 때문에 조상에서 찾음
		// SportsCar에도 speed가 있는 경우 조상과 구별할 수 없어서 this.speed 사용은 바람직하지 않다.
		
		// super.speed = speed; // super.으로 찾으면 조상의 멤버 speed 구별 가능.
		// super.mileage = mileage;
		// super.color = color;
		
	} // SportsCar_speed, mileage, color

	//-------------------------------------------------------------------------------
	
	// => Car의 기능 + 추가기능 -> 기능 향상
	@Override // 컴파일러에게 전달하는 지시어
	public void speedUp() {
		super.speedUp(); // 조상의 speedUp()메서드 호출
		super.speed += turbo; // super.speed = super.speed + turbo
	} // speedUp
	
	/*
	// => 메서드 오버로딩
	// @Override -> 그러므로 Error
	public void speedUp(int i) {
		super.speed += i;
	}
	
-----------------------------------------------------
	
	// => 기존 Car에 없던 신기능 추가
	// @Override -> 아닌 경우(조상에 없는 경우) 사용하면 오류
	public void speedDown(int i) {
		super.speed -= i;

	} // speedDown
	*/

	// => 동일한 이름의 변수 Test
	//    매개변수 speed(메서드의 지역변수)를 현재클래스(SportsCar)의 speed, Car의 speed 모두 적용한다.
	public void speedDown(int speed) {
		super.speed -= speed; // Car의 speed
		this.speed -= speed; // SportsCar의 speed
		
		System.out.println("** 매개변수 speed => " + speed);
		System.out.println("** Car speed => " + super.speed);
		System.out.println("** SportsCar speed => " + this.speed);

	} // speedDown
	
	//-------------------------------------------------------------------------------

	@Override
	public String toString() {
		// speed는 조상의 speed를 출력한다. => + super.speed 사용
		return "SportsCar [turbo = " + turbo + ", speed = " + speed + 
				", mileage = " + mileage + ", color = " + color + "]";
	
	} // SportsCar toString
	// => 조상의 멤버에 접근 가능함

} // c_SportsCar

//===================================================================================

public class Ex01_CarTest {

	public static void main(String[] args) {
		
		// 1) Car 생성
		Car c1 = new Car(100, 10000, "White");
		
		c1.speedUp(); // 사용 가능.
		
		// c1.speedDown(200); // undefined Error
		// 자손한테만 있는 메서드 사용 시 오류
		
		System.out.println("* Car c1 = " + c1);
		// < Car 초기화 생성자 >
		// * Car c1 = Car [speed = 100, mileage = 10000, color = White]
		
		System.out.println("--------------------------------------------------------------------");
		
		//--------------------------------------------------------------------
		
		// 2) SportsCar 생성
		SportsCar sc = new SportsCar();

		System.out.println("* SportsCar sc = " + sc);
		// < Car Default 생성자 >
		// < SportsCar Default 생성자 >
		// * SportsCar sc = SportsCar [turbo = 0, speed = 0, mileage = 0, color = null]
		
		System.out.println("--------------------------------------------------------------------");
		
		SportsCar sc1 = new SportsCar(500);
		
		sc1.color = "Red";

		System.out.println("* SportsCar sc1 = " + sc1);
		// < Car 초기화 생성자 >
		// < SportsCar 멤버만 초기화 생성자 >
		// * SportsCar sc1 = SportsCar [turbo = 500, speed = 0, mileage = 0, color = Red]
		
		System.out.println("* Car c1 = " + c1); // sc1의 변동사항과 관련 없음.
		// * Car c1 = Car [speed = 100, mileage = 10000, color = White]
		
		System.out.println("--------------------------------------------------------------------");
		
		//--------------------------------------------------------------------
		
		SportsCar sc2 = new SportsCar(5000);
		System.out.println("SportsCar sc2 = " + sc2);
		// < Car 초기화 생성자 >
		// < SportsCar 멤버만 초기화 생성자 >
		// SportsCar sc2 = SportsCar [turbo = 5000, speed = 0, mileage = 0, color = null]
		
		System.out.println("--------------------------------------------------------------------");
		
		//--------------------------------------------------------------------
	
		SportsCar sc3 = new SportsCar(300, 6000, "Blue", 9000);
		
		// sc3.speedUp();
		// sc3.speedDown(50);
		// 자손에 포함되어 있는 메서드로 둘 다 사용 가능.
		
		System.out.println("SportsCar sc3 = " + sc3);
		// < Car 초기화 생성자 >
		// < 조상의 멤버와 현재 멤버 초기화 생성자 >
		// SportsCar sc3 = SportsCar [turbo = 9000, speed = 300, mileage = 6000, color = Blue]
	
	} // main

} // class
