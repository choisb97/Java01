package j08_AbsInterface;

/*
 < 추상클래스와 intertrace의 활용 >
 - 일반적인 경우 사례
 - 실무에서는 interface가 많이 사용되고 (다중구현의 장점),  
   API의 계층도에서는 추상클래스도 많이 이용됨 

 < 과제 >
 - 게시판을 종류별로 10개 이상 만든다고 가정.
 - 기본 기능(interface) : insert, update, delete, listPrint, detail, replyInsert
 - 게시판 종류별로 : 일반게시판(i, u, d, l, detail, r), QnA(i, r, l), 공지사항(i, l, detail)
 - 모든 게시판은 interface를 구현해야 한다면
   게시판 종류에 따라 필요없는 메서드도 오버라이딩 해야함.
   이런 경우 interface를 구현하는 추상 클래스를 작성하고
   게시판은 이 추상클래스를 구현한다면 의무적 구현에서 벗어나 필요한 메서드만 구현할 수 있음.
*/


// < 추상메서드 >
interface Boardi {
	
	void insert();
	void update();
	void delete();
	void listPrint();
	void detail();
	void replyInsert();
	
} // i_Boardi


/*
 ** 추상클래스 : 일반메서드, 추상메서드
 
 < 추상클래스는 추상메서드를 포함할 수 있으므로 구현 의무 없음 >
 - 선택적으로 오버라이딩 가능
 - 의무구현 메서드는 추상메서드로 두고, 선택적 구현메서드들은 미리 구현해 놓음.
   그러므로 구현 클래스들의 의무구현 코드를 줄여줌.
*/
abstract class BoardA implements Boardi {
	
	@Override
	public void replyInsert() {
		
	}
	
	
	@Override
	public void delete() {
		
	}
	
	
	@Override
	public void detail() {
		
	}
	
	
	@Override
	public void update() {
		
	}
	
} // ac_BoardA

//-----------------------------------------------------------------------------------

// Boardi를 상속받았기 때문에 전부 구현해야 함
class QnABoard implements Boardi {
	
	QnABoard() {
		System.out.println("< QnABoard Default 생성자 >");
	} // QnABoard default
	
	@Override
	public void insert() {
		System.out.println("** QnA Insert **");
	}
	
	
	@Override
	public void listPrint() {
		System.out.println("** QnA List **");
	}
	
	
	@Override
	public void replyInsert() {
		System.out.println("** QnA replyInsert **");
	}
	
	
	@Override
	public void delete() {
		System.out.println("** QnA Delete **");
	}
	
	
	@Override
	public void detail() {
		System.out.println("** QnA Detail **");
	}
	
	
	@Override
	public void update() {
		System.out.println("** QnA Update **");
	}
	
	/*
	 @Override
	public void 어쩌구저쩌구() {
		// 의무 구현
	} 
	*/
	
} // c_QnABoard

//-----------------------------------------------------------------------------------

// => 추상클래스(BoardA)를 상속받도록 하여 의무를 줄여줌
class QnABoard2 extends BoardA {
	
	QnABoard2() {
		System.out.println("< QnABoard2 Default 생성자 >");
	} // QnABoard2 default
	
	@Override
	public void insert() {
		System.out.println("** QnA2 Insert **");
	} // 의무 구현
	
	
	@Override
	public void listPrint() {
		System.out.println("** QnA2 List **");
	} // 의무 구현
	
	
	@Override
	public void replyInsert() {
		System.out.println("** QnA2 replyInsert **");
	} // 선택 구현
	
} // c_QnABoard2

//-----------------------------------------------------------------------------------

class MyBoard extends BoardA {
	
	MyBoard() {
		System.out.println("< MyBoard Default 생성자 >");
	} // MyBoard default
	
	@Override
	public void insert() {
		System.out.println("** MyBoard Insert **");
	} // 의무 구현
	
	
	@Override
	public void listPrint() {
		System.out.println("** MyBoard List **");
	} // 의무 구현
	
	
	@Override
	public void detail() {
		System.out.println("** MyBoard Detail **");
	} // 선택 구현
	
} // c_MyBoard


//===================================================================================

public class Ex05_AbsInter {

	public static void main(String[] args) {
		
		// 좌측 : 조상 = 우측 : 후손
		// 조상의 범위보다 후손의 범위가 더 커야된다.
		// MyBoard의 조상인 BoardA가 모든 것을 포함하고 있어서 오류 아님.

		// 조상 Boardi가 가지고 있는 만큼만 사용 가능
		Boardi board = new QnABoard(); // Boardi의 후손들은 모두 우측에 대입할 수 있다.
		//           => MyBoard(), QnABoard(), QnABoard2()
		
		board.delete();
		board.detail();
		board.insert();
		board.listPrint();
		board.replyInsert();
		board.update();
		
		System.out.println("");
		
	//-------------------------------------------------------------------------------
		
		// QnABoard = implements Boardi(인터페이스 Boardi 받음) -> BoardA와는 무관
		// 그러나 BoardA를 상속받은 MyBoard, QnABoard2는 모두 가능
		
		// BoardA ba = new QnABoard(); => Error
		BoardA ba = new QnABoard2();
		
		ba.delete();
		ba.detail();
		ba.insert();
		ba.listPrint();
		ba.replyInsert();
		ba.update();
 
		System.out.println("");

	//-------------------------------------------------------------------------------

		BoardA ba2 = new MyBoard();
		
		ba2.delete();
		ba2.detail();
		ba2.insert();
		ba2.listPrint();
		ba2.replyInsert();
		ba2.update();
		
	} // main

} // class
