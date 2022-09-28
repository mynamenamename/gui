package d_calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTest {

	// 1. 멤버변수 선언
	JFrame f;
	JTextField tf;
	JButton[] bNum= new JButton[10]; // 0~9 숫자 표현 버튼
	JButton[] bOp= new JButton[4]; // +, -, *, / 연산자 표현 버튼
	JButton bEqual;
	
	//계산
	int first, second;
	String op;

	
	// 2. 객체 생성
	CalTest() {

		f = new JFrame("유치원 계산기");
		
		//텍스트필드
		tf = new JTextField();
		
		
		//숫자 1~0까지
		
		/*
		 bNum[0] = new JButton("0");
		 bNum[1] = new JButton("1");
		 bNum[2] = new JButton("2");
		 bNum[3] = new JButton("3");
		 bNum[4] = new JButton("4");
		 bNum[5] = new JButton("5");
		 bNum[6] = new JButton("6");
		 bNum[7] = new JButton("7");
		 bNum[8] = new JButton("8");
		 bNum[9] = new JButton("9");
		 */
		
		  //문자열 숫자로 Integer.tostring
		 for(int i=0; i<10; i++) {
			bNum[i]= new JButton(Integer.toString(i));
		 }
		 
		 
		 //연산자 +,-,*,/
		 
		 bOp[0] = new JButton("+");
		 bOp[1] = new JButton("-");
		 bOp[2] = new JButton("*");
		 bOp[3] = new JButton("/");
		 
		 // 연산자 =
		 
		 bEqual = new JButton("=");
		 
       
		

	}// end of CalTest()

	// 3. 화면 구성 및 화면 출력


	void addLayout() {
		//전체 레이아웃 방식 
		f.setLayout(new BorderLayout());
         
		//텍스트필드 부분 north
	 	f.add(tf, BorderLayout.NORTH);
		 
	 	
	 	//숫자,연산자 west
		 JPanel jpwest=new JPanel();          
	     jpwest.setLayout(new GridLayout(5,3)); 
	        
	      /*
	        jpwest.add(bNum[0]);
	        jpwest.add(bNum[1]);
	        jpwest.add(bNum[2]);
	        jpwest.add(bNum[3]);
	        jpwest.add(bNum[4]);
	        jpwest.add(bNum[5]);
	        jpwest.add(bNum[6]);
	        jpwest.add(bNum[7]);
	        jpwest.add(bNum[8]);
	        */
	      
	        // 숫자 1~9까지
	        for (int i=1; i<bNum.length;i++) {
	        	jpwest.add(bNum[i]);
	        }
	         
	        //연산자 +, 숫자0, 연산자 =
	        jpwest.add(bOp[0]);
	        jpwest.add(bNum[0]);
	        jpwest.add(bEqual);
	     

	        /*
	        jpwest.add(bOp[1]);
	        jpwest.add(bOp[2]);
	        jpwest.add(bOp[3]);
	        */
	        
	        // 연산자 -, *, / 
	        for(int i=1; i<bOp.length;i++) {
	        	jpwest.add(bOp[i]);
	        }
	        
	        // 숫자 입력하는 곳
	        f.add(jpwest, BorderLayout.CENTER);
	        
	        
		f.setBounds(100, 100, 350, 300); 
		f.setVisible(true); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		

	}// end of addLayout()

	
	// 4. 이벤트 처리
	void eventProc() {
		// 숫자 버튼이 눌렸을 때
		for(int i=0; i<bNum.length; i++) {
		
		bNum[i].addActionListener(new ActionListener(){                 
	         public void actionPerformed(ActionEvent e) {   
	        	//이벤트 발생한 컴포넌트(화면)의 참조를 얻어옴 > 
	        	//특정 버튼을 마우스로 클릭시, 그 버튼을 eBtn에 복사
	           JButton eBtn =(JButton)e.getSource();
	           //su에 JButton의 txt를 string 형으로 저장
	        	 String su = eBtn.getText();
	        	 // tf에 su  출력
	            //tf.setText(su); 
	        	tf.setText(tf.getText() +su);  //tf에 새로 값 불러 넣고 이전값 더하기 
	        	
	         }  
	      });   
		} // end of 연산자 i
		
		
	    //연산자 버튼이 눌렸을 때
	   for(int i=0; i<bOp.length; i++) {	
		   
		   bOp[i].addActionListener(new ActionListener(){                 
		         public void actionPerformed(ActionEvent e) {                
		         JButton eBtn =(JButton)e.getSource();  
		         // op에 연산자 저장
		         op = eBtn.getText(); // set은 설정 get은 가져오는 것
		         // 문자열 >> 숫자 변환
		         first = Integer.parseInt(tf.getText()); 
		         tf.setText(null); // null이나 " " 똑같음  -> 지우기
		         
		         
		         }  
		      }); 
	   } // end of 연산자 i 
	   
		// = 버튼이 눌렸을 때	
		bEqual.addActionListener(new ActionListener(){                 
	         public void actionPerformed(ActionEvent e) {                
	        	 second = Integer.parseInt(tf.getText());
	        	 int result=0;
	        	 switch(op) {
	        	 case "+": result=first+second; break;             
	        	           // first += second;
	        	 case "*": result=first*second; break;
	        	 case "-": result=first-second; break;
	        	 case "/": result=first/second; break;
	        	 }
	        	 // 숫자 >> 문자열 변환
	        	 tf.setText(String.valueOf(result));
	         }  
	         
	      }); 
		

	}// end of eventProc()

	public static void main(String[] args) {
		CalTest cal = new CalTest();
		cal.addLayout();
		cal.eventProc();
	}
}
