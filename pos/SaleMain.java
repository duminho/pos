package pos;

import java.util.Scanner;


public class SaleMain {

	public static void main(String[] args) {
		MenueDAO db = new MenueDAO();
		Scanner sc =new Scanner(System.in);
		db.DB = "pos";
		db.table = "menue";

		System.out.print("name : ");
		String name = sc.next();
		System.out.print("price : ");
		int price = sc.nextInt();
		System.out.print("kind : ");
		String kind = sc.next();
		System.out.print("xplace : ");
		int xplace = sc.nextInt();
		System.out.print("yplace : ");
		int yplace = sc.nextInt();

		MenueDTO dto = new MenueDTO();
		dto.setName(name);
		dto.setPrice(price);
		dto.setKind(kind);
		dto.setXplace(xplace);
		dto.setYplace(yplace);
		
		try {
			db.insert(dto);;
		} catch (Exception e) {
			System.out.println("에러발생!! 에러발생!!");
			e.printStackTrace();
		}
		
		sc.close();
	}

}
