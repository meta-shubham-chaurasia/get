package Animals;

public class Crocodile extends Reptile{

	private int id;
	private String name;

	Crocodile(String name,int id)
	{
		this.id=id;
		this.name=name;
	}

	public String BodySize()
	{
		return "large";
	}

	@Override
	public boolean equals(Object animal)
	{
		Crocodile x=(Crocodile)animal;
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
		return "GRRR";
	}
}