package j08_AbsInterface;

/*
 < interface 2 >
 1) 인터페이스와 인터페이스 관계
  - 인터페이스 간의 상속(extends) 가능.
  - 다중상속(부모 여러개 허용), 계층적 상속 모두 가능
 
 2) 클래스와 인터페이스 관계
  - 다중 구현(implements) 가능
  - 클래스가 클래스를 상속(extends) 받으면서 동시에
    인터페이스를 구현(implements, 다중구현도 포함)하는 것 가능
*/


interface Inter1 {
	float PI = 3.1415f; // public static final 생략
	int getA(); // public abstract 생략
} // i_Inter1


interface Inter2 {
	int getB(); // public abstract 생략
} // i_Inter2


interface Inter3 extends Inter1, Inter2 {
	float getC(); // public abstract 생략
} // i_Inter3


/*
 < 복수의 interface를 다중구현(implements)한 클래스 >
 Inter3이 Inter1과 Inter2를 상속받아 Inter3만 써도 됨.
*/
// == class MultiInter implements Inter1, Inter2, Inter3 {
class MultiInter implements Inter3 {
	
	MultiInter(){
		System.out.println("< MultiInter Default 생성자 >");
	} // MultiInter default
	
	int a = 123,
		b = 100;
	
	// Override 메서드에 public 써야 됨
	// -> class의 default는 package이기 때문에 Interface의 default인 public보다 범위가 좁아서 Error
	@Override
	public int getA() {
		return a;
	}
	
	
	@Override
	public int getB() {
		return b;
	}
	
	
	@Override
	public float getC() {
		return (a + b) * PI;
	}
	
} // c_MultiInter

//------------------------------------------------------------------------------------

// < class extends와 interface implements(다중구현) 동시 구현 가능 >

class Add {
	
	int addNum(int a, int b) {
		return (a + b);
	} // addNum_a, b
	
} // c_Add


// class MultiExIm implements Inter1, Inter2, Inter3 extends Add  { -> Error
// => extends와 implements 동시 구현 시 순서는 extends 먼저하고 implements 해야 한다.
class MultiExIm extends Add implements Inter1, Inter2, Inter3 {
	
	MultiExIm() {
		System.out.println("< MultiExIm Default 생성자 >");
	} // MultiExIm default
	
	int a = 123,
		b = 100;
		
	@Override
	public int getA() {
		return a;
	}
		
		
	@Override
	public int getB() {
		return b;
	}
		
		
	@Override
	public float getC() {
		//return addNum(a, b) * PI;
		return (a + b) * PI;
	}
	
	// class Override는 선택, 추상(Abstract)class, interface는 Override 필수
	
} // MultiExIm -> Extends, Implements


//===================================================================================

public class Ex03_MultiTest {

	public static void main(String[] args) {

		// < Test 1 >
		MultiInter m1 = new MultiInter();
		
		System.out.printf("** m1 = getA = %d, getB = %d, getC = %f \n",
				m1.getA(), m1.getB(), m1.getC());
		
		System.out.println("");
		
		
	//-------------------------------------------------------------------------------
		
		// < Test 2 >
		MultiExIm m2 = new MultiExIm();
		
		System.out.printf("** m2 = getA = %d, getB = %d, getC = %f \n",
				m2.getA(), m2.getB(), m2.getC());
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		/*
		 < Test 3 : 다형성 적용 >
		 Inter1 in1 = new MultiInter(); // Inter1에 정의된 만큼만 접근 가능 -> getA만 OK
		 Inter2 in1 = new MultiInter(); // Inter2에 정의된 만큼만 접근 가능 -> getB만 OK
		 
		 Inter3 in1 = new MultiInter(); // OK -> MultiInter(), MultiExIm() 가능
		 => Inter3이 Inter1, Inter2를 상속받아서 모두 포함하고 있기 때문에 getA, B, C 전부 접근 가능
		*/
		
		 Inter3 in1 = new MultiExIm(); // MultiInter(), MultiExIm() 클래스 교체 가능

		System.out.printf("** m1 = getA = %d, getB = %d, getC = %f \n",
				in1.getA(), in1.getB(), in1.getC());
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		// < Test 4 : instanceof >
		
		if (m1 instanceof Inter1)
			System.out.println("** m1은 Inter1입니다. **");
		else
			System.out.println("** m1은 Inter1이 아닙니다. **");
		
		
		if (m1 instanceof Inter2)
			System.out.println("** m1은 Inter2입니다. **");
		else
			System.out.println("** m1은 Inter2이 아닙니다. **");
		
		
		if (m1 instanceof Inter3)
			System.out.println("** m1은 Inter3입니다. **");
		else
			System.out.println("** m1은 Inter3이 아닙니다. **");
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		/*
		 < interface들과 무관한 Add클래스 Test >	
		 => 비교 대상이 interface인 경우에는 컴파일 오류 없고, 런타임 시 비교 결과 (적합성 여부) 알려줌
		    그러므로 instancof를 이용해서 적합성 확인 필요!
		 => Inter3 in = new Add(); -> Error
		*/
		
		Add add = new Add();
		
		if (add instanceof Inter3)
			System.out.println("** add는 Inter3입니다. **");
		else
			System.out.println("** add는 Inter3이 아닙니다. **");
		
		System.out.println("");
		
		
		if (m2 instanceof Add)
			System.out.println("** m2는 Add의 인스턴스입니다. **");
		else
			System.out.println("** m2는 Add의 인스턴스가 아닙니다. **");
		// MultiExIm m2 = new MultiExIm
		// Add => MultiExIm
		
		/*
		instanceof의 비교대상이 클래스일 때 false인 경우 컴파일 오류
		
		if (m1 instanceof Add) // 비교대상 => class Add
			System.out.println("** m1는 Add의 인스턴스입니다.");
		else
			System.out.println("** m1는 Add의 인스턴스가 아닙니다.");
		*/
		
	} // main

} // class
