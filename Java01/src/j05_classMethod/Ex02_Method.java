package j05_classMethod;

/*
 < 멤버 메서드 (method) >
 - 함수(Function), 프로시져(Procedure)

 J06_ 15,16 p

 1) 정의, 실행

 2) return값
 => return이 있으면 Type을 지정, 없으면 무조건 void  
 => 메서드 실행결과 return Type에 해당하는 결괏값을 제공
 => return 명령어를 void 메서드에서 사용하면 메서드 종료

 3) 매개변수
 => 매개변수(Argument, 인자), Parameter
 => 메서드의 지역변수이며, 모든타입 정의 가능

 => 매개변수의 값 전달방법
    CallByValue (기본자료형, String -> 매개변수의 값 전달)
   - 값에 의한 전달
    CallByReference (참조자료형 : 배열, 인스턴스 -> 주소 전달)   
   - 주소에 의한 전달

 < 기본자료형 >
 - Primitive Data Type (int, double, boolean, ... 등)

 < 참조자료형 >
 - Reference Data Type (String, array(배열),... 등 Class Type)
*/

public class Ex02_Method {

	/*
	  1. 메서드 종류별 4종 정의
	
	  2. return Test 
	     => return 값 활용 (main 에서 Test)
	     => void 메서드에서 사용 : 메서드 종료 
	
	  3. 매개변수 전달방법
	     => CallByValue (기본자료형, String -> 매개변수의 값 전달됨) 
	     => CallByReference (참조자료형, 주소값을 전달 -> 배열, 인스턴스)
	 */
	
	int price = 5000; // 전역(멤버) 변수
	
	//----------------------------------------------------------------
	
	// 1) 매개변수, return 값 없음
	public void juiceCafe1() {
		System.out.println("< 무슨 주스를 원하시나요? >");
	
		// return 값 없음 = void
	} // m_juiceCafe1 default

	
	// < 메서드명 >
	// - 매개변수가 다른 경우 이름이 같아도 사용 가능.
	// => 소문자로 시작함.
	
	public void juiceCafe1(int n) {
		System.out.println("** 메서드명 Test - 매개변수가 있습니다. => " + n); // 555
		                                      // #160 -> cafe.juiceCafe1(555)
		
		// non_static 메서드에서는 static, non_static 멤버 모두 인스턴스 없이 접근 가능.
		// => 메서드끼리 호출 가능
		juiceCafe1(); 
		
		price = 7000; // non_static끼리는 인스턴스 없이 호출 가능
	
	} // juiceCafe1(int n)
	
	//----------------------------------------------------------
	
	// 2) 매개변수 있고, return 값 없음
	// 매개변수 = 지역변수
	public void juiceCafe2(String s, int n) {
		                 // 무슨 주스    몇 잔
		                 // orange
		if (n < 5) {
			System.out.printf("주문 오류입니다 = %s, %d \n", s, n);
			return; // void 라서 return 만! => void 에서 사용하면 메서드 종료
		} // if
		
		System.out.println("< 주문 내용 >");
		// CallByValue (기본자료형, String -> 매개변수의 값 전달됨) => 나머지 클래스는 주소 전달
		
		s = "apple";
		System.out.printf("=> %s 주스, %d잔 입니다. \n", s, n); // s = "apple"
	
	} // juiceCafe2
	// (String s, int n) =  매개변수

	//----------------------------------------------------------
	
	// 3) 매개변수 없고, return 값 있음
	public String juiceCafe3() {
		return "주스 한 잔은 " + price + "입니다.";
	
	} // juiceCafe3
	// String 사용으로 return 값 출력 
	
	//----------------------------------------------------------

	// 4) 매개변수, return 값 있음
	public int juiceCafe4(int n, String s) {
		System.out.printf("=> %s 주스, %d잔 주문. \n", s, n);
		return n * price;
	// return n * price = 총 금액
	
	} // juiceCafe4
	
	//----------------------------------------------------------

	// 5) 참조자료형 Test
	// => 매개변수, return 값 있음
	public int carTest(Ex01_Car car, int speed) {
		// 매개변수로 전달받아 사용하기 때문에 use-a 관계라고 한다.
		// use-a(사용) 관계 : 한 객체가 그것의 행위를 수행(use)하기 위해 다른 종류의 객체를 사용하는 경우
		System.out.println("car 111 => " + car);
		// Ex01_Car car = myCar , speed = carTest speed(5000)
		
		System.out.println("-------------------------------------------");
		
		car.color = "Pink";
		car.speed = speed; // 5000
				
		System.out.println("car 222 => " + car);
		// [ 속도 : 5000, 주행거리 : 0, 색상 : Pink ]
		
		System.out.println("-------------------------------------------");

		return car.speed + speed;
	
	} // carTest
	
	//===============================================================
	
	public static void main(String[] args) {
		
		// < 메서드 호출 >
		// - 같은 클래스에서도 접근하기 위해서는 인스턴스 필요
		// 인스턴스화  인스턴스명        생성자 메서드
		Ex02_Method cafe = new Ex02_Method();
		
		String kind = "orange"; // 지역변수
		
		// cafe.juiceCafe(n) 으로 위에서 만든 메서드 확인 가능
		
		// cafe.juiceCafe1(); => #52로 호출함
		// static 메서드에서 non_static 멤버를 사용하려면 반드시 인스턴스가 필요함.
		// price = 10000; => Error
		
		cafe.price = 10000; // 사용가능
		// cafe. -> 인스턴스
		
		cafe.juiceCafe1(555); // int 매개변수를 한 개 가진 juiceCafe1 메서드를 call

		System.out.println("-------------------------------------------");
		
		cafe.juiceCafe2(kind, 7); // kind 는 "orange" 의 주소만 전달
		
		System.out.println("-------------------------------------------");

		System.out.println("** main CallByValue Test kind => " + kind);
		
		System.out.println("-------------------------------------------");

		cafe.juiceCafe2("Banana", 3);
		// 매개변수 타입 순서 일치 (String, int)

		System.out.println("-------------------------------------------");
		
		System.out.println("main cafe3 = " + cafe.juiceCafe3());
		
		System.out.println("-------------------------------------------");

		System.out.println("main cafe4 = " + cafe.juiceCafe4(20, "WaterMelon"));
									  // 매개변수 타입 순서 일치해야됨 (int, String)
		
		// 위 4) return 값(총 금액) 먼저 출력 후 main cafe 4 출력

		System.out.println("===========================================");
		
		//--------------------------------------------------------------------------
		
		// < 참조자료형 Test >
		
		/*
		// 5) 참조자료형 Test
		// => 매개변수, return 값 있음
		 * 
		public int carTest(Ex01_Car car, int speed) {
		// Ex01_Car car = myCar , speed = carTest speed(5000)
		 * 
			System.out.println("car 111 => " + car);
			// [ 속도 : 0, 주행거리 : 0, 색상 : Purple ]
			
			car.color = "Pink";
			car.speed = speed; // 5000
					
			System.out.println("car 222 => " + car);
			// [ 속도 : 5000, 주행거리 : 0, 색상 : Pink ]
			
			return car.speed + speed; // 5000 + 5000 = 10000
		}
		*/
		
		//-------------------------------------------------------------------
		
		// 인스턴스화
		Ex01_Car myCar = new Ex01_Car();
		// myCar = Ex01_Car 의 주소를 받음
		
		System.out.println("main Before car = " + myCar); // Purple
		// [ 속도 : 0, 주행거리 : 0, 색상 : Purple ]

		System.out.println("-------------------------------------------");
		
		System.out.println("main Call carTest = " + cafe.carTest(myCar, 5000)); // 10000
		// 위 5) return car.speed + speed => 5000 + 5000 = 10000
		
		System.out.println("-------------------------------------------");
		
		System.out.println("main After car = " + myCar); // Pink
		// [ 속도 : 5000, 주행거리 : 0, 색상 : Pink ]
		
		
		// cafe.carTest(myCar, 5000);
		// => .carTest(Ex01_Car car, int speed) : int
		// => .carTest ( 매개변수 한 개, 두 개) : int (return Type)
		
		System.out.println("-------------------------------------------");

		System.out.println("main Call 매개변수 carTest = " 
								+ cafe.carTest(new Ex01_Car(), 5000)); // 10000
		         							// new Ex01_Car 매개변수로 일회성 사용 가능
				 							// new 꼭 붙여야 함!
			     							// 일회성이기 때문에 myCar.어쩌구 같은 방식은 사용 못 함
		
		// ***************************************************************************
		// < 매개변수 생성 비교 >
	    // - 매개변수 위치에서 바로 생성해도 됨
	    // => Car 를 일회성 매개변수로만 사용하는 경우 적당
	
	} // main

} // class
