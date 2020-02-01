package Shapes;

import java.util.*;

public class Screen {
	
	private ArrayList<Shape> shapeList=new ArrayList<Shape>();
	
	public Screen()
	{
		
	}
	
	public void AddShape(Shape shape)
	{
		shapeList.add(shape);
	}
	
	public void DeleteShape(Shape shape)
	{
		shapeList.remove(shape);
	}
	
	public void DeleteAllSpecificShape(String type)
	{
		for(int i=0;i<shapeList.size();i++)
		{
			if(shapeList.get(i).GetType().equals(type))
				shapeList.remove(shapeList.get(i));
		}
	}
	
	public ArrayList<Shape> SortByArea()
	{
		AreaCompare areaCompare = new AreaCompare();
		Collections.sort(shapeList, areaCompare);
		return shapeList;
	}
	
	public ArrayList<Shape> SortByPerimeter()
	{
		PerimeterCompare perimeterCompare = new PerimeterCompare();
		Collections.sort(shapeList, perimeterCompare);
		return shapeList;
	}
	
	public ArrayList<Shape> SortByTimestamp()
	{
		return shapeList;
	}
	
	public ArrayList<Shape> SortByOrigin()
	{
		return shapeList;
	}
	
	public ArrayList<Shape> EnclosingPoint()
	{
		return shapeList;
	}

}
