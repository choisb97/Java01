package jv1_2345_test; // p96

// 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
// 만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면,
// 13개의 바구니가 필요할 것이다.
// int numOfBucket = ; 에 알맞은 코드를 넣으시오.

// 결과 : 필요한 바구니의 수 : 13

public class Chap03_04 {

	public static void main(String[] args) {

		int numOfApples = 123, // 사과의 수
			sizeOfBucket = 10; // 바구니 하나에 담을 수 있는 사과의 갯수

		// int numOfBucket = ; 에 알맞은 코드를 넣으시오.
		int numOfBucket = numOfApples / sizeOfBucket + 
				       		(numOfApples % sizeOfBucket > 0 ? 1 : 0);
		// numOfApples / sizeOfBucket (나눈 값) +
		// numOfApples % sizeOfBucket(나머지)가 0보다 크면 바구니 한 개 추가, 아니면 0
		
		System.out.println("필요한 바구니의 수 : " + numOfBucket);
	}

}