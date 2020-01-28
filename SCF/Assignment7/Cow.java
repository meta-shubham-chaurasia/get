package Animals;

public class Cow extends Mammal {

	private int id;
	private String name;

	public Cow(String name,int id)
	{
		this.name=name;
		this.id=id;
	}

	public int NoOfLegs()
	{
		return 4;
	}

	@Override
	public boolean equals(Object animal)
	{
		Cow x=(Cow)animal;
		if(x.GetName().compareTo(name)==0)
		{
			return true;
		}
		return false;
	}

	public String GetSound()
	{
		return "MOO"; 
	}

	public String GetName()
	{
		return name;
	}

	public int GetId()
	{
		return id;
	}



}
