package b_info3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView2 {

	//1. 멤버변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow ,bSearch, bDelete, bCancel, bExit; 
	
	
    //2. 객체 생성
	InfoView2() {
		f = new JFrame("DBTest");
		
		tfName = new JTextField(15);
		tfId = new JTextField (15);
		tfTel = new JTextField (15);
		tfGender = new JTextField (15);
		tfAge = new JTextField (15);
		tfHome = new JTextField (15);
		
		bAdd = new JButton("Add");          //추가버튼
		bShow = new JButton("Show");        //전체보기버튼
		bSearch = new JButton("Search");    //검색버튼
		bDelete = new JButton("Delete");    //삭제버튼
		bCancel = new JButton("Cancel");    //취소버튼
		bExit = new JButton("Exit(alt+x)", new ImageIcon("src\\b_info\\imgs\\img1.PNG"));
		//bExit.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(Exit.png"))));
          //그림 밑에 글자 위치
		  bExit.setHorizontalTextPosition(JButton.CENTER); // 수평 가운데
          bExit.setVerticalTextPosition(JButton.BOTTOM);   // 수직 밑에
          //마우스 올리면 이미지가 변하게
          bExit.setRolloverIcon(new ImageIcon("src\\b_info\\imgs\\img3.PNG"));
          //클릭하면 이미지가 변하게
          bExit.setPressedIcon(new ImageIcon("src\\b_info\\imgs\\img2.PNG"));
          //tooltip >> 마우스 가져다댔을때 기다리면 뜨는 도움말 (좀 기다려야함)
          bExit.setToolTipText("나가기 버튼");
          //단축키 눌려지는 효과 나타남
          bExit.setMnemonic('x');
          //배경색 바꾸기
          bExit.setBackground(Color.cyan);
          
       
		
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
	
	//이벤트 처리 함수
	public void eventProc() {
		// ADD 버튼이 눌렸을 때 이벤트 처리
		bAdd.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Add 버튼 클릭");
			}   
			
		}  );
		
		
		bShow.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Show 버튼 클릭");
			}   
			
		}  );
		
		bSearch.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Search 버튼 클릭");
			}   
			
		}  );
		
		
		bDelete.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Delete 버튼 클릭");
			}   
			
		}  );
		
		bCancel.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cancel 버튼 클릭");
			}   
			
		}  );
		
		
		bExit.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exit 버튼 클릭");
			}   
			
		}  );
		
        
		    // 주민번호 입력창에서 엔터 쳤을때 이벤트
		tfId.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jumin = tfId.getText();  //얻어오는거 get
				if( jumin.length() < 14) {      //입력글자가 14자보다 적을때만 작동
					JOptionPane.showMessageDialog(null, "- 포함한 15자를 입력하세요");
					return;
				}
				
				 // (1) 주민번호 7번째 문자로 성별을 구하여 성별창에 출력
				
				char seven = jumin.charAt(7);
				if(seven == '1'||seven == '3'||seven == '9') {
					//JOptionPane.showMessageDialog(null, "남자"); // 남자 팝업창 뜸
					tfGender.setText("남자");
				}else if(seven == '2'||seven == '4'||seven == '0') {
					//JOptionPane.showMessageDialog(null, "여자"); // 여자 팝업창 뜸
					tfGender.setText("여자");
					return;
				}
				// (2) 주민번호 8번째 문자로 출신지 구하여 출신지창에 출력
				
				 char seven2 = jumin.charAt(8);
				 switch (seven2) {
				 case '0': tfHome.setText("서울");  break;
				 case '1': tfHome.setText("인천/부산");  break;
				 case '2':  case '3': case '4': case '5':
					 tfHome.setText("경상북도");  break;
				 case '6': case '7': case '8':
					 tfHome.setText("경상남도"); break;
				 case '9':
					 tfHome.setText("제주도");  break;
			     default:
			    	 tfHome.setText("한국사람이 아닙니다.");
			    	 
			     //마지막 안해도 됨! 어차피 나가니까
				 }
				 
				// (3) 주민번호에서 년도를 구해서 나이를 구해서 나이창에 출력
				
				 String nai = jumin.substring(0, 2);
				 int sunai = Integer.parseInt(nai); // sunai = 앞 두자리
				 char seven3 = jumin.charAt(7);
					
				     int sum =0;                    //최종 나이 계산 sum
				     
					     if (seven3 == '0'||seven3 == '9') {
						sum=1800;
					 }else if (seven3 =='1'||seven3 =='2') {
						sum=1900;
					 }else if (seven3 =='3'||seven3 =='4') {
						sum=2000;
					 }
					 
					 Calendar c = Calendar.getInstance();   // c에 pc캘린더 calendar 클래스의 getinstance메소드 가져오기
					 int year = c.get(Calendar.YEAR);
					 int age = 0;
					 
					 age= year- (sum + sunai) + 1;
					 tfAge.setText(Integer.toString(age));
				 
					 JOptionPane.showMessageDialog(null, jumin);      //팝업 창 뜨면서 출력할 메세지 입력. 
	           
			}   
			}  );
			
			
		
	}
		
	public static void main(String[] args) {

		InfoView2 info = new InfoView2();
		info.addLayout();
		info.eventProc();
		
		
	}

}
