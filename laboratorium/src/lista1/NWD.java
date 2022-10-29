package lista1;

public class NWD {
	
	
	public static void main(String[] args) {
	
		int m=-80,n=15;
		if(m<0)
			m=m*(-1);
		
		if(n<0)
			n=n*(-1);
			
		while(m!=n)
			{
			if(m>n)
				m=m-n;
			else
				n=n-m;
			}
			
		System.out.println("Największy wspólny dzielnik: " + m);	
			
	}
}
