package j08_AbsInterface;

/*
 < 클래스의 형변환 >
 - 자동 형변환 (형변환 생략 가능)
 - 조상 <- 자손 (Up_Casting)

 - 명시적 형변환 (형변환 생략 불가능)
 - 자손 <- 조상 (Down_Casting)
   실제적 클래스타입이 변환 가능한 경우에만 적용됨 
  (변환 불가능한 경우에는 컴파일 오류 없어도 런타임 오류(ClassCastException) 발생)

  Animal => Mammal 포유류  => PetAnimal
  Animal => Reptile 파충류
*/


class Animal2 {
	
	   int legsA = 2;
	   String name;
	   
	   public Animal2() {
		   System.out.println("< Animal 생성자 >");
		}
	   
	   public Animal2(String name) {
		   this.name = name;
		   }
	   
	   void breath() {
	      System.out.println(name + "는 숨을 쉽니다 ~~");
	   }
	   
	} // c_Animal2

//------------------------------------------------------------------------------------------	

class Mammal extends Animal2 {
		
	String cry ;
	int legs = 3;
	   
	public Mammal() {
		System.out.println("< Mammal 생성자 >");
	}
	   
	void crying() {
	    System.out.println(super.name + " 은(는) " + cry + " 웁니다 ~~");
	}
	   
} // c_Mammal

//------------------------------------------------------------------------------------------	

class PetAnimal extends Mammal {
	
	String name = "강아지";
	int legs = 4;
	   
	PetAnimal() {
		System.out.println("< PetAnimal 생성 >");
	}
	   
	   
	@Override // Animal2
	void breath() {
	   super.breath();
	     System.out.println("여기는 PetAnimal breath() 입니다.");
	}
	   
	   
	void legsPrint(int legs) {
	     System.out.printf("%s의 다리 = (Local) : %d, Pet(Global) : %d, Mam(Father) : %d, "
	      		+ "Ani(할아버지) : %d \n", name, legs, this.legs, super.legs, super.legsA);
	} 
	   
} // c_PetAnimal

//------------------------------------------------------------------------------------------	
	
class Reptile extends Animal2 {
		
} // Reptile	


//===================================================================================

public class Ex06_classCasting {

	public static void main(String[] args) {

		// < Test 1 - PetAnimal 생성 >
		PetAnimal dog = new PetAnimal();
		// PetAnimal > Mammal > Animal
		
		System.out.println("");
		
	//--------------------------------------------------------------------------------------
		
		// < instanceof Test >
		System.out.println("< instanceof Test >");
		
		if (dog instanceof PetAnimal)
			System.out.println("dog는 PetAnimal입니다.");
		
		
		if (dog instanceof Mammal)
			System.out.println("dog는 Mammal입니다.");
		
		
		if (dog instanceof Animal2)
			System.out.println("dog는 Animal2입니다.");
		
		
		if (dog instanceof Object)
			System.out.println("dog는 Object입니다.");
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		// < Test 2 - Up_Casting Test >
		System.out.println("< Up_Casting Test >");
		
		System.out.println("");
		
		// PetAnimal pa = new Animal(); // 후손 <- 조상 : Down_Casting - Error
		Animal2 an1 = new PetAnimal(); // 조상 <- 후손 : Up_Casting
		
		System.out.println("");
		
		
		an1 = new Reptile(); // 다형성 : 후손 교체 가능
		// < Animal 생성자 >
		
		System.out.println("");
		
		
		Animal2 an2 = new Animal2();
		// 이런 형식으로 생성된 an2는 PetAnimal 절대 될 수 없음
		// < Animal 생성자 >

		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		System.out.println("< an1과 an2 비교 >");
		
		an1 = dog;
		
		an2 = dog;
		// 조상 <- 후손 : Up_Casting, an1, an2에 정의된 만큼만 접근 가능
		// => Animal2 an2 = new Animal2(); 와 동일 효과
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		// < Test 3 - Down_Casting Test > - 명시적으로
		System.out.println("< Down_Casting Test >");
		
		dog = (PetAnimal)an1; // 컴파일 오류, 런타임 오류 없음 -> 명시적 Down_Casting 가능
		
		dog.legsPrint(5); // PetAnimal에 정의된 멤버 접근 가능
		
		
		//dog = (PetAnimal)an2;
		// - 컴파일 오류 없음, 런타임 오류 발생 - ClassCastException
		// - 위 Test 2 -> an2 = dog; 주석 후 출력하면 런타임 오류 확인 가능함.
		// - 그러므로 instanceof 연산자로 확인 후 Down_Casting 적용
		
		
		if (an2 instanceof PetAnimal) {
			dog = (PetAnimal)an2;
			System.out.println("** dog는 PetAnimal입니다. **"); // 출력됨
		} else
			System.out.println("** dog는 PetAnimal이 될 수 없습니다. **");
		
		System.out.println("");
			 
	//-------------------------------------------------------------------------------
		
		// < 인스턴스의 Class Type 출력하기 >
		// - Object에 정의된 getClass()메서드 이용
		System.out.println("** dog의 Class Type = " + dog.getClass().getName());
		System.out.println("** an1의 Class Type = " + an1.getClass().getName());
		System.out.println("** an2의 Class Type = " + an2.getClass().getName());
		
		System.out.println("\n < Program Stop >");
		
	} // main

} // class
