package j14_generic;

/*
 < Enum 클래스 (java.lang.Enum) >
 - 모든 열거형의 조상
 - 열거형을 지원하는 다양한 메서드제공 
   values(), valueOf(), name(), ordinal() 등
   ordinal()은 열거형 상수가 정의된 순서를 정수로 반환 (0부터 시작)
   그러나 이 값은 내부적 용도이므로 열거형 상수의 값으로 사용하지 않는 것이 좋다.
   
 - Enum 클래스 header
   public abstract class Enum <E extends Enum <E>>
            implements Constable, Comparable <E>, Serializable {
            
 - 계층도
   Object -> Enum <E extends Enum <E>> : 추상클래스 : Direction
*/

enum Direction {
	EAST, WEST, SOUTH, NORTH
} // enum Direction

public class Ex06_enumMethod {

	public static void main(String[] args) {
		
		// < 1. 열거형 사용 >
		System.out.println("< 열거형 사용 >");
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "SOUTH");
		Direction d4 = Direction.NORTH;
		
		System.out.printf("d1 = %s, d2 = %s, d3 = %s, d4 = %s \n", d1, d2, d3, d4);
		
	//----------------------------------------------------------------------------------------
		
		// < 2. 배열 처리 >
		System.out.println("\n< 배열 처리 >");
		
		Direction[] ds = Direction.values();
		
		for (Direction d : ds) {
			System.out.printf("%s = %d \n", d.name(), d.ordinal());
		} // eachfor
		
		/*
		 < ordinal() 메서드 >
		 - 전체 중 해당 열거 객체가 몇 번째인 지 알려준다. (순서는 0부터 시작)
		*/
		System.out.println("\n** Enum - ordinal() 예시** ");
		System.out.println(d1.ordinal()); // 0
		System.out.println(d2.ordinal()); // 1
		
	//----------------------------------------------------------------------------------------
	
		// < 3. 열거형 상수간의 비교 >
		// - "==" 비교 가능 (그러므로 equals()보다 빠른 성능) -> 결과 같음
		// - 위 외의 관게 연산자는 사용 불가능.
		// - compareTo는 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수
		//   ordinal() 값으로 비교.
		System.out.println("\n< 열거형 상수간의 비교 >");
		
		//d2 = Direction.EAST; // 비교 Test
		
		// '==', .equals => Boolean(%b) - True or False
		System.out.printf("d1 == d2 : %b \n", d1 == d2); // true
		System.out.printf("d1 == d3 : %b \n", d1 == d3);

		System.out.printf("\nd1.equals(d2) : %b \n", d1.equals(d2)); // true
		System.out.printf("d1.equals(d3) : %b \n", d1.equals(d3));
		
		// compareTo => Integer(%d) - 0 or +n or -n
		System.out.printf("\nd1.compareTo(d2) : %d \n", d1.compareTo(d2));
		System.out.printf("d2.compareTo(d1) : %d \n", d2.compareTo(d1));

		System.out.printf("d1.compareTo(d3) : %d \n", d1.compareTo(d3));
		System.out.printf("d1.compareTo(d4) : %d \n", d1.compareTo(d4));
		
		System.out.printf("d2.compareTo(d3) : %d \n", d2.compareTo(d3));
		System.out.printf("d2.compareTo(d4) : %d \n", d2.compareTo(d4));
		
	//----------------------------------------------------------------------------------------
		
	} // main

} // class
