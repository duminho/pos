package pos;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuTable {
	
	static int num=0;
	
	public MenuTable() {
		JButton[] b = new JButton[20];
		Menu m = new Menu();
		JFrame f = new JFrame("테이블 주문");
		f.setSize(1200,800);
		f.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("주문하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.cnt=1;
				m.total=0;
				m.total1=0;
			}
		});
		btnNewButton.setBounds(12, 147, 153, 39);
		f.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("이동하기");
		button.setBounds(12, 196, 153, 39);
		f.getContentPane().add(button);
		
		JButton button_1 = new JButton("그룹짓기");
		button_1.setBounds(12, 245, 153, 39);
		f.getContentPane().add(button_1);
		
		
		
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 5; j++) {
				num++;
				b[num]=new JButton(num+"번 테이블");
				
				b[num].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(m.cnt==1) {
							MenuList menu = new MenuList();
						}
					}
				});
				
				b[num].setBounds(j*200, i*150, 150, 100);
				f.getContentPane().add(b[num]);
				System.out.println(num);
			}
		}
//		b[0] =new JButton("총량"+m.total1+);
//		b[0].setBounds(250, 150, 150, 100);
//		f.getContentPane().add(b[0]);
		
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		MenuTable name = new MenuTable();
	}
}
