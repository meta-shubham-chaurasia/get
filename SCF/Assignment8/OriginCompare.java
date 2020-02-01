package Shapes;

import java.util.*;

public class OriginCompare implements Comparator<Shape>{
	
	public int compare(Shape s1,Shape s2) 
    { 
        if (s1.GetOrigin().GetXCood()<s2.GetOrigin().GetXCood()) return -1; 
        if (s1.GetOrigin().GetXCood()>s2.GetOrigin().GetXCood()) return 1; 
        else return 0; 
    } 

}
