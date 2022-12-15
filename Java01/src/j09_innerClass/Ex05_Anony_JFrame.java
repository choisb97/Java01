package j09_innerClass;

import java.awt.Button;

/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/
import java.awt.event.*;
// import 시에 클래스명 대신 * 사용가능

import javax.swing.JFrame;

// < 익명 클래스의 활용 예 >
// - 이벤트 리스너를 이용하여 종료버튼 만들기

public class Ex05_Anony_JFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	// JFrame 사용 시 객체직렬화...? 상수.. IO.. 나중에 다시 설명해주신다고 함.

	public static void main(String[] args) {

		// < UI 준비 >
		Ex05_Anony_JFrame ex05 = new Ex05_Anony_JFrame();
		Button btn = new Button("Stop");
		
		ex05.setSize(300, 300);
		ex05.add(btn);
		ex05.setVisible(true);

		/*
		// < 1. 이벤트 리스너에 Inner(익명) 클래스 적용 > - 인스턴스 생성 후 익명클래스 작성하고 매개변수로 전달
		ActionListener ac = new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// => Button btn에서 발생된 이벤트인지 확인 후 종료
				if (e.getActionCommand().equals("Stop"))
					System.exit(0); // 대부분 일회성으로 사용
			} // m_actionPerformed
			
		}; // anony_actionPerformed
		
		btn.addActionListener(ac);
		// button에 리스너로 ac( => 작성된 익명클래스를 매개변수로 전달)을 사용하겠다는 의미
		*/
		
		
		// < 2. 매개변수 위치에 익명 클래스를 직접 작성 > - 인스턴스 없이 직접 익명클래스를 매개변수에 작성
		// =>  많이 사용된다.
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// => Button btn에서 발생된 이벤트인지 확인 후 종료
				if (e.getActionCommand().equals("Stop"))
					System.exit(0); // 대부분 일회성으로 사용
			} // m_actionPerformed
			
		}); // anony_actionPerformed -> 매개변수 끝에는 세미콜론(;) 필요 없음.
		
	} // main

} // class
