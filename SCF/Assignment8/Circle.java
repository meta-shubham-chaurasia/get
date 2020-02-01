package Shapes;

import java.util.ArrayList;
import java.util.Date;

public class Circle implements Shape {
	
	private int radius;
	private final double PI=3.14;
	private int x__cood;
	private int y__cood;
	private long time;
		
	public Circle(ArrayList<Integer> parameters,Point p)
	{
		this.radius=parameters.get(0);
		this.x__cood=p.GetXCood();
		this.y__cood=p.GetYCood();
		Date date= new Date();
		time = date.getTime();
		}
	
	public String GetType()
	{
		return "circle";
	}
	
	public long GetTime()
	{
		return time;
	}
	
	public int GetArea()
	{
		return ((int)(PI*radius*radius));
	}
	
	public int GetPerimeter()
	{
		return ((int)(2*PI*radius));
	}
	
	public Point GetOrigin()
	{
		Point p=new Point(x__cood,y__cood);
		return p;
	}
	
	public boolean IsPointEnclosed(Point p)
	{
		int distance=((p.GetXCood()-x__cood)*(p.GetXCood()-x__cood))+((p.GetYCood()-y__cood)*(p.GetYCood()-y__cood));
		if(Math.sqrt(distance)<=radius)
			return true;
		else
			return false;
	}
	
}