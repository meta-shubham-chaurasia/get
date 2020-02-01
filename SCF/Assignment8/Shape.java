package Shapes;

public interface Shape {
	
	enum Shapes
	{
		TRIANGLE,SQUARE,RECTANGLE,CIRCLE;
	}
	
	public abstract int GetArea();
	public abstract int GetPerimeter();
	public abstract Point GetOrigin();
	public abstract boolean IsPointEnclosed(Point p);
	public abstract String GetType();
	public abstract long GetTime();

}