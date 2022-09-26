package a_sample;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BTest extends JFrame { //부모는 하나여야만 함
	
	JButton btn; //더 상속받을 수 없으니 객체 생성!
	
	
	
	// 상속받기 
	BTest() {
		super("나의 두번째창");
		btn = new JButton("확인2");
	}
	
	void addLayout() {
		//붙이기 작업(붙이고 출력해야함)
		add(btn);
		
		//화면출력 작업
		setBounds(100,100,500,350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		BTest b = new BTest();
		b.addLayout();
		
		
	}

}
