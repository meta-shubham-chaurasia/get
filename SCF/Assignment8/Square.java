package Shapes;

import java.util.ArrayList;
import java.util.Date;

public class Square implements Shape{
	
	private int base;
	private int x__cood;
	private int y__cood;
	private long time;
		
	public Square(ArrayList<Integer> parameters,Point p)
	{
		this.base=parameters.get(0);
		this.x__cood=p.GetXCood();
		this.y__cood=p.GetYCood();
		Date date= new Date();
		time = date.getTime();
		
	}
	
	public String GetType()
	{
		return "square";
	}
	
	public long GetTime()
	{
		return time;
	}
	
	public int GetArea()
	{
		return (base*base);
	}
	
	public int GetPerimeter()
	{
		return (4*base);
	}
	
	public Point GetOrigin()
	{
		Point p=new Point(x__cood,y__cood);
		return p;
	}
	
	public boolean IsPointEnclosed(Point p)
	{
		int x__diagonal=x__cood+base;
		int y__diagonal=y__cood+base;
		if((p.GetXCood()>=x__cood&&p.GetXCood()<=x__diagonal)&&(p.GetYCood()>=y__cood&&p.GetYCood()<=y__diagonal))
			return true;
		else
			return false;
	}
	
}