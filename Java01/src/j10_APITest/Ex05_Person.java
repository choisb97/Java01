package j10_APITest;

import java.util.Calendar;

/*
 < Person >
 - 주민등록번호, 이름을 전달받으면
   주민등록번호를 이용해서 age, 성별을 set하고
   info 출력하기
   
 - 멤버필드(private) : idNo(String), name(String), age(int), gender(char)
 - 생성자 2개
   * default
   * 주민등록번호, 이름을 매개변수로 전달받아 초기화
    -> 나이 계산, 성별도 찾아서 set
 - setter/getter
   이름만 수정 가능, -> setter
   모든 필드를 사용가능 (그러나 주민등록번호 뒷자리는 * 표시) -> getter
   
 - infoPrint()
 - toString은 오버라이딩 - Object 오버라이딩으로 제공되는 서식 사용하기
 
 < info >
 - 이름 : 000
 - 번호 : 970517-*******
 - 나이 : 26세
 - 성별 : "남" or "여"
*/

//========================================================================================

public class Ex05_Person {
	
	// 1) 멤버필드(private)
	private String idNo;
	private String name;
	private int age;
	private char gender;
	
//----------------------------------------------------------------------------------------
	
	// 2) 생성자 2개
	// => default 생성자
	Ex05_Person() {
		System.out.println("< Ex05_Person Default 생성자 >");
	} // Ex05_Person default

	
	// => 초기화 생성자(주민등록번호, 이름)
	public Ex05_Person(String idNo, String name) {
		System.out.println("< Ex05_Person 초기화 생성자 >");
		this.idNo = idNo;
		this.name = name;
		
		
		// inNO : 6자리 - 7자리 총 14자리 -> 900909-1022333, 010101-3011222
		// < 성별 >
		this.gender = idNo.charAt(idNo.indexOf("-") + 1);
		          // charAt으로 한 글자 추출하는데 indexOf "-" + 1 => - 다음 첫 번째 글자
		
		
		// age : 올 해 - 태어난 해
		// < 나이 >
		// => 올 해 : Date(지원X), Calendar(많이 사용)
		// => 태어난 해 : idNo의 앞 두 자리 + 뒤 첫 자리
		         // (1, 2 -> + 1900 / 3, 4 -> + 2000)
		
		// < ** Calendar 사용 >
		// Calendar now = new Calendar(); => XXXX
		/*
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		*/
		// now 인스턴스 없이 한 줄로!
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		age = year - Integer.parseInt(idNo.substring(0, 2));
		
		if (gender == '1' || gender == '2') // "-"다음 첫 번째 글자(gender)가 '1'이거나 '2'이면
			age -= 1900; // age = age - 1900
		else 			 // 아니면
			age -= 2000; // age = age - 2000
		
	} // Ex05_Person_idNo, name
	
//----------------------------------------------------------------------------------------
	
	// 3) setter - 이름만 수정 가능
	public void setName(String name) {
		this.name = name;
	}
	
	
	// 4) getter
	public String getIdNo() { // 주민등록번호 뒷자리는 * 표시
		// 970517-2345678 -> 970517-*******
		if (idNo != null) // 만약 idNo가 null이 아닌(!) 경우
			return idNo.substring(0, idNo.indexOf("-")) + "-*******";
		// idNo의 첫 글자 ~ "-" 이전 글자까지 + "-*******"
		else
			return null;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public char getGender() {
		if (gender == '1' || gender == '3') // 만약 gender가 1이거나 3인 경우
			return '남';
		else if (gender == '2' || gender == '4') // 아니면 만약 gender가 2이거나 4인 경우
			return '여';
		else
			return ' '; // char Type은 '' 빈 문자 허용하지 않음 -> ' ' 공백 필요.
	}

//----------------------------------------------------------------------------------------

	// 5) 출력
	// => info
	public void infoPrint() {
		System.out.println("< info Print >");
		System.out.println("** 주민등록번호 : " + getIdNo());
		System.out.println("** 이    름 : " + getName());
		System.out.println("** 나    이 : " + getAge());
		System.out.println("** 성    별 : " + getGender());
	} // infoPrint



	// => toString
	@Override
	public String toString() {
		return "Ex05_Person [ idNo = " + idNo + ", name = " + name 
							+ ", age = " + age + ", gender = " + gender + " ]";
	} // toString => 개발자용 (입력한 원시 Data 그대로 출력)
	
	
} // class
