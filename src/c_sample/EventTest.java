package c_sample;

import java.awt.*; //모든거 포함= class만
import java.awt.event.*; //event는 폴더

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * 화면(JFrame)에 '확인'버튼 하나 출력
 */

public class EventTest {

	//멤버변수 선언
	JFrame f;
	JButton jbt;

	
	// 생성자함수 생성하기
	EventTest() {
		
		// 객체 생성하기
		f = new JFrame();
		jbt = new JButton("확인");
		
		
	//(2) 핸들러 객체 생성 	
		MyHandler hdlr = new MyHandler();
	//(3) 이벤트 발생할 컴포넌트와 연결	
		jbt.addActionListener(hdlr); //jbt 눌렀을때 이벤트 vjm이 불러줌

	}
    
	//이너클래스 >> ActionListener 상속받기
	//(1) 이벤트 핸들러 만들기
	//    핸들러 -이벤트 처리 클래스
	class MyHandler implements ActionListener {
		@Override  // 그리고 오버라이딩 (오른쪽 버튼 클릭 후 그 밑의 메소드 호출하는듯?)
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "이벤트 발생");
		}   
		
	}
	
	
	// 클래스명이랑 다르게,, 메소드 생성하기
	public void addLayout() { 

		
		
		

		// 레이아웃 설정
		f.setLayout(new FlowLayout());

		
		// 버튼
		f.add(jbt);

		
		// 화면 출력
		f.setBounds(100, 100, 500, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		EventTest event = new EventTest();
		event.addLayout();

	}

}
