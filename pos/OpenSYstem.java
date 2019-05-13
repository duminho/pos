package pos;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class OpenSYstem {
	private static JTextField Dayt1;
	private static JTextField Dayt2;
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField nowT;
	private static JButton b[] = new JButton[30];
	private static JPanel memberp[] = new JPanel[12];

	public static void main(String[] args) {
		Date date = new Date();
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		
		JFrame f = new JFrame("개점처리");
		f.setUndecorated(true);
		f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		f.setSize(1300, 800);
		f.getContentPane().setLayout(null);
		
		
		//버튼 반복 생성
				int jo=7;
				int yp=0;
				for (int i = 0; i < 4; i++) {
					if(i==3) {
						jo=9;
						yp=-2;
					}
					for (int j = 1; j <jo; j++) {
						int num = (j+(i*6));
						b[num] = new JButton(String.valueOf(num));
						if(num>10) {
							b[num].setText(null);
						}
						switch(num){
						case 10:b[num].setText("0"); break;
						case 11:b[num].setText("00"); break;
						case 12:b[num].setText("000"); break;
						}
						b[num].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								nowT.setText(nowT.getText()+b[num].getText());
							}
						});
						b[num].setForeground(Color.BLACK);
						b[num].setFont(new Font("굴림", Font.PLAIN, 21));
						b[num].setBackground(new Color(100, 149, 237));
						b[num].setBounds(631+((j+yp)*91), 40+(i*90), 80, 80);
						b[num].isEnabled();
						f.getContentPane().add(b[num]);
						
					}
					
				}
		
		
		JButton button = new JButton("영업일자");
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.setEnabled(false);
		button.setBackground(new Color(102, 255, 255));
		button.setBounds(60, 41, 144, 40);
		f.getContentPane().add(button);
		
		Dayt1 = new JTextField();
		Dayt1.setFont(new Font("굴림", Font.PLAIN, 20));
		Dayt1.setColumns(10);
		Dayt1.setBounds(205, 41, 200, 40);
		f.getContentPane().add(Dayt1);
		
		JButton button_1 = new JButton("시스템일자");
		button_1.setFont(new Font("Dialog", Font.BOLD, 20));
		button_1.setEnabled(false);
		button_1.setBackground(new Color(102, 255, 255));
		button_1.setBounds(60, 86, 144, 40);
		f.getContentPane().add(button_1);
		
		Dayt2 = new JTextField();
		Dayt2.setEditable(false);
		Dayt2.setFont(new Font("굴림", Font.PLAIN, 20));
		Dayt2.setColumns(10);
		Dayt2.setBounds(205, 86, 200, 40);
		Dayt2.setText((year+1900) +"-"+ month +"-"+ day);
		f.getContentPane().add(Dayt2);
		
		JButton button_2 = new JButton("사원코드");
		button_2.setFont(new Font("Dialog", Font.BOLD, 20));
		button_2.setEnabled(false);
		button_2.setBackground(new Color(102, 255, 255));
		button_2.setBounds(60, 131, 144, 40);
		f.getContentPane().add(button_2);
		
		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.PLAIN, 20));
		t1.setColumns(10);
		t1.setBounds(205, 131, 200, 40);
		t1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				System.out.println("진입");
			}
			public void mouseClicked(MouseEvent e) {
				nowT = t1;
			}
		});
		f.getContentPane().add(t1);
		
		JButton button_3 = new JButton("사원명");
		button_3.setFont(new Font("Dialog", Font.BOLD, 20));
		button_3.setEnabled(false);
		button_3.setBackground(new Color(102, 255, 255));
		button_3.setBounds(60, 176, 144, 40);
		f.getContentPane().add(button_3);
		
		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.PLAIN, 20));
		t2.setColumns(10);
		t2.setBounds(205, 176, 200, 40);
		t2.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				System.out.println("2진입");
			}
			public void mouseClicked(MouseEvent e) {
				nowT = t2;
			}
		});
		f.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("굴림", Font.PLAIN, 20));
		t3.setColumns(10);
		t3.setBounds(205, 221, 200, 40);
		t3.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				System.out.println("3진입");
			}
			public void mouseClicked(MouseEvent e) {
				nowT = t3;
			}
		});
		f.getContentPane().add(t3);
		
		JButton button_4 = new JButton("비밀번호");
		button_4.setFont(new Font("Dialog", Font.BOLD, 20));
		button_4.setEnabled(false);
		button_4.setBackground(new Color(102, 255, 255));
		button_4.setBounds(60, 221, 144, 40);
		f.getContentPane().add(button_4);
		
		JButton nabc = new JButton("abc");
		nabc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[] list = {97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122};
				int i=1;
					for(char c : list) {
						String a = null;
						try {
							a= String.valueOf(c);						
						}catch(Exception e1) {
							System.out.println(e1.getMessage());
						}
						b[i].setText(a);
						if(i==list.length) {
							break;
						}
						i++;
						
					}
				
					
			}
		});
		nabc.setForeground(Color.WHITE);
		nabc.setFont(new Font("굴림", Font.PLAIN, 18));
		nabc.setBackground(new Color(100, 149, 237));
		nabc.setBounds(537, 168, 78, 117);
		f.getContentPane().add(nabc);
		
		JButton nABC = new JButton("ABC");
		nABC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] list = {65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90};
				int i=1;
					for(char c : list) {
						String a= String.valueOf(c);			
						b[i].setText(a);
						if(i==list.length) {
							break;
						}
						i++;
					}
				
				
			}
		});
		nABC.setForeground(Color.WHITE);
		nABC.setFont(new Font("굴림", Font.PLAIN, 18));
		nABC.setBackground(new Color(100, 149, 237));
		nABC.setBounds(627, 168, 78, 117);
		f.getContentPane().add(nABC);
		
		JButton n123 = new JButton("123");
		n123.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 27; i++) {
					b[i].setText(String.valueOf(i));
					if(i>10) {
						b[i].setText(null);
					}
					switch(i){
					case 10:b[i].setText("0"); break;
					case 11:b[i].setText("00"); break;
					case 12:b[i].setText("000"); break;
					}
				}
			}
		});
		n123.setForeground(Color.WHITE);
		n123.setFont(new Font("굴림", Font.PLAIN, 18));
		n123.setBackground(new Color(100, 149, 237));
		n123.setBounds(537, 41, 78, 117);
		f.getContentPane().add(n123);
		
		JButton nclear = new JButton("CLEAR");
		nclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText("");
			}
		});
		nclear.setForeground(Color.WHITE);
		nclear.setFont(new Font("굴림", Font.PLAIN, 14));
		nclear.setBackground(new Color(100, 149, 237));
		nclear.setBounds(627, 41, 80, 117);
		f.getContentPane().add(nclear);
		
		JButton button_11 = new JButton("");
		button_11.setEnabled(false);
		button_11.setBackground(Color.WHITE);
		button_11.setBounds(520, 27, 760, 375);
		f.getContentPane().add(button_11);
		
		JButton bopen = new JButton("개점");
		bopen.setFont(new Font("굴림", Font.PLAIN, 24));
		bopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bopen.setBounds(1019, 460, 160, 50);
		f.getContentPane().add(bopen);
		
		JButton button_6 = new JButton("환전");
		button_6.setFont(new Font("굴림", Font.PLAIN, 24));
		button_6.setBounds(835, 460, 160, 50);
		f.getContentPane().add(button_6);
		
		JButton bclose = new JButton("닫기 X");
		bclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
				System.exit(0);
			}
		});
		bclose.setFont(new Font("굴림", Font.PLAIN, 24));
		bclose.setBounds(1019, 690, 160, 50);
		f.getContentPane().add(bclose);
		
		//-=============사원 판넬 반복 생성=====================
		int x=0;
		int y=0;
		for(int i=0; i<12;i++) {
			memberp[i] = new JPanel();
			memberp[i].setBackground(new Color(224, 255, 255));
			memberp[i].setBounds(36+(173*x), 548+(52*y), 170, 50);
			memberp[i].setName(name);
			f.getContentPane().add(memberp[i]);
			
			x++;
			if(i==5) {
				x=0;
				y++;
			}
		}
		
		JLabel lblNewLabel = new JLabel("사원 리스트");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 27));
		lblNewLabel.setBounds(36, 493, 190, 50);
		f.getContentPane().add(lblNewLabel);
		
		JButton BackGround = new JButton("");
		BackGround.setBackground(SystemColor.textHighlightText);
		BackGround.setEnabled(false);
		BackGround.setBounds(12, 0, 1476, 790);
		f.getContentPane().add(BackGround);
		
		f.setVisible(true);
	}
}
