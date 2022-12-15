package j14_generic;

/*
 < Generic Class Test >
 - FruitBox 만들기
 - Apple, Banana 등 모든 과일을 담을 수 있는 FruitBox class를 만들어 보세요.
   단, 과일만 담을 수 있다.
   ( 자율적으로 하기 )
 
 Hint : Apple, Banana 등 각종 과일들이 객체형(class)이고,
        이들은 과일(Fruit)로 구분될 수 있어야 함.
 */


class Fruit {
	public String toString() {
		return "I am Fruit";
	}
} // c_Fruit


class Apple extends Fruit {
	public String toString() {
		return "I am Apple";
	}
} // c_Apple

class Banana extends Fruit {
	public String toString() {
		return "I am Banana";
	}
} // c_Banana

class Orange extends Fruit {
	private String color;
	
	Orange(String color) {
		this.color = color;
	} // Orange_color
	
	public String toString() {
		return "I am " + color + " Orange";
	}
} // c_Orange

class Tomato {
	public String toString() {
		return "I am Tomato";
	}
} // c_Tomato

//----------------------------------------------------------------------------------
/*
 => 과일만 담을 수 있는 FruitBox 만들기
 => Generic으로 Fruit의 후손들만 담을 수 있는 배열에 set & print
    Fruit의 후손들만 사용 가능하도록 Generic Type 제한
*/
class FruitBox <T extends Fruit> {
	
	private T[] farr;
	
	public void setFarr(T[] farr) {
		this.farr = farr;
	} // set

	public void fruitPrint() {
		for (T f : farr) {
			System.out.println(f);
		} // eachfor
		
	} // fruitPrint
	
} // c_FruitBox

//==================================================================================================================

public class Ex03_GenFruitBox {

	public static void main(String[] args) {
		
		FruitBox<Fruit> f1 = new FruitBox<Fruit>(); // => Type 제하
		
		// Fruit[] fa = { new Apple(), new Banana(), new Orange(), new Fruit(), new.Tomato() };
		// Tomato 클래스는 Fruit을 상속받고 있지 않기 때문에 배열에 포함될 수 없다.
		Fruit[] fa = { new Apple(), new Banana(), new Orange("Red"), new Fruit() };
		
		f1.setFarr(fa);
		f1.fruitPrint();
		
		System.out.println("");
		
	//---------------------------------------------------------------------------------------------------------------
		
		FruitBox<Orange> f2 = new FruitBox<Orange>();

		Orange[] oa = {new Orange("Orange"), new Orange("Purple"), new Orange("Pink"), new Orange("Green")};

		f2.setFarr(oa);
		f2.fruitPrint();

	//---------------------------------------------------------------------------------------------------------------

		// FruitBox<Tomato> f3 = new FruitBox<Tomato>();
		//=> Fruit의 자손이 아니라 허용하지 않음.

	} // main

} // class
