package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TSalesDAO {
	
	String url="jdbc:mysql://localhost:3306/pos";
	String user="root";
	String password="1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList selectAll() {
		
		ArrayList list = new ArrayList();
		TSalesDTO dto=null;//변수의 생존범위: 선언 위치!
		try {
			//1. 드라이버 설정
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. DB연결(DB명,아이디,패스워드)
			con = DriverManager.getConnection(url, user, password);
			//3. SQL문 결정(객체화)
			String sql ="select * from tsales";
			ps = con.prepareStatement(sql);
			
			//4. SQL문 전송
			rs = ps.executeQuery();
			
			//SQL문의 결과가 있으면, 받아서 처리
			
			while(rs.next()) {
				dto = new TSalesDTO();
				int number = rs.getInt(1);
				String kind = rs.getString(2);
				int quantity = rs.getInt(3);
				int price = rs.getInt(4);
				dto.setNumber(number);
				dto.setKind(kind);
				dto.setQuantity(quantity);
				dto.setPrice(price);
				
				list.add(dto);
			}
		} catch (Exception e) {
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
	public TSalesDTO select(int inputnumber) throws Exception {
		TSalesDTO dto = null;
		//1. 드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB연결(DB명,아이디,패스워드)
		con = DriverManager.getConnection(url, user, password);
		//3. SQL문 결정(객체화)
		String sql ="select * from tsales where number =?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, inputnumber);
		
		//4. SQL문 전송
		rs = ps.executeQuery();
		if(rs.next()) {
			dto = new TSalesDTO();
			int number = rs.getInt(1);
			String kind = rs.getString(2);
			int quantity = rs.getInt(3);
			int price = rs.getInt(4);
			dto.setNumber(number);
			dto.setKind(kind);
			dto.setQuantity(quantity);
			dto.setPrice(price);
		}else {
			System.out.println("에러발생");
		}
		
		return dto;
		
	}
	
	public void insert(TSalesDTO dto) throws Exception {
		
		//1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.DB연결(DB명,id,pw)
		con = DriverManager.getConnection(url, user, password);
		
		//3.SQL문 결졍
		String sql="insert into tsales values(?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getNumber());
		ps.setString(2, dto.getKind());
		ps.setInt(3, dto.getQuantity());
		ps.setInt(4, dto.getPrice());
		
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
		String sql="delete from tsales where number = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, number);
		
		//4.SQL전송
		ps.executeUpdate();
		ps.close();
	}
	
}
