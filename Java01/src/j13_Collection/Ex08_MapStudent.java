package j13_Collection;

import java.util.HashMap;

class Student {
	
	private String no;
	private String name;
	private int java;
	private int html;
	private int sum;
	
	Student(String no, String name, int java, int html) {
		
		this.no = no;
		this.name = name;
		this.java = java;
		this.html = html;
		this.sum = java + html;
		
	} // Student_no, name, java, html
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getJava() {
		return java;
	}


	public void setJava(int java) {
		this.java = java;
	}


	public int getHtml() {
		return html;
	}


	public void setHtml(int html) {
		this.html = html;
	}


	@Override
	public String toString() {
		
		return " Student [ no = " + no +", name = " + name + ", java = " + java 
				+ ", html = " + html + ", 합계 = " + sum + " ]\n";
		
	} // toString
	
} // c_Student

public class Ex08_MapStudent {

	public static void main(String[] args) {
		
		// 1. HashMap 정의
		HashMap<String, Student> sm = new HashMap<String, Student>();
		
	// ------------------------------------------------------------------------------------
		
		// 2. put
		sm.put("A001", new Student("A001", "홍길동", 70, 80));
		sm.put("A002", new Student("A002", "이재영", 100, 100));
		sm.put("A003", new Student("A003", "최수빈", 80, 85));
		sm.put("B001", new Student("B001", "홍영우", 75, 90));
		sm.put("B002", new Student("B002", "최보라", 85, 60));

	// ------------------------------------------------------------------------------------

		// 3. 수정, 삭제
		sm.get("B001").setName("우영우");
		sm.remove("A001");
	
	// ------------------------------------------------------------------------------------

		// 4. 출력 
		System.out.println(sm); // 출력은 임의의 순서로!
	
	} // main

} // class
