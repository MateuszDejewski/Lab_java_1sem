package lista1;

public class funkcja {
public static void main(String[] args) {
		
double a=1,b=-1,c=-6,x,y,d;

if(a==0)
{
	if(b==0)
	{
		if(c==0) 
			System.out.println("tożsamość");
		else 
			System.out.println("sprzeczność");
		
	}
	else
	{
		x=-c/b;
		System.out.println("rozwiązanie "+ x);
	}
}
else
{
	d=b*b-4*a*c;
	if(d<0)
	{
		System.out.println("brak rozwiązań");
	}
	else
	{
		if(d==0)
		{
			x=-b/(2*a);
			System.out.println("rozwiązanie (podwójny pierwiasetek) "+x);
		}
		else
		{
			x=(-b-Math.sqrt(d))/(2*a);
			y=(-b+Math.sqrt(d))/(2*a);
			System.out.println("rozwiązania "+x+" lub "+y);					
					
		}
	}
}

}
}
