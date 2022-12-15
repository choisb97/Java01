package j02_ifSwitch;

// 이상(>=), 이하(<=), 초과(>), 미만(<)

public class Ex02_ifelseif {

	public static void main(String[] args) {

		int score = 97;

		// < 점수 이용해서 등급 처리하기 >
		// score 90 이상 : A, 80 이상 : B, 70 이상 : C, 60 이상 : D, 나머지 : F

		char grade;

		if (score >= 90) {
			grade = 'A';
			System.out.println("****우수 학생****");
		} else if (score >= 80)
			grade = 'B';
		else if	(score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		else {
			grade = 'F';
			System.out.println("**재시험 대상 학생**");
		}
		// if 부터 else 까지를 한 문장으로 쭉 읽어 내려옴.

		System.out.println("grade1 : " + grade);

		System.out.println("--------------------");

		//--------------------------------------------------------

		// < 비교 1 >

		if (score >= 90) 
			grade = 'A';
		if (score >= 80) 
			grade = 'B'; // int score = 99 가 80보다 크거나 같음에 해당하기 때문에 'B' 출력.
		if (score >= 70) 
			grade = 'C';
		if (score >= 60) 
			grade = 'D';
		else 
			grade = 'F';
		// 각각 한 문장으로 확인하여 비교하며 내려오다가 int score 값이 60이상이기 때문에 'D' 값으로 출력.

		System.out.println("grade2 : " + grade);

		System.out.println("--------------------");

		//--------------------------------------------------------

		// < 비교 2 >
		// => 중첩 if 구문 (if문 내에 if문 포함)

		if (score >= 90) { // 만약 score 가 90 이상인데
			if (score == 100) 
				System.out.println("*****우수 장학생*****"); // score 가 100이면 우수장학생
			grade = 'A';
		} else { // 그게 아니고
			if (score >= 80) 
				grade = 'B'; // 만약 score 가 80 이상이면 B
			else {
				if (score >= 70) 
					grade = 'C';
				else {
					if (score >= 60) 
						grade = 'D';
					else 
						grade = 'F';
				} // 'C'
			} // 'B'
		} // 'A'

		System.out.println("grade3 : " + grade);

	} // main

} // class
