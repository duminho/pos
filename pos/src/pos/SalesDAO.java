package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDAO {

	String url="jdbc:mysql://localhost:3306/pos";
	String user="root";
	String password="1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList selectAll() {
		
		ArrayList list = new ArrayList();
		SalesDTO dto=null;//변수의 생존범위: 선언 위치!
		try {
			//1. 드라이버 설정
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. DB연결(DB명,아이디,패스워드)
			con = DriverManager.getConnection(url, user, password);
			//3. SQL문 결정(객체화)
			String sql ="select * from sales";
			ps = con.prepareStatement(sql);
			
			//4. SQL문 전송
			rs = ps.executeQuery();
			
			//SQL문의 결과가 있으면, 받아서 처리
			
			while(rs.next()) {
				dto = new SalesDTO();
				String day = rs.getString(1);
				int number = rs.getInt(2);
				int price = rs.getInt(3);
				dto.setDay(day);
				dto.setNumber(number);
				dto.setPrice(price);
			}
			
		}catch (Exception e) {
			System.out.println("DB처리 중 에러발생...");
			System.out.println(e.getMessage());
		}finally{
		//에러 발생 여부와 상관없이 무조건 실행시켜야 하는 코드.
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("자원 해제중 에러 발생!!");
			}//catch
		}//try-catch-finally
		
		return list;
	}//select
	public SalesDTO select(String inputday) throws Exception {
		SalesDTO dto = null;
		//1. 드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB연결(DB명,아이디,패스워드)
		con = DriverManager.getConnection(url, user, password);
		//3. SQL문 결정(객체화)
		String sql ="select * from sales where time =?";
		ps = con.prepareStatement(sql);
		ps.setString(1, inputday);
		
		//4. SQL문 전송
		rs = ps.executeQuery();
		if(rs.next()) {
			dto = new SalesDTO();
			String day = rs.getString(1);
			int number = rs.getInt(2);
			int price = rs.getInt(3);
			dto.setDay(day);
			dto.setNumber(number);
			dto.setPrice(price);
		}else {
			System.out.println("에러발생");
		}
		
		return dto;
		
	}
	
	public void insert(SalesDTO dto) throws Exception {
		
		//1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.DB연결(DB명,id,pw)
		con = DriverManager.getConnection(url, user, password);
		
		//3.SQL문 결졍
		String sql="insert into sales values(?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getDay());
		ps.setInt(2, dto.getNumber());
		ps.setInt(3, dto.getPrice());
		
		//4.SQL전송
		ps.executeUpdate();
		ps.close();
	}
	public void delete(int number) throws Exception {
		
		//1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.DB연결(DB명,id,pw)
		con = DriverManager.getConnection(url, user, password);
		
		//3.SQL문 결졍
		String sql="delete from sales where tablenumber = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,number);
		
		//4.SQL전송
		ps.executeUpdate();
		ps.close();
	}
}
