package hello;

public class LcmHcf
{
	public int Hcf(int x, int y)
	{
		if(y!=0)
		{
			int rem=x%y;
			x=y;
			y=rem;
			return Hcf(x,y);
		}
		else{
			return x;
		}
		
	}
	public int Lcm(int x, int y)
	{
		int hcf=Hcf(x,y);
		int lcm=(x*y)/hcf;
		return lcm;
	}
}