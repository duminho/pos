package pos;

public class MenuDTO {

	private String name;
	private int price;
	private String kind;
	private String xp;
	private String yp;
	
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
	public String getXp() {
		return xp;
	}
	public void setXp(String xp) {
		this.xp = xp;
	}
	public String getYp() {
		return yp;
	}
	public void setYp(String yp) {
		this.yp = yp;
	}
	
	@Override
	public String toString() {
		return "MenuDTO [name=" + name + ", price=" + price + ", kind=" + kind + ", xp=" + xp + ", yp=" + yp + "]";
	}
	
	
}
