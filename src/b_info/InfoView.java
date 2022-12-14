package b_info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InfoView {

	//1. 멤버변수 선언
	JFrame f;
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow ,bSearch, bDelete, bCancel, bExit; 
	
	//person VO 저장할 변수, 객체 생성
	ArrayList <PersonVO> list = new ArrayList <PersonVO> ();
	
    //2. 객체 생성
	InfoView() {
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
		f.setBounds(300,300,800,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	//이벤트 처리 함수
	public void eventProc() {
		// ADD 버튼이 눌렸을 때 이벤트 처리
		bAdd.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Add 버튼 클릭");
				inputData();
				clearTextField();
				selectAll();
			}   
			
		}  );
		
		// SHOW 버튼이 눌렸을 때 이벤트 처리
		bShow.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Show 버튼 클릭");
				selectAll();
			}   
			
		}  );
		
		// SEARCH 버튼이 눌렸을 때 이벤트 처리
		bSearch.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Search 버튼 클릭");
				selectByTel();
			}   
			
		}  );
		
		
		// DELETE 버튼이 눌렸을 때 이벤트 처리
		bDelete.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Delete 버튼 클릭");
				deleteByTel();
			}   
			
		}  );
		
		// CANCEL 버튼이 눌렸을 때 이벤트 처리
		bCancel.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Cancel 버튼 클릭");
				clearTextField();
			}   
			
		}  );
		
		// EXIT 버튼이 눌렸을 때 이벤트 처리
		bExit.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exit 버튼 클릭");
			}   
			
		}  );
		
        
		// 전화번호 텍스트필드에서 엔터쳤을 때 이벤트
		tfTel.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
				
		
			}   
			
		}  );
		
		
		    // 주민번호 입력창에서 엔터 쳤을때 이벤트
		tfId.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJuminInfo();
			}    //end of actionPerformed
			}  );  //end of  getJuminInfo();
				
				
		    // (1) 주민번호 7번째 문자로 성별을 구하여 성별창에 출력
				//950111-1234567
		   tfId.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jumin = tfId.getText();  //얻어오는거 get
				char seven = jumin.charAt(7);
				if(seven == '1'||seven == '3'||seven == '9') {
					JOptionPane.showMessageDialog(null, "남자"); // 남자 팝업창 뜸
					tfGender.setText("남자");
				}else if(seven == '2'||seven == '4'||seven == '0') {
					JOptionPane.showMessageDialog(null, "여자"); // 여자 팝업창 뜸
					tfGender.setText("여자");
				}else tfGender.setText("잘못 입력하셨습니다!");
			}   
			}  );
				
				
				
			// (2) 주민번호 8번째 문자로 출신지 구하여 출신지창에 출력
		
		tfId.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jumin = tfId.getText();  //얻어오는거 get
				char seven = jumin.charAt(8);
				 switch (seven) {
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
				
			}   
			}  );
				
				
			// (3) 주민번호에서 년도를 구해서 나이를 구해서 나이창에 출력	
		
		   tfId.addActionListener(new  ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String jumin = tfId.getText();  //얻어오는거 get
				 String nai = jumin.substring(0, 2);
				 int sunai = Integer.parseInt(nai); // sunai = 앞 두자리
				 char seven2 = jumin.charAt(7);
					
				     int sum =0;                    //최종 나이 계산 sum
				     
					 if (seven2 == '0'||seven2 == '9') {
						sum=1800;
					 }else if (seven2 =='1'||seven2 =='2') {
						sum=1900;
					 }else if (seven2 =='3'||seven2 =='4') {
						sum=2000;
					 }
					 
					 Calendar c = Calendar.getInstance();   // c에 pc캘린더 calendar 클래스의 getinstance메소드 가져오기
					 int year = c.get(Calendar.YEAR);
					 int age = 0;
					 
					 age= year- (sum + sunai) + 1;
					 tfAge.setText(Integer.toString(age));
					 
					 
					  //이렇게 해도 되고 하나 이벤트 안에 다만들고 마지막에 팝업창 출력 시켜도 됨!!
					 
			}    // end of actionPerformed
			}  );  // end of addActionListener
		
		   
		// 주민번호 입력창에서 <<포커스>> 이벤트 발생했을때
		   
		   tfId.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
				}
				public void focusLost(FocusEvent e) {
                       getJuminInfo();
				}
			   
			   
		   } );  // end of addFocusListener 
		   
	}//end of eventProc()
	
	
	
	void deleteByTel() {
		// 입력한 전화번호값 얻어오기
		String tel = tfTel.getText();
		//입력받은 전화번호가 공백이라면 "전화번호를 입력하세요" 메시지창 띄우기
		if (tel.equals(" ")) { //string 비교는 equals
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요"); 
			return; //전화번호 입력하지 않으면 메세지 띄우고 나가버리는 역할
		}
		//list에 저장된 PersonVO의 전화번호와 비교하여 
        //해당 전화번호가 있으면 해당하는 PersonVO를 리스트에서 삭제
		for(PersonVO vo: list) {
			if(tel.equals(vo.getTel())) {
			    list.remove(vo); 
			    ta.setText(null);
				tfName.setText(null);
			    tfId.setText(null);
			    tfTel.setText(null);
			    tfAge.setText(null); //String >> int
			    tfGender.setText(null);
			    tfHome.setText(null);
			    break;
			} 
			}
		//참고 : 삭제하고 나서 break로 반복문 끝내기
		
	}
	
	
	
	
	
	
	/*
	 * 함수명:  selectByTel
	 * 인자 :   없음
	 * 리턴값:  void 
	 * 역할 :
	 */
	
	void selectByTel() {
		// 입력한 전화번호값 얻어오기
	String tel = tfTel.getText();
		
	    //입력받은 전화번호가 공백이라면 "전화번호를 입력하세요" 메시지창 띄우기
		if (tel.equals(" ")) { //string 비교는 equals
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요"); 
			return; //전화번호 입력하지 않으면 메세지 띄우고 나가버리는 역할
		}
		
		//list에 저장된 PersonVO의 전화번호와 비교하여 
		//해당 전화번호가 있으면 그 내용을 각각의 텍스트필드에 출력
		
		for(PersonVO vo: list) {
			if(tel.equals(vo.getTel())) {
				tfName.setText(vo.getName());
			    tfId.setText(vo.getId());
			    tfTel.setText(vo.getTel());
			    tfAge.setText(Integer.toString(vo.getAge())); //String >> int
			    tfGender.setText(vo.getGender());
			    tfHome.setText(vo.getHome());
			    
			}
		}
		
		
	}// end of selectByTel()
	
	
	
	
	/*
	 * SHOW 버튼이 눌렸을 때 리스트에 저장된 정보를 모두
	 * text area에 출력
	 */
	

	void selectAll() {
		ta.setText("------ 전체 목록 ------  \n \n "); 
		//ta.setText(null); 해도됨
		for(PersonVO vo : list ) {
			ta.append(vo.toString()); //기존 내용에 추가 : append
		         //object값은 자동변환이 되지 않기 때문에 toString으로 변환해줘야함
		}
		
		
		
	}// end of selectAll()
	
	
	
	/*
	 * ADD 버튼이 눌렸을 때 Textfield에 입력한 사용자 값들을
	 * PersonVO에 저장
	 */
	
	void inputData() {
		//[1] 각각의 텍스트필드 입력값 얻어오기
	    //  String n = tfName.getText();  한번 사용하고 마니까 바로 넣기 
		  
		
		//[2] 1번의 값들을 PersonVO 멤버변수에 저장(setter/ constructor(생성자))
		//setter
	    PersonVO vo = new PersonVO();
	    vo.setName(tfName.getText());
		vo.setId(tfId.getText());
		vo.setTel(tfTel.getText());
		vo.setAge(Integer.parseInt(tfAge.getText())); // int > string
		vo.setHome(tfHome.getText());
		vo.setGender(tfGender.getText());
		
		//한 사람의 정보를 arraylist에 저장
		list.add(vo);
		
		
		 /* 생성자
		 PersonVO vo2 = new PersonVO(String tfName, String tfId, String tfTel);
		
	    */
		
	} // end of inputdata()
	
	
	
	
	/*
	 * CANCEL 버튼이 눌렸을 때 각각의 텍스트필드, 텍스트area 값을 지우기 
	 */
	
	void clearTextField() {
		ta.setText(null); //지우기
		
		//나머지 텍스트 필드도 지우기
		tfName.setText(null);
		tfId.setText(null);
		tfTel.setText(null);  
		tfAge.setText(null);
		tfHome.setText(null);
		tfGender.setText(null);
		
		
	} // end of clearTextField()
	
	
	
	//반복적인 코딩 >> 함수로 만들기!!!!
	// 주민번호 입력창에서 엔터 쳤을때 이벤트
	void getJuminInfo() {
		
		String jumin = tfId.getText();  //얻어오는거 get
		if( jumin.length() < 14) {      //입력글자가 14자보다 적을때만 작동
			JOptionPane.showMessageDialog(null, "- 포함한 15자를 입력하세요");
			return;
		}
	} //end of  getJuminINfo()
	
	
	
	
		
	public static void main(String[] args) {

		InfoView info = new InfoView();
		info.addLayout();
		info.eventProc();
		
		
	}

}
