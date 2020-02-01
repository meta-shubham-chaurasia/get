package Shapes;


import java.util.ArrayList;
import java.util.Date;

public class Rectangle implements Shape {
	
	private int base;
	private int height;
	private int x__cood;
	private int y__cood;
	private long time;
	
	
	public Rectangle(ArrayList<Integer> parameters,Point p)
	{
		this.base=parameters.get(0);
		this.height=parameters.get(1);
		this.x__cood=p.GetXCood();
		this.y__cood=p.GetYCood();
		Date date= new Date();
		time = date.getTime();
		
	}
	
	public String GetType()
	{
		return "rectangle";
	}
	
	public long GetTime()
	{
		return time;
	}
	
	public int GetArea()
	{
		return (base*height);
	}
	
	public int GetPerimeter()
	{
		return (2*(base+height));
	}
	
	public Point GetOrigin()
	{
		Point p=new Point(x__cood,y__cood);
		return p;
	}
	
	public boolean IsPointEnclosed(Point p)
	{
		int x__diagonal=x__cood+base;
		int y__diagonal=y__cood+height;
		if((p.GetXCood()>=x__cood&&p.GetXCood()<=x__diagonal)&&(p.GetYCood()>=y__cood&&p.GetYCood()<=y__diagonal))
			return true;
		else
			return false;
	}
	
}