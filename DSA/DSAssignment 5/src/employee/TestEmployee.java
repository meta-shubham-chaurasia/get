package employee;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

/**
 * Class to test Employee class
 *
 */
public class TestEmployee {

	@Test
	public void testEmplyee1() {
		try {
			LinkedList linkedList = new LinkedList();
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			
			expectedOrder.add(new Employee("Naman", 17, 800));
			expectedOrder.add(new Employee("Shubham", 18, 600));
			expectedOrder.add(new Employee("Ashish", 19, 500));
			
			linkedList.insert(expectedOrder.get(2));
			linkedList.insert(expectedOrder.get(1));
			linkedList.insert(expectedOrder.get(0));
			linkedList.sort();
			
			List<Employee> resultingOrder = linkedList.returnAsList();
			
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	public void testEmplyee2() {
		try {
			LinkedList linkedList = new LinkedList();
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			
			expectedOrder.add(new Employee("Naman", 17, 800));
			expectedOrder.add(new Employee("Shubham", 18, 500));
			expectedOrder.add(new Employee("Ashish", 19, 500));
			
			linkedList.insert(expectedOrder.get(2));
			linkedList.insert(expectedOrder.get(1));
			linkedList.insert(expectedOrder.get(0));
			linkedList.sort();
			
			List<Employee> resultingOrder = linkedList.returnAsList();
						
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	public void testEmplyee3() {
		try {
			LinkedList linkedList = new LinkedList();
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			
			expectedOrder.add(new Employee("Naman", 17, 800));
			expectedOrder.add(new Employee("Shubham", 18, 800));
			expectedOrder.add(new Employee("Ashish", 19, 800));
			
			linkedList.insert(expectedOrder.get(2));
			linkedList.insert(expectedOrder.get(1));
			linkedList.insert(expectedOrder.get(0));
			linkedList.sort();
			
			List<Employee> resultingOrder = linkedList.returnAsList();
			
			assertTrue(expectedOrder.equals(resultingOrder));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
