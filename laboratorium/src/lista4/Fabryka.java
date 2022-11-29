package lista4;

import java.util.ArrayList;

abstract public class Fabryka {
	
	private String nazwa;
	private ArrayList<Produkt> produkty;
	private int skuteczność_produkcji;
	
	public Fabryka(String nazwa, int skuteczność_produkcji)
	{
		this.nazwa=nazwa;
		this.produkty=new ArrayList<Produkt>() ;
		setskuteczność_produkcji(skuteczność_produkcji);
	}
	
	public String getnazwa() 
	{
		return nazwa;
	}

	public void setnazwa(String nazwa) 
	{
		this.nazwa = nazwa;
	}

	public int getskuteczność_produkcji()
	{
		return skuteczność_produkcji;
	}
	
	public void setskuteczność_produkcji(int skuteczność_produkcji)
	{
		if(skuteczność_produkcji<0)
			this.skuteczność_produkcji=0;
		else {
			if(skuteczność_produkcji>100)
				this.skuteczność_produkcji=100;
			else {
				this.skuteczność_produkcji=skuteczność_produkcji;
			}
		}
	}
	
	public Produkt get_removeprodukty(Produkt a)
	{
		for(Produkt q: produkty)
		{
			if(a.equals(q))
			{
				a=q;
				produkty.remove(q);
				return a;
			}
		}
		return null;
	}
	
	public void set_addprodukty (Produkt p)
	{
		produkty.add(p);
	}
	
	public Produkt wyprodukuj (String nazwa,String nazwa_sklepu , double cena)
	{
		return new Produkt(nazwa,cena,this.nazwa,nazwa_sklepu,skuteczność_produkcji);
	}
	
	public boolean wyprodukuj_i_zatwierdz(String nazwa,String nazwa_sklepu, double cena)
	{
		Produkt p= wyprodukuj(nazwa,nazwa_sklepu, cena);
		if(p.getczy_działa())
			{
			produkty.add(p);
			return true;
			}
		return false;
	}
	
	public void wyczyść_magazyn()
	{
		produkty.clear();
	}
	
	public void getstan()
	{
		
		System.out.println("Nazwa: "+nazwa+ "   Skuteczność produkcji: "+skuteczność_produkcji+"%" );
		
		if(produkty.isEmpty())
			System.out.println("Magazyn jest pusty");
		else {
			System.out.println("Stan magazynu:");
			for(Produkt p:produkty)
			{
				p.wypisz_opis();
			}
		}
		System.out.println("- - - - - - - - - - - - - - - - ");
	}
	
	abstract boolean przyjmij_zwrot(Produkt p);
}
