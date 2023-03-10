package j08_AbsInterface;

/*
 < ** 캡슐화(Encapsulation) ** >
 1. 은닉 (보호) : 접근 제어자를 이용
 => 외부로부터 데이터를 보호하고,
    내부적으로만 사용되는 부분은 감추어 준다 
 => 접근 제어자 : private < default <  protected < public

 2. 단위 기능 모듈화
 => 세분화 되어있는 모듈을 하나의 기능으로 처리할 수 있도록 묶어준다.
 => 종합 감기약 처럼 
 => 세분화 되어있는 모듈을 사용하면서 호출 순서에 따른 오류 등
    발생 가능한 논리적 오류를 예방하고, 생산성 및 유지보수에 유리     

 < 실습 >
 감기 증상 : 두통, 콧물, 몸살
*/


class HeadacheCap {

	void take() {
		System.out.println(" 두통 해결 ~~ ");
	}

} // c_HeadacheCap


class SinivelCap {

	void take() {
		System.out.println(" 콧물 해결 ~~ ");
	}

} // c_SinivelCap


class BodyPainCap {

	void take() {
		System.out.println(" 몸살 해결 ~~ ");
	}

} // c_BodyPainCap

//-------------------------------------------------------------------------------------
/*
 < 환자 1. BadCase Encapsulation >
 => 증상별 복용순서에 따라 복용
 => 세분화 되어있는 모듈을 직접 사용하는 경우
*/
class ColdPatient {
	
	void takeHead(HeadacheCap hcap) {
		hcap.take();
	}
	
	void takeSinivel(SinivelCap scap) {
		scap.take();
	}
	
	void takeBody(BodyPainCap bcap) {
		bcap.take();
	}
	
} // c_ColdPatient

//-------------------------------------------------------------------------------------
/*
 < 환자 2. GoodCase Encapsulation >
*/
class TotalCap {
	
	// 인스턴스는 멤버변수로 정의 가능
	HeadacheCap hcap = new HeadacheCap();
	SinivelCap scap = new SinivelCap();
	BodyPainCap bcap = new BodyPainCap();
	// 선언과 동시에 초기화하는 것과 동일 (전역변수)
	// String name = "홍길동"; 과 같음

	
	// 복용 순서대로 작성해놓음
	void take() {
		hcap.take();
		scap.take();
		bcap.take();
	}
	
} // c_TotalCap


class NewPatient {
	
	void takeTotal(TotalCap tc) {
		tc.take();
	} // takeTotal
	
} // c_NewPatient


//=====================================================================================

public class Ex09_Encapsulation {

	public static void main(String[] args) {
		
		/*
		 < 환자발생 1. 'BadCase' Encapsulation >
		 => 인스턴스 생성, 메서드 호출
	     => 단점 : 메서드 호출 순서 등 오류 발생 가능
	     => 컴파일오류, 런타임오류, 논리적오류(Logical Error)의 확률이 높아짐   
	    */
		System.out.println("< 'BadCase' Encapsulation >");
		
		ColdPatient cp = new ColdPatient();
		
		cp.takeHead(new HeadacheCap());
		cp.takeSinivel(new SinivelCap());
		cp.takeBody(new BodyPainCap());
		
		System.out.println("");
		
	//---------------------------------------------------------------------------------
		
		/*
		 < 환자 2. 'GoodCase' Encapsulation >
		*/
		System.out.println("< 'GoodCase' Encapsulation >");
		
		NewPatient np = new NewPatient();
		
		np.takeTotal(new TotalCap());
		
		
	} // main

} // class
