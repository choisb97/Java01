package j03_forWhile;

// 무한반복(Infinity Loop)

public class Ex03_infinityLoop {

	public static void main(String[] args) {

		// 1) for
		System.out.println("< Infinity Loop Test - for >");

		int count = 0;
		
		for (;;) { 	// 무조건(조건이 없음)
			count++;
			
			System.out.println("count : " + count);
		
			if (count >= 100) break; // 100이상이면 break -> 현재 진행중인 반복문 종료
		}
		
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
		
		//=========================================================
		
		// 2) while
		System.out.println("< Infinity Loop Test - while >");
		
		count = 0;
		
		while(true) {	// true이면 무조건 진행
			count++;
			
			System.out.println("count : " + count);

			if (count >= 100) break;
		}
		
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
		
		//=========================================================
		
		// 3) do ~ while
		System.out.println("< Infinity Loop Test - do ~ while >");
		
		count = 0;
		
		do {
			count++;
			
			System.out.println("count : " + count);
			
			if (count >= 100) break;
		} while(true);	// true이면 무조건 진행
		
		System.out.println("-----------------------------------");
		
		// < 조건문 무조건 실행 >
		
		if (true) System.out.println("**TRUE**");
		// else System.out.println("**FALSE");
		// if (true) 무조건 true 실행되기 때문에 else 는 "Dead Code"
		
		
	} // main

} // class
