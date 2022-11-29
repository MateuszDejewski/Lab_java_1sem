package lista4;

public class Ubran extends Fabryka {

	private int wydajność;
	
	public Ubran(String nazwa,int wydajność) {
		super(nazwa, 100);
		setwydajność(wydajność);
	}

	public int getwydajność() {
		return wydajność;
	}

	public void setwydajność(int wydajność) {
		if(wydajność>0)
			this.wydajność = wydajność;
	}
	
	public int wyprodukuj_masowo(String nazwa,String nazwa_sklepu, double cena, int liczba_sztuk)
	{
		if(liczba_sztuk>wydajność)
			liczba_sztuk=wydajność;
		
		for(int i=0;i<liczba_sztuk;i++)
		{
			set_addprodukty(super.wyprodukuj(nazwa,nazwa_sklepu, cena));
		}
		return liczba_sztuk;
	}	
	
	public boolean przyjmij_zwrot(Produkt p) {
		
		System.out.println("Fabryka ubrań nie przyjmuje zwrotów");
		return false;
	}
	
	public void getstan()
	{
	System.out.printf("Ta jest fabryka ubrań o wydajności %d szt na raz\n", wydajność);
	super.getstan();
	}
}
