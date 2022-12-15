package j00_practice;

/*
 < 분수(fraction)의 더하기 >
 - 첫 번째 분수의 분자와 분모를 뜻하는 denum1, num1, 두 번째 분수의 분자와 분모를 뜻하는 denum2, num2가 매개변수로 주어집니다.
   두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 함수를 완성해보세요.
*/

public class Ex09_AddFraction {
	
	public int[] addfraction(int denum1, int num1, int denum2, int num2) {
		int[] answer = {};
        return answer;
	}
		/*
		// 입력받은 두 분모의 최대공약수(Greatest Common Divisor)를 구한다.
		int gcd = gcd(num1, num2);
		
		// 입력받은 두 분모의 최소공배수(least(=lowest) common multiple)를 구한다.
		int lcm = lcm(num1, num2, gcd);
		
		// 분모에 어떤 수를 곱해야 최소공배수가 나오는지 확인한 후 분자를 분모에 맞춰준다.
		int mul1 = lcm / num1;
		denum1 *= mul1;
		int mul2 = lcm / num2;
		denum2 *= mul2;
		
		// 두 분자를 더한다.
		int denum = denum1 + denum2;
		
		// 기약분수를 구해야 하므로, 합한 분자와 분모의 최대공약수를 구한다.
		int gcd2 = gcd(denum, lcm);
		
		// 최대공약수로 나눠준다.
		int[] answer = {denum / gcd2, lcm / gcd2};
		
        return answer;
        
    } // addfraction
	
//------------------------------------------------------------------------------------------

	// 최대공약수(Greatest Common Divisor)
	public int gcd(int num1, int num2) {
		
		boolean stop = false;
		int temp1 = num1;
		int temp2 = num2;
		
		while (!stop) {
			if (temp2 == 0) {
				break;
			} // if
			
			if (temp2 != 0 || temp1 % temp2 != 0) {
				int temp = temp1;
				temp1 = temp2;
				temp2 = temp % temp2;
			} else
				stop = true;
		} // while
		
		return temp1; 
		
	} // gcd
	
//------------------------------------------------------------------------------------------
	
	// 최소공배수(least(=lowest) common multiple)
	public int lcm(int num1, int num2, int gcd) {
		return (num1 * num2) / gcd;
	} // lcm
	*/
//==========================================================================================
	
	public static void main(String[] args) {
		
		Ex09_AddFraction af = new Ex09_AddFraction();

		System.out.println(af.addfraction(1, 2, 3, 4));
		
	} // main

} // class
