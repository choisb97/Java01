package j07_classExtends;

// < static import >
// - static 멤버 호출 시 클래스명 생략 가능.
import static j07_classExtends.Animal.color;


public class Ex03_Child extends Ex03_Father {
	
	String name;
	int money;
	
	
	Ex03_Child () {
		System.out.println("< Child Default 생성자 >");
	} // Ex03_Child default
	
	
	// < Father, Child 모두 초기화하는 생성자 >
	Ex03_Child(String fname, int fmoney, String name, int money) {
		
		super(fname, fmoney);
		this.name = name;
		this.money = money;
		
		System.out.println("< Child 초기화 생성자 >");
		
	} // Ex03_Child fname, fmoney, name, money
	
	//-------------------------------------------------------------------------------
	
	/*
	=> Father에서 final : 오버라이딩 금지
	그러나 오버로딩(매개변수 다르게)은 무관
	public void bank(int money, int i) {
	*/

	//-------------------------------------------
	
	/*
	=> Father에서 static : 오버라이딩 금지
	   그러나 Child에서 같은 이름의 static메서드 허용되고,
	   인스턴스 메서드는 허용되지 않는다.
	public static void bank(int money) {
	*/
	
	@Override
	public void bank(int money) {
		this.money += money * 0.8;
		
		// Father 용돈 드리기
		money *= 0.2; // money = money * 0.2;

		// Father bank = private이면 접근 불가
		super.bank(money); // => 완전차단 - Father에서 private 
	} // bank_money
	
	//-------------------------------------------------------------------------------
	
	@Override
	public void info() {
		super.info();
		System.out.printf("Child : country = %s, name = %s, money : %d \n"
				, country, name, money);
	} // info
	
	
	//===============================================================================

	public static void main(String[] args) {

		Ex03_Child c1 = new Ex03_Child();
		
		c1.name = "홍길동";
		c1.bank(10000);
		c1.info();
		
		System.out.println("-----------------------------------------------------");
		
		Ex03_Child c2 = new Ex03_Child("김아빠", 100000, "김아들", 50000);
		
		c2.bank(-1000000);
		c2.info();

		System.out.println("-----------------------------------------------------");
		
		// < static import Test >
		System.out.println("< static import Test >");
		
		// Ex02_Animal에 import test 작성함
		System.out.println("** Before static import >> Animal Color = " + Animal.color);
		System.out.println("** After static import >> Animal Color = " + color);
		
	} // main

} // class
