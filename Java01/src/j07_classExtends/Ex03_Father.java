package j07_classExtends;

import java.util.Arrays;

// public final class Ex03_Father {
// => final을 클래스에 적용하면 상속 불가(종단클래스)
public class Ex03_Father {
	
	static String country = "Korea"; // static 변수 = 클래스 변수 (cv)
	String name; // 인스턴스 변수 (iv)
	private int money;
	
	Ex03_Father() {
		System.out.println("< Father Default 생성자 >");
	} // Ex03_Father default
	
	
	Ex03_Father(String name, int money) {
		this.name = name;
		this.money = money;
		System.out.println("< Father 초기화 생성자 >");
	} // Ex03_Father name, money
	
	//------------------------------------------------------------------------------
	
	/*
	// < 메서드에 final >
	// - 오버라이딩 금지
	// public final void bank(int money ) {
	*/
	
	//-------------------------------------------
	
	/*
	// private final void bank(int money) {
	// => Child에서도 접근 불가
	*/

	//-------------------------------------------
	
	/*
	< 메서드에 static >
	public static void bank(int money) {
	 => static메서드에서는 this, super 사용 불가
	System.out.println("Father : Money = " + this.money);
		 this.money += money;
	System.out.println("Father : Money = " + this.money);
	}
	*/
	
	public void bank(int money) {
		this.money += money; // this.money = this.money + money;
		System.out.println("Father : this.money = " + this.money);
		System.out.println("Father : money = " + money);
	} // bank_bank

	//------------------------------------------------------------------------------
	
	public void info() {
		System.out.printf("Father : country = %s, name = %s, money : %d \n"
				, country, name, money);
	} // info

	
	//==============================================================================

	/*
	// < main 메서드 오버로딩 Test >
	// - 허용은 되지만 사용이 바람직하지 않음.
	public static void main(String name, int money) {
		System.out.printf("** main 오버로딩 Test : name = %s, money = %d \n"
				, name, money);
	}
	*/
	
	// < main >
	// - JVM이 클래스를 실행시키는 기본 메서드
	//   그러므로 public static void 여야만 한다.
	// => 매개변수는 필요 시 사용 가능함.
	public static void main(String[] args) { // args = arguments
		
		// < main 매개변수 args 활용 >
		// - 실행 시 전달 : 하하하 호호호 123 456 (space로 구분)
		// 우클릭 -> Run As -> Run Configurations -> Arguments -> Program Arguments
		
		System.out.println("** main 매개변수 args = " + Arrays.toString(args));
		// ** main 매개변수 args = [하하하, 호호호, aaa, bbb, 이재영, 123, 5555]

		System.out.println("-----------------------------------------------------");
		
		//-----------------------------------------------------------------------

		// < main 오버로딩 Test >
		// main("오버로딩 Test", 12345); // test용
		// ** main 오버로딩 Test : name = 오버로딩 Test, money = 12345
		
	//-----------------------------------------------------------------------------		
		Ex03_Father f1 = new Ex03_Father("최수빈", 1000);
		
		f1.bank(5000);
		f1.info();
		
		System.out.println("-----------------------------------------------------");
		
		Ex03_Father f2 = new Ex03_Father("이재영", 5000);
		f2.bank(-10000);
		f2.info();

		System.out.println("-----------------------------------------------------");

		// < static 변수 Test >
		country = "대한민국";
		// 실행 후 종료 -> default : Korea
		
		System.out.println("< static 변수 Test - country >");
		
		f1.info();
		f2.info();
		
	} // main

} // class
