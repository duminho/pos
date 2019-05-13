package pos;


import javax.swing.JFrame;
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



public class MenueMain {
	private static JTextField id;
	private static JTextField password;
	private static JTextField nowT;
	private static JButton b[] = new JButton[24];

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
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		button_1.setBackground(new Color(102, 255, 255));
		button_1.setBounds(21, 181, 345, 40);
		f.getContentPane().add(button_1);
		
		JButton login = new JButton("LOG-IN");
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
		nabc.setForeground(Color.WHITE);
		nabc.setFont(new Font("굴림", Font.PLAIN, 18));
		nabc.setBackground(new Color(100, 149, 237));
		nabc.setBounds(29, 417, 78, 117);
		f.getContentPane().add(nabc);
		
		JButton nABC = new JButton("ABC");
		nABC.setForeground(Color.WHITE);
		nABC.setFont(new Font("굴림", Font.PLAIN, 18));
		nABC.setBackground(new Color(100, 149, 237));
		nABC.setBounds(119, 417, 78, 117);
		f.getContentPane().add(nABC);
		
		b[0] = new JButton("1");
		b[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+1);
			}
		});
		b[0].setForeground(Color.BLACK);
		b[0].setFont(new Font("굴림", Font.PLAIN, 21));
		b[0].setBackground(new Color(100, 149, 237));
		b[0].setBounds(211, 290, 80, 80);
		f.getContentPane().add(b[0]);
		
		b[1] = new JButton("2");
		b[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+2);
			}
		});
		b[1].setForeground(Color.BLACK);
		b[1].setFont(new Font("굴림", Font.PLAIN, 21));
		b[1].setBackground(new Color(100, 149, 237));
		b[1].setBounds(305, 290, 80, 80);
		f.getContentPane().add(b[1]);
		
		b[2] = new JButton("3");
		b[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+3);
			}
		});
		b[2].setForeground(Color.BLACK);
		b[2].setFont(new Font("굴림", Font.PLAIN, 21));
		b[2].setBackground(new Color(100, 149, 237));
		b[2].setBounds(397, 290, 80, 80);
		f.getContentPane().add(b[2]);
		
		b[3] = new JButton("4");
		b[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+4);
			}
		});
		b[3].setForeground(Color.BLACK);
		b[3].setFont(new Font("굴림", Font.PLAIN, 21));
		b[3].setBackground(new Color(100, 149, 237));
		b[3].setBounds(489, 290, 80, 80);
		f.getContentPane().add(b[3]);
		
		b[4] = new JButton("5");
		b[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+5);
			}
		});
		b[4].setForeground(Color.BLACK);
		b[4].setFont(new Font("굴림", Font.PLAIN, 21));
		b[4].setBackground(new Color(100, 149, 237));
		b[4].setBounds(581, 290, 80, 80);
		f.getContentPane().add(b[4]);
		
		b[5] = new JButton("6");
		b[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+6);
			}
		});
		b[5].setForeground(Color.BLACK);
		b[5].setFont(new Font("굴림", Font.PLAIN, 21));
		b[5].setBackground(new Color(100, 149, 237));
		b[5].setBounds(673, 290, 80, 80);
		f.getContentPane().add(b[5]);
		
		b[6] = new JButton("7");
		b[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+7);
			}
		});
		b[6].setForeground(Color.BLACK);
		b[6].setFont(new Font("굴림", Font.PLAIN, 21));
		b[6].setBackground(new Color(100, 149, 237));
		b[6].setBounds(211, 380, 80, 80);
		f.getContentPane().add(b[6]);
		
		b[7] = new JButton("000");
		b[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+"000");
			}
		});
		b[7].setForeground(Color.BLACK);
		b[7].setFont(new Font("굴림", Font.PLAIN, 21));
		b[7].setBackground(new Color(100, 149, 237));
		b[7].setBounds(673, 380, 80, 80);
		f.getContentPane().add(b[7]);
		
		b[8] = new JButton("00");
		b[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+"00");
			}
		});
		b[8].setForeground(Color.BLACK);
		b[8].setFont(new Font("굴림", Font.PLAIN, 21));
		b[8].setBackground(new Color(100, 149, 237));
		b[8].setBounds(581, 380, 80, 80);
		f.getContentPane().add(b[8]);
		
		b[9] = new JButton("0");
		b[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+0);
			}
		});
		b[9].setToolTipText("");
		b[9].setForeground(Color.BLACK);
		b[9].setFont(new Font("굴림", Font.PLAIN, 21));
		b[9].setBackground(new Color(100, 149, 237));
		b[9].setBounds(489, 380, 80, 80);
		f.getContentPane().add(b[9]);
		
		b[10] = new JButton("9");
		b[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+9);
			}
		});
		b[10].setForeground(Color.BLACK);
		b[10].setFont(new Font("굴림", Font.PLAIN, 21));
		b[10].setBackground(new Color(100, 149, 237));
		b[10].setBounds(397, 380, 80, 80);
		f.getContentPane().add(b[10]);
		
		b[11] = new JButton("8");
		b[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nowT.setText(nowT.getText()+8);
			}
		});
		b[11].setForeground(Color.BLACK);
		b[11].setFont(new Font("굴림", Font.PLAIN, 21));
		b[11].setBackground(new Color(100, 149, 237));
		b[11].setBounds(305, 380, 80, 80);
		f.getContentPane().add(b[11]);
		
		b[12] = new JButton("");
		b[12].setForeground(Color.BLACK);
		b[12].setFont(new Font("굴림", Font.PLAIN, 21));
		b[12].setBackground(new Color(100, 149, 237));
		b[12].setBounds(209, 470, 80, 80);
		f.getContentPane().add(b[12]);
		
		b[13] = new JButton("");
		b[13].setForeground(Color.BLACK);
		b[13].setFont(new Font("굴림", Font.PLAIN, 21));
		b[13].setBackground(new Color(100, 149, 237));
		b[13].setBounds(671, 470, 80, 80);
		f.getContentPane().add(b[13]);
		
		b[14] = new JButton("");
		b[14].setForeground(Color.BLACK);
		b[14].setFont(new Font("굴림", Font.PLAIN, 21));
		b[14].setBackground(new Color(100, 149, 237));
		b[14].setBounds(579, 470, 80, 80);
		f.getContentPane().add(b[14]);
		
		b[15] = new JButton("");
		b[15].setForeground(Color.BLACK);
		b[15].setFont(new Font("굴림", Font.PLAIN, 21));
		b[15].setBackground(new Color(100, 149, 237));
		b[15].setBounds(487, 470, 80, 80);
		f.getContentPane().add(b[15]);
		
		b[16] = new JButton("");
		b[16].setForeground(Color.BLACK);
		b[16].setFont(new Font("굴림", Font.PLAIN, 21));
		b[16].setBackground(new Color(100, 149, 237));
		b[16].setBounds(395, 470, 80, 80);
		f.getContentPane().add(b[16]);
		
		b[17] = new JButton("");
		b[17].setForeground(Color.BLACK);
		b[17].setFont(new Font("굴림", Font.PLAIN, 21));
		b[17].setBackground(new Color(100, 149, 237));
		b[17].setBounds(303, 470, 80, 80);
		f.getContentPane().add(b[17]);
		
		b[18] = new JButton("");
		b[18].setForeground(Color.BLACK);
		b[18].setFont(new Font("굴림", Font.PLAIN, 21));
		b[18].setBackground(new Color(100, 149, 237));
		b[18].setBounds(209, 560, 80, 80);
		f.getContentPane().add(b[18]);
		
		b[19] = new JButton("");
		b[19].setForeground(Color.BLACK);
		b[19].setFont(new Font("굴림", Font.PLAIN, 21));
		b[19].setBackground(new Color(100, 149, 237));
		b[19].setBounds(671, 560, 80, 80);
		f.getContentPane().add(b[19]);
		
		b[20] = new JButton("");
		b[20].setForeground(Color.BLACK);
		b[20].setFont(new Font("굴림", Font.PLAIN, 21));
		b[20].setBackground(new Color(100, 149, 237));
		b[20].setBounds(579, 560, 80, 80);
		f.getContentPane().add(b[20]);
		
		b[21] = new JButton("");
		b[21].setForeground(Color.BLACK);
		b[21].setFont(new Font("굴림", Font.PLAIN, 21));
		b[21].setBackground(new Color(100, 149, 237));
		b[21].setBounds(487, 560, 80, 80);
		f.getContentPane().add(b[21]);
		
		b[22] = new JButton("");
		b[22].setForeground(Color.BLACK);
		b[22].setFont(new Font("굴림", Font.PLAIN, 21));
		b[22].setBackground(new Color(100, 149, 237));
		b[22].setBounds(395, 560, 80, 80);
		f.getContentPane().add(b[22]);
		
		b[23] = new JButton("");
		b[23].setForeground(Color.BLACK);
		b[23].setFont(new Font("굴림", Font.PLAIN, 21));
		b[23].setBackground(new Color(100, 149, 237));
		b[23].setBounds(303, 560, 80, 80);
		f.getContentPane().add(b[23]);
		
		JButton lblNewLabel_1 = new JButton("");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 276, 760, 375);
		f.getContentPane().add(lblNewLabel_1);
		
		
		
		f.setVisible(true);
	}
}
