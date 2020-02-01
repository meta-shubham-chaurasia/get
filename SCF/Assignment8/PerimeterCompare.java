package Shapes;

import java.util.*;

public class PerimeterCompare implements Comparator<Shape> {
	
	public int compare(Shape s1,Shape s2) 
    { 
        if (s1.GetPerimeter()<s2.GetPerimeter()) return -1; 
        if (s1.GetPerimeter()>s2.GetPerimeter()) return 1; 
        else return 0; 
    } 

}
