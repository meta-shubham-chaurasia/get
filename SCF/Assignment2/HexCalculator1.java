package hello;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Hex
{
    static String Hexadecimal="0123456789ABCDEF";  
    public static int ConvertToDecimal(String Hexa1)
    {
    	int Decimal=0;
    	for (int i = Hexa1.length()-1; i >=0; i--) {
    		char ch=Hexa1.charAt(i);  
		    int index=Hexadecimal.indexOf(ch);
		    Decimal+=Math.pow(16, Hexa1.length()-1-i)*index;
		}
    	return Decimal;
    }
    
    public static String ConvertToHexadecimal(int Decimal2)
    {
        int temp=Decimal2;
        String Hexa2="";
        int rem=0;
        char a[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(temp>0)
        {
            rem=temp%16; 
            Hexa2=a[rem]+Hexa2; 
            temp=temp/16;
        }
        return Hexa2;
    }
    public static String Addition(int Decimal1,int Decimal2)
    {
		return ConvertToHexadecimal(Decimal1+Decimal2);
    }
    public static String Subtraction(int Decimal1,int Decimal2)
    {
		return ConvertToHexadecimal(Decimal1-Decimal2);
    }
    public static String Division(int Decimal1,int Decimal2)
    {
		return ConvertToHexadecimal(Decimal1/Decimal2);
    }
    public static String Multiplication(int Decimal1,int Decimal2)
    {
		return ConvertToHexadecimal(Decimal1*Decimal2);
    }
    public static Boolean Comparison_Equal(String Hexa1,String Hexa2)
    {
    	if(Hexa1.equals(Hexa2)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public static Boolean Comparison_LessThan(String Hexa1,String Hexa2)
    {
    	if(Hexa1.length()<Hexa2.length()){
    		return true;
    	}
    	else if(Hexa1.length()==Hexa2.length()){
    		for (int i = 0; i < Hexa1.length(); i++) {
				if((int)Hexa1.charAt(i)<(int)Hexa2.charAt(i)){
				break;
				}
			}
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public static Boolean Comparison_GreaterThan(String Hexa1,String Hexa2)
    {
    	if(Hexa1.length()>Hexa2.length()){
    		return true;
    	}
    	else if(Hexa1.length()==Hexa2.length()){
    		for (int i = 0; i < Hexa1.length(); i++) {
				if((int)Hexa1.charAt(i)<(int)Hexa2.charAt(i)){
				break;
				}
			}
    		return false;
    	}
    	else{
    		return false;
    	}
    }
    
}
class HexCalculator1 extends Hex
{
	public static void main(String[] args)throws IOException
	{
		try{
		    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		    int z=0;
		    label:
		    while(z!=-1){
				System.out.println("Enter Hexadecimal Number 1:");
				String Hexa1=br.readLine().toUpperCase();
				if (Hexa1 == null || Hexa1.trim().isEmpty()) {
			         System.out.println("Incorrect format of string");
			     }
			     Pattern p = Pattern.compile("[^A-Fa-f0-9]");
			     Matcher m1 = p.matcher(Hexa1);
			     boolean b1 = m1.find();
			     if(b1){
			        System.out.println("Invalid String ");
			        continue label;
			      }
				System.out.println("Enter Hexadecimal Number 2:");
				String Hexa2=br.readLine().toUpperCase();
				Matcher m2 = p.matcher(Hexa2);
			     boolean b2 = m2.find();
			     if(b2){
			        System.out.println("Invalid String ");
			        continue label;
			      }
				int Decimal1=ConvertToDecimal(Hexa1);
				int Decimal2=ConvertToDecimal(Hexa2);
				int x=1;
				while(x!=10)
				{
					System.out.println("What do you want?");
					System.out.println("1. Add\n"
									+ "2. Subtract\n"
									+ "3. Multiply\n"
									+"4. Divide\n"
									+"5. Decimal Conversion\n"
									+"6. HexaDecimal Conversion\n"
									+"7. ==\n"
									+"8. >\n"
									+"9. <\n"
									+"10. Exit");
					try{
						x=Integer.parseInt(br.readLine());
						if(x==1)//Addition
						{
							System.out.println(Subtraction(Decimal1,Decimal2));
						}
						else if(x==2)//Subtraction
						{
							if(Decimal1>Decimal2)
							{
								System.out.println(Subtraction(Decimal1,Decimal2));
							}
							else
							{
								System.out.println(Subtraction(Decimal2,Decimal1));
							}
						}
						else if(x==3)//Multiplication
						{
							System.out.println(Multiplication(Decimal1,Decimal2));
						}
						else if(x==4)//Division
						{
							if(Decimal1==0||Decimal1==0){
								System.out.println("Divide By Zero not allowed");
							}
							else if(Decimal1>Decimal2)
							{
								System.out.println(Division(Decimal1,Decimal2));
							}
							else
							{
								System.out.println(Division(Decimal2,Decimal1));
							}
						}
						else if(x==5)	//Decimal Conversion
						{
							System.out.println(ConvertToDecimal(Hexa1));
							System.out.println(ConvertToDecimal(Hexa2));
						}
						else if(x==6)	//HexaDecimal Conversion
						{
							System.out.println(ConvertToHexadecimal(Decimal1));
							System.out.println(ConvertToHexadecimal(Decimal2));
						}
						else if(x==7)	//Equality(==) 
						{
							System.out.println(Comparison_Equal(Hexa1,Hexa2));
						}
						else if(x==8)	//GreaterThan(>)
						{
							System.out.println(Comparison_GreaterThan(Hexa1,Hexa2));
						}
						else if(x==9)	//LessThan(<)
						{
							System.out.println(Comparison_LessThan(Hexa1,Hexa2));
						}
						else if(x==10)//Exit
						{
							System.exit(0);
						}
						else
						{
							System.out.println("Wrong choice");
						}
					}
					catch(Exception e){
						System.out.println("Invalid Choice");
					}
				}
		    }
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
