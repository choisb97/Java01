package j12_Exception;

/*
 < try ~ catch ~ finally >
 - finally 블럭은 무조건 실행 
*/

public class Ex03_finally {

	public static void main(String[] args) {
		
		int[] price = {100, 200, 300};
		
		// < 1. 정상실행 >
		//for (int i = 0; i < price.length; i++) {
		
		
		// < 2. Exception, finally Test >
		// => ArrayIndexOutOfBoundsException, continue, break, return
		for (int i = 0; i <= price.length; i++) { // ArrayIndexOutOfBoundsException
		
			try {
				if (i == 3) 
					continue; // i가 3일 때 이하를 동작하지 않고 다음 반복으로 넘어감
						      // -> exception X, finally O, Program 종료 O
				
				if (i == 2)
					break; // i가 2일 때 이하를 동작하지 않고 반복문 종료
						   // -> exception X, finally O, Program 종료 O
				
				if (i == 1)
					return; // i가 1일 때 더이상 동작하지 않고 메서드 종료 (void 메서드의 경우)
							// -> exception X, finally O, Program 종료 X
				
				System.out.printf("\n** price[%d] = %d \n", i, price[i]);
			} catch (Exception e) {
				System.out.println("\n** Exception => " + e.toString());
			} finally {
				System.out.println("** finally : 무조건 실행 => i = " + i);
			}
			System.out.println("** for_endLine => " + i);
		} // for
		
		System.out.println("\n< Program 정상 종료 >");
		
	} // main

} // class
