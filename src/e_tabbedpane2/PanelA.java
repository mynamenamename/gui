package e_tabbedpane2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelA extends JPanel{
	
	//직접 객체 생성
	JLabel aLa = new JLabel("판때기 A");
	JButton aBtn = new JButton ("A버튼");
	
	
	public PanelA() {
		setBackground(new Color(255,0,0)); //RGB (Red,Green,Blue)
		addLayout();
		eventProc();
	}

	void addLayout() {
		add(aLa);
		add(aBtn);
	}
	
	void eventProc() {
		
		
	}
	
	
}
