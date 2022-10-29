package lista2;

public class funkcje4 {
	
	public static double silnia (int j)
	{
		double wynik=1;
		for(int i=2;i<=j;i++)
		{
			wynik*=i;
		}
	return wynik;
	}
	
	public static double potega(double x, int j){
		
		double mnoznik=x*x,wynik=1;

		for(int i=1;i<j;i=i+2)
		{
			wynik*=mnoznik;		
		}
		
		if(j%2!=0)
			wynik=wynik*x;
			
	return wynik;	
	}

	public static double E_x_md (double x, double eps)
	{
		double wynik=1,wyraz=1;
		int k=1;
		do
		{
			wyraz=potega(x,k)/silnia(k);
			wynik+=wyraz;
			k++;
			
		}while(wyraz>eps);

	return wynik;
	}	
	
	public static double Sin_x_md ( double x, double eps)
	{
		double wynik=x,wyraz=0;
		int k=1;
		do {
			wyraz=potega(x,2*k+1)/silnia(2*k+1);
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
			wyraz=potega(x,2*k)/silnia(2*k);
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
		
	/*
	 * Problemem tego rozwiązania jest złożoność obliczeniowa.
	 * W zad3 kolejne elementy liczę wykonując kilka operacji na podstawie poprzednich wyrazów sumy,
	 * natomiast używając funkji za każdym razem wyliczam wartość od początku.
	 * 
	 * 
	 * Zalety:
	 * 	Ten kod szybciej się pisze
	 * 	Nie trzeba myśleć i analizować zadania, wystarczy przepisać wzór. 
	 * 		(W rozwiązaniu zad3 trzeba było ustalić zależności między kolejnymi wyrazami sumy)
	 * 	 
	 * Wady:
	 * 	Złożoność obliczeniowa
	 * 	Ograniczenia związane z long i double (w tym programie osobno liczę x^k oraz k!, przez co te liczby są większe
	 * 		w zad3 kolejny wyraz liczę na podstawie x^(k-1)/(k-1)! są to znacznie mniejsze wartości, 
	 * 		przez co trudniej jest wyjść poza zakres zmiennych
	 * 
	 */
	}
	
}
