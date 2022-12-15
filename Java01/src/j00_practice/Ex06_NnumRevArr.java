package j00_practice;

/*
 < 자연수 뒤집어 배열로 만들기 >
  - 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
    예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
  
  - 제한조건 : n은 10,000,000,000이하인 자연수입니다.
  
  - 입출력 예)
    n = 12345
    return = [5, 4, 3, 2, 1]
*/

class Ex06_NnumRevArr {
	
	public int[] numrevarr(long n) {
		
		if (n > 10000000000L) {
			return null;
		}
		
		// 문자열 + 숫자 = 문자열
		String s = "" + n;
		
		int[] answer = new int[s.length()];
		
		int i = 0;
		
		while (n > 0) {
			
			answer[i] = (int)(n % 10);
			/*
			 1) 12345 % 10 = 5
			 2) 1234 % 10 = 4
			 3) 123 % 10 = 3
			 4) 12 % 10 = 2
			 5) 1 % 10 = 1 
			*/
			
			n /= 10;
			/*
			 12345 = 1234
			 1234 = 123
			 123 = 12
			 12 = 1
			 1 = 0 (0.1) 
			*/
			
			i++;
		} // while
		
		return answer;
		
	} // numrevarr

	public static void main(String[] args) {

		Ex06_NnumRevArr nnra = new Ex06_NnumRevArr();
		
		System.out.println(nnra.numrevarr(12345));
		
	} // main

} // class
