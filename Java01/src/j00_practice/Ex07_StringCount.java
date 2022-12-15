package j00_practice;

/*
 < 문자열 내 p와 y의 개수 >
 - 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. 
   s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return하는 solution를 완성하세요.
   'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 
   단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

 - 제한사항 : 문자열 s의 길이 : 50 이하의 자연수
			  문자열 s는 알파벳으로만 이루어져 있습니다.
			  
 - 입출력 예)
   "pPoooyY" - true
   "Pyy" - false
*/

public class Ex07_StringCount {
	
	boolean stringcount(String s) {
		

		boolean answer = true;
		int p = 0;
		int y = 0;
		
		// p와 y 개수
		for (int i = 0; i < s.length(); i++) {
			// charAt으로 입력받은 String s를 한 글자씩 확인
			if (s.charAt(i) == 'p' || s.charAt(i) == 'P')
				p++;
			else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y')
				y++;
					
		} // for
		
		if (p != y)
			answer = false;

		return answer;
	}

	public static void main(String[] args) {
		
		Ex07_StringCount sc = new Ex07_StringCount();
		
		System.out.println("pPoooyY => " + sc.stringcount("pPoooyY"));
		System.out.println("Pyy => " + sc.stringcount("Pyy"));
		System.out.println("Ppopyy => " + sc.stringcount("Ppopyy"));
		System.out.println("PpYopyy => " + sc.stringcount("PpYopyy"));

	} // main

} // class
