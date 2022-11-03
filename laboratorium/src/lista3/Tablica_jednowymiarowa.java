package lista3;

import java.util.Random;

public class Tablica_jednowymiarowa {
	
	public static void main(String[] args)
	{
		int n=30;
		int k=1000;
		Tablica_jednowymiarowa tablica=new Tablica_jednowymiarowa(n);
		tablica.wypelnij(k,tablica.tab);
		tablica.wypisz_normalnie(tablica.tab);
		tablica.podzial(tablica.tab);
	}
	
	int[] tab;
	int[] T_parzyste;
	int[] T_nieparzyste;
	
	public Tablica_jednowymiarowa(int n)
	{
		if(n>0)
			tab=new int[n];
		else
			throw new IllegalArgumentException("tablica musi mieć conajmiej jedną komórkę");
	}
	
	public void wypelnij(int k, int[]tab)
	{
		Random generator = new Random();
		for(int i=0;i<tab.length;i++)
			tab[i]=generator.nextInt(k)+1;		
	}
	
	public void wypisz_normalnie(int[]tab)
	{
		for(int i=0;i<tab.length;i++)
			System.out.print(tab[i]+ " ");
		System.out.println();
	}
	
	public void wypisz_odwrotnie(int[] tab)
	{
		for(int i=tab.length-1;i>=0;i--)
			System.out.print(tab[i]+ " ");
		System.out.println();
	}
	
	public int znajdz_min(int[] tab)
	{
		int min=tab[0];
		for(int i=1;i<tab.length;i++)
		{
			if(tab[i]<min)
				min=tab[i];
		}
	return min;
	}
	
	public int znajdz_max(int[] tab)
	{
		int max=tab[0];
		for(int i=1;i<tab.length;i++)
		{
			if(tab[i]>max)
				max=tab[i];
		}
	return max;
	}
	
	public void sort(int[] tab)
	{
		for(int i=0;i<tab.length;i++)
		{
			for(int j=i+1;j<tab.length;j++)
			{
				if(tab[i]>tab[j])
				{
					int tmp=tab[i];
					tab[i]=tab[j];
					tab[j]=tmp;
				}
			}
		}
	}
	
	public void podzial (int[] tab)
	{
		int parzyste=0,nieparzyste=0;
		for(int i=0;i<tab.length;i++)
		{
			if(tab[i]%2==0)
				parzyste++;
			else
				nieparzyste++;
		}
		

		T_parzyste=new int[parzyste];
		T_nieparzyste=new int[nieparzyste];
		parzyste=0; 
		nieparzyste=0;
		for(int i=0;i<tab.length;i++)
		{
			if(tab[i]%2==0)
			{
				T_parzyste[parzyste]=tab[i];
				parzyste++;
			}
			else
			{
				T_nieparzyste[nieparzyste]=tab[i];
				nieparzyste++;
			}
		}
		sort(T_parzyste);
		sort(T_nieparzyste);
		System.out.print("parzyste: ");
		wypisz_normalnie(T_parzyste);
		System.out.print("nieparzyste: ");
		wypisz_normalnie(T_nieparzyste);
	}
}
