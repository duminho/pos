package pos;

public class MenueDTO {
	private String name;
	private int price;
	private String kind;
	private int xplace;
	private int yplace;
	//알트 쉬프트 s R
	//String name, int price,String kind, int xplace, int yplace
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getXplace() {
		return xplace;
	}
	public void setXplace(int xplace) {
		this.xplace = xplace;
	}
	public int getYplace() {
		return yplace;
	}
	public void setYplace(int yplace) {
		this.yplace = yplace;
	}
	public String toString() {
		return "MenueDTO [name=" + name + ", price=" + price + ", kind=" + kind + ", xplace=" + xplace + ", yplace="
				+ yplace + "]";
	}
	
	
	
}
