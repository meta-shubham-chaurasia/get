package hello;
import java.io.*;
class HexCalc
{
	static int base=16;
	HexCalc(int base1){
		base=base1;
	}
    static String Hexadecimal="0123456789ABCDEF";  
    public static int ConvertToDecimal(String Hexa1)
    {
        int Decimal1=0;  
	    for(int i=0;i<Hexa1.length();i++)  
	    {  
		    char ch=Hexa1.charAt(i);  
		    int index=Hexadecimal.indexOf(ch);  
		    Decimal1=base*Decimal1+index;  
	    }  
	    return Decimal1;
    }
    
    public static String ConvertToHexadecimal(int Decimal2)
    {
        int temp=Decimal2;
        String Hexa2="";
        int rem=0;
        char a[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(temp>0)
        {
            rem=temp%base; 
            Hexa2=a[rem]+Hexa2; 
            temp=temp/base;
        }
        return Hexa2;
    }
}
class Hex extends HexCalc
{
	Hex(int base){
		super(base);
	}
	public static void print(int temp){
		String Hexa3=ConvertToHexadecimal(temp);
		System.out.println("Result in Hexadecimal is:"+Hexa3);
	}
	public static void main(String[] args)throws IOException
	{
	    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Hexadecimal Number 1:");
		String Hexa1=br.readLine().toUpperCase();;
		System.out.println("Enter Hexadecimal Number 2:");
		String Hexa2=br.readLine().toUpperCase();;
		int Decimal1=ConvertToDecimal(Hexa1);
		System.out.println(Decimal1);
		
		int Decimal2=ConvertToDecimal(Hexa2);
		System.out.println(Decimal2);
		int x=1;
		while(x!=6)
		{
		    int temp=0;
			System.out.println("What do you want?");
			System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Compare\n6. Exit");
			x=Integer.parseInt(br.readLine());
			if(x==1)//Addition
			{
				temp=Decimal1+Decimal2;
				print(temp);
			}
			else if(x==2)//Subtraction
			{
				if(Decimal1>Decimal2)
				{
				    temp=Decimal1-Decimal2;
				}
				else
				{
				    temp=Decimal2-Decimal1;
				}
				print(temp);
			}
			else if(x==3)//Multiplication
			{
				temp=Decimal1*Decimal2;
				print(temp);
			}
			else if(x==4)//Division
			{
				if(Decimal1>Decimal2)
				{
				    temp=Decimal1/Decimal2;
				}
				else
				{
				    temp=Decimal2/Decimal1;
				}
				print(temp);
			}
			else if(x==5)//Comparison
			{
				if(Decimal1>Decimal2)
					System.out.println(Hexa1 +" is greater");
				else
				{
					if(Decimal2>Decimal1)
					System.out.println(Hexa2 +" is greater");
					else
					System.out.println("Both are equal");
				}
			}
			else if(x==6)//Exit
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Wrong choice");
			}
		}
	}
}
