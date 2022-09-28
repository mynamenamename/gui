package e_tabbedpane2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class MainTest {

	JFrame f;
	JButton btn;
	JLabel la;
	
	PanelA panela;
	PanelB panelb;
	PanelC panelc;
	
	
	MainTest() {
		f = new JFrame("나의 창");
		btn = new JButton("확인");
		la = new JLabel("data");
		
		panela = new PanelA();
		panelb = new PanelB();
		panelc = new PanelC();
		
	}
	
	void addLayout() {
		
		//프레임 기본 프레임 -> border 그치만 쓰길 권장~
		f.setLayout(new BorderLayout());
		
		f.add(btn, BorderLayout.EAST);
		f.add(la,BorderLayout.SOUTH);
		
		
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("메인", panela);
		tab.addTab("서브", panelb);
		tab.addTab("기타", panelc);
		f.add(tab, BorderLayout.CENTER);
		
		
		
		f.setBounds(100, 100, 500, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String[] args) {

	MainTest test = new MainTest();
	test.addLayout();
		
		
	}

}
