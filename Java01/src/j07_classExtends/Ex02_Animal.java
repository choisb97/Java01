package j07_classExtends; // 상속 Animal

/*
 < Java의 상속의 특징 >
 - 계층적으로 다중 상속이 가능하고 제한이 없음.
 => 그러나 다중 상속은 안된다 (부모는 무조건 1개의 클래스만 허용)
    class WildAnimal extends Mammal, Reptile {  -> ERROR

-----------------------------------------------------------

 < 메서드 오버라이딩 >
 - 조상의 메서드와 매개변수, 리턴값, 이름 모두 동일한 메서드
  (매개변수가 다르다면 메서드 오버로딩에 해당됨.) 
   현재 클래스에 구현된 메서드가 호출됨
   이름은 동일하지만 후손클래스 별로 다양한 기능을 구현할 수 있음. 

------------------------------------------------------------

 < static , final >
 - 멤버변수, 멤버메서드 , 클래스(final)

 => final
  - class : 종단클래스(상속 불가)
  - method : 재정의(Override) 금지
  - 필드(변수) : 상수 -> 수정 불가
  - 대표적인 종단클래스 : String

 => static 메서드
  - 상속(오버라이딩) 안 됨
  - 클래스(종속) 메서드로써 필요 시 각자 정의해서 사용하는 것은 가능함.
   (단, 동일한 이름의 메서드를 후손이 non_static으로 정의하는 것은 불가능)   
  - super, this는 non_static (인스턴스 메서드)에서만 사용 가능
    (super, this인 인스턴스를 의미하기 때문)
  - static 변수는 클래스명으로 접근

------------------------------------------------------------

 < Animal >
 => Mammal (String cry, crying),
    Reptile (swimming)
 => WildAnimal (all Print), PetAnimal(infoPrint())

------------------------------------------------------------

 멤버변수 => this. / super.
 생성자 => this() / super()
*/

class Animal {
	
	String name;
	static int legs; // 4
	
	
	// Ex03_Child - static import Test
	static String color = "Red";
	
	
	Animal() {
		
		System.out.println("< Animal Default 생성자 >");
		
	} // Animal default
	
	
	Animal(String name, int legs) {
		
		this.name = name;
		Animal.legs = legs;
		
		System.out.println("< Animal 초기화 생성자 >");
		
	} // Animal_name, legs
	
	
	void breath() {
		
		System.out.printf("< %s는 숨을 쉬고, 다리는 %d개입니다. > \n", name, legs);
		
	} // breath
	
} // c_Animal

//----------------------------------------------------------------------

// < 클래스명에 final >
// - 상속을 허용하지 않음 -> 종단 클래스
// => 대표적인 종단 클래스 : String (public final class String)

// final class Mammal extends Animal {}


// Mammal = 포유류
class Mammal extends Animal {
	
	String cry;
	int legs;

	Mammal () {
		
		System.out.println("< Mammal Default 생성자 >");
		
	} // Mammal default
	
	
	Mammal(String name, String cry, int legs) {
		
		super(name, legs);
		this.cry = cry;
		
		System.out.println("< Mammal 초기화 생성자 >");
		
	} // Mammal_name, cry, legs
	
	
	// < 메서드에 final >
	// - 오버라이딩 불가 : final void crying() {}
	// => 후손에게 동일한 이름, 동일한 매개변수의 메서드 작성을 허용하지 않는다.
	void crying () {
		
		System.out.printf("< %s는 %s 소리를 내며 웁니다. > \n", name, cry);
		
	} // crying
	
	
	static void staticTest() {
		
		System.out.println("< Mammal : staticTest()");
	
	} // staticTest
	
} // c_Mammal
	
//----------------------------------------------------------------------

//  < Java에서는 다중상속을 불허함 >
// Error -> extends Mammal Reptile

class WildAnimal extends Mammal {
	
	
} // c_WildAnimal

//----------------------------------------------------------------------

class PetAnimal extends Mammal {
	
	int legs;

	PetAnimal() {
		
		System.out.println("< PetAnimal Default 생성자 >");
		
	} // PetAnimal default
	
	
	PetAnimal(String name, String cry, int legs){
		
		super(name, cry, legs);
		// legs는 Animal의 legs로 전달
		// -> this.legs에는 할당하지 않음
		
		System.out.println("< PetAnimal 초기화 생성자 >");
		
	} // PetAnimal_name, cry, legs
	
	
	@Override
	void crying() {
		
		super.crying();
		System.out.println("< 노래도 부릅니다~! >");
		
	} // or_crying
	
	
	/*
	 < static Method Override Test >
	 - static 멤버들은 클래스 종속이므로 상속의 개념보다 우선 적용된다.
	   그러므로 Override 적용 안 되고, 각 클래스의 멤버이다.
	
	   즉, 조상의 staticTest()와는 무관한 PetAnimal.staticTest()이다.
	    -> 이러한 특성을 "static에서 오버라이딩(Overriding) 불가"라고 함
	*/
	// @Override -> Error
	static void staticTest() {
		
		System.out.println("< PetAnimal : staticTest() >");
		Mammal.staticTest(); // 조상의 클래스메서드 호출 가능.
	
	} // staticTest
	
	
	/*
	void staticTest() {
		// 조상의 static 메서드와 동일한 이름의 메서드를 후손이 non_static으로 정의하는 것은 불가능
	}
	*/
	
	/*
	void staticTest(int a) {
		// 매개변수가 다르기 때문에 메서드 오버로딩 허용
	} 
	*/
	
	
	void checking() {
		
		System.out.printf("< %s는 예방접종을 했습니다. > \n", name);
		
	} // checking
	
	
	void infoPrint() {
		
		super.legs = this.legs;
		
		breath(); // legs = 0
		crying();
		checking();
		
	} // infoPrint
	
	//----------------------------------------------------------------
	
	// legs print
	void legsPrint(int legs) {
		
		System.out.printf("< Local = %d, Global_Pet = %d, Parent_Mammal = %d,"
				+ " Animal = %d> \n", legs, this.legs, super.legs, Animal.legs);
		
	} // legsPrint_legs
	
} // c_PetAnimal

//----------------------------------------------------------------------

// Reptile = 파충류
class Reptile extends Animal {
	
	
} // c_Reptile

//========================================================================================

public class Ex02_Animal { // extends 없는 class => 자동으로 Object 상속

	public static void main(String[] args) {
		
		PetAnimal cat = new PetAnimal();
		
		cat.name = "고양이";
		cat.legs = 4;
		// infoPrint()에서 PetAnimal과 Mammal의 legs가 없으면 4를 출력 / 있으면 0을 출력
		// => breath()메서드는 Animal의 legs를 출력하기 때문.
		cat.cry = "야옹~ 야옹~";
		
		cat.infoPrint();
		
		System.out.println("--------------------------------------");
		
		//-----------------------------------------------------------
		
		PetAnimal dog = new PetAnimal("강아지", "멍멍! 멍멍!", 4);
		
		dog.infoPrint();

		System.out.println("--------------------------------------");
		
		System.out.println("** 비교 Test dog.legs1 = " + dog.legs); // 0
		// PetAnimal legs
		
		dog.legsPrint(77);
	
		dog.legs = 10;
		System.out.println("** 비교 Test dog.legs2 = " + dog.legs); // 10

		dog.legsPrint(55);

		System.out.println("--------------------------------------");
		
		cat.infoPrint();
		
		System.out.println("--------------------------------------");

		// static Method Test
		Mammal.staticTest();
		PetAnimal.staticTest();
		
		System.out.println("--------------------------------------");

		//-----------------------------------------------------------
		/*
		 < Object Test >
		 - 모든 클래스의 최상위 조상
		 => 클래스 계층도 확인 : 클래스를 클릭한 후 ctrl + t
		 => 클래스 소스코드 보기 : 클래스명을 ctrl + click -> source code
		*/
		Object obj = new Object();
		
		System.out.println("< Object Test1 > = " + obj.toString());
		// < Object Test1 > = java.lang.Object@7e0ea639
		
		System.out.println("< Object Test2 > = " + obj);
		// < Object Test2 > = java.lang.Object@7e0ea639
		
		System.out.println("--------------------------------------");

		//========================================================================
		/*
		 < 다형성 적용 -> j08-Ex01 참고 >
		 - 타입은 조상으로, 생성은 후손으로
		   조상에 정의된 멤버만큼 접근 가능.
		*/
		System.out.println("< 추상 아닌 다형성 적용 Test >");
		Mammal mm1 = new PetAnimal();
		
		mm1.breath();
		mm1.crying();
		
		Mammal mm2 = new WildAnimal();
		
		mm2.breath();
		mm2.crying();
		
		// => 후손의 타입(좌측), 조상의 생성자(우측)으로 생성은 허용하지 않는다.
		// 좌측(타입) : 후손 = 우측(생성) 조상 XXXXXXXX
		// PetAnimal pet = new Mammal(); => Error -> Type mismatch
		
		// 좌측(타입) : 조상 = 우측(생성) : 후손
		
	} // main

} // class 

