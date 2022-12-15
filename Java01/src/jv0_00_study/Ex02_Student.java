package jv0_00_study;

//j14_generic -> Ex01_GenStore에 사용

public class Ex02_Student extends Ex01_Person{

		private int java;
		private int html;

		public Ex02_Student (){ 
			// 특별하게 조상생성자를 명시하지 않음
			// => 조상의 default 자동 호출됨
			System.out.println("** Student Default 생성자 **");
		}

		public Ex02_Student(String idNo,String name,int java, int html) {
			super(idNo,name);  // 조상 명시적 호출
			this.java = java;
			this.html = html;
			System.out.println("** Student 초기화 생성자 **");
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
		public void infoPrint() {
			super.infoPrint();
			System.out.println("Java : "+getJava());
			System.out.println("Html : "+getHtml());
		}
		@Override
		public String toString() {
			return super.toString()+", java="+java+", html="+html+"] \n";
		}

	}//Student