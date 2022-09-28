package b_info3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView3 {

   //1. 멤버변수 선언
   JFrame f;   //새 창을 만들기 위한 선언
   JTextField tfname, tfId, tfTel, tfGender, tfAge, tfHome;
   //한 줄 입력 받을 때 사용
   JTextArea ta;
   //여러 줄 입력 받을 때 사용
   JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
   //버튼 삽입
   JLabel la;
   //글씨만 한 줄 입력해야 할 때 사용

   //2. 멤버변수 객체생성
   InfoView3(){
      f     =new JFrame("DBTest");            //새 창의 헤드부분에 나올 도메인
      tfname=new JTextField(10);               //한 줄 입력 받을 창 크기 선언
      tfId  =new JTextField(10);
      tfTel =new JTextField(10);
      tfGender=new JTextField(10);
      tfAge =new JTextField(10);
      tfHome=new JTextField(10);
      ta     =new JTextArea(40,20);            //여러 줄 입력 받을 창 
      bAdd  =new JButton("Add");               //각 버튼들 변수 선언
      bShow =new JButton("Show");
      bSearch=new JButton("Search");
      bDelete=new JButton("Delete");
      bCancel=new JButton("Cancel");
      bExit  =new JButton("Exit(alt+x)",new ImageIcon("src\\b_info\\imgs\\2.PNG"));//버튼에 이미지 삽입 new ImageIcon(아이콘 경로)
      bExit.setHorizontalTextPosition(JButton.CENTER);                  //수평으로는 가운데에
      bExit.setVerticalTextPosition(JButton.BOTTOM);                     //수직으로는 아래에
      bExit.setRolloverIcon(new ImageIcon("src\\b_info\\imgs\\3.PNG"));       //마우스를 올렸을 때 아이콘이 바뀌게 함
      bExit.setPressedIcon(new ImageIcon("src\\b_info\\imgs\\4.PNG"));       //클릭 했을 때 아이콘이 바뀌게 함
      bExit.setToolTipText("종료버튼입니다");                              //마우스를 대고 있을 때 메세지박스가 뜨게 함
      bExit.setMnemonic('x');                                       //alt 키와 함께 설정한 키를 눌렀을 때 그 버튼이 눌리게 함


   }

   //3. 화면 구성하고 출력
   /*
    * 전체 프레임은 BorederLayout 지정 
    * west : Jpannel 만들어서 Jlabel과 JTextField tfname, tfId, tfTel, tfGender, tfAge, tfHome; (GridLayout(6,2))
    * center : JTextArea ta;
    * south : Jpannel 만들어서 JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit; (GridLayout(1,6))
    */
   public void addLayout() {
      //Border 레이아웃으로 큰 창의 전체 레이아웃 먼저 설정
      f.setLayout(new BorderLayout());
      //붙히기 작업
      //하단 버튼 붙히기
      JPanel jpdown=new JPanel();            //버튼 올릴 패널 만들기
      jpdown.setLayout(new GridLayout(1,6));   //패널을 행,열 순서대로 나오게 배치 출력
      jpdown.add(bAdd);   //패널 위에 버튼 올리기
      jpdown.add(bShow);
      jpdown.add(bSearch);
      jpdown.add(bDelete);
      jpdown.add(bCancel);
      jpdown.add(bExit);
      f.add(jpdown,BorderLayout.SOUTH);   //보더 레이아웃의 아래쪽에 위치 선언

      //왼쪽 붙히기
      JPanel jpwest=new JPanel();                  //입력 창과 입력 받을 창 올릴 패널 만들기
      jpwest.setLayout(new GridLayout(6,2));         //패널을 행,열 순서대로 나오게 배치 출력
      jpwest.add(new JLabel("Name",JLabel.CENTER));   //가운데 정렬하는 키 JLabel뒤 .center넣기
      jpwest.add(tfname);
      jpwest.add(new JLabel("ID",JLabel.CENTER));
      jpwest.add(tfId);
      jpwest.add(new JLabel("Tel",JLabel.CENTER));
      jpwest.add(tfTel);
      jpwest.add(new JLabel("Sex",JLabel.CENTER));
      jpwest.add(tfGender);
      jpwest.add(new JLabel("Age",JLabel.CENTER));
      jpwest.add(tfAge);
      jpwest.add(new JLabel("Home",JLabel.CENTER));
      jpwest.add(tfHome);
      f.add(jpwest, BorderLayout.WEST);   //보더 레이아웃의 왼쪽에 위치 선언

      //오른쪽 붙히기
      f.add(ta,BorderLayout.CENTER);      //보더 레이아웃의 가운데쪽에 위치 선언

      f.setBounds(100,100,500,350);      //사이트의 크기 설정
      f.setVisible(true);               //true이기 때문에 프로그램이 보이게 작동함
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //x키를 누르면 프로그램 자동 종료

   }

   //이벤트 처리 함수
   public void eventProc() {
      //Add 버튼을 눌렀을 때 나오는 이벤트
      bAdd.addActionListener(new ActionListener(){                  //이너 클래스, 이벤트는 이너클래스로 많이 작업한다.
         public void actionPerformed(ActionEvent e) {                 //액션리스너 클래스는 추상클래스라서 메소드를 똑같이 상속 받아서 쓴다.
            JOptionPane.showMessageDialog(null, "ADD 버튼 클릭");         //팝업 창 뜨면서 출력할 메세지 입력. 
         }   
      });                                                   //버튼에다가 이너클래스 이벤트 담기
      bShow.addActionListener(new ActionListener(){                  //이너 클래스, 이벤트는 이너클래스로 많이 작업한다.
         public void actionPerformed(ActionEvent e) {                 //액션리스너 클래스는 추상클래스라서 메소드를 똑같이 상속 받아서 쓴다.
            JOptionPane.showMessageDialog(null, "Show 버튼 클릭");      //팝업 창 뜨면서 출력할 메세지 입력. 
         }   
      });         
      bSearch.addActionListener(new ActionListener(){                  //이너 클래스, 이벤트는 이너클래스로 많이 작업한다.
         public void actionPerformed(ActionEvent e) {                 //액션리스너 클래스는 추상클래스라서 메소드를 똑같이 상속 받아서 쓴다.
            JOptionPane.showMessageDialog(null, "SEARCH 버튼 클릭");      //팝업 창 뜨면서 출력할 메세지 입력. 
         }   
      });         
      bDelete.addActionListener(new ActionListener(){                  //이너 클래스, 이벤트는 이너클래스로 많이 작업한다.
         public void actionPerformed(ActionEvent e) {                 //액션리스너 클래스는 추상클래스라서 메소드를 똑같이 상속 받아서 쓴다.
            JOptionPane.showMessageDialog(null, "Delete 버튼 클릭");      //팝업 창 뜨면서 출력할 메세지 입력. 
         }   
      });         
      bCancel.addActionListener(new ActionListener(){                  //이너 클래스, 이벤트는 이너클래스로 많이 작업한다.
         public void actionPerformed(ActionEvent e) {                 //액션리스너 클래스는 추상클래스라서 메소드를 똑같이 상속 받아서 쓴다.
            JOptionPane.showMessageDialog(null, "Cancle 버튼 클릭");      //팝업 창 뜨면서 출력할 메세지 입력. 
         }   
      });         
      bExit.addActionListener(new ActionListener(){                  //이너 클래스, 이벤트는 이너클래스로 많이 작업한다.
         public void actionPerformed(ActionEvent e) {                 //액션리스너 클래스는 추상클래스라서 메소드를 똑같이 상속 받아서 쓴다.
            JOptionPane.showMessageDialog(null, "Exit 버튼 클릭");      //팝업 창 뜨면서 출력할 메세지 입력. 
         }   
      });   
      //주민번호 입력창에서 엔터 쳤을 때 이벤트 발생
      tfId.addActionListener(new ActionListener(){                  //이너 클래스, 이벤트는 이너클래스로 많이 작업한다.
         public void actionPerformed(ActionEvent e) {                 //액션리스너 클래스는 추상클래스라서 메소드를 똑같이 상속 받아서 쓴다.
            String in=tfId.getText();                           //입력값을 그대로 String에 받는다.
            if(in.length()<14) {                              //입력값이 15자보다 적을때만 정상 작동
               JOptionPane.showMessageDialog(null,"-를 포함한 14자를 맞춰주세요.");//15자리를 넘으면 15자를 출력하라고 메세지가 뜬다.
               return;
            }
            //1. 주민 번호의 7번째 문자로 성별을 구하여 성별창에 출력
            in.charAt(7);               //in 변수의 7번째 글자 따오기
            char ye=in.charAt(7);         //따온 7번째 글자를 저장할 char 변수 선언
            
            if(ye=='2'|ye=='4'|ye=='0')     tfGender.setText("여자");   //if문으로 2,4,0일때는 tfGender 창에 "여자" 를 입력한다.
            else if(ye=='1'|ye=='3'|ye=='9') tfGender.setText("남자");   //if문으로 1,3,9일때는 tfGender 창에 "남자" 를 입력한다.               
            else                   tfGender.setText("잘못 입력됨");   //if문으로 나머지일때는 tfGender 창에 "잘못 입력됨" 를 입력한다.
            
            //2. 주민 번호의 8번째 문자로 출신지를 구하여 출신지 창에 출력
            char chul=in.charAt(8);         //in 변수의 8번째 글자 따오기
            
            switch(chul) {   //문자,정수, 숫자열            //if문은 너무 복잡하고 길어지니 switch문으로 대체
            case '0': tfHome.setText("서울"); break;      //8번째 글자가 0일때 tfHome에 "서울" 출력 
            case '1': tfHome.setText("경기"); break;      //8번째 글자가 1일때 tfHome에 "경기" 출력
            case '2': tfHome.setText("인천"); break;      //8번째 글자가 2일때 tfHome에 "인천" 출력
            case '3': tfHome.setText("대구"); break;      //8번째 글자가 3일때 tfHome에 "대구" 출력
            case '4': tfHome.setText("대전"); break;      //8번째 글자가 4일때 tfHome에 "대전" 출력
            case '5': tfHome.setText("전주"); break;      //8번째 글자가 5일때 tfHome에 "전주" 출력
            case '6': tfHome.setText("울산"); break;      //8번째 글자가 6일때 tfHome에 "울산" 출력
            case '7': tfHome.setText("부산"); break;      //8번째 글자가 7일때 tfHome에 "부산" 출력
            case '8': tfHome.setText("독도"); break;      //8번째 글자가 8일때 tfHome에 "독도" 출력
            case '9': tfHome.setText("제주");         //마지막은 어차피 걸려서 나가니까 굳이 브레이크 걸지 않아도 됨
            }

            //3. 주민 번호에서 년도에 의해 나이를 구하여 나이창에 출력
            String nai=in.substring(0,2);         //in에서 0번째와 2번째 앞의 글자를 따온다. ex)"80"   >문자열
            int sunai=Integer.parseInt(nai);      //                           ex) 80   >문자열을 숫자로 변경
            int age=0;                        //최종 나이를 담을 변수 선언
            
            Calendar cal=Calendar.getInstance();   //변수 cal에 PC 캘린더를 Calendar클래스의 getInstance메소드를 가져옴
            int year=cal.get(Calendar.YEAR);      //변수 year에 pc캘린더의 년도를 인풋 받음
            if(ye=='3'|ye=='4')     age=year-(2000+sunai)+1;   //if문으로 3,4일때 age에 계산식을 넣는다.
            else if(ye=='1'|ye=='2') age=year-(1900+sunai)+1;   //if문으로 1,2일때 age에 계산식을 넣는다.
            else if(ye=='0'|ye=='9') age=year-(1800+sunai)+1;   //if문으로 0,9일때 age에 계산식을 넣는다.
            tfAge.setText(Integer.toString(age));            //tfAge에 텍스트 설정.(age는 int이므로 String으로 변환해서 넣어준다.)
            
            JOptionPane.showMessageDialog(null, in);      //팝업 창 뜨면서 출력할 메세지 입력.(in : 입력받은 값) 
         }   
      });//주민번호 입력창에서 엔터 쳤을 때 이벤트 발생창 닫음
      
      tfId.addFocusListener(new FocusListener() {
         public void focusLost(FocusEvent e) {   
         }
         public void focusGained(FocusEvent e) {
            getJuminInfo();
         }
      });   //End addFocusListener()
      
   }      //End eventProc()      
   
   void getJuminInfo(){
      
   }
   

   
   public static void main(String[] args) {

      InfoView info=new InfoView();   //위의 페이지를 부를 변수 선언
      info.addLayout();            //레이아웃이 보이게 함수 선언
      info.eventProc();            //이벤트 

   }

}