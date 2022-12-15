package j00_practice;

/*
 < 정수 내림차순으로 배치하기 >
 - 정수 n을 매개변수로 입력받습니다.
   n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
   예를들어 n이 118372면 873211을 리턴하면 됩니다.
   
 - 제한 조건 : n은 1이상 8000000000 이하인 자연수입니다.
 
 - 입출력 예
    n = 118372 / return = 873211
*/

public class Ex08_intDesc {

    public long intdesc(long n) {
    	
    	String answer = "";
    	String str = Long.toString(n);
    	
    	int[] arr = new int[str.length()];

    	// lont type의 숫자를 int 배열로 옮긴다.
    	for (int i = 0; i < str.length(); i++) {
    		String s = str.substring(i, i+1);
            arr[i] = Integer.parseInt(s);
    	} // for_i
    	
    	// 내림차순 정렬
    	for (int j = 0; j < str.length() - 1; j++) {
    		for(int i = 0; i < str.length() - 1; i++) {
    			
    			if (arr[i] < arr[i+1]) {
    				int tmp = arr[i+1];
    				arr[i+1] = arr[i];
    				arr[i] = tmp;
    			} // if
    			
    		} // for_i
    	} // for_j
    	
    	for(int i = 0; i < str.length(); i++){
            answer += arr[i];
        } // for_i
    	
        return Long.parseLong(answer);
        
    } // intdesc
	
	public static void main(String[] args) {

		Ex08_intDesc id = new Ex08_intDesc();
		
		System.out.println("118372 => " + id.intdesc(118372));
		System.out.println("517976592 => " + id.intdesc(517976592));
		
	} // main

} // class
