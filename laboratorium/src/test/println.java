package test;

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
	}

}
