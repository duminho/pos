package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MenueDAO {
	Connection con;
	PreparedStatement ps;
	String url;
	String user;
	String password;
	String DB="pos";
	String table="menue";
	ResultSet rs;
	

	public void start() {
		
		System.out.println("1 DB 연결 OK");
		//1.드라이버 설정
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2. 드라이버 설정 Ok");
			
			
			//2.DB 설정(DB명, id,pw)
			url = "jdbc:mysql://localhost:3306/"+DB;
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList selectAll() {
		ArrayList list = new ArrayList();
		
		start();
		
		MenueDTO dto = null; //변수의 생존범위 = 선언의 위치
		try {
			
			//3. SQL문 결정(객체화)
			String sql = "select * from menue";
			ps = con.prepareStatement(sql);
			System.out.println("SQL문 객체화 OK");
			//4. SQL문 전송
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new MenueDTO();
				String id =rs.getString(1);
				int price = rs.getInt(2);
				String content = rs.getString(3);
				int xplace = rs.getInt(4);
				int yplace = rs.getInt(5);
				dto.setName(id);
				dto.setPrice(price);
				dto.setKind(content);
				dto.setXplace(xplace);
				dto.setYplace(yplace);
				
				list.add(dto);
			}//while end*
//			{
//				System.out.println("검색 결과가 없습니다.");
//			}
			
			System.out.println("SQL문 전송 OK");
			
		} catch (Exception e) {
			System.out.println("DB 처리중 에러발생....");
			System.out.println(e.getMessage());
		}
		finally {
				//에러 발생 여부와 상관없이 무조건 실행시켜야 하는 코드.
			//5. SQL문의 결과가 있으면 받아서 처리
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("자운 해제 중 에러 발생!!");
			}
		
		
	}
		return list;
}	
	
	
	
	
	
	
	public void insert(MenueDTO dto){
		

		start();
		
		//1.드라이버 설정 , 연걸자
		try {
			
			String sql = "insert into menue values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 결정 ok");
			
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getPrice());
			ps.setString(3, dto.getKind());
			ps.setInt(4, dto.getXplace());
			ps.setInt(5, dto.getYplace());
			
			ps.executeUpdate();
			System.out.println("4번. SQL문 전송 OK.....");		
			//3.SQL 선택
			//4.SQL 전송
		} catch (Exception e) {
			System.out.println("DB 처리중 에러발생....");
			System.out.println(e.getMessage());
		}
		
	}
	public void update(String id,String changeid, String value) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		url = "jdbc:mysql://localhost:3306/"+DB;
		user = "root";
		password = "1234";
		con = DriverManager.getConnection(url, user, password);
		
		
		String sql = "update "+table+" set "+changeid+"= '"+value+"' where id = '"+id+"'";
		ps = con.prepareStatement(sql);
		System.out.println(sql);
		ps.executeUpdate();
	}
	public void delete(String id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/pos";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);
			
			
			String sql = "delete from menue where id = '"+id+"'";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
	}
	
	

	public MenueDTO select(String inputId) {
		MenueDTO dto = null; //변수의 생존범위 = 선언의 위치
		start();

		try {
			
			//3. SQL문 결정(객체화)
			String sql = "select * from bbs where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			System.out.println("SQL문 객체화 OK");
			//4. SQL문 전송
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MenueDTO();
				String id =rs.getString(1);
				int price = rs.getInt(2);
				String content = rs.getString(3);
				int xplace = rs.getInt(4);
				int yplace = rs.getInt(5);
				dto.setName(id);
				dto.setPrice(price);
				dto.setKind(content);
				dto.setXplace(xplace);
				dto.setYplace(yplace);
				
				
			}else {
				System.out.println("검색 결과가 없습니다.");
			}
			
			System.out.println("SQL문 전송 OK");
			
		} catch (Exception e) {
			System.out.println("DB 처리중 에러발생....");
			System.out.println(e.getMessage());
		}
		finally {
				//에러 발생 여부와 상관없이 무조건 실행시켜야 하는 코드.
			//5. SQL문의 결과가 있으면 받아서 처리
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("자운 해제 중 에러 발생!!");
			}
		}//try-catch finally
		return dto;
		
	}//select

}
