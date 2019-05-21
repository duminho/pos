package pos;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MenuList extends Menu {
	
	public MenuList(){
		JFrame f = new JFrame("메뉴 리스트");
		JTextField[] t = new JTextField[7];
		MenuDAO dao = new MenuDAO();
		
		f.getContentPane().setBackground(Color.WHITE);
		f.setSize(800,800);
		f.getContentPane().setLayout(null);
		
		for (int i = 0; i < t.length; i++) {//-------------------------------------텍스트 생성중----------------------------//
			t[i]= new JTextField();	
			t[i].setBounds(12, 143+((i+1)*40), 280, 40);
			f.getContentPane().add(t[i]);
			t[i].setColumns(10);
		}
		
		t[0].addMouseListener(new MouseListener() {  //1번 텍스트 필드
			public void mouseReleased(MouseEvent e) { // 출시됌
			}
			public void mousePressed(MouseEvent e) { // 눌러지다
			}
			public void mouseExited(MouseEvent e) {	// 나갔을 때 반응
			}
			public void mouseEntered(MouseEvent e) { // 들어갔을때 반응	
			}
			public void mouseClicked(MouseEvent e) { // 클릭했을때 반응
				System.out.println("1번 칸");
				String ram=t[0].getText();
				dump=ram.charAt(0);
				System.out.println(dump);
			}
		});
		t[1].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) { // 출시됌
			}
			public void mousePressed(MouseEvent e) { // 눌러지다
			}
			public void mouseExited(MouseEvent e) {	// 나갔을 때 반응
			}
			public void mouseEntered(MouseEvent e) { // 들어갔을때 반응	
			}
			public void mouseClicked(MouseEvent e) { // 클릭했을때 반응
				System.out.println("2번 칸");
				String ram=t[1].getText();
				dump=ram.charAt(0);
				System.out.println(dump);
			}
		});
		t[2].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) { // 출시됌
			}
			public void mousePressed(MouseEvent e) { // 눌러지다
			}
			public void mouseExited(MouseEvent e) {	// 나갔을 때 반응
			}
			public void mouseEntered(MouseEvent e) { // 들어갔을때 반응	
			}
			public void mouseClicked(MouseEvent e) { // 클릭했을때 반응
				System.out.println("3번 칸");
				String ram=t[2].getText();
				dump=ram.charAt(0);
				System.out.println(dump);
			}
		});
		t[3].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) { // 출시됌
			}
			public void mousePressed(MouseEvent e) { // 눌러지다
			}
			public void mouseExited(MouseEvent e) {	// 나갔을 때 반응
			}
			public void mouseEntered(MouseEvent e) { // 들어갔을때 반응	
			}
			public void mouseClicked(MouseEvent e) { // 클릭했을때 반응
				System.out.println("4번 칸");
				String ram=t[3].getText();
				dump=ram.charAt(0);
				System.out.println(dump);
			}
		});
		t[4].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) { // 출시됌
			}
			public void mousePressed(MouseEvent e) { // 눌러지다
			}
			public void mouseExited(MouseEvent e) {	// 나갔을 때 반응
			}
			public void mouseEntered(MouseEvent e) { // 들어갔을때 반응	
			}
			public void mouseClicked(MouseEvent e) { // 클릭했을때 반응
				System.out.println("5번 칸");
				String ram=t[4].getText();
				dump=ram.charAt(0);
				System.out.println(dump);
			}
		});
		t[5].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) { // 출시됌
			}
			public void mousePressed(MouseEvent e) { // 눌러지다
			}
			public void mouseExited(MouseEvent e) {	// 나갔을 때 반응
			}
			public void mouseEntered(MouseEvent e) { // 들어갔을때 반응	
			}
			public void mouseClicked(MouseEvent e) { // 클릭했을때 반응
				System.out.println("6번 칸");
				String ram=t[5].getText();
				dump=ram.charAt(0);
				System.out.println(dump);
			}
		});
		
		JButton b1 = new JButton("쌀국수 3900원");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(0);
				a[0]++;
				if(index[0]==0) {
					for (int i = 0; i < 6; i++) {
						if(witch[0]<witch[i]) {
							index[0]=0;
							index[0]=witch[i]+1;
							witch[0]=witch[i];
						}
					}					
					witch[0]=index[0];
				}
				if(witch[0] == 0) {
					witch[0]++;
					index[0]++;
				}
				if(witch[0] == 1) {
					t[0].setText(dto.getName()+"\t"+a[0]+"\t"+dto.getPrice()*a[0]+"원");
				}else if(witch[0] == 2) {
					t[1].setText(dto.getName()+"\t"+a[0]+"\t"+dto.getPrice()*a[0]+"원");
				}else if(witch[0] == 3) {
					t[2].setText(dto.getName()+"\t"+a[0]+"\t"+dto.getPrice()*a[0]+"원");
				}else if(witch[0] == 4) {
					t[3].setText(dto.getName()+"\t"+a[0]+"\t"+dto.getPrice()*a[0]+"원");
				}else if(witch[0] == 5) {
					t[4].setText(dto.getName()+"\t"+a[0]+"\t"+dto.getPrice()*a[0]+"원");
				}else if(witch[0] == 6) {
					t[5].setText(dto.getName()+"\t"+a[0]+"\t"+dto.getPrice()*a[0]+"원");
				}
				
				total1= a[0]+a[1]+a[2]+a[3]+a[4]+a[5];
				total=(a[0]*3900)+(a[1]*4000)+(a[2]*5000)+(a[3]*8000)+(a[4]*6000)+(a[5]*1500);
				
				t[6].setText("총량\t"+total1+"\t"+total+"원");
				
				
			}
		});
		b1.setBackground(Color.CYAN);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("굴림", Font.PLAIN, 12));
		b1.setBounds(371, 215, 123, 67);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("볶음밥 4000원");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(1);
				a[1]++;
				if(index[1]==0) {
					for (int i = 0; i < 6; i++) {
						if(witch[1]<witch[i]) {
							index[1]=0;
							index[1]=witch[i]+1;
							witch[1]=witch[i];
						}
					}					
					witch[1]=index[1];
				}
				if(witch[1] == 0) {
					witch[1]++;
					index[1]++;
				}
				if(witch[1] == 1) {
					t[0].setText(dto.getName()+"\t"+a[1]+"\t"+dto.getPrice()*a[1]+"원");
				}else if(witch[1] == 2) {
					t[1].setText(dto.getName()+"\t"+a[1]+"\t"+dto.getPrice()*a[1]+"원");
				}else if(witch[1] == 3) {
					t[2].setText(dto.getName()+"\t"+a[1]+"\t"+dto.getPrice()*a[1]+"원");
				}else if(witch[1] == 4) {
					t[3].setText(dto.getName()+"\t"+a[1]+"\t"+dto.getPrice()*a[1]+"원");
				}else if(witch[1] == 5) {
					t[4].setText(dto.getName()+"\t"+a[1]+"\t"+dto.getPrice()*a[1]+"원");
				}else if(witch[1] == 6) {
					t[5].setText(dto.getName()+"\t"+a[1]+"\t"+dto.getPrice()*a[1]+"원");
				}
				
				total1=a[0]+a[1]+a[2]+a[3]+a[4]+a[5];
				total=(a[0]*3900)+(a[1]*4000)+(a[2]*5000)+(a[3]*8000)+(a[4]*6000)+(a[5]*1500);
				
				t[6].setText("총량\t"+total1+"\t"+total+"원");
				
			}
		});
		b2.setBackground(Color.CYAN);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("굴림", Font.PLAIN, 12));
		b2.setBounds(494, 215, 123, 67);
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("볶음면 5000원");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(2);
				a[2]++;
				if(index[2]==0) {
					for (int i = 0; i < 6; i++) {
						if(witch[2]<witch[i]) {
							index[2]=0;
							index[2]=witch[i]+1;
							witch[2]=witch[i];
						}
					}					
					witch[2]=index[2];
				}
				if(witch[2] == 0) {
					witch[2]++;
					index[2]++;
				}
				if(witch[2] == 1) {
					t[0].setText(dto.getName()+"\t"+a[2]+"\t"+dto.getPrice()*a[2]+"원");
				}else if(witch[2] == 2) {
					t[1].setText(dto.getName()+"\t"+a[2]+"\t"+dto.getPrice()*a[2]+"원");
				}else if(witch[2] == 3) {
					t[2].setText(dto.getName()+"\t"+a[2]+"\t"+dto.getPrice()*a[2]+"원");
				}else if(witch[2] == 4) {
					t[3].setText(dto.getName()+"\t"+a[2]+"\t"+dto.getPrice()*a[2]+"원");
				}else if(witch[2] == 5) {
					t[4].setText(dto.getName()+"\t"+a[2]+"\t"+dto.getPrice()*a[2]+"원");
				}else if(witch[2] == 6) {
					t[5].setText(dto.getName()+"\t"+a[2]+"\t"+dto.getPrice()*a[2]+"원");
				}
				
				total1=a[0]+a[1]+a[2]+a[3]+a[4]+a[5];
				total=(a[0]*3900)+(a[1]*4000)+(a[2]*5000)+(a[3]*8000)+(a[4]*6000)+(a[5]*1500);
				
				t[6].setText("총량\t"+total1+"\t"+total+"원");
				
			}
		});
		b3.setBackground(Color.CYAN);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("굴림", Font.PLAIN, 12));
		b3.setBounds(371, 281, 123, 67);
		f.getContentPane().add(b3);
		
		JButton b4 = new JButton("딤섬 8000원");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(3);
				a[3]++;
				if(index[3]==0) {
					for (int i = 0; i < 6; i++) {
						if(witch[3]<witch[i]) {
							index[3]=0;
							index[3]=witch[i]+1;
							witch[3]=witch[i];
						}
					}					
					witch[3]=index[3];
				}
				if(witch[3] == 0) {
					witch[3]++;
					index[3]++;
				}
				if(witch[3] == 1) {
					t[0].setText(dto.getName()+"\t"+a[3]+"\t"+dto.getPrice()*a[3]+"원");
				}else if(witch[3] == 2) {
					t[1].setText(dto.getName()+"\t"+a[3]+"\t"+dto.getPrice()*a[3]+"원");
				}else if(witch[3] == 3) {
					t[2].setText(dto.getName()+"\t"+a[3]+"\t"+dto.getPrice()*a[3]+"원");
				}else if(witch[3] == 4) {
					t[3].setText(dto.getName()+"\t"+a[3]+"\t"+dto.getPrice()*a[3]+"원");
				}else if(witch[3] == 5) {
					t[4].setText(dto.getName()+"\t"+a[3]+"\t"+dto.getPrice()*a[3]+"원");
				}else if(witch[3] == 6) {
					t[5].setText(dto.getName()+"\t"+a[3]+"\t"+dto.getPrice()*a[3]+"원");
				}
				
				total1=a[0]+a[1]+a[2]+a[3]+a[4]+a[5];
				total=(a[0]*3900)+(a[1]*4000)+(a[2]*5000)+(a[3]*8000)+(a[4]*6000)+(a[5]*1500);
				
				t[6].setText("총량\t"+total1+"\t"+total+"원");
				
			}
		});
		b4.setBackground(Color.CYAN);
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("굴림", Font.PLAIN, 12));
		b4.setBounds(494, 281, 123, 67);
		f.getContentPane().add(b4);
		
		JButton b5 = new JButton("새우볼 6000원");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(4);
				a[4]++;
				if(index[4]==0) {
					for (int i = 0; i < 6; i++) {
						if(witch[4]<witch[i]) {
							index[4]=0;
							index[4]=witch[i]+1;
							witch[4]=witch[i];
						}
					}					
					witch[4]=index[4];
				}
				if(witch[4] == 0) {
					witch[4]++;
					index[4]++;
				}
				if(witch[4] == 1) {
					t[0].setText(dto.getName()+"\t"+a[4]+"\t"+dto.getPrice()*a[4]+"원");
				}else if(witch[4] == 2) {
					t[1].setText(dto.getName()+"\t"+a[4]+"\t"+dto.getPrice()*a[4]+"원");
				}else if(witch[4] == 3) {
					t[2].setText(dto.getName()+"\t"+a[4]+"\t"+dto.getPrice()*a[4]+"원");
				}else if(witch[4] == 4) {
					t[3].setText(dto.getName()+"\t"+a[4]+"\t"+dto.getPrice()*a[4]+"원");
				}else if(witch[4] == 5) {
					t[4].setText(dto.getName()+"\t"+a[4]+"\t"+dto.getPrice()*a[4]+"원");
				}else if(witch[4] == 6) {
					t[5].setText(dto.getName()+"\t"+a[4]+"\t"+dto.getPrice()*a[4]+"원");
				}
				
				total1=a[0]+a[1]+a[2]+a[3]+a[4]+a[5];
				total=(a[0]*3900)+(a[1]*4000)+(a[2]*5000)+(a[3]*8000)+(a[4]*6000)+(a[5]*1500);
				
				t[6].setText("총량\t"+total1+"\t"+total+"원");
				
			}
		});
		b5.setBackground(Color.CYAN);
		b5.setForeground(Color.BLACK);
		b5.setFont(new Font("굴림", Font.PLAIN, 12));
		b5.setBounds(371, 348, 123, 67);
		f.getContentPane().add(b5);
		
		JButton b6 = new JButton("음료 1500원");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(5);
				a[5]++;
				if(index[5]==0) {
					for (int i = 0; i < 6; i++) {
						if(witch[5]<witch[i]) {
							index[5]=0;
							index[5]=witch[i]+1;
							witch[5]=witch[i];
						}
					}					
					witch[5]=index[5];
				}
				if(witch[5] == 0) {
					witch[5]++;
					index[5]++;
				}
				if(witch[5] == 1) {
					t[0].setText(dto.getName()+"\t"+a[5]+"\t"+dto.getPrice()*a[5]+"원");
				}else if(witch[5] == 2) {
					t[1].setText(dto.getName()+"\t"+a[5]+"\t"+dto.getPrice()*a[5]+"원");
				}else if(witch[5] == 3) {
					t[2].setText(dto.getName()+"\t"+a[5]+"\t"+dto.getPrice()*a[5]+"원");
				}else if(witch[5] == 4) {
					t[3].setText(dto.getName()+"\t"+a[5]+"\t"+dto.getPrice()*a[5]+"원");
				}else if(witch[5] == 5) {
					t[4].setText(dto.getName()+"\t"+a[5]+"\t"+dto.getPrice()*a[5]+"원");
				}else if(witch[5] == 6) {	
					t[5].setText(dto.getName()+"\t"+a[5]+"\t"+dto.getPrice()*a[5]+"원");
				}
				
				total1=a[0]+a[1]+a[2]+a[3]+a[4]+a[5];
				total=(a[0]*3900)+(a[1]*4000)+(a[2]*5000)+(a[3]*8000)+(a[4]*6000)+(a[5]*1500);
				
				t[6].setText("총량\t"+total1+"\t"+total+"원");
				
			}
		});
		b6.setBackground(Color.CYAN);
		b6.setForeground(Color.BLACK);
		b6.setFont(new Font("굴림", Font.PLAIN, 12));
		b6.setBounds(494, 348, 123, 67);
		f.getContentPane().add(b6);
		
		JLabel lblNewLabel = new JLabel("품목");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 121, 83, 34);
		f.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("수량");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(107, 121, 83, 34);
		f.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("금액");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(202, 121, 83, 34);
		f.getContentPane().add(label_1);
		
		JButton button = new JButton("주문 완료");		//(insert)데이터 베이스 입력중
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TSalesDAO dao = new TSalesDAO();
				TSalesDTO dto = new TSalesDTO();
				//table[cnt-1]=cnt;
				for (int i = 0; i < a.length; i++) {
					if(a[i] > 0) {
						dto.setNumber(cnt[0]);
						dto.setKind(kind[i]);
						dto.setQuantity(a[i]);
						dto.setPrice(menudata[i]*a[i]);
						try {
							dao.insert(dto);
							check=0;
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				f.setVisible(false);
			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 18));
		button.setBounds(202, 535, 135, 51);
		f.getContentPane().add(button);
		
		JButton button_1 = new JButton("주문 취소");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < t.length-1; i++) {
					if(kind[i].equals(String.valueOf(dump))) { //클릭한 곳이랑 같은종류인지 비교
						
						t[witch[i]-1].setText(""); // 클릭한곳 초기화
						int ram = witch[i]+1; // 자신보다 한칸 밑에 있는 텍스트와 값이 같음
						for (int j = 0; j < 6; j++) { // 텍스트 전부 비교
							if(ram == witch[j]) { // 값이 같을때 이행
								
								t[ram-2].setText(t[witch[j]-1].getText()); //텍스토 위로 옮기기
								t[witch[j]-1].setText(""); // 옮기고 초기화
								ram = witch[j]+1; // 다음 값 읽기위해 저장
								witch[j]--;	// 한칸씩 다운
								index[j]--; // 한칸씩 다운
								j=0; //7이 될때까지 비교
								
							}
						}
						
						a[i]=0;	//메뉴 초기화
						witch[i]=0; //메뉴 위치 초기화
						index[i]=0; //덤
						
						total1=a[0]+a[1]+a[2]+a[3]+a[4]+a[5];
						total=(a[0]*3900)+(a[1]*4000)+(a[2]*5000)+(a[3]*8000)+(a[4]*6000)+(a[5]*1500);
						
						t[6].setText("총량\t"+total1+"\t"+total+"원");
					}					
				}
			}
		});
		button_1.setFont(new Font("굴림", Font.PLAIN, 18));
		button_1.setBounds(337, 535, 135, 51);
		f.getContentPane().add(button_1);
		
		f.setVisible(true);
	}
}
