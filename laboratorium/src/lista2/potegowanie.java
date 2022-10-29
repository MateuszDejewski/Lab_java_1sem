package lista2;

public class potegowanie {
	
	public static double potega(double x, int k){
	
	double mnoznik=x*x,wynik=1;

	for(int i=1;i<k;i=i+2)
	{
		wynik*=mnoznik;		
	}
	
	if(k%2!=0)
		wynik=wynik*x;
		
	return wynik;
	
}
	
	public static void main(String[]args) {
		double x=3;
		int k=2;
		if(k<0)
			System.out.println("k musi być liczą naturalną");
		else
			System.out.println("wynik x^k: " + potega(x,k));
		
	}

}
