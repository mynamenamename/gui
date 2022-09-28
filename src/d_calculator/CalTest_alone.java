package d_calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTest_alone {
   
	 
	//1. 멤버변수 선언   
	
	JFrame f;
	JTextField tf;
	JButton[] bNum= new JButton[10]; // 0~9 숫자 표현 버튼
	JButton[] bOp= new JButton[4]; // +, -, *, / 연산자 표현 버튼
	JButton bEqual;
	
	
	CalTest_alone() {
	
		
	//2. 객체 생성	
		//f 객체 생성
		f = new JFrame("그냥 계산기");
		
		//tf 객체 생성
		tf = new JTextField();
		
		//bNum 객체 생성
		for (int i=0; i<bNum.length; i++) {
			bNum[i]= new JButton(Integer.toString(i));
		}
		
		//bOp 객체 생성 연산자
		bOp[0] = new JButton("+");
		bOp[1] = new JButton("-");
		bOp[2] = new JButton("*");
		bOp[3] = new JButton("/");
		
		//bEqual 객체 생성
		bEqual = new JButton("=");
		
		
	}
	
	
	//3. 화면 구성 및 출력
	
	public void addLayout() {
		
	    //레이아웃 출력
		f.setLayout(new BorderLayout());
		
		  //north
		
		f.add(tf, BorderLayout.NORTH);
		
		  //west
		
		JPanel jj = new JPanel();
		jj.setLayout(new GridLayout(5,3));
		   for(int i=1;i<bNum.length;i++) {
			   jj.add(bNum[i]);
		   }
		    jj.add(bOp[0]);
		    jj.add(bNum[0]);
		    jj.add(bEqual);
		    
		   for(int i=0; i<bOp.length; i++) {
			   jj.add(bOp[i]);
		   }
		 
		 f.add(jj, BorderLayout.CENTER);
		
		 
		
		
		//화면 출력
		f.setBounds(100, 100, 350, 300); 
		f.setVisible(true); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	//4. 이벤트 처리 
	 
	public void eventProc() {
		
		
		
		
		
		

	}

	public static void main(String[] args) {
   
		//클래스명이랑 똑같이....^^^^
		CalTest_alone cal = new CalTest_alone();
		cal.addLayout();
		cal.eventProc();

	}

}
