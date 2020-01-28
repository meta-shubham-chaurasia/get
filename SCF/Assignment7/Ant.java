package Animals;

public class Ant extends Insect{

	private int id;
	private String name;

	Ant(String name,int id)
	{
		this.id=id;
		this.name=name;
	}

	public boolean CanFly()
	{
		return false;
	}

	@Override
	public boolean equals(Object animal)
	{
		Ant x=(Ant)animal;
		if(x.GetName().compareTo(name)==0)
		{
			return true;
		}
		return false;
	}

	public String GetName()
	{
		return name;
	}

	public int GetId()
	{
		return id;
	}

	public String GetSound()
	{
		return "ZZZ";
	}


}