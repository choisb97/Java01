package jv1_67_test; // p.284

// 다음의 코드는 컴파일하면 에러가 발생한다.
// 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하는가?


class Product {
	
	int price;			// 제품의 가격
	int bonusPoint;		// 제품구매 시 제공하는 보너스점수
	/*
	 Product 클래스에 기본 생성자 Product( )가 없기 때문에 에러가 발생한다.
	 Product클래스에 기본 생성자를 추가해줘야 한다.
	*/
	Product() {
		// Product Default 생성자
	}
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
} // c_Product


class Tv extends Product {
	
	Tv() {
		// Tv Default 생성자
	}

	public String toString() {
		return "Tv";
	}
	
} // c_Tv


//=================================================================================================

public class Chap07_03 {

	public static void main(String[] args) {
		
		Tv t = new Tv();
		
		System.out.println(t);

	} // main

} // class
