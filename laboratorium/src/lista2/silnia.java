package lista2;

public class silnia {

	public static void main(String[]args)
	{
		int k=200;
		double silnia=1;
		if(k<0)
			System.out.println("Błędne dane, silnia jest obliczana jedynie dla wartości nieujemnych");
		else
		{
			for(int i=2;i<=k;i++)
			{
				silnia*=i;
			}
			System.out.println(silnia);	
	
		}
	}
}
