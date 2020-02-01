package Shapes;

import java.util.*;
import java.util.Date;

public class Triangle implements Shape {

	private int base;
	private int height;
	private int x__cood;
	private int y__cood;
	private int x__cood2;
	private int y__cood2;
	private int x__cood3;
	private int y__cood3;
	private long time;
		
	
	public Triangle(ArrayList<Integer> parameters,Point p)
	{
		this.base=parameters.get(0);
		this.height=parameters.get(1);
		this.x__cood=p.GetXCood();
		this.y__cood=p.GetYCood();
		this.x__cood2=x__cood+base;
		this.y__cood2=y__cood;
		this.x__cood3=x__cood+(base/2);
		this.y__cood3=y__cood+height;
		Date date= new Date();
		time = date.getTime();
	}
	
	public String GetType()
	{
		return "triangle";
	}
	
	public int GetArea()
	{
		return ((x__cood*(y__cood2-y__cood3) + x__cood2*(y__cood3-y__cood)+ x__cood3*(y__cood-y__cood2))/2);
	}
	
	public long GetTime()
	{
		return time;
	}
	
	public int GetAreaUtil(int x1,int y1,int x2,int y2,int x3,int y3)
	{
		return ((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2);
	}
	
	public int GetSideLength(int x1,int y1,int x2,int y2)
	{
		int dist=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		return ((int)Math.sqrt(dist));
	}
	
	public int GetPerimeter()
	{
		int side1=GetSideLength(x__cood,y__cood,x__cood2,y__cood2);
		int side2=GetSideLength(x__cood,y__cood,x__cood3,y__cood3);
		int side3=GetSideLength(x__cood2,y__cood2,x__cood3,y__cood3);
		return (side1+side2+side3);
	}
	
	public Point GetOrigin()
	{
		Point p=new Point(x__cood,y__cood);
		return p;
	}
	
	public boolean IsPointEnclosed(Point p)
	{
		int x=p.GetXCood();
		int y=p.GetYCood();
		int A = GetArea(); 
		int A1 = GetAreaUtil(x,y,x__cood2,y__cood2,x__cood3,y__cood3);  
		int A2 = GetAreaUtil(x__cood,y__cood,x,y,x__cood3,y__cood3);
		int A3 = GetAreaUtil(x__cood,y__cood,x__cood2,y__cood2,x,y);
		if(A==(A1+A2+A3))
			return true;
		else
			return false;
	}
	
}