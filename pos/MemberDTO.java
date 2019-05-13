package pos;

public class MemberDTO {
	private String num;
	private String name;
	private String pw;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String toString() {
		return "MemberDTO [num=" + num + ", name=" + name + ", pw=" + pw + "]";
	}
	
}
