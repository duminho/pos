package pos;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;


import javax.swing.JCheckBox;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;



public class MenueMain2 {
	private static JTextField id;
	private static JTextField password;
	private static JTextField nowT;
	private static JButton b[] = new JButton[30];

	public static void main(String[] args) {
		
		JFrame f = new JFrame("MEMBER LOGIN");
		f.setSize(800, 700);
		f.getContentPane().setLayout(null);

		JButton lblNewLabel = new JButton("아이디");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(102, 255, 255));
		lblNewLabel.setBounds(21, 93, 144, 40);
		f.getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("비밀번호");
		button.setEnabled(false);
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.setBackground(new Color(102, 255, 255));
		button.setBounds(21, 135, 144, 40);
		f.getContentPane().add(button);
		
		id = new JTextField();
		nowT = id;
		id.setFont(new Font("굴림", Font.PLAIN, 20));
		id.setBounds(166, 93, 200, 40);
		id.addMouseListener(new MouseListener() {
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
				nowT = id;
			}
		});
		f.getContentPane().add(id);
		id.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("굴림", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(166, 135, 200, 40);
		password.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				nowT = password;
			}
		});
		f.getContentPane().add(password);
		
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
				b[num].setBounds(120+((j+yp)*91), 290+(i*90), 80, 80);
				b[num].isEnabled();
				f.getContentPane().add(b[num]);
				
			}
			
		}
		
		
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		button_1.setBackground(new Color(102, 255, 255));
		button_1.setBounds(21, 181, 345, 40);
		f.getContentPane().add(button_1);
		
		JButton login = new JButton("LOG-IN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = id.getText();
				String pw = password.getText();
				
				if(Id.equals("1234")&&pw.equals("1234")) {
				}else if(Id.equals("1234")==false) {
					System.out.println(Id);
					JOptionPane.showMessageDialog(null,"아이디가 틀립니다.");
				}else if(pw.equals("1234")==false) {
					JOptionPane.showMessageDialog(null,"비밀번호가 틀립니다.");
				}
				
			}
		});
		login.setBackground(new Color(153, 255, 255));
		login.setFont(new Font("굴림", Font.BOLD, 20));
		login.setBounds(166, 226, 200, 40);
		f.getContentPane().add(login);
		
		JCheckBox save = new JCheckBox("저장");
		save.setBackground(Color.WHITE);
		save.setFont(new Font("굴림", Font.PLAIN, 21));
		save.setHorizontalAlignment(SwingConstants.CENTER);
		save.setBounds(21, 227, 144, 40);
		f.getContentPane().add(save);
		
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
		n123.setBackground(new Color(100, 149, 237));
		n123.setForeground(Color.WHITE);
		n123.setFont(new Font("굴림", Font.PLAIN, 18));
		n123.setBounds(29, 290, 78, 117);
		f.getContentPane().add(n123);
		
		JButton nClear = new JButton("CLEAR");
		nClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText("");
			}
		});
		
		
		
		
		nClear.setForeground(Color.WHITE);
		nClear.setFont(new Font("굴림", Font.PLAIN, 14));
		nClear.setBackground(new Color(100, 149, 237));
		nClear.setBounds(119, 290, 80, 117);
		f.getContentPane().add(nClear);
		
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
		nabc.setBounds(29, 417, 78, 117);
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
		nABC.setBounds(119, 417, 78, 117);
		f.getContentPane().add(nABC);
		
		
		JButton lblNewLabel_1 = new JButton("");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 276, 760, 375);
		f.getContentPane().add(lblNewLabel_1);
		
		
		
		f.setVisible(true);
	}
}
