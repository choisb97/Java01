package j08_AbsInterface; // p.249

// 정석기초 - 참조변수의 형변환 예제 - class Casting 관련 예제

// 결과 = water!!!
//      water!!!

class Car {

	String color;
	int door;

	void drive() {    // 운전하는 기능
		System.out.println("drive, Brrrr~");
	}


	void stop() {     // 멈추는 기능   
		System.out.println("stop!!!");   
	}

} // c_Car

//------------------------------------------------------------------------------------

class FireEngine extends Car {   // 소방차

	void water() {   // 물을 뿌리는 기능
		System.out.println("water!!!");
	}

} // c_FireEngine

//====================================================================================

public class Ex06_Chap07_Ex07 {

	public static void main(String[] args) {

		Car car = null; // 인스턴스 생성 X, 선언만
		FireEngine fe = new FireEngine(); // FireEngine객체를 생성
		FireEngine fe2 = null; // 인스턴스 생성 X, 선언만

		fe.water();
		
		// (Car)fe -> (자동 형변환)
		// car = (Car)fe; -> 후손은 언제든지 조상의 Type이 될 수 있기 때문에 (Car) 생략가능
		car = fe; // fe의 값을 car에 저장. / 조상 <- 후손 (Up_Casting)
		// Car car = new FireEngine(); -> 그러므로 Car에 정의된 만큼만 접근 가능
		
		// car.water(); => Error -> Car 타입의 참조변수로는 water()를 호출할 수 없다

		fe2 = (FireEngine)car; // OK (#48 때문에 가능)
		// => 양쪽 Type 같아야 하기 때문에 (FireEngine)car 사용
		// 후손 <- 조상. 형변환 생략 불가(Down_Casting => 자동 형변환 X -> 명시적으로 형변환 필요)
		
		// !! car가 FireEngine이 될 수 있는지 instanceof 이용해서 확인 !!
		if (car instanceof FireEngine)
			System.out.println("** car는 FireEngine Type이 될 수 있습니다!!");
		else
			System.out.println("Error : redCar는 FireEngine Type이 될 수 없습니다!!");
		

		fe2.water();
		// car.water(); -> 여전히 car는 car일 뿐
		// (#53에서 car를 다운캐스팅한 값을 fe2에 전달만 했고 자신이 변경된 것은 아님)
		
		
		Car redCar = new Car();
		
		// fe2 = (FireEngine)redCar;
		// => 다운캐스팅 불가능 : Error -> 컴파일 오류는 없지만 런타임 오류 발생(ClassCastException)
		// => 그러므로 instanceof 연산자로 확인 후 Down_Casting 적용
		
		if (redCar instanceof FireEngine)
			fe2 = (FireEngine)redCar;
		else
			System.out.println("Error : redCar는 FireEngine Type이 될 수 없습니다!!");
		

	} // main

} // class
