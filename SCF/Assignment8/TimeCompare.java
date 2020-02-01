package Shapes;

import java.util.*;

public class TimeCompare implements Comparator<Shape> {
	
	public int compare(Shape s1,Shape s2) 
    { 
        if (s1.GetTime()<s2.GetTime()) return -1; 
        if (s1.GetTime()>s2.GetTime()) return 1; 
        else return 0; 
    } 

}
