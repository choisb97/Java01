package jv1_67_test; // p.289

import java.awt.Frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// import java.awt.event.*; => 클래스명만 * 적용가능 -> java.awt.*; XXXX
// Window 관련 event가 많기 때문에 소량 사용 시 * 말고 그냥 클래스명을 사용하는 것이 바람직함

// 아래의 EventHandler를 익명 클래스(anonymous class)로 변경하시오.


/*
class EventHandler extends WindowAdapter {
	
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	} // m_windowClosing

} // c_EventHandler
*/


//=============================================================================

public class Chap07_09 {

	public static void main(String[] args) {
		
		Frame f = new Frame();
		
		// f.addWindowListener(new EventHandler());
		// => 익명클래스(Anonymous class)로 변경
		
		f.addWindowListener(new WindowAdapter() { // 조상인 WindowAdapter로 직접 생성
			
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			} // m_windowClosing
			
		}); // anony_addWindowListener

	} // main

} // class

