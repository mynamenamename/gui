package b_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView {

	//1. 멤버변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow ,bSearch, bDelete, bCancel, bExit; 
	
	
    //2. 객체 생성
	InfoView() {
		f = new JFrame("DBTest");
		
		tfName = new JTextField(15);
		tfId = new JTextField (15);
		tfTel = new JTextField (15);
		tfGender = new JTextField (15);
		tfAge = new JTextField (15);
		tfHome = new JTextField (15);
		
		bAdd = new JButton("Add");
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
		
		ta = new JTextArea();
		
		
	}
	
	//3. 화면 구성하고 출력
	/* 
	 * hint: 전체 프레임>> BorderLayout 지정
	 *       -west   : JPanel 붙이기 >>> GridLayout(6,2)로 지정
	 *       -center : textarea
	 *       -south  : JPanel 붙이기 >>> GridLayout(1,6)로 지정
	 */
	public void addLayout() {
		
		//전체 프레임 정렬 방식
		  f.setLayout(new BorderLayout());
		
		
		
		
		//붙이기 작업
		  
		  //west
		    JPanel pWest = new JPanel();
		   
		   //모두 다 안에 넣기
		   pWest.add(new JLabel("Name", JLabel.CENTER));    //글자 가운데로 
		   pWest.add(tfName);
		   pWest.add(new JLabel("ID", JLabel.CENTER));
		   pWest.add(tfId);
		   pWest.add(new JLabel("Tel", JLabel.CENTER));
		   pWest.add(tfTel);
		   pWest.add(new JLabel("Gender",JLabel.CENTER));
		   pWest.add(tfGender);
		   pWest.add(new JLabel("Age", JLabel.CENTER));
		   pWest.add(tfAge);
		   pWest.add(new JLabel("Home", JLabel.CENTER));
		   pWest.add(tfHome);
		  
		   f.add(pWest, BorderLayout.WEST);
		   pWest.setLayout(new GridLayout(6,2)); //pWest 프레임 정렬 방식
		   
		   
		   
		   
		   //center
		   f.add(ta,  BorderLayout.CENTER );
		  
		   
		   
		   //south
		     JPanel pSouth = new JPanel();
		     
		   pSouth.add(bAdd);
		   pSouth.add(bShow);
		   pSouth.add(bSearch);
		   pSouth.add(bDelete);
		   pSouth.add(bCancel);
		   pSouth.add(bExit);
		   f.add(pSouth, BorderLayout.SOUTH);
		   pSouth.setLayout(new GridLayout(1,6));
		   //f가 아니고 PSouth 넣는거 까먹지 말기
		   //pSouth 프레임 정렬 방식
		
		  
		
		
		//화면 출력
		f.setBounds(100,100,500,350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String[] args) {

		InfoView info = new InfoView();
		info.addLayout();
		
		
		
	}

}
