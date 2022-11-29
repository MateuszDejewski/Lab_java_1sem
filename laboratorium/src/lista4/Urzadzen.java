package lista4;

import java.util.Random;

public class Urzadzen extends Fabryka {

	private int udane;
	private int nieudane;
	private double ocena_efektywności;
	
	public Urzadzen(String nazwa, int skuteczność_produkcji, double ocena_efektywności) {
		super(nazwa, skuteczność_produkcji);
		udane=0;
		nieudane=0;
		setocena_efektywności(ocena_efektywności);
	}
	
	public void setocena_efektywności(double ocena_efektywności)
	{
		ocena_efektywności=Math.round(ocena_efektywności*10)/10.0;
		this.ocena_efektywności=ocena_efektywności;
		if(ocena_efektywności<0)
			this.ocena_efektywności=0;
		if(ocena_efektywności>10)
			this.ocena_efektywności=10;
	}
	
	public double getocena_efektywności()
	{
		return ocena_efektywności;
	}
	
	public boolean wyprodukuj_i_zatwierdz(String nazwa,String nazwa_sklepu, double cena) {

		boolean zatwierdzone=super.wyprodukuj_i_zatwierdz(nazwa,nazwa_sklepu, cena);
		
		if(zatwierdzone)
			udane++;
		else 
			nieudane++;
		
		return zatwierdzone;
	}
	
	public double oceń()
	{
		double ocena= (double)udane/(udane+nieudane)*10;
		setocena_efektywności(ocena);
		return getocena_efektywności();
	}
	
	public boolean przyjmij_zwrot(Produkt p)
	{
		if(p.getwytwórca()!=getnazwa())
		{
			System.out.println("Towar nie został wyprodukowany przez " +getnazwa());
			return false;
		}
			
		Random g=new Random();
		boolean czy_będzie_działać=g.nextBoolean();
		boolean uszkodził_użytkownik=g.nextBoolean();
		
		if(uszkodził_użytkownik)
		{	
			System.out.println("Nie przyjęto zwrotu");
			return false;
		}
		else {
			System.out.print("Przyjęto zwrot");

			if(czy_będzie_działać)
			{
				set_addprodukty(p);
				System.out.print(" (i udało się naprawić)\n");
			}
			else
				System.out.print(" (i nie udało się naprawić)\n");
			return true;
		}
	}
	
	public void getstan()
	{
		System.out.printf("Ta jest fabryka urządzeń oceniana na %.1f /10\n",ocena_efektywności);
		super.getstan();
	}
}
