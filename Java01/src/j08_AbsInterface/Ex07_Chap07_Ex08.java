package j08_AbsInterface; // p.253

// 정석기초 - 매개변수의 다형성 예제 
// => 매개변수로 자동형변환 Test

// 참고 : '참조변수 + 문자열'은 '참조변수.toString() + 문자열'로 처리된다.

// 결과 = Tv을/를 구입하셨습니다.
//      Computer을/를 구입하셨습니다.
//      현재 남은 돈은 700만원입니다.
//      현재 보너스점수는 30점입니다.


class Product {
	
	int price;         // 제품의 가격
	int bonusPoint;    // 제품구매 시 제공하는 보너스점수

	int bigSale; // 세일 시 할인율 => 쌤이 설명하시면서 추가함

	/*
	// 원래 예제
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);   // 보너스점수는 제품가격의 10%
	}
	*/
	
	// 쌤 추가
	Product(int price, int bigSale) {
		this.price = price;
		this.bigSale = bigSale;
		bonusPoint = (int)(price/10.0);   // 보너스점수는 제품가격의 10%
	}
	
} // c_Product

//------------------------------------------------------------------------------------

class Tv1 extends Product {
	
	/*
	// 원래 예제
	Tv1() {
		// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(100);      // Tv의 가격을 100만원으로 한다.
	}
	*/
	
	Tv1() { // 쌤 추가
		super(100, 0);      // Tv의 가격을 100만원으로 하고 할인율 0
	}

	// Object클래스의 toString()을 오버라이딩한다.
	public String toString() {
		return "Tv";
	}
	
} // c_Tv1

//------------------------------------------------------------------------------------

class Computer extends Product {
	
	// ** 새로운 변수를 사용하게 되면 조상에 정의하는 것이 바람직하다.
	// int bigSale = 10; // 쌤이 설명하시면서 추가함
	/*
	// 원래 예제
	Computer() {
		super(200);
	}
	*/
	
	Computer() { // 쌤 추가
		super(200, 10);		// Computer의 가격은 200만원, 할인율 10%
	}

	public String toString() {
		return "Computer";
	}
	
} // c_Computer

//------------------------------------------------------------------------------------
// 예제에 없는 class -> 쌤이 설명하시면서 추가함

class Mask1 extends Product {
	
	Mask1(){
		super(100, 5);		// Mask1의 가격은 100, 할인율 5%
	}
	
	
	public String toString() {
		return "Mask1";
	}
	
} // c_Mask1


// < Mask1과 비교 >
class Mask {
	
	int price;
	int bonusPoint;
	
	Mask(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	
	public String toString() {
		return "Mask";
	}
	
} // c_Mask


//------------------------------------------------------------------------------------
/*
// 원래 예제 클래스

class Buyer {   // 고객, 물건을 사는 사람
	
	int money = 1000;     // 소유금액
	int bonusPoint = 0;   // 보너스점수

	void buy(Product p) { 	// Product p가 TV도 되고 Computer도 된다.
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}

		money -= p.price;            // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;  // 제품의 보너스 점수를 추가한다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
} // c_Buyer
*/

// 쌤 설명
class Buyer {   // 고객, 물건을 사는 사람
	
	int money;     		  // 소유금액
	int bonusPoint = 0;   // 보너스점수
	
	Buyer(int money) {
		this.money = money;
	}

	
	// < ** 확인사항 ** >
	// - Product를 상속받지 않은 Mask를 사기 위해서는 별도의 메서드가 필요하다
	// Computer에만 정의한 bigSale은 p 객체로는 전달 불가능
	// => 비교
	void buyMask(Mask p) {
		
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;            // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;  // 제품의 보너스 점수를 추가한다.
		System.out.println(p + "을/를 구입하셨습니다.");
		
	} // buyMask_Mask
	
	
	void buy(Product p) { 	// Product p가 TV도 되고 Computer도 된다.
		
		// < 할인 적용하기 (bigSale) >
		p.price -= (p.price * p.bigSale) / 100;
		
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;            // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;  // 제품의 보너스 점수를 추가한다.
		
		System.out.printf("%s을/를 %d에 구입하셨습니다. \n", p, p.price);
		
	} // buy_Product
	
} // c_Buyer


//====================================================================================

public class Ex07_Chap07_Ex08 {

	public static void main(String[] args) {
		
		/*
		// 원래 예제
		Buyer b = new Buyer();

		// Tv t = new Tv(); b.buy(t);를 한 문장으로 줄이면 b.buy(new Tv1());가 된다.
		b.buy(new Tv1());
		b.buy(new Computer());

		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
		*/
		
		
		// 쌤
		System.out.println("< Buyer b Test >");

		Buyer b = new Buyer(500);
		
		Product t1 = new Tv1();
		b.buy(t1);
		// => t1을 매개변수 뿐만 아니라 다른 용도로 계속 사용해야 한다면 위처럼 인스턴스 생성을 하고, (메모리 더 씀)
		//    t1을 매개변수로만 사용한다면 b.buy(new Tv)처럼 바로 생성한다.
		// => 매개변수로 전달되면서 자동 형변환(Up_Casting)이 일어남
		
		b.buy(new Computer()); 
		// Product c1 = new Computer();
		// b.buy(c1); 
		// 이렇게 쓰는 것과 동일하다
		
		b.buyMask(new Mask(100));
		
		b.buy(new Mask1()); // Product의 후손인 Mask1은 buy메서드 적용 가능

		System.out.println("\nb 현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("b 현재 보너스점수는 " + b.bonusPoint + "점입니다.");
		
		//----------------------------------------------------------------------------
		
		System.out.println("\n< Buyer c Test >");
		Buyer c = new Buyer(1000);
		
		c.buy(t1);
		
		/*
		Product c1 = new Computer();
		
		// ** price 값이 누적 변경됨(180 -> 162 -> 146)
		c.buy(c1);
		c.buy(c1);
		c.buy(c1);
		*/
		// => 이 점을 보완하려면
		c.buy(new Computer()); // 180
		c.buy(new Computer()); // 180
		c.buy(new Computer()); // 180
		
		
		System.out.println("c 현재 남은 돈은 " + c.money + "만원입니다.");
		System.out.println("c 현재 보너스점수는 " + c.bonusPoint + "점입니다.");
		
		System.out.println("\n** Buyer b는 Buyer c의 결과와 무관하다 **");
		System.out.println("b 현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("b 현재 보너스점수는 " + b.bonusPoint + "점입니다.");
		
	} // main

} // class
