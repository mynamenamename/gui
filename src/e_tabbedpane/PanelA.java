package e_tabbedpane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelA extends JPanel {

	// 직접 객체 생성
	JLabel aLa = new JLabel("판때기 A");
	JButton aBtn = new JButton("A버튼");
	
	MainTest parent;
	

	public PanelA(MainTest maintest) {
		//  무한루프 parent = new MainTest(); 
		
		//서브>>>메인 주소값 받아서 넣어주기
		parent = maintest;
		
		setBackground(new Color(255, 255, 255)); // RGB (Red,Green,Blue)
		addLayout();
		eventProc();
	}

	void addLayout() {
		add(aLa);
		add(aBtn);
	}

	void eventProc() {
		
	  //A버튼 눌렀을 때 이벤트
	   aBtn.addActionListener(new ActionListener(){                 
	   public void actionPerformed(ActionEvent e) {   
			  parent.la.setText("안녕하세요");
			  
		  }  
       });   
	}
		
		
	public static void main(String[] args) {

	MainTest test = new MainTest();
	test.addLayout();
	test.eventProc();	
		
		
		
	}

}
