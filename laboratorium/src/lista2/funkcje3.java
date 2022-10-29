package lista2;

public class funkcje3 {
	
	public static double E_x_md (double x, double eps)
	{
		double wynik=1,wyraz=1;
		int i=1;
		do
		{
			wyraz=wyraz*x/i;
			wynik+=wyraz;
			i++;
			
		}while(wyraz>eps);

	return wynik;
	}	
	
	public static double Sin_x_md ( double x, double eps)
	{
		double wynik=x,wyraz=x;
		int k=1;
		do {
			wyraz=wyraz*x*x/(2*k)/(2*k+1);
			if(k%2==0)
				wynik+=wyraz;
			else
				wynik-=wyraz;
			k++;
			
		}while(wyraz>eps);
	
	return wynik;
	}
	
	public static double Cos_x_md (double x, double eps)
	{
		double wynik=1,wyraz=1;
		int k=1;
		do {
			wyraz=wyraz*x*x/(2*k)/(2*k-1);
			if(k%2==0)
				wynik+=wyraz;
			else
				wynik-=wyraz;
			k++;
			
		}while(wyraz>eps);
		
	return wynik;
	}
	
	public static void main(String[]args)
	{
		double x=50;
		double x1=x%(2*Math.PI);
		double eps=0.0000000000000000001;
		System.out.println("e^x: " + E_x_md(x,eps));
		System.out.println("sin(x): " + Sin_x_md(x1,eps));
		System.out.println("cos(x): " + Cos_x_md(x1,eps));
	}

}
