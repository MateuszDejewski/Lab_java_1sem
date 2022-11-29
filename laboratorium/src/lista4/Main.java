package lista4;

public class Main {	
	
	public static void main(String[] args)
	{
		
		Sklep sklep_wielobranzowy=new Sklep("Sklep Wielobranżowy", 10000, 30);
		Ubran szwalnia=new Ubran("Szwalnia Nyska", 10);
		Urzadzen lenovo=new Urzadzen("Lenovo productions", 85, 8.5);
		
		Fabryka[] fabryki=new Fabryka[2];
		fabryki[0]=lenovo;
		fabryki[1]=szwalnia;
		
		// Stan początkowy
		sklep_wielobranzowy.getstan();
		for(Fabryka F:fabryki)
			F.getstan();

		//zamów i odbierz
		sklep_wielobranzowy.zamów(lenovo, "Laptop",2400 , 1);
		sklep_wielobranzowy.zamów(lenovo, "Laptop",2400 , 1);
		sklep_wielobranzowy.zamów(lenovo, "Smartfon", 1500, 1);
		sklep_wielobranzowy.zamów(lenovo, "Myszka",39.99,5);
		sklep_wielobranzowy.zamów(lenovo, "Klawiatura", 79.99, 1);
		sklep_wielobranzowy.zamów(lenovo, "Klawiatura", 79.99, 1);
		sklep_wielobranzowy.zamów(szwalnia, "Koszulka", 49.99, 10);
		sklep_wielobranzowy.zamów(szwalnia, "Spodnie", 84.99, 5);
		sklep_wielobranzowy.zamów(szwalnia, "Bluza", 149.99, 15);
		sklep_wielobranzowy.zamów(szwalnia, "koszulka", -5.00, 3);
		sklep_wielobranzowy.odbierz(lenovo, "Laptop", 2400, 1);
		sklep_wielobranzowy.odbierz(lenovo, "Klawiatura", 79.99, 2);
		sklep_wielobranzowy.odbierz(szwalnia, "Koszulka", 49.99,4);
		sklep_wielobranzowy.odbierz(szwalnia, "Spodnie", 84.99, 2);
		sklep_wielobranzowy.odbierz(szwalnia, "Bluza", 149.99, 15);
		
		//Stan po zamówieniach i odbiorach
		sklep_wielobranzowy.getstan();
		for(Fabryka F:fabryki)
			F.getstan();
		
		//sprzedaż
		sklep_wielobranzowy.sprzedaj(sklep_wielobranzowy.get_random_produkt());
		
		//Zwrot	
		sklep_wielobranzowy.zwróć(lenovo,"Laptop",2400);
		sklep_wielobranzowy.zwróć(szwalnia,"Bluza", 149.99);
		
		//ocena fabryki urządeń
		lenovo.oceń();
		
		//Stan po sprzedaży, zwrotach i ocenie
		sklep_wielobranzowy.getstan();
		for(Fabryka F:fabryki)
			F.getstan();
		
	}

}
