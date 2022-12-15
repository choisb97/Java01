package j05_classMethod;

/*
 < static Test >
 => Phone 클래스 정의
 private 멤버변수 3개 (static 1개, non_static 2개, getter/setter)
 메서드 2개 (static 1개, non_static 1개)
 멤버변수 3개를 생성자로 초기화한다.

---------------------------------------------------------------

 < 추가 실습 >
 => price는 수정 불가능(readOnly)하도록 한다.
    setter는 작성하지 않고 getter만 작성
    단, 초기화는 생성자로 한다.
*/


// Ex10_Phone : 프로젝트 내의 어디에서든 접근 가능.
public class Ex10_Phone {
	
	
	// 1) 멤버변수 정의 (private 멤버변수 3개 - static 1개, non_static 2개)
	
	private static String company = "Green";
	private String color;
	private int price;
	
	// < 상수 정의 >
	// - 수정 불가(readOnly), 바로 값 입력
	// - static final blah blah = 값;
	// 그냥 final만 사용해도 상수는 정의할 수 있지만 메모리 절약을 위해 static final 사용 권장. 
	// 변수명은 전체 알파벳 대문자로 -> 예) PI
	// Java는 'const' 라는 예약어 없음.
	
	public static final double PI = 3.14159;
	
	// public final double PI2 = 3.14159;
	final double PI2 = 3.14159; // default 접근범위 : 패키지
	// final에 static 안붙이면 메모리 낭비
	
	//========================================================
	
	// 2) 생성자
	
	public Ex10_Phone() { // default 생성자
		
	}

	// public Ex10_Phone(String color, int price, String company) {
		// Ex10_Phone.company = company; // 자동완성으로는 만들어지지 않음.
		// static 수동 초기화
	
		// this.color = color;
		// this.price = price;
		
	public Ex10_Phone(String color, int price) {

		this.color = color;
		this.price = price;
		
	}
	
	//========================================================
	
	// 3) getter / setter
	
	public static String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		Ex10_Phone.company = company;
	}
	// company

	//--------------------------------------------------------
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	// color
	
	//--------------------------------------------------------
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// price
	
	//========================================================

	// 4) 메서드 정의 (메서드 2개 : static 1개, non_static 1개)
	
	// < 상수 Test >
	public void finalTest () { // non-static 메서드
		// PI = 3.141592; // readOnly -> 수정불가
		// PI2 = 3.141592; // readOnly -> 수정불가
		// 출력만 가능
		System.out.printf("* PI = %f, PI2 = %f \n", PI, PI2);
	
	} // constTest
	
	
	public static void staticTest () { // static 메서드
		// PI2는 static이 아니라서 그냥 출력 불가능.
		// static company, static PI 가능.
		System.out.printf("* PI = %f, company = %s \n", PI, company);
		
	} // staticTest
	
	//========================================================

	// 5) toString
	
	@Override
	public String toString() {
		return "Ex10_Phone [color = " + color + ", price = " + price 
				+ ", company = " + company + "]";
		// company는 static이기 때문에 인스턴스별로 관리되는 대상 X -> 따로 추가해줘야 됨.
		
	} // toString
	
} // class Phone
