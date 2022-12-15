package j01_basic;

// < XOR 연산자를 사용한 암호화(Encryption) / 복호화(Decryption) 예제 >
// - XOR (^) : 같으면 0, 다르면 1

public class Ex04_Oper03_Encry {

	public static void main(String[] args) {

		int p = 1234567,
			t = 0;
		int e = 0x1A253B65; // 16진수(0x 로 시작) 438647653
		
		System.out.println("** 암호화 전 password : " + p);
		
		System.out.println("------------------------------");
		
		// < 암호화 (Encryption) >
		t = p ^ e;
		
		System.out.println("** 암호화 된 password : " + t);
		
		System.out.println("------------------------------");
		
		// < 복호화 (Decryption) >
		t = t ^ e;
		
		System.out.println("** 복호화 된 password : " + t);
		
	}	// main

}	// class
