package mini;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RecipeMain extends JFrame implements ActionListener, MouseListener{
	private LoginPanel loginPanel = new LoginPanel(this);
	private SearchPanel searchPanel = new SearchPanel(this, loginPanel);
	private HomePanel homePanel = new HomePanel(this, searchPanel);
	private WritePanel writePanel = new WritePanel(this);
	private MyPagePanel myPagePanel = new MyPagePanel(this, searchPanel);
	private UpdatePanel updatePanel = new UpdatePanel(this);
	private DetailPanel detailPanel = new DetailPanel(this, loginPanel);
	private DeletePanel deletePanel = new DeletePanel(this);
	private RecipeWritePanel recipeWritePanel = new RecipeWritePanel(this, loginPanel);
	private RecipeUpdatePanel recipeUpdatePanel = new RecipeUpdatePanel(this, detailPanel);		
	
	private Icon home = new ImageIcon("image/home.png");
	private Icon myPage = new ImageIcon("image/my.png");
	private Icon pImg = new ImageIcon("image/노을사진1.png");
	private JRadioButton[] RBtn = new JRadioButton[2];
	private ButtonGroup group = new ButtonGroup();
	private JButton writeBtn, loginBtn, logoutBtn;
	private CardLayout card;
	private JPanel btnP, centerP;
	
	private Icon deco1Img = new ImageIcon("image/하트pink.png");              //0906  권영민
	private JButton[] decoBtn;
	private MouseListener listener; 																		// 여기까지
   
	int x = 10;                             // 0906 9시 마지막 시도 권영민
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //여기까지
	
	public RecipeMain() { //생성자
		
		decoBtn = new JButton[4];																	//0906 권영민
		decoBtn[0] = new JButton(deco1Img);
		decoBtn[1] = new JButton(deco1Img);
		decoBtn[2] = new JButton(deco1Img);
		decoBtn[3] = new JButton(deco1Img);
		for(int i = 0; i<4; i++) {
			decoBtn[i] = new JButton(deco1Img);
			decoBtn[i].setBounds(((int)(Math.random()*300)+20)+20, (int)(Math.random()*400)+20, 80, 70);
			this.add(decoBtn[i]);
			decoBtn[i].setBorderPainted(false);
			decoBtn[i].setContentAreaFilled(false);
			decoBtn[i].setToolTipText("버튼x 누르지 마세요.......");
			decoBtn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));	//0906 권영민

		}

			decoBtn[0].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[0].setBounds(x,y,width,height);
			}
		});																																	//0906 권영민
			decoBtn[1].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[1].setBounds(x,y,width,height);
			}
		});																																	//0906 권영민
			decoBtn[2].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[2].setBounds(x,y,width,height);
			}
		});																																	//0906 권영민
			decoBtn[3].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[3].setBounds(x,y,width,height);
			}
		});		
		
		
		//JRadioButton 생성		
		RBtn[0] = new JRadioButton("HOME", home);
		RBtn[1] = new JRadioButton("MY", myPage);
		
		for(int i=0; i<RBtn.length; i++) {
			RBtn[i].setVerticalTextPosition(JRadioButton.BOTTOM);
			RBtn[i].setHorizontalTextPosition(JRadioButton.CENTER);
			group.add(RBtn[i]);
		}//for

		//JButton 생성
		writeBtn = new JButton("SIGN UP");
		loginBtn = new JButton("LOGIN");
		logoutBtn = new JButton("LOGOUT");
		
		logoutBtn.setVisible(false);
		
		//CardLayout 생성
		card = new CardLayout();
		
		//JPanel 생성 - 4개 버튼 패널
		btnP = new JPanel() {
	  		public void paintComponent(Graphics g) {  //JPanel에 이미지 삽입
				g.drawImage(((ImageIcon) pImg).getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		btnP.add(RBtn[0]); //홈
	    btnP.add(writeBtn); //회원가입
	    btnP.add(loginBtn); //로그인
	    btnP.add(RBtn[1]); //마이페이지
	    btnP.add(logoutBtn); //로그아웃
	    writeBtn.setBackground(Color.white); 	// 버튼 흰색배경
	    loginBtn.setBackground(Color.white);	
	    logoutBtn.setBackground(Color.white);	
	    RBtn[0].setOpaque(false);		// 버튼 투명하게
	    writeBtn.setOpaque(false);	
	    loginBtn.setOpaque(false);
	    RBtn[1].setOpaque(false);
	    logoutBtn.setOpaque(false);
		
		//JPanel 생성 - 카드 레이아웃 패널
		centerP = new JPanel();
		centerP.setLayout(card);
		centerP.add("home", homePanel);
		centerP.add("write", writePanel);
		centerP.add("login", loginPanel);
		centerP.add("myPage", myPagePanel);
		centerP.add("update", updatePanel);
		centerP.add("search", searchPanel);
		centerP.add("detail", detailPanel);
		centerP.add("delete", deletePanel);
		centerP.add("recipeWrite", recipeWritePanel);
		centerP.add("recipeUpdate", recipeUpdatePanel);

		Container C = this.getContentPane();
		C.add("North", btnP);
		C.add("Center", centerP);

		setBounds(800, 200, 400, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		RBtn[0].addActionListener(this); //홈
	    RBtn[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
	    writeBtn.addActionListener(this); //회원가입
	    writeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    loginBtn.addActionListener(this); //로그인
	    loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    RBtn[1].addActionListener(this); //마이페이지
	    RBtn[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
	    logoutBtn.addActionListener(this); //로그아웃
	    logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}//RecipeMain()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//RecipeMain
		if(e.getActionCommand() == "HOME") { //홈
			card.show(centerP,"home");
			
			homePanel.getSearchT().setText("");
		}else if(e.getActionCommand() == "SIGN UP") { //회원가입
			card.show(centerP,"write"); 
			
			writePanel.getNameT().setText("");
			writePanel.getIdT().setText("");
			writePanel.getEmailT().setText("");
			writePanel.getEmailNumT().setText("");
			writePanel.getPwdT().setText("");
		}else if(e.getActionCommand() == "LOGIN") { //로그인
			card.show(centerP,"login"); 
			
			loginPanel.getIdT().setText("");
			loginPanel.getPwdT().setText("");
		}else if(e.getActionCommand() == "MY") { //마이페이지
			if(loginPanel.getId() != null) {
				card.show(centerP,"myPage");
			
				recipeWritePanel.getRecipeNameT().setText("");
				recipeWritePanel.getImgT().setText("");
				recipeWritePanel.getRecipedatailTA().setText("");
				
				updatePanel.getIdT().setText("");
				updatePanel.getPwdT().setText("");
				updatePanel.getEmailT().setText("");
				
				deletePanel.getNameT().setText("");
				deletePanel.getIdT().setText("");
				deletePanel.getPwdT().setText("");
			}else 
				JOptionPane.showMessageDialog(this, "로그인이 필요한 서비스입니다");
		}else if(e.getActionCommand() == "LOGOUT") {
			card.show(centerP,"home");
			
			writeBtn.setVisible(true);
			loginBtn.setVisible(true);
			logoutBtn.setVisible(false);
			
			loginPanel.setId(null);
		}
		//-----------------------------------------------
		//HomePanel
		if(e.getActionCommand() == "검색") { // 레시피명 검색 (검색창)
			int sw = homePanel.recipeNameSearch();
			if(sw == 1) card.show(centerP, "search");
		}else if(e.getActionCommand() == "한식") { // 카테고리 검색
			String category = "한식";
	        int sw = homePanel.categorySearch(category);
	           if(sw == 1) card.show(centerP, "search");
		}else if(e.getActionCommand() == "양식") {
			String category = "양식";
	        int sw = homePanel.categorySearch(category);
	           if(sw == 1) card.show(centerP, "search");
		}else if(e.getActionCommand() == "중식") {
			String category = "중식";
	        int sw = homePanel.categorySearch(category);
	           if(sw == 1) card.show(centerP, "search");
		}else if(e.getActionCommand() == "일식") {
			String category = "일식";
	        int sw = homePanel.categorySearch(category);
	           if(sw == 1) card.show(centerP, "search");
		}
		//-----------------------------------------------
		//WritePanel
		if(e.getActionCommand() == "회원가입") {
			if(writePanel.getIdCheck()==true && writePanel.getEmailCheck()==true && writePanel.getNameT().getText() != null) { //회원가입 성공
				card.show(centerP, "home"); 
				JOptionPane.showMessageDialog(this, "회원가입을 축하합니다!");
			}else if(writePanel.getIdCheck()==false){ //회원가입 실패
				card.show(centerP, "write");	
				JOptionPane.showMessageDialog(this, "아이디 중복체크를 완료해주세요");
			}else if(writePanel.getEmailCheck()==false){ //회원가입 실패
				card.show(centerP, "write");	
				JOptionPane.showMessageDialog(this, "이메일 인증을 완료해주세요");
			}else if(writePanel.getNameT().getText() == null){ //회원가입 실패
				card.show(centerP, "write");	
				JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요");
			}
		}
		//-----------------------------------------------
		//LoginPanel
		if(e.getActionCommand() == "로그인") {
			if(loginPanel.getLoginCheck() != null) { // 로그인 성공
				card.show(centerP, "home"); 
				JOptionPane.showMessageDialog(this, "로그인 성공!");
			
				writeBtn.setVisible(false);
		        loginBtn.setVisible(false);
		        logoutBtn.setVisible(true);
			}else { //로그인 실패
				card.show(centerP, "login");
				JOptionPane.showMessageDialog(this, "로그인 실패! 아이디와 비밀번호를 확인하세요");
			}
		}
		//-----------------------------------------------
		//MyPagePanel
		if(e.getActionCommand() == "레시피 등록") {
			card.show(centerP, "recipeWrite"); 
			recipeWritePanel.lbupdate();
		}else if(e.getActionCommand() == "내 레시피 보기") {
			int sw = myPagePanel.idSearch(loginPanel.getId());
			if (sw == 1)
				card.show(centerP, "search");
		}else if(e.getActionCommand() == "회원 정보수정") {
			card.show(centerP, "update");
		}
		//------------------------------------------------------
		//DeletePanel
		if(e.getActionCommand() == "회원 탈퇴") {
			card.show(centerP, "delete");
		}else if(e.getActionCommand() == "탈퇴 완료") {
			String pwdCheck = JOptionPane.showInputDialog("비밀번호를 다시한번 입력해주세요");
			int su = deletePanel.deleteMember(pwdCheck);
			if(su>0) { // 탈퇴 완료
				card.show(centerP, "home");
				JOptionPane.showMessageDialog(this, "회원탈퇴 완료");
			
				writeBtn.setVisible(true);
	            loginBtn.setVisible(true);
	            logoutBtn.setVisible(false);

	            loginPanel.setId(null);
	            
			} else { // 탈퇴 실패
				card.show(centerP, "delete");
				JOptionPane.showMessageDialog(this, "해당 회원정보가 존재하지 않습니다");
			}
		}
		//-----------------------------------------------
		//UpdatePanel
		if(e.getActionCommand() == "수정 완료") {
			String pwdCheck = JOptionPane.showInputDialog("기존 비밀번호를 다시한번 입력해주세요");
			int su = updatePanel.updateMember(pwdCheck);
			if(su>0) { // 수정 성공
				card.show(centerP, "home"); 
				JOptionPane.showMessageDialog(this, "회원정보 수정 완료");
			}else { // 수정 실패
				card.show(centerP, "update");	
				JOptionPane.showMessageDialog(this, "해당 회원정보가 없습니다");
			}
		}		
		//-----------------------------------------------
		//DetailPanel
		if(e.getActionCommand() == "수정") { 
			// 로그인한 아이디 = 검색된레시피등록한아이디 일치해야 수정창 진입 가능
			if(loginPanel.getId() != null) { // 로그인 한 경우
				if(loginPanel.getId().equals(detailPanel.getDetailId())) {
					recipeUpdatePanel.lbupdate();
					card.show(centerP, "recipeUpdate");
				}else JOptionPane.showMessageDialog(this, "직접 등록한 레시피만 수정 가능합니다");
			}else JOptionPane.showMessageDialog(this, "로그인이 필요한 서비스입니다");
		
		
		}else if(e.getActionCommand() == "삭제") {
			// 로그인한 아이디 = 검색된레시피등록한아이디 일치해야 수정가능하도록 해야함!!
			if(loginPanel.getId() != null) { // 로그인상태에서만 가능
			int su = detailPanel.recipeDelete();
				if(su>0) {
					JOptionPane.showMessageDialog(this, "레시피 삭제 완료");
					card.show(centerP, "myPage");
				}
				else if(su==0) 
					JOptionPane.showMessageDialog(this, "직접 등록한 레시피만 삭제 가능합니다");
			}else // 로그인 안한상태
				JOptionPane.showMessageDialog(this, "로그인이 필요한 서비스입니다");
		}
		
		//-----------------------------------------------
		//RecipeWritePanel
		if(e.getActionCommand() == "등록") {
			int sw = recipeWritePanel.recipeWrite();
			
			//등록 성공시
			if(sw==1) {
	            myPagePanel.idSearch(loginPanel.getId());
	            card.show(centerP, "search");    
	         }
		}
		//-------------------------------------------------
		//RecipeUpdatePanel
		if(e.getActionCommand() == "저장") {
				int ans = JOptionPane.showConfirmDialog(this, "정말로 수정하시겠습니까?");
				if(ans == JOptionPane.YES_OPTION) {
					int sw = recipeUpdatePanel.recipeUpdate();
		            //등록 성공시
		            if(sw==1) {
		                myPagePanel.idSearch(loginPanel.getId());
		                card.show(centerP, "search");    
		            }
		            JOptionPane.showMessageDialog(this, "수정 완료");
		        }
		}
	}//actionPerformed(ActionEvent e)
//===============================================================
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel lb = (JLabel)e.getSource();
		detailPanel.detailPrint(lb.getText());
		card.show(centerP, "detail");
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
//========================================================================
	public static void main(String[] args) {
		new RecipeMain();
	}
	
}

















