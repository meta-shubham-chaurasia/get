package Animals;

import java.util.ArrayList;

public class NorthZone extends Zone{

	private int capacity;
	private ArrayList<Cow> cowList;
	
	public NorthZone()
	{
		this.capacity=3;
		this.cowList=new ArrayList<Cow>();
	}
	
	public boolean HasPark()
	{
		return true;
	}
	
	public boolean HasCanteen()
	{
		return false;
	}
	
	public boolean AvailableSpace()
	{
		if(cowList.size()<capacity)
			return true;
		else
			return false;
	}
	
	public void AddAnimal(Cow animal)
	{
		if(AvailableSpace())
			cowList.add(animal);
	}
	
	public void RemoveAnimal(Cow animal)
	{
		cowList.remove(animal);
	}
	
	public ArrayList<Cow> ShowAnimal()
	{
		return cowList;
	}
		
	public int GetCapacity()
	{
		return capacity;
	}

}