package j05_classMethod;

public class Ex01_CarUser {

	public static void main(String[] args) {
		
		// < 객체 사용 >
		// => 생성(메모리에 공간 생성) -> 사용 -> 소멸
		// => 생성 : "인스턴스화 한다" 또는 "인스턴스를 생성한다" 라고 함
		
		// 인스턴스화     // new 뒤에는 생성자 메서드
		Ex01_Car myCar = new Ex01_Car();
		// 내부에서 포함하기 때문에 has의 관계라고 한다.
		
		// => 사용
		myCar.color = "White";
		myCar.mileage = 100000;
		myCar.speed = 200;
		myCar.speedUp();
		
		System.out.println("toString = " + myCar.toString());
		// [ 속도 : 210, 주행거리 : 100000, 색상 : White ]
		
		// => 출력문에서 인스턴스명만 사용했을 때 자동 호출됨.
		// => toString 메서드를 정의하지 않으면 인스턴스의 주솟값을 제공함
		// => 인스턴스도 참조형 변수이다.
		
		System.out.println("toString2 = " + myCar);
		// [ 속도 : 210, 주행거리 : 100000, 색상 : White ]
		
		System.out.println("myCar.color = " + myCar.color); // White
		
		System.out.println("------------------------------------");
		
		//---------------------------------------------------------------------------
		
		//       fCar = 인스턴스명
		Ex01_Car fCar = myCar;
		// myCar와 fCar가 동일 주소를 갖게 되면서 myCar와 같은 값을 출력한다.
		
		//-------------------------------------------------------------------------
		/*
		 < 소멸 : 메모리청소 >
	     => 더이상 사용되지 않는 값들은 자동 제거해줌
	     => Garbage Collector (쓰레기 수집기) -> 힙(heap) 메모리 공간 청소
	     => 정해진 알고리즘에 의해 작동됨 (일정시간동안 또는 더이상 참조되지 않는 등등...)   
	     => 참조형 변수에 null 값을 주면 소멸 (더이상 참조되지 않음)
		
		 myCar를 소멸하면서 안에 저장해놓은 값을 다 지워버린다.
		 fCar는 같은 값을 참조하고 있어서 출력 가능.
		 fCar까지 소멸 시 전부 삭제됨.
		*/
		myCar = null; // null = 값 없음.
		// => 소멸 -> 청소기가 지워버림
		
		// myCar.speedUp();
		// 소멸 후 사용하면 Error -> Null pointer access: - java.lang.NullPointerException
		
		System.out.println("fCar = " + fCar);
		// fCar는 소멸하지 않았기 때문에 myCar와 같은 값 출력됨.
		// [ 속도 : 210, 주행거리 : 100000, 색상 : White ]
		
		System.out.println("------------------------------------");
		
		//------------------------------------------------------------
		
		Ex01_Car uCar = new Ex01_Car();
		// Car로 생긴 모양은 같지만 uCar로 접근하여 myCar와 값은 다를 수 있다.
		
		uCar.speed = 300;
		uCar.mileage = 300000;
		uCar.color = "Brown";
		
		System.out.println("uCar = " + uCar);
		// toString() { return } 형식은 같음.
		// [ 속도 : 300, 주행거리 : 300000, 색상 : Brown ]
		
		// myCar, fCar, uCar => 모두 인스턴스
		
	} // main

} // class
