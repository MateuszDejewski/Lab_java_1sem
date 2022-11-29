package lista4;

import java.util.ArrayList;
import java.util.Random;

public class Sklep {

	private String nazwa_sklepu;
	private double saldo;
	private int narzut;
	private ArrayList<Produkt> asortyment;
	
	public Sklep(String nazwa_sklepu, double saldo_początkowe, int narzut)
	{
		setnazwa(nazwa_sklepu);
		setsaldo(saldo_początkowe);
		setnarzut(narzut);
		asortyment=new ArrayList<Produkt>();
	}

	public String getnazwa() {
		return nazwa_sklepu;
	}

	public void setnazwa(String nazwa_sklepu) {
		this.nazwa_sklepu = nazwa_sklepu;
	}

	public double getsaldo() {
		return saldo;
	}
	
	public void setsaldo(double saldo) {
		if(saldo>0)
			this.saldo = saldo;
	}

	public int getnarzut() {
		return narzut;
	}

	public void setnarzut(int narzut) {
		if(narzut<0)
			this.narzut=0;
		else 
			this.narzut=narzut;
		
	}
	
	public ArrayList<Produkt> getasortyment() {
		return asortyment;
	}

	public Produkt get_random_produkt()
	{
		Random gRandom=new Random();
		return getasortyment().get(gRandom.nextInt(getasortyment().size()));
	}
	
	public Produkt get_removeasortyment(Produkt p)
	{
		asortyment.remove(p);
		return p;
	}
	
	public void set_addasortyment (Produkt p)
	{
		asortyment.add(p);
	}
	
	public void wypiszsaldo()
	{
		System.out.printf("Obecne saldo: %.2f zł\n",getsaldo());
	}
	
	public boolean zamów(Fabryka F, String nazwa, double cena, int ilość)
	{
		System.out.println("-------------------");
		System.out.printf("Zamówienie do %s na %d x %s \n",F.getnazwa(),+ilość,nazwa);
		
		if(ilość<1 || cena<=0 || F==null)
			{
			System.out.println("Zamówienie nie powiodło się (błędne dane)");
			return false;
			}
		if(cena>saldo)
			{
			System.out.println("Zamówienie nie powiodło się (brak środków)");
			return false;
			}
			
		while(saldo<ilość*cena)
			{
			ilość--;
			}
			
		if(F instanceof Ubran && ilość>1)
			{
				ilość=((Ubran) F).wyprodukuj_masowo(nazwa,this.nazwa_sklepu, cena, ilość);
			}
		else {
				if(F.wyprodukuj_i_zatwierdz(nazwa,this.nazwa_sklepu, cena))
					ilość=1;
				else 
					ilość=0;
			}
		double koszt =ilość*cena;
		if(ilość==0)
			{
			System.out.println("Zamówienie nie powiodło się (Problem z produkcją)");
			return false;
			}
		else 
			{	
			System.out.printf("Wyprodukowano %d za %.2f zł\n",ilość, koszt);
			saldo-=koszt;
			wypiszsaldo();
			return true;
			}
	}
	
	public boolean odbierz (Fabryka F, String nazwa, double cena, int ilość)
	{
		System.out.println("-------------------");	
		
		Produkt tmp=new Produkt(nazwa, cena, F.getnazwa(),this.nazwa_sklepu, F.getskuteczność_produkcji());
		Produkt zfabryki;
		int i=0;
		
		do
		{	zfabryki=F.get_removeprodukty(tmp);
			if(zfabryki==null)
				break;
			set_addasortyment(zfabryki);
			i++;
			
		}while(i<ilość);
		
		if(i==0)
		{
			System.out.printf("Nie ma takiego produktu (%s , %.2f zł)\nNajpierw złóż zamówienie\n",nazwa,cena);
			return false;
		}
		else
		{
		String prod=new String("produktów");
		if(i==1)
			prod="produkt";
		else
			if(i<5)
				prod="produkty";
			
			System.out.printf("Odebrano "+i +" %s (%s , %.2f zł)\n",prod,nazwa,cena);
			return true;
		}
	}
	
	public boolean sprzedaj(Produkt a)
	{
		if(asortyment.contains(a))
		{
			System.out.println("-------------------");
			double cena=a.getcena()*(1+((double) narzut/100));
			get_removeasortyment(a);
			saldo+=cena;
			System.out.printf("Strzedano %s za %.2f\n",a.getnazwa(),cena);
			wypiszsaldo();
			return true;
		}
		return false;
	}
	
	public boolean zwróć(Fabryka F, String nazwa, double cena)
	{
		System.out.println("-------------------");
		System.out.println("Zwrot produktu "+nazwa+" do fabryki "+F.getnazwa());
		
		Produkt tmp=new Produkt(nazwa, cena, F.getnazwa(),this.nazwa_sklepu, F.getskuteczność_produkcji());
		Produkt do_zwrotu=null;
		
		for(Produkt p:asortyment)
		{
			if(p.equals(tmp))
					do_zwrotu=p;
		}
		
		if(do_zwrotu==null)
		{
			System.out.println("Nie ma takiego produktu na stanie");
			return false;
		}
		
		boolean udany=F.przyjmij_zwrot(do_zwrotu);
		if(udany)
		{
			saldo+=cena;	
			wypiszsaldo();		
		}
		get_removeasortyment(do_zwrotu);
		
		return udany;
	}
	
	public void getstan()
	{
		System.out.println("- - - - - - - - - - - - - - - - ");
		System.out.println("To jest sklep");
		System.out.printf("Nazwa: %s   Saldo: %.2f zł   ",nazwa_sklepu,saldo);
		System.out.print("Narzut: "+narzut+"% \n");
		if(asortyment.isEmpty())
			System.out.println("Na stanie nie ma nic");
		else {
			System.out.println("Na stanie jest obecnie: ");
			for(Produkt q:getasortyment())
			{
				q.wypisz_opis();
			}
		}	
		System.out.println("- - - - - - - - - - - - - - - - ");
	}

}
