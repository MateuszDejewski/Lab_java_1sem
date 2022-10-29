package lista1;

public class sortowanie {
	public static void main(String[] args) {

	double tmp;
	int n=3;
	double tab[]= {4.6,13.59,-125};
	
	for(int i=0;i<(n-1);i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(tab[i]>tab[j])
			{
				tmp=tab[i];
				tab[i]=tab[j];
				tab[j]=tmp;
			}
		}
	}
	
System.out.println("Liczby w kolejności rosnącej: ");

for(int i=0;i<n;i++)
	System.out.println(tab[i]);

	}

}
