package j05_classMethod;

/*
 < 접근제어자 >
 - 접근 범위 제한

 => public(프로젝트 전체) > protected(상속 + default) 
        > default : 입력 안 할 시 (해당 패키지 내)> private(해당 클래스 내)

 < 설정자(mutator) 와 접근자(accessor) >
 - 외부클래스 에서 변수에 직접 접근하지 못하도록 하고, 
   메서드를 통해서만 접근하도록 함
 => 그러면 변수에 값을 넣어주는 메서드 (설정자) 와
    변수의 값을 보여주는 메서드 (접근자) 가 필요함.

 => 설정자: 멤버변수 write, setXXX() 형식 -> setter
 => 접근자: 멤버변수 read, getXXX() 형식 -> getter

 => 메서드를 통해 접근하므로 변수값에 대한 Control 이 가능함
 => 필요에 따라서 setter , getter 를 적절하게 작성해서 외부에서의 접근을 조정할 수 있음

 Member : 접근범위 - default -> 해당 패키지(package) 내에서만 접근 가능
*/

class Member { 
	
	// < 접근제어로 Data 보호 >
	// - private : 해당 클래스 내에서만 접근 가능.
	// => 클래스 외부에서는 메서드를 통해 접근하도록 함.
	//    설정자(mutator)와 접근자(accessor)
	
	// 변수는 private
	private String id;
	private String name;
	private int age;
	
	// < 생성자 >
	// 우클릭 -> source -> Generate Constructor using Fields
	
	public Member() {} // 매개변수 없고, 실행문도 없음.
	// 같은 Member(어쩌구 저쩌구)가 있는 경우 컴파일러가 자동으로 넣어주지 못함.
	// Member(어쩌구 저쩌구) 하나도 없으면 필요한 경우 컴파일러가 기본생성자 Member() 자동 생성
	// 지금 당장 사용하지 않더라도 언제 사용할 지 모르기 때문에 기본생성자 넣어놔도 된다.
	
	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	} // Member
	
	//=======================================================================
	
	// < getter / setter >
	// => get + 변수명의 첫 글자를 대문자로 (낙타표기법) -> 예) getId, getName, getAge
	// => set + 변수명의 첫 글자를 대문자로 (낙타표기법) -> 예) setId, setName, setAge
	
	// 우클릭 -> source -> Generate Getters and Setters
	
	// 메서드는 public
	public void setId(String id) {

		if (id.contains("불량")) // id에 "불량"이라는 데이터가 포함되어 있으면 return
			return;
		
		this.id = id;
		// this = class Member private id
	
	} // setId

	public String getId() {
		return this.id;
		// this.id = 전역변수 id 라는 표기
	
	} // getId
	
	//----------------------------------------------------------------------
	
	public void setName(String name) {
		
		this.name = name;
	
	} // setName
	
	public String getName() {
		
		return this.name;
	
	} // getName

	
	//----------------------------------------------------------------------
	
	/*
	public void setAge(int age) {
		
		this.age = age;
		
	} // setAge
	
	public int getAge() {
		
		return this.age;
		
	} // getAge
	*/
	
	// 우클릭 후 Generate getters & setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//=======================================================================

	// < toString >
	// 우클릭 -> source -> Generate toString()
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
} // class Member


public class Ex09_MemberTest {

	public static void main(String[] args) {
		
		// < 생성자로 초기화 >
		Member m1 = new Member("banana", "홍길동", 20);
		System.out.println("* m1 = " + m1);
		// * m1 = Member [id=banana, name=홍길동, age=20]
		
		// m1.setId("orange");
		// System.out.println("* m1.id = " + m1.getId());
		
		m1.setName("김길동");
		
		// System.out.println("* m1.name = " + m1.name); // not visible
		// -> 멤버변수 직접 접근 불가능 (변수 보호)
		
		System.out.println("* m1.name = " + m1.getName());
		// * m1.name = 김길동
		
		System.out.println("--------------------------------------------------");
		
		//----------------------------------------------------------------------
		
		// < setter로 초기화 >
		Member m2 = new Member();
		m2.setId("apple");
		m2.setName("스티브");
		m2.setAge(100);
		
		System.out.println("* m2 = " + m2);
		// * m2 = Member [id=apple, name=스티브, age=100]
		
		System.out.println("* age 합계 = " + (m1.getAge() + m2.getAge()));
		// * age 합계 = 120
	
	} // main

} // class
