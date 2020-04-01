package employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Class to test sorting and hashing of Employee class
 *
 */
class TestEmployee {

	@Test
	void testEmployee1() {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(new Employee(4, "Abhijeet", "Jaipur"));
			employees.add(new Employee(5, "Shubham", "Kanpur"));
			employees.add(new Employee(2, "Naman", "Udaipur"));
			employees.add(new Employee(1, "Priyansh", "Udaipur"));
			employees.add(new Employee(3, "Animesh", "Jaipur"));
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			expectedOrder.add(employees.get(3));
			expectedOrder.add(employees.get(2));
			expectedOrder.add(employees.get(4));
			expectedOrder.add(employees.get(0));
			expectedOrder.add(employees.get(1));
			
			employees.sort(new CompareEmpId());
			assertTrue(expectedOrder.equals(employees));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	void testEmployee2() {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(new Employee(4, "Abhijeet", "Jaipur"));
			employees.add(new Employee(5, "Shubham", "Kanpur"));
			employees.add(new Employee(2, "Naman", "Udaipur"));
			employees.add(new Employee(1, "Priyansh", "Udaipur"));
			employees.add(new Employee(3, "Animesh", "Jaipur"));
			
			List<Employee> expectedOrder = new ArrayList<Employee>();
			expectedOrder.add(employees.get(2));
			expectedOrder.add(employees.get(3));
			expectedOrder.add(employees.get(1));
			expectedOrder.add(employees.get(0));
			expectedOrder.add(employees.get(4));
			
			employees.sort(new CompareName());
			assertTrue(expectedOrder.equals(employees));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testEmployee3() {
		try {
			Set<Employee> employees = new HashSet<Employee>();
			employees.add(new Employee(1, "Abhijeet", "Jaipur"));
			employees.add(new Employee(1, "Shubham", "Kanpur"));
			employees.add(new Employee(1, "Naman", "Udaipur"));
			employees.add(new Employee(3, "Priyansh", "Udaipur"));
			employees.add(new Employee(3, "Animesh", "Jaipur"));

			assertEquals(employees.size(), 2);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	void testEmployee4() {
		try {
			Set<Employee> employees = new HashSet<Employee>();
			employees.add(new Employee(1, "Shubham", "Jaipur"));
			employees.add(new Employee(2, "Shubham", "Jaipur"));
			employees.add(new Employee(3, "Shubham", "Jaipur"));
			employees.add(new Employee(4, "Shubham", "Jaipur"));
			employees.add(new Employee(5, "Shubham", "Jaipur"));

			assertEquals(employees.size(), 5);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
