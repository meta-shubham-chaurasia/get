package Animals;

import java.util.ArrayList;

public  class WestZone extends Zone{
	
	private int capacity;
	private ArrayList<Ant> antList;
	
	public WestZone()
	{
		this.capacity=4;
		this.antList=new ArrayList<Ant>();
	}
	
	public boolean AvailableSpace()
	{
		if(antList.size()<capacity)
			return true;
		else
			return false;
	}
	
	public void AddAnimal(Ant animal)
	{
		if(AvailableSpace())
		antList.add(animal);
	}
	
	public void RemoveAnimal(Ant animal)
	{
		antList.remove(animal);
	}
	
	public boolean HasPark()
	{
		return true;
	}
	
	public boolean HasCanteen()
	{
		return true;
	}
	
	public int GetCapacity()
	{
		return capacity;
	}
	
	public ArrayList<Ant> ShowAnimal()
	{
		return antList;
	}	

}
