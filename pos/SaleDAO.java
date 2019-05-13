package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SaleDAO {
	//멤버변수
	Connection con;
	PreparedStatement ps;
	String url;
	String user;
	String password;
	String DB="pos";
	String table="sale";
	ResultSet rs;
	
	
	//멤버 메소드
	
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
	
	//String name, int price,String kind, int xplace, int yplace
	public void insert(SaleDTO dto) throws Exception {
		start();
		
		
		String sql = "insert into "+table+" values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 결정 ok");
		ps.setString(1, dto.getName());
		ps.setInt(2, dto.getPrice());
		ps.setInt(3, dto.getMonth());
		ps.setInt(4, dto.getDay());
		ps.setInt(5, dto.getTime ());
		
		ps.executeUpdate();
		System.out.println("4번. SQL문 전송 OK.....");		
		//3.SQL 선택
		//4.SQL 전송
	}

	public void delete(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		url = "jdbc:mysql://localhost:3306/"+DB;
		user = "root";
		password = "1234";
		con = DriverManager.getConnection(url, user, password);
		
		
		String sql = "delete from "+table+" where id = '"+id+"'";
		ps = con.prepareStatement(sql);
		System.out.println(sql);
		ps.executeUpdate();
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


	public String[] select(String id) throws Exception {

		System.out.println("2 DB 연결 OK");
		
		//1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버 설정 Ok");
		
		
		//2.DB 설정(DB명, id,pw)
		url = "jdbc:mysql://localhost:3306/"+DB;
		user = "root";
		password = "1234";
		con = DriverManager.getConnection(url, user, password);
		
		
		String sql = "select * from "+table+" where name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 결정 ok");
		
		//3.SQL 선택
		ps.setString(1, id);
		String mem[] = null;
		
		rs = ps.executeQuery();
		if(rs.next()) { //레코드 존재 O   아래로 한칸 내려가 값이 있는지 없는지 체크한다.
			mem = new String[4];
			String S1 = rs.getString(1);
			String S2 = rs.getString(2);
			String S3 = rs.getString(3);
			String S4 = rs.getString(4);
			mem[0] = S1;
			mem[1] = S2;
			mem[2] = S3;
			mem[3] = S4;
			
			
		}else {//레코드 존재 X
			System.out.println("검색결과가 없습니다.");
			
		}
		return mem;
		//4.SQL 전송
	}
	
	
}
