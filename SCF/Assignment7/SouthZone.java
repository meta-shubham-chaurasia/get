package Animals;

import java.util.ArrayList;

public class SouthZone extends Zone
{
	private int capacity;
	private ArrayList<Crocodile> crocList;
	
	public SouthZone()
	{
		this.capacity=2;
		this.crocList=new ArrayList<Crocodile>();
	}
	
	public boolean HasPark()
	{
		return false;
	}
	
	public boolean HasCanteen()
	{
		return false;
	}
		
	public boolean AvailableSpace()
	{
		if(crocList.size()<capacity)
			return true;
		else
			return false;
	}
	public void AddAnimal(Crocodile animal)
	{
		if(AvailableSpace())
		crocList.add(animal);
	}
	
	public void RemoveAnimal(Crocodile animal)
	{
		crocList.remove(animal);
	}
	
	public int GetCapacity()
	{
		return capacity;
	}
	
	public ArrayList<Crocodile> ShowAnimal()
	{
		return crocList;
	}
	
}
