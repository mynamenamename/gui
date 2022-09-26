package a_sample;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;

/*
 * 자바의 GUI(화면) = UI
 * - AWT : 1.2 이전
 * - Swing : 1.2 이후
 *          대부분 클래스 앞에 J
 */

//ctrl+shift+o 해도 되지만 잘 이해하고 있기
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
       //javax에서 x의 뜻  >> 확장
public class ATest {
	
	//객체 생성하기

	JFrame f;
	JButton btn,bCancel;
	JCheckBox chb, chb2;
	JRadioButton nan,nu;                    //변수 마음대로 지정 가능
	JTextField tf;                          //한 줄 입력
	JTextArea ta;                           //여러 줄 입력
	
	
	
	ATest() {                               //생성자 함수 생성
		f = new JFrame("나의 첫창");
		btn = new JButton("클릭");           //클릭 버튼
		bCancel = new JButton("취소");       //취소 버튼
		chb = new JCheckBox("자바");         //자바 체크박스  (체크박스 >> 네모) : 다중선택
		chb2 = new JCheckBox("오라클");       //오라클 체크박스 
		nan = new  JRadioButton("남자");     //남자 라디오버튼 (라디오버튼 >> 똥그라미) : 단일선택
		nu = new  JRadioButton("여자");      //여자 라디오버튼
		
		ButtonGroup group = new ButtonGroup();    // 그룹화 하면 단일선택 가능!! 한번만 쓰고 말 것이기 때문에 멤버변수로 선언할 필요 없음
		group.add(nan);
		group.add(nu);
		
		tf = new JTextField(20);            //평균 알파벳 길이라서 20
		ta = new JTextArea(40,20);
		
		
	}
	
	void addLayout() {
		
		//붙이는 방식(layout)                   >> 이거 안하니까 덮어써짐
		//FlowLayout f1 = new FlowLayout(); 객체 한번만 쓰니께 변수명 생략
		//f.setLayout(new FlowLayout());      // 한 줄에 배치
		//f.setLayout(new GridLayout(3,3));   // 행,열 구조에 맞춰 배치
		f.setLayout(new BorderLayout());      // 동,서,남,북, 가운데 >> 5개만 가능, 뒤에 BorderLayout.<방향> 지정해야함
 		
		
		//붙이기 작업(붙이고 출력해야함)
		f.add(btn, 	BorderLayout.NORTH );                           //클릭 버튼
		f.add(bCancel, BorderLayout.SOUTH);                       //취소 버튼
		//f.add(chb);                           //자바 체크박스
		//f.add(chb2);                          //오라클 체크박스
		     JPanel pEast = new JPanel();            //패널,, 판때기 > 한번만 붙이고 땡이라 멤버변수에 선언x
		     pEast.add(nan);                         //같은 곳에 여러 변수 선언하기 
		     pEast.add(nu);
		     f.add(pEast, BorderLayout.EAST);  
		//f.add(nan, BorderLayout.EAST);                           //남자 라디오버튼
		//f.add(nu, BorderLayout.EAST);                            //여자 라디오버튼
		f.add(new JLabel("입력하세요"), BorderLayout.WEST);         //한번만 붙이고 땡이라 멤버변수에 선언x
		//f.add(tf, BorderLayout.EAST);                            //한 줄 입력
		f.add(ta, BorderLayout.CENTER);                            //여러줄 입력
		
		
		
		//화면출력 작업
		f.setBounds(100, 100, 500, 350);      //화면 크기 지정
		f.setVisible(true);                   //화면 나오게 할건지?
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 누르고 나가기
	}
	
	public static void main(String[] args) {
          ATest a = new ATest();
          a.addLayout();                   //addLayout 출력
	}

}
