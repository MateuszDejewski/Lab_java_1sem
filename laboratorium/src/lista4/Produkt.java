package lista4;

import java.util.Random;

public class Produkt {
	
	private String nazwa;
	private double cena;
	private String wytwórca;
	private String wyprodukowano_dla;
	private boolean czy_działa;
	
	public Produkt(String nazwa, double cena, String wytwórca,String wyprodukowano_dla, int prawdopodobieństwo)
	{
		this.setnazwa(nazwa);
		this.cena=cena;
		this.wytwórca=wytwórca;
		this.setwyprodukowano_dla(wyprodukowano_dla);
		czy_działa=losuj_czy_działa(prawdopodobieństwo);
	}
	
	public String getnazwa() 
	{
		return nazwa;
	}

	public void setnazwa(String nazwa) 
	{
		this.nazwa = nazwa;
	}

	public double getcena()
	{
		return cena;
	}
	
	public void setcena(double cena)
	{
		this.cena=cena;
	}
	
	public String getwytwórca()
	{
		return wytwórca;
	}
	
	public void setwytwórca(String wytwórca)
	{
		this.wytwórca=wytwórca;
	}
	
	public String getwyprodukowano_dla() {
		return wyprodukowano_dla;
	}

	public void setwyprodukowano_dla(String wyprodukowano_dla) {
		this.wyprodukowano_dla = wyprodukowano_dla;
	}

	public boolean getczy_działa()
	{
		return czy_działa;
	}
	
	public void setczy_dzaiła(boolean czy_działa)
	{
		this.czy_działa=czy_działa;
	}
	
	public boolean equals(Object p)
	{
		if(!(p instanceof Produkt))
			return false;
		return ( this.nazwa.equals(((Produkt)p).getnazwa()) && this.cena==((Produkt)p).getcena() && this.wytwórca.equals(((Produkt)p).getwytwórca()) && this.wyprodukowano_dla.equals(((Produkt)p).getwyprodukowano_dla()));
	}
	
	public boolean losuj_czy_działa(int prawdopodobieństwo)
	{
		if(prawdopodobieństwo>=100)
			return true;
		if(prawdopodobieństwo<=0)
			return false;
		
		Random g=new Random();
		int los=g.nextInt(100)+1;
		if(los<=prawdopodobieństwo)
			return true;
		else
			return false;
	}
	
	public void wypisz_opis()
	{
		System.out.printf("Nazwa: %-10s   Cena: %7.2f zł   Wytwórca: %-20s  Wyprodukowano dla: %20s \n",nazwa,cena,wytwórca,wyprodukowano_dla);
	}
}
