package Shapes;
import java.util.*;
public class AreaCompare implements Comparator<Shape>{
	
	public int compare(Shape s1,Shape s2) 
    { 
        if (s1.GetArea()<s2.GetArea()) return -1; 
        if (s1.GetArea()>s2.GetArea()) return 1; 
        else return 0; 
    } 

}