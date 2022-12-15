package jv1_67_test; // p.281, 282~283

// ** 연습문제 07_01 **
// 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)를 정의한 것이다.
// 섯다카드 20장을 담는 SutdaCard배열을 초기화하시오.
// 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고,
// 숫자가 1, 3, 8이ㄴ 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다.
// 즉, SutdaCard의 인스턴스 변수 isKwang의 값이 true이어야 한다.

// 결과 = 1K, 2, 3K, 4, 5, 6, 7, 8K, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,

//-----------------------------------------------------------------------------------

//** 연습문제 07_02 **

//연습문제 7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트하시오.

//주의 - Math.random()을 사용하는 경우 실행결과와 다를 수 있음.

//결과 = 1K
//		 7
//		 2, 6, 10, 1K, 7, 3, 10, 5, 7, 8, 5, 1, 2, 9, 6, 9, 4, 8K, 4, 3K,
//		 2

/*
1. 메서드명 : shuffle
	기능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다.(Math.random() 사용)
	반환타입 : 없음
	매개변수 : 없음
	
2. 메서드명 : pick
	기능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
	반환타입 : SutdaCard
	매개변수 : int index - 위치
	
3. 메서드명 : pick
	기능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다.(Math.random() 사용)
	반환타입 : SutdaCard
	매개변수 : 없음
*/

class SutdaDeck {
	// 배열 정의
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	// 생성자로 초기화
	SutdaDeck() {
		/*
		// (1) 배열 SutdaCard를 적절히 초기화 하시오.
		for (int i = 0; i < CARD_NUM; i++) {
			if (i == 0 || i == 2 || i == 7) {
				cards[i] = new SutdaCard(i + 1, true);
			} else {
				cards[i] = new SutdaCard(i % 10 + 1, false);
			}
		} // for
		*/
		
		// 쌤 풀이
		for (int i = 0; i < cards.length; i++) {
			
				int num = i % 10 + 1; // 10 % 10 == 0이기 때문에 + 1 함.
				// i = 0, 1, 2,...10,...19 / n = 1(0 + 1), 2,...1(0 + 1),...10(9 + 1)
				boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
				// i가 10보다 작고(&&) num이 1이거나(||) 3이거나(||) 8일 때
				
				cards[i] = new SutdaCard(num, isKwang);
				
		} // for
	} // SutdaDeck 생성자
	
//----------------------------------------------------------------------------------------
	// 연습문제 07_02
	// (1) 위에 정의된 세 개의 메서드를 작성하시오.

	// => Math.random() 사용
	//    맞교환 할 cards 배열의 인덱스 찾기
	void shuffle() {
		
		for (int i = 0; i < cards.length; i++) {
			int j = (int)(Math.random() * cards.length);
			
			SutdaCard temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		} // for
		
	} // shuffle


	SutdaCard pick(int index) {
		// index의 유효범위 확인 (0 ~ 19)
		if (index < 0 || index >= CARD_NUM) { // index > CARD_NUM - 1 해도 됨
			System.out.println("index 오류입니다.");
			return null;
		}
		return cards[index];
	
	} // pick_index
	

	// => Math.random() 사용
	SutdaCard pick() {
		
		int index = (int)(Math.random() * cards.length);
		
		// return cards[i];
		return pick(index);
		
	} // pick
	
} // c_SutdaDeck


class SutdaCard {
	
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	// info() 대신 Object클래스의 toString()을 오버라이딩 했다.
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
	
} // c_SutdaCard


//==============================================================================================

public class Chap07_01 {

	public static void main(String[] args) {
		
		System.out.printf("< 연습문제 7-1 > \n");
		
		SutdaDeck deck = new SutdaDeck();
		
		for (int i = 0; i < deck.cards.length; i++) {
			
			System.out.print(deck.cards[i] + ", ");
			
		} // for
		
	//----------------------------------------------------------------------------
		
		System.out.printf("\n\n< 연습문제 7-2 > \n");
		
		System.out.println("Before, pick(0) = " + deck.pick(0));
		System.out.println("Before, pick() = " + deck.pick());

		deck.shuffle();
		System.out.println("\n** shuffle **");
		
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ", ");
			
		System.out.println("\n\nAfter, pick(0) = " + deck.pick(0));
		System.out.println("After, pick() = " + deck.pick());
		
	} // main

} // class
