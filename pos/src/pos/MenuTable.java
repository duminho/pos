package pos;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

public class MenuTable extends Menu{
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	
	public MenuTable() {
		//JButton[] b = new JButton[20];
		//Menu m = new Menu();
		Calendar time=Calendar.getInstance();
		int year = time.get(Calendar.YEAR);
		int month = time.get(Calendar.MONTH)+1;
		int date = time.get(Calendar.DATE);
		
		JFrame f = new JFrame("테이블 주문");
		f.setSize(1300,800);
		f.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("주문하기");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt[0]+=1;
				check=1;
				System.out.println(cnt[0]);
			}
		});
		btnNewButton.setBounds(12, 233, 153, 39);
		f.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("이동하기");
		button.setBackground(new Color(30, 144, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt[2]=1;
			}
		});
		button.setBounds(12, 282, 153, 39);
		f.getContentPane().add(button);
		
		JButton button_1 = new JButton("계산 하기");
		button_1.setBackground(new Color(30, 144, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt[1]=1;
				total1=0;
				total=0;
			}
		});
		button_1.setBounds(12, 331, 153, 39);
		f.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("든든한 한끼");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("나눔고딕", Font.ITALIC, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(188, 10, 782, 55);
		f.getContentPane().add(lblNewLabel);
		
		b1 = new JButton("1번 테이블");
		b1.setBackground(Color.CYAN);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(cnt[0] >= 1 && check == 1) {			//주문하기를 누르고 처음 테이블이 눌렸을때
					table[0]=100;
					MenuList menu = new MenuList();
					
				}
				
				if(check == 0 && table[0] == 100) {		//입력받은 주문을 출력하기 위한 클릭
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[0] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
					
					b1.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[0]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
					
				}
				if(cnt[1]==1 && 0 < table[0]) {	//계산하기를 누르고 테이블을 누르면 나오는형식
					cnt[1]=table[0];
					b1.setText("1번 테이블");
					MenuCalculation mc = new MenuCalculation();
					table[0]=0;
				}
				if(cnt[2] == 1 && table[0] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[0]; //테이블 번호 값
					move[1]=1; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[0] == 0) {
					
					switch(move[1]) {
						case 2:b1.setText(moveram[1]); b2.setText("2번 테이블"); table[1]=0;break;
						case 3:b1.setText(moveram[2]); b3.setText("3번 테이블"); table[2]=0;break;
						case 4:b1.setText(moveram[3]); b4.setText("4번 테이블"); table[3]=0;break;
						case 5:b1.setText(moveram[4]); b5.setText("5번 테이블"); table[4]=0;break;
						case 6:b1.setText(moveram[5]); b6.setText("6번 테이블"); table[5]=0;break;
						case 7:b1.setText(moveram[6]); b7.setText("7번 테이블"); table[6]=0;break;
						case 8:b1.setText(moveram[7]); b8.setText("8번 테이블"); table[7]=0;break;
					} 
					
					table[0]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[0] > 0) {
					
					switch(move[1]) {
						case 2:b1.setText(moveram[1]); b2.setText(moveram[0]); table[1]=table[0];break;
						case 3:b1.setText(moveram[2]); b3.setText(moveram[0]); table[2]=table[0];break;
						case 4:b1.setText(moveram[3]); b4.setText(moveram[0]); table[3]=table[0];break;
						case 5:b1.setText(moveram[4]); b5.setText(moveram[0]); table[4]=table[0];break;
						case 6:b1.setText(moveram[5]); b6.setText(moveram[0]); table[5]=table[0];break;
						case 7:b1.setText(moveram[6]); b7.setText(moveram[0]); table[6]=table[0];break;
						case 8:b1.setText(moveram[7]); b8.setText(moveram[0]); table[7]=table[0];break;
					} 
					
					table[0]=move[0];
					move[0]=0;
				}
				
			}
		});
		b1.setBounds(260, 263, 186, 100);
		f.getContentPane().add(b1);
		
		b2 = new JButton("2번 테이블");
		b2.setBackground(Color.CYAN);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt[0] >= 1 && check == 1) {
					table[1]=100;
					MenuList menu = new MenuList();					
				}
				
				if(check == 0 && table[1] == 100) {	
					
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[1] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
				
					b2.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[1]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
				}
				if(cnt[1]==1 && 0 < table[1]) {
					cnt[1]=table[1];
					b2.setText("2번 테이블");
					MenuCalculation mc = new MenuCalculation();
					table[1]=0;
				}
				if(cnt[2] == 1 && table[1] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[1]; //테이블 번호 값
					move[1]=2; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[1] == 0) {
					
					switch(move[1]) {
						case 1:b2.setText(moveram[0]); b1.setText("1번 테이블"); table[0]=0;break;
						
						case 3:b2.setText(moveram[2]); b3.setText("3번 테이블"); table[2]=0;break;
						case 4:b2.setText(moveram[3]); b4.setText("4번 테이블"); table[3]=0;break;
						case 5:b2.setText(moveram[4]); b5.setText("5번 테이블"); table[4]=0;break;
						case 6:b2.setText(moveram[5]); b6.setText("6번 테이블"); table[5]=0;break;
						case 7:b2.setText(moveram[6]); b7.setText("7번 테이블"); table[6]=0;break;
						case 8:b2.setText(moveram[7]); b8.setText("8번 테이블"); table[7]=0;break;
					} 
					
					table[1]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[1] > 0) {
					
					switch(move[1]) {
						case 1:b2.setText(moveram[0]); b1.setText(moveram[1]); table[0]=table[1];break;
						
						case 3:b2.setText(moveram[2]); b3.setText(moveram[1]); table[2]=table[1];break;
						case 4:b2.setText(moveram[3]); b4.setText(moveram[1]); table[3]=table[1];break;
						case 5:b2.setText(moveram[4]); b5.setText(moveram[1]); table[4]=table[1];break;
						case 6:b2.setText(moveram[5]); b6.setText(moveram[1]); table[5]=table[1];break;
						case 7:b2.setText(moveram[6]); b7.setText(moveram[1]); table[6]=table[1];break;
						case 8:b2.setText(moveram[7]); b8.setText(moveram[1]); table[7]=table[1];break;
					} 
					
					table[1]=move[0];
					move[0]=0;
				}
			}
		});
		b2.setBounds(260, 147, 186, 100);
		f.getContentPane().add(b2);
		
		b3 = new JButton("3번 테이블");
		b3.setBackground(Color.CYAN);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt[0] >= 1 && check == 1) {
					table[2]=100;
					MenuList menu = new MenuList();					
				}
				
				if(check == 0 && table[2] == 100) {	
					
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[2] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
				
					b3.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[2]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
				}
				if(cnt[1]==1 && 0 < table[2]) {
					cnt[1]=table[2];
					b3.setText("3번 테이블");
					MenuCalculation mc = new MenuCalculation();
					table[2]=0;
				}
				if(cnt[2] == 1 && table[2] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[2]; //테이블 번호 값
					move[1]=3; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[2] == 0) {
					
					switch(move[1]) {
						case 1:b3.setText(moveram[0]); b1.setText("1번 테이블"); table[0]=0;break;
						case 2:b3.setText(moveram[1]); b2.setText("2번 테이블"); table[1]=0;break;
						
						case 4:b3.setText(moveram[3]); b4.setText("4번 테이블"); table[3]=0;break;
						case 5:b3.setText(moveram[4]); b5.setText("5번 테이블"); table[4]=0;break;
						case 6:b3.setText(moveram[5]); b6.setText("6번 테이블"); table[5]=0;break;
						case 7:b3.setText(moveram[6]); b7.setText("7번 테이블"); table[6]=0;break;
						case 8:b3.setText(moveram[7]); b8.setText("8번 테이블"); table[7]=0;break;
					} 
					
					table[2]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[2] > 0) {
					
					switch(move[1]) {
						case 1:b3.setText(moveram[0]); b1.setText(moveram[2]); table[0]=table[2];break;
						case 2:b3.setText(moveram[1]); b2.setText(moveram[2]); table[1]=table[2];break;
						
						case 4:b3.setText(moveram[3]); b4.setText(moveram[2]); table[3]=table[2];break;
						case 5:b3.setText(moveram[4]); b5.setText(moveram[2]); table[4]=table[2];break;
						case 6:b3.setText(moveram[5]); b6.setText(moveram[2]); table[5]=table[2];break;
						case 7:b3.setText(moveram[6]); b7.setText(moveram[2]); table[6]=table[2];break;
						case 8:b3.setText(moveram[7]); b8.setText(moveram[2]); table[7]=table[2];break;
					} 
					
					table[2]=move[0];
					move[0]=0;
				}
			}
		});
		b3.setBounds(587, 150, 250, 100);
		f.getContentPane().add(b3);
		
		b4 = new JButton("4번 테이블");
		b4.setBackground(Color.CYAN);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt[0] >= 1 && check == 1) {
					table[3]=100;
					MenuList menu = new MenuList();					
				}
				
				if(check == 0 && table[3] == 100) {	
					
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[3] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
				
					b4.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[3]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
				}
				if(cnt[1]==1 && 0 < table[3]) { //계산하기
					cnt[1]=table[3];
					b4.setText("4번 테이블");
					MenuCalculation mc = new MenuCalculation();
					table[3]=0;
				}
				if(cnt[2] == 1 && table[3] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[3]; //테이블 번호 값
					move[1]=4; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[3] == 0) {
					
					switch(move[1]) {
						case 1:b4.setText(moveram[0]); b1.setText("1번 테이블"); table[0]=0;break;
						case 2:b4.setText(moveram[1]); b2.setText("2번 테이블"); table[1]=0;break;
						case 3:b4.setText(moveram[2]); b3.setText("3번 테이블"); table[2]=0;break;
						
						case 5:b4.setText(moveram[4]); b5.setText("5번 테이블"); table[4]=0;break;
						case 6:b4.setText(moveram[5]); b6.setText("6번 테이블"); table[5]=0;break;
						case 7:b4.setText(moveram[6]); b7.setText("7번 테이블"); table[6]=0;break;
						case 8:b4.setText(moveram[7]); b8.setText("8번 테이블"); table[7]=0;break;
					} 
					
					table[3]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[3] > 0) {
					
					switch(move[1]) {
						case 1:b4.setText(moveram[0]); b1.setText(moveram[3]); table[0]=table[3];break;
						case 2:b4.setText(moveram[1]); b2.setText(moveram[3]); table[1]=table[3];break;
						case 3:b4.setText(moveram[2]); b3.setText(moveram[3]); table[2]=table[3];break;
						
						case 5:b4.setText(moveram[4]); b5.setText(moveram[3]); table[4]=table[3];break;
						case 6:b4.setText(moveram[5]); b6.setText(moveram[3]); table[5]=table[3];break;
						case 7:b4.setText(moveram[6]); b7.setText(moveram[3]); table[6]=table[3];break;
						case 8:b4.setText(moveram[7]); b8.setText(moveram[3]); table[7]=table[3];break;
					} 
					
					table[3]=move[0];
					move[0]=0;
				}
			}
		});
		b4.setBounds(587, 263, 250, 100);
		f.getContentPane().add(b4);
		
		b5 = new JButton("5번 테이블");
		b5.setBackground(Color.CYAN);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt[0] >= 1 && check == 1) {
					table[4]=100;
					MenuList menu = new MenuList();					
				}
				
				if(check == 0 && table[4] == 100) {
					
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[4] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
					
					b5.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[4]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
				}
				if(cnt[1]==1 && 0 < table[4]) {
					cnt[1]=table[4];
					MenuCalculation mc = new MenuCalculation();
					b5.setText("5번 테이블");
					table[4]=0;
				}
				if(cnt[2] == 1 && table[4] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[4]; //테이블 번호 값
					move[1]=5; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[4] == 0) {
					
					switch(move[1]) {
						case 1:b5.setText(moveram[0]); b1.setText("1번 테이블"); table[0]=0;break;
						case 2:b5.setText(moveram[1]); b2.setText("2번 테이블"); table[1]=0;break;
						case 3:b5.setText(moveram[2]); b3.setText("3번 테이블"); table[2]=0;break;
						case 4:b5.setText(moveram[3]); b4.setText("4번 테이블"); table[3]=0;break;
						
						case 6:b5.setText(moveram[5]); b6.setText("6번 테이블"); table[5]=0;break;
						case 7:b5.setText(moveram[6]); b7.setText("7번 테이블"); table[6]=0;break;
						case 8:b5.setText(moveram[7]); b8.setText("8번 테이블"); table[7]=0;break;
					} 
					
					table[4]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[4] > 0) {
					
					switch(move[1]) {
						case 1:b5.setText(moveram[0]); b1.setText(moveram[4]); table[0]=table[4];break;
						case 2:b5.setText(moveram[1]); b2.setText(moveram[4]); table[1]=table[4];break;
						case 3:b5.setText(moveram[2]); b3.setText(moveram[4]); table[2]=table[4];break;
						case 4:b5.setText(moveram[3]); b4.setText(moveram[4]); table[3]=table[4];break;
						
						case 6:b5.setText(moveram[5]); b6.setText(moveram[4]); table[5]=table[4];break;
						case 7:b5.setText(moveram[6]); b7.setText(moveram[4]); table[6]=table[4];break;
						case 8:b5.setText(moveram[7]); b8.setText(moveram[4]); table[7]=table[4];break;
					} 
					
					table[4]=move[0];
					move[0]=0;
				}
			}
		});
		b5.setBounds(260, 562, 250, 100);
		f.getContentPane().add(b5);
		
		b6 = new JButton("6번 테이블");
		b6.setBackground(Color.CYAN);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt[0] >= 1 && check == 1) {
					table[5]=100;
					MenuList menu = new MenuList();					
				}
				
				if(check == 0 && table[5] == 100) {
					
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[5] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
					
					b6.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[5]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
				}
				if(cnt[1]==1 && 0 < table[5]) {
					cnt[1]=table[5];
					MenuCalculation mc = new MenuCalculation();
					b6.setText("6번 테이블");
					table[5]=0;
				}
				if(cnt[2] == 1 && table[5] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[5]; //테이블 번호 값
					move[1]=6; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[5] == 0) {
					
					switch(move[1]) {
						case 1:b6.setText(moveram[0]); b1.setText("1번 테이블"); table[0]=0;break;
						case 2:b6.setText(moveram[1]); b2.setText("2번 테이블"); table[1]=0;break;
						case 3:b6.setText(moveram[2]); b3.setText("3번 테이블"); table[2]=0;break;
						case 4:b6.setText(moveram[3]); b4.setText("4번 테이블"); table[3]=0;break;
						case 5:b6.setText(moveram[4]); b5.setText("5번 테이블"); table[4]=0;break;
						
						case 7:b6.setText(moveram[6]); b7.setText("7번 테이블"); table[6]=0;break;
						case 8:b6.setText(moveram[7]); b8.setText("8번 테이블"); table[7]=0;break;
					} 
					
					table[5]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[5] > 0) {
					
					switch(move[1]) {
						case 1:b6.setText(moveram[0]); b1.setText(moveram[5]); table[0]=table[5];break;
						case 2:b6.setText(moveram[1]); b2.setText(moveram[5]); table[1]=table[5];break;
						case 3:b6.setText(moveram[2]); b3.setText(moveram[5]); table[2]=table[5];break;
						case 4:b6.setText(moveram[3]); b4.setText(moveram[5]); table[3]=table[5];break;
						case 5:b6.setText(moveram[4]); b5.setText(moveram[5]); table[4]=table[5];break;
						
						case 7:b6.setText(moveram[6]); b7.setText(moveram[5]); table[6]=table[5];break;
						case 8:b6.setText(moveram[7]); b8.setText(moveram[5]); table[7]=table[5];break;
					} 
					
					table[5]=move[0];
					move[0]=0;
				}
			}
		});
		b6.setBounds(543, 562, 250, 100);
		f.getContentPane().add(b6);
		
		b7 = new JButton("7번 테이블");
		b7.setBackground(Color.CYAN);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt[0] >= 1 && check == 1) {
					table[6]=100;
					MenuList menu = new MenuList();					
				}
				
				if(check == 0 && table[6] == 100) {
					
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[6] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
					
					b7.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[6]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
				}
				if(cnt[1]==1 && 0 < table[6]) {
					cnt[1]=table[6];
					MenuCalculation mc = new MenuCalculation();
					b7.setText("7번 테이블");
					table[6]=0;
				}
				if(cnt[2] == 1 && table[6] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[6]; //테이블 번호 값
					move[1]=7; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[6] == 0) {
					
					switch(move[1]) {
						case 1:b7.setText(moveram[0]); b1.setText("1번 테이블"); table[0]=0;break;
						case 2:b7.setText(moveram[1]); b2.setText("2번 테이블"); table[1]=0;break;
						case 3:b7.setText(moveram[2]); b3.setText("3번 테이블"); table[2]=0;break;
						case 4:b7.setText(moveram[3]); b4.setText("4번 테이블"); table[3]=0;break;
						case 5:b7.setText(moveram[4]); b5.setText("5번 테이블"); table[4]=0;break;
						case 6:b7.setText(moveram[5]); b6.setText("6번 테이블"); table[5]=0;break;
						
						case 8:b7.setText(moveram[7]); b8.setText("8번 테이블"); table[7]=0;break;
					} 
					
					table[6]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[6] > 0) {
					
					switch(move[1]) {
						case 1:b7.setText(moveram[0]); b1.setText(moveram[6]); table[0]=table[6];break;
						case 2:b7.setText(moveram[1]); b2.setText(moveram[6]); table[1]=table[6];break;
						case 3:b7.setText(moveram[2]); b3.setText(moveram[6]); table[2]=table[6];break;
						case 4:b7.setText(moveram[3]); b4.setText(moveram[6]); table[3]=table[6];break;
						case 5:b7.setText(moveram[4]); b5.setText(moveram[6]); table[4]=table[6];break;
						case 6:b7.setText(moveram[5]); b6.setText(moveram[6]); table[5]=table[6];break;
						
						case 8:b7.setText(moveram[7]); b8.setText(moveram[6]); table[7]=table[6];break;
					} 
					
					table[6]=move[0];
					move[0]=0;
				}
			}
		});
		b7.setBounds(260, 452, 250, 100);
		f.getContentPane().add(b7);
		
		b8 = new JButton("8번 테이블");
		b8.setBackground(Color.CYAN);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt[0] >= 1 && check == 1) {			
					table[7]=100;
					MenuList menu = new MenuList();
					
				}
				
				if(check == 0 && table[7] == 100) {
					
					TSalesDAO dao = new TSalesDAO();
					ArrayList list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {		
						TSalesDTO dto = (TSalesDTO)list.get(i);
						if(cnt[0] == dto.getNumber()) {
								
							table[7] = dto.getNumber();
							int quantity = dto.getQuantity();
							int price = dto.getPrice();
							total1+=quantity;
							total+=price;
						}
					}
					
					b8.setText("총량: "+total1+"\n"+"합계: "+total+"원");
					moveram[7]="총량:"+total1+" 합계:"+total+"원";
					total1=0;
					total=0;
				}
				if(cnt[1]==1 && 0 < table[7]) {
					cnt[1]=table[7];
					MenuCalculation mc = new MenuCalculation();
					b8.setText("8번 테이블");
					table[7]=0;
				}
				if(cnt[2] == 1 && table[7] > 0 && move[0] == 0) { //테이블 위치 이동
					move[0]=table[7]; //테이블 번호 값
					move[1]=8; // 테이블 위치
					cnt[2]=0; // 카운트리셋
				}else if(move[0] > 0 && table[7] == 0) {
					
					switch(move[1]) {
						case 1:b8.setText(moveram[0]); b1.setText("1번 테이블"); table[0]=0;break;
						case 2:b8.setText(moveram[1]); b2.setText("2번 테이블"); table[1]=0;break;
						case 3:b8.setText(moveram[2]); b3.setText("3번 테이블"); table[2]=0;break;
						case 4:b8.setText(moveram[3]); b4.setText("4번 테이블"); table[3]=0;break;
						case 5:b8.setText(moveram[4]); b5.setText("5번 테이블"); table[4]=0;break;
						case 6:b8.setText(moveram[5]); b6.setText("6번 테이블"); table[5]=0;break;
						case 7:b8.setText(moveram[7]); b7.setText("7번 테이블"); table[6]=0;break;
					} 
					
					table[7]=move[0];
					move[0]=0;
					
				}else if(move[0] > 0 && table[7] > 0) {
					
					switch(move[1]) {
						case 1:b8.setText(moveram[0]); b1.setText(moveram[7]); table[0]=table[7];break;
						case 2:b8.setText(moveram[1]); b2.setText(moveram[7]); table[1]=table[7];break;
						case 3:b8.setText(moveram[2]); b3.setText(moveram[7]); table[2]=table[7];break;
						case 4:b8.setText(moveram[3]); b4.setText(moveram[7]); table[3]=table[7];break;
						case 5:b8.setText(moveram[4]); b5.setText(moveram[7]); table[4]=table[7];break;
						case 6:b8.setText(moveram[5]); b6.setText(moveram[7]); table[5]=table[7];break;
						case 7:b8.setText(moveram[6]); b7.setText(moveram[7]); table[6]=table[7];break;
					} 
					
					table[7]=move[0];
					move[0]=0;
				}
			}
		});
		b8.setBounds(543, 452, 250, 100);
		f.getContentPane().add(b8);
		
		JButton button_2 = new JButton("전체 취소");
		button_2.setBackground(new Color(30, 144, 255));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt[0]=0;
				int number=0;
				TSalesDAO dao = new TSalesDAO();
				ArrayList list = dao.selectAll();
				for (int i = 0; i < list.size(); i++) {
					TSalesDTO dto = (TSalesDTO)list.get(i);
					number = dto.getNumber();
				}
				for (;number > 0; number--) {					
					try {
						System.out.println(number);
						dao.delete(number);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				b1.setText("1번 테이블");
				b2.setText("2번 테이블");
				b3.setText("3번 테이블");
				b4.setText("4번 테이블");
				b5.setText("5번 테이블");
				b6.setText("6번 테이블");
				b7.setText("7번 테이블");
				b8.setText("8번 테이블");
			}
		});
		button_2.setBounds(12, 380, 153, 39);
		f.getContentPane().add(button_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(188, 394, 735, 25);
		f.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(504, 147, 25, 270);
		f.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(12, 93, 927, 32);
		panel_2.setLayout(null);
		f.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("영업일자 :");
		lblNewLabel_1.setBounds(0, 0, 80, 32);
		panel_2.add(lblNewLabel_1);
		
		JLabel label = new JLabel(year+"-"+month+"-"+date);
		label.setBounds(105, 0, 80, 32);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("담당자 :");
		label_1.setBounds(227, 0, 80, 32);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("김민중");
		label_2.setBounds(378, 0, 80, 32);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(12, 10, 1032, 55);
		panel_3.setLayout(null);
		f.getContentPane().add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("테이블 주문");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 10, 183, 35);
		panel_3.add(lblNewLabel_2);
		
		JButton button_3 = new JButton("돌아가기");
		button_3.setBackground(new Color(30, 144, 255));
		button_3.setBounds(12, 690, 153, 39);
		f.getContentPane().add(button_3);
		
		
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		MenuTable name = new MenuTable();
	}
}
