package c_sample;

import java.awt.*; //모든거 포함= class만
import java.awt.event.*; //event는 폴더

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * 화면(JFrame)에 '확인'버튼 하나 출력
 */

public class EventTest3 {

	//멤버변수 선언
	JFrame f;
	JButton jbt;

	
	// 생성자함수 생성하기
	EventTest3() {
		
		// 객체 생성하기
		f = new JFrame();
		jbt = new JButton("확인3");
		
    //이너클래스 >> ActionListener 상속받기
    //(1) 이벤트 핸들러 만들기
    //    핸들러 -이벤트 처리 클래스	
	//(2) 핸들러 객체 생성 	
	//(3) 이벤트 발생할 컴포넌트와 연결	> 한번만 쓰니까 바로 객체 생성
		
		//앞으로 복사해서 사용할 것~~
		
		jbt.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "이벤트 발생3");
			}   
			
		}  );

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

		EventTest3 event = new EventTest3();
		event.addLayout();

	}

}
