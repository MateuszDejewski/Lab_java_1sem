package test;

import java.util.ArrayList;
import java.util.Collections;

public class println {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int n=12345678, suma=0;
		//n=nextint();
		while(n>0)
		{
			suma+=n%10;
			n=n/10;
		}
	System.out.println(suma);
	
	ArrayList<Integer> tab=new ArrayList<Integer>();
	tab.add(10);
	tab.add(20);
	Collections.swap(tab, 0, 1);
	System.out.println(tab.get(0));
	System.out.println(tab.get(1));
	}
	
	

}
