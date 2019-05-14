package pos;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MenuList {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	
	public MenuList(){
		JFrame f = new JFrame();
		MenuDAO dao = new MenuDAO();
		Menu m = new Menu();
		f.getContentPane().setBackground(Color.WHITE);
		f.setSize(800,800);
		f.getContentPane().setLayout(null);
		
		JButton b1 = new JButton("쌀국수 3900원");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(0);
				m.a++;
				if(m.index[0]==0) {
					for (int i = 0; i < 6; i++) {
						if(m.witch[0]<m.witch[i]) {
							m.index[0]=0;
							m.index[0]=m.witch[i]+1;
							m.witch[0]=m.witch[i];
						}
					}					
					m.witch[0]=m.index[0];
				}
				if(m.witch[0] == 0) {
					m.witch[0]++;
					m.index[0]++;
				}
				if(m.witch[0] == 1) {
					t1.setText(dto.getName()+"\t"+m.a+"\t"+dto.getPrice()*m.a+"원");
				}else if(m.witch[0] == 2) {
					t2.setText(dto.getName()+"\t"+m.a+"\t"+dto.getPrice()*m.a+"원");
				}else if(m.witch[0] == 3) {
					t3.setText(dto.getName()+"\t"+m.a+"\t"+dto.getPrice()*m.a+"원");
				}else if(m.witch[0] == 4) {
					t4.setText(dto.getName()+"\t"+m.a+"\t"+dto.getPrice()*m.a+"원");
				}else if(m.witch[0] == 5) {
					t5.setText(dto.getName()+"\t"+m.a+"\t"+dto.getPrice()*m.a+"원");
				}else if(m.witch[0] == 6) {
					t6.setText(dto.getName()+"\t"+m.a+"\t"+dto.getPrice()*m.a+"원");
				}
				
				m.total1=m.a+m.b+m.c+m.d+m.e+m.f;
				m.total=(m.a*3900)+(m.b*4000)+(m.c*5000)+(m.d*8000)+(m.e*6000)+(m.f*1500);
				
				t7.setText("총량\t"+m.total1+"\t"+m.total+"원");
				
			}
		});
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("굴림", Font.PLAIN, 12));
		b1.setBounds(371, 215, 123, 67);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("볶음밥 4000원");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(1);
				m.b++;
				if(m.index[1]==0) {
					for (int i = 0; i < 6; i++) {
						if(m.witch[1]<m.witch[i]) {
							m.index[1]=0;
							m.index[1]=m.witch[i]+1;
							m.witch[1]=m.witch[i];
						}
					}					
					m.witch[1]=m.index[1];
				}
				if(m.witch[1] == 0) {
					m.witch[1]++;
					m.index[1]++;
				}
				if(m.witch[1] == 1) {
					t1.setText(dto.getName()+"\t"+m.b+"\t"+dto.getPrice()*m.b+"원");
				}else if(m.witch[1] == 2) {
					t2.setText(dto.getName()+"\t"+m.b+"\t"+dto.getPrice()*m.b+"원");
				}else if(m.witch[1] == 3) {
					t3.setText(dto.getName()+"\t"+m.b+"\t"+dto.getPrice()*m.b+"원");
				}else if(m.witch[1] == 4) {
					t4.setText(dto.getName()+"\t"+m.b+"\t"+dto.getPrice()*m.b+"원");
				}else if(m.witch[1] == 5) {
					t5.setText(dto.getName()+"\t"+m.b+"\t"+dto.getPrice()*m.b+"원");
				}else if(m.witch[1] == 6) {
					t6.setText(dto.getName()+"\t"+m.b+"\t"+dto.getPrice()*m.b+"원");
				}
				
				m.total1=m.a+m.b+m.c+m.d+m.e+m.f;
				m.total=(m.a*3900)+(m.b*4000)+(m.c*5000)+(m.d*8000)+(m.e*6000)+(m.f*1500);
				
				t7.setText("총량\t"+m.total1+"\t"+m.total+"원");
			}
		});
		b2.setBackground(Color.YELLOW);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("굴림", Font.PLAIN, 12));
		b2.setBounds(494, 215, 123, 67);
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("볶음면 5000원");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(2);
				m.c++;
				if(m.index[2]==0) {
					for (int i = 0; i < 6; i++) {
						if(m.witch[2]<m.witch[i]) {
							m.index[2]=0;
							m.index[2]=m.witch[i]+1;
							m.witch[2]=m.witch[i];
						}
					}					
					m.witch[2]=m.index[2];
				}
				if(m.witch[2] == 0) {
					m.witch[2]++;
					m.index[2]++;
				}
				if(m.witch[2] == 1) {
					t1.setText(dto.getName()+"\t"+m.c+"\t"+dto.getPrice()*m.c+"원");
				}else if(m.witch[2] == 2) {
					t2.setText(dto.getName()+"\t"+m.c+"\t"+dto.getPrice()*m.c+"원");
				}else if(m.witch[2] == 3) {
					t3.setText(dto.getName()+"\t"+m.c+"\t"+dto.getPrice()*m.c+"원");
				}else if(m.witch[2] == 4) {
					t4.setText(dto.getName()+"\t"+m.c+"\t"+dto.getPrice()*m.c+"원");
				}else if(m.witch[2] == 5) {
					t5.setText(dto.getName()+"\t"+m.c+"\t"+dto.getPrice()*m.c+"원");
				}else if(m.witch[2] == 6) {
					t6.setText(dto.getName()+"\t"+m.c+"\t"+dto.getPrice()*m.c+"원");
				}
				
				m.total1=m.a+m.b+m.c+m.d+m.e+m.f;
				m.total=(m.a*3900)+(m.b*4000)+(m.c*5000)+(m.d*8000)+(m.e*6000)+(m.f*1500);
				
				t7.setText("총량\t"+m.total1+"\t"+m.total+"원");
				
			}
		});
		b3.setBackground(Color.YELLOW);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("굴림", Font.PLAIN, 12));
		b3.setBounds(371, 281, 123, 67);
		f.getContentPane().add(b3);
		
		JButton b4 = new JButton("딤섬 8000원");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(3);
				m.d++;
				if(m.index[3]==0) {
					for (int i = 0; i < 6; i++) {
						if(m.witch[3]<m.witch[i]) {
							m.index[3]=0;
							m.index[3]=m.witch[i]+1;
							m.witch[3]=m.witch[i];
						}
					}					
					m.witch[3]=m.index[3];
				}
				if(m.witch[3] == 0) {
					m.witch[3]++;
					m.index[3]++;
				}
				if(m.witch[3] == 1) {
					t1.setText(dto.getName()+"\t"+m.d+"\t"+dto.getPrice()*m.d+"원");
				}else if(m.witch[3] == 2) {
					t2.setText(dto.getName()+"\t"+m.d+"\t"+dto.getPrice()*m.d+"원");
				}else if(m.witch[3] == 3) {
					t3.setText(dto.getName()+"\t"+m.d+"\t"+dto.getPrice()*m.d+"원");
				}else if(m.witch[3] == 4) {
					t4.setText(dto.getName()+"\t"+m.d+"\t"+dto.getPrice()*m.d+"원");
				}else if(m.witch[3] == 5) {
					t5.setText(dto.getName()+"\t"+m.d+"\t"+dto.getPrice()*m.d+"원");
				}else if(m.witch[3] == 6) {
					t6.setText(dto.getName()+"\t"+m.d+"\t"+dto.getPrice()*m.d+"원");
				}
				
				m.total1=m.a+m.b+m.c+m.d+m.e+m.f;
				m.total=(m.a*3900)+(m.b*4000)+(m.c*5000)+(m.d*8000)+(m.e*6000)+(m.f*1500);
				
				t7.setText("총량\t"+m.total1+"\t"+m.total+"원");
				
			}
		});
		b4.setBackground(Color.YELLOW);
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("굴림", Font.PLAIN, 12));
		b4.setBounds(494, 281, 123, 67);
		f.getContentPane().add(b4);
		
		JButton b5 = new JButton("새우볼 6000원");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(4);
				m.e++;
				if(m.index[4]==0) {
					for (int i = 0; i < 6; i++) {
						if(m.witch[4]<m.witch[i]) {
							m.index[4]=0;
							m.index[4]=m.witch[i]+1;
							m.witch[4]=m.witch[i];
						}
					}					
					m.witch[4]=m.index[4];
				}
				if(m.witch[4] == 0) {
					m.witch[4]++;
					m.index[4]++;
				}
				if(m.witch[4] == 1) {
					t1.setText(dto.getName()+"\t"+m.e+"\t"+dto.getPrice()*m.e+"원");
				}else if(m.witch[4] == 2) {
					t2.setText(dto.getName()+"\t"+m.e+"\t"+dto.getPrice()*m.e+"원");
				}else if(m.witch[4] == 3) {
					t3.setText(dto.getName()+"\t"+m.e+"\t"+dto.getPrice()*m.e+"원");
				}else if(m.witch[4] == 4) {
					t4.setText(dto.getName()+"\t"+m.e+"\t"+dto.getPrice()*m.e+"원");
				}else if(m.witch[4] == 5) {
					t5.setText(dto.getName()+"\t"+m.e+"\t"+dto.getPrice()*m.e+"원");
				}else if(m.witch[4] == 6) {
					t6.setText(dto.getName()+"\t"+m.e+"\t"+dto.getPrice()*m.e+"원");
				}
				
				m.total1=m.a+m.b+m.c+m.d+m.e+m.f;
				m.total=(m.a*3900)+(m.b*4000)+(m.c*5000)+(m.d*8000)+(m.e*6000)+(m.f*1500);
				
				t7.setText("총량\t"+m.total1+"\t"+m.total+"원");
				
			}
		});
		b5.setBackground(Color.YELLOW);
		b5.setForeground(Color.BLACK);
		b5.setFont(new Font("굴림", Font.PLAIN, 12));
		b5.setBounds(371, 348, 123, 67);
		f.getContentPane().add(b5);
		
		JButton b6 = new JButton("음료 1500원");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList list = dao.selectAll();
				MenuDTO dto=(MenuDTO)list.get(5);
				m.f++;
				if(m.index[5]==0) {
					for (int i = 0; i < 6; i++) {
						if(m.witch[5]<m.witch[i]) {
							m.index[5]=0;
							m.index[5]=m.witch[i]+1;
							m.witch[5]=m.witch[i];
						}
					}					
					m.witch[5]=m.index[5];
				}
				if(m.witch[5] == 0) {
					m.witch[5]++;
					m.index[5]++;
				}
				if(m.witch[5] == 1) {
					t1.setText(dto.getName()+"\t"+m.f+"\t"+dto.getPrice()*m.f+"원");
				}else if(m.witch[5] == 2) {
					t2.setText(dto.getName()+"\t"+m.f+"\t"+dto.getPrice()*m.f+"원");
				}else if(m.witch[5] == 3) {
					t3.setText(dto.getName()+"\t"+m.f+"\t"+dto.getPrice()*m.f+"원");
				}else if(m.witch[5] == 4) {
					t4.setText(dto.getName()+"\t"+m.f+"\t"+dto.getPrice()*m.f+"원");
				}else if(m.witch[5] == 5) {
					t5.setText(dto.getName()+"\t"+m.f+"\t"+dto.getPrice()*m.f+"원");
				}else if(m.witch[5] == 6) {	
					t6.setText(dto.getName()+"\t"+m.f+"\t"+dto.getPrice()*m.f+"원");
				}
				
				m.total1=m.a+m.b+m.c+m.d+m.e+m.f;
				m.total=(m.a*3900)+(m.b*4000)+(m.c*5000)+(m.d*8000)+(m.e*6000)+(m.f*1500);
				
				t7.setText("총량\t"+m.total1+"\t"+m.total+"원");
				
				
			}
		});
		b6.setBackground(Color.YELLOW);
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
		
		t1 = new JTextField();
		t1.setBounds(12, 186, 280, 40);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(12, 223, 280, 40);
		f.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(12, 262, 280, 40);
		f.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(12, 300, 280, 40);
		f.getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(12, 339, 280, 40);
		f.getContentPane().add(t5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(12, 380, 280, 40);
		f.getContentPane().add(t6);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(12, 421, 280, 40);
		f.getContentPane().add(t7);
		
		JButton b7 = new JButton("카드 계산");
		b7.setFont(new Font("굴림", Font.PLAIN, 18));
		b7.setBounds(188, 535, 135, 51);
		f.getContentPane().add(b7);
		
		JButton b8 = new JButton("현금 계산");
		b8.setFont(new Font("굴림", Font.PLAIN, 18));
		b8.setBounds(324, 535, 135, 51);
		f.getContentPane().add(b8);
		
		JButton button = new JButton("주문 완료");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.cnt=0;
				f.setVisible(false);
			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 18));
		button.setBounds(461, 535, 135, 51);
		f.getContentPane().add(button);
		
		f.setVisible(true);
	}
}
