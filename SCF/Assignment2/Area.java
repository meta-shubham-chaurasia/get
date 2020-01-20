package hello;

import java.util.Scanner;
import java.lang.ArithmeticException;
class Area
{ 
	/**
	 * Calculating the Area of Triangle
	 * @param Width Width of Triangle 
	 * @param Height Height of Triangle 
	 * @return Area of Triangle
	 */
    static double AreaOfTriangle(double Width, double Height) throws ArithmeticException
    {
           return(0.5*Width*Height);
    }
    /**
	 * Calculating the Area of Rectangle
	 * @param Width Width of Rectangle 
	 * @param Height Height of Rectangle
	 * @return Area of Rectangle
	 */
	static double AreaOfRectangle(double Width, double Height) throws ArithmeticException
    {
           return(Width*Height);
    }
	/**
	 * Calculating the Area of Square
	 * @param Width Side of Square
	 * @return Area of Square
	 */
	static double AreaOfSquare(double Width) throws ArithmeticException
    {
           return(Width*Width);
    }
	/**
	 * Calculating the Area of Circle
	 * @param Radius Radius of Circle
	 * @return Area of Circle
	 */
	static double AreaOfCircle(double Radius) throws ArithmeticException
    {
           return(3.14*Radius*Radius);
    }
    public static void main(String args[]) throws ArithmeticException
    {   
        Scanner sc=new Scanner(System.in);
		int x=0;
        while(x!=5)
		{
			try{
				System.out.println("Select the shape to calculate area\n1. Triangle\n2. Rectangle\n3. Square\n4. Circle\n5. Exit");
				x=sc.nextInt();
				switch(x){
					case 1:
					{
						System.out.println("Enter Width and Height");
						double Width=sc.nextDouble();
						double Height=sc.nextDouble();
						if(Width<0||Height<0){
							System.out.println("Dimesnions can`t be negative");
						}
						else{
						double Area=AreaOfTriangle(Width,Height);
						System.out.println("Area of triangle="+Area);
						}
					}
					break;
					case 2:
					{
						System.out.println("Enter Width and Height");
						double Width=sc.nextDouble();
						double Height=sc.nextDouble();
						if(Width<0||Height<0){
							System.out.println("Dimesnions can`t be negative");
						}
						else{
						double Area=AreaOfRectangle(Width,Height);
						System.out.println("Area of rectangle="+Area);
						}
					}
					break;
					case 3:
					{
						System.out.println("Enter Width");
						double Width=sc.nextDouble();
						if(Width<0){
							System.out.println("Width can`t be negative");
						}
						else{
						double Area=AreaOfSquare(Width);
						System.out.println("Area of square="+Area);
						}
					}
					break;
					case 4:
					{
						System.out.println("Enter Radius");
						double Radius=sc.nextDouble();
						if(Radius<0){
							System.out.println("Radius can`t be negative");
						}
						else{
							double Area=AreaOfCircle(Radius);
							System.out.println("Area of Circle="+Area);
						}
					}
					break;
					case 5:
					{
						System.exit(0);
					}
					break;
					default:
					{
						System.out.println("Wrong Choice");
					}
				}
			}
			catch(Exception e){
				System.out.println("Invalid");
				sc.next();
			}
		}
        sc.close();
    } 
} 