package pos;

import java.util.ArrayList;

public class Menu {
	
	String[] kind = {"a","b","c","d","e","f"};
	int[] a= {0,0,0,0,0,0};
	int[] menudata = {3900,4000,5000,8000,6000,1500};
	int total=0;
	int total1=0;	
	int[] witch = {0,0,0,0,0,0};
	int[] index = {0,0,0,0,0,0};
	int[] price = new int[16];
	int[] price1 = new int[16];
	static int[] table = {0,0,0,0,0,0,0,0};
	char dump;
	static int[] cnt = {0,0,0};
	static int check = 0;
	static int[] move = {0,0};
	String[] moveram = new String[8];

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal1() {
		return total1;
	}

	public void setTotal1(int total1) {
		this.total1 = total1;
	}
	
}
