package lista3;

import java.util.Random;

public class Macierz {

	public static void main(String[] args) {
	int M=10;
	Macierz macierze=new Macierz(M);
	System.out.println("Macierz A");
	macierze.wypisz(macierze.A);
	System.out.println("Macierz B");
	macierze.wypisz(macierze.B);
	macierze.dodawanie(macierze.A, macierze.B);
	macierze.mnożenie(macierze.A, macierze.B);
	}
	
	double[][] A;
	double[][] B;
	
	public Macierz(int M)
	{
		if(M>0)
		{
			A=new double[M][M];
			B=new double[M][M];
			wypelnij(A);
			wypelnij(B);
		}
		else
			throw new IllegalArgumentException("liczba kolumn i wierszy macierzy musi być większa od 0");
	}
	
	public void wypelnij(double[][] tab)
	{
		Random generator = new Random();
		for(int i=0;i<tab.length;i++)
		{
			for(int j=0;j<tab[0].length;j++)
				tab[i][j]=generator.nextInt()+ generator.nextDouble();
		}
	}
	
	public void wypisz (double[][] tab)
	{
		for(int i=0;i<tab.length;i++)
		{
			for(int j=0;j<tab[0].length;j++)
				System.out.print(tab[i][j]+ " ");
			
			System.out.println();
		}	
	}
	
	public void dodawanie (double[][] T1, double[][] T2)
	{
		double[][] T3=new double[T1.length][T1[0].length];
		for(int i=0;i<T3.length;i++)
		{
			for(int j=0;j<T3[0].length;j++)
				T3[i][j]=T1[i][j]+T2[i][j];
		}
		System.out.println("Macierz wynikowa (suma macierzy)");
		wypisz(T3);
	}
	
	public void mnożenie (double[][] T1, double[][]T2)
	{
		double suma=0;
		double[][] T3 = new double[T1.length][T1[0].length];
		for(int i=0;i<T3.length;i++)
		{
			for(int j=0;j<T3[0].length;j++)
			{
				for(int k=0;k<T1.length;k++)
				{
					suma+=T1[i][k]*T2[k][j];
				}
				T3[i][j]=suma;
				suma=0;
			}
		}
		System.out.println("Macierz wynikowa (iloczyn macierzy)");
		wypisz(T3);
	}
}
