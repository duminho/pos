package pos;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuCalculation extends Menu{
	
	public MenuCalculation() {
		
		Calendar time=Calendar.getInstance();
		int month = time.get(Calendar.MONTH)+1;
		int date = time.get(Calendar.DATE);
		
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.YELLOW);
		f.getContentPane().setForeground(Color.BLACK);
		JTextField[] t = new JTextField[7];
		f.setSize(500, 600);
		f.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("계산");//------------------------------------------------계산 버튼------------------------//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SalesDAO dao = new SalesDAO();
				SalesDTO dto = new SalesDTO();
				dto.setDay(String.valueOf(month)+"-"+String.valueOf(date));
				dto.setNumber(cnt[1]);
				dto.setPrice(total);
				try {
					dao.insert(dto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cnt[1]=0;
				f.setVisible(false);
			}
		});
		btnNewButton.setBounds(138, 500, 210, 40);
		f.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("계산서");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("바탕체", Font.BOLD, 40));
		lblNewLabel.setBounds(64, 50, 384, 94);
		f.getContentPane().add(lblNewLabel);
		
		for (int i = 0; i < t.length; i++) {//-------------------------------------텍스트 생성중----------------------------//
			t[i]= new JTextField();	
			t[i].setBounds(105, 140+((i+1)*40), 280, 40);
			f.getContentPane().add(t[i]);
			t[i].setColumns(10);
		}
		int j=0;
		TSalesDAO dao = new TSalesDAO();
		ArrayList list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			TSalesDTO dto =(TSalesDTO)list.get(i);
			if(cnt[1]==dto.getNumber()) {
				
				String kind = dto.getKind();
				int quantity = dto.getQuantity();
				int price = dto.getPrice();
				if(price > 0) {
					t[j].setText(kind+"\t"+quantity+"\t 가격:"+price);
					j++;
					total+=price;
					total1+=quantity;
				}
			}
		}
		t[6].setText("총수량:"+total1+"\t 합계:"+total);
	
		f.setVisible(true);
	}
}
