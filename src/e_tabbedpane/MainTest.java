package e_tabbedpane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class MainTest {

	JFrame f;
	JButton btn;
	JLabel la;
	
	PanelA panela;
	PanelB panelb;
	PanelC panelc;
	
	
	MainTest() {
		f = new JFrame("");
		btn = new JButton("확인");
		la = new JLabel("data");
		
		panela = new PanelA(this); // 메인 자기 자신의 주소값 부르기
		panelb = new PanelB();
		panelc = new PanelC();
		
	}
	
	void addLayout() {
		
		//프레임 기본 프레임 -> border 그치만 쓰길 권장~
		f.setLayout(new BorderLayout());
		
		f.add(btn, BorderLayout.EAST);
		f.add(la,BorderLayout.SOUTH);
		
		//TAbbedpane 구성 작성한 순서대로 출력됨
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("메인", panela);
		tab.addTab("서브", panelb);
		tab.addTab("기타", panelc);
		f.add(tab, BorderLayout.CENTER);
		
		//화면출력
		f.setBounds(100, 100, 500, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
    void eventProc() {
		
    	//확인버튼 눌렀을 때 이벤트
		btn.addActionListener(new ActionListener(){                 
	         public void actionPerformed(ActionEvent e) {   
	         panela.aLa.setText("WELCOME2"); //글자 판때기A >> WELCOME으로 변경
	         }  
	      });   
	}
	
	public static void main(String[] args) {

	MainTest test = new MainTest();
	test.addLayout();
	test.eventProc();
	
	}

}
