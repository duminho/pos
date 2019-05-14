package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pos.MenuDTO;

public class MenuDAO {
	
	String url="jdbc:mysql://localhost:3306/pos";
	String user="root";
	String password="1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList selectAll() {
		
		ArrayList list = new ArrayList();
		MenuDTO dto=null;//변수의 생존범위: 선언 위치!
		try {
			//1. 드라이버 설정
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. DB연결(DB명,아이디,패스워드)
			con = DriverManager.getConnection(url, user, password);
			
			
			//3. SQL문 결정(객체화)
			String sql ="select * from menu";
			ps = con.prepareStatement(sql);
			
			
			//4. SQL문 전송
			rs = ps.executeQuery();
			
			//SQL문의 결과가 있으면, 받아서 처리
			
			while(rs.next()) {
				dto = new MenuDTO();
				String name = rs.getString(1);
				int price = rs.getInt(2);
				String kind = rs.getString(3);
				String xp = rs.getString(4);
				String yp = rs.getString(5);
				dto.setName(name);
				dto.setPrice(price);
				dto.setKind(kind);
				dto.setXp(xp);
				dto.setYp(yp);
				
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
	public void insert(MenuDTO dto) throws Exception {
		
		//1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.DB연결(DB명,id,pw)
		con = DriverManager.getConnection(url, user, password);
		
		//3.SQL문 결졍
		String sql="insert into menu values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setInt(2, dto.getPrice());
		ps.setString(3, dto.getKind());
		ps.setString(4, dto.getXp());
		ps.setString(5, dto.getYp());
		
		//4.SQL전송
		ps.executeUpdate();
		ps.close();
	}
//	public void update(String etc,String id) throws Exception {
//		
//		//1.드라이버 설정
//		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("1.드라이버 설정 OK....");
//						
//		//2.DB연결(DB명,id,pw)
//		con = DriverManager.getConnection(url, user, password);
//		System.out.println("2.DB연결 OK.....");
//		
//		//3.SQL문 결졍
//		String sql="update menu set etc=? where name=?";
//		ps = con.prepareStatement(sql);
//		ps.setString(1, etc);
//		ps.setString(2, id);
//		System.out.println("3.SQl문 결정 OK...");
//		
//		//4.SQL전송
//		ps.executeUpdate();
//		System.out.println("4.SQL문 전송 OK....");
//		ps.close();
//	}
	public void delete(String name) throws Exception {
		
		//1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.DB연결(DB명,id,pw)
		con = DriverManager.getConnection(url, user, password);
		
		//3.SQL문 결졍
		String sql="delete from menu where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		
		//4.SQL전송
		ps.executeUpdate();
		ps.close();
	}
	
	
}
