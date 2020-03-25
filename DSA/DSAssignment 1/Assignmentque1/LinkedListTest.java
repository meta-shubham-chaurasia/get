package que1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * contains test class for Linked List rotation
 *
 */
public class LinkedListTest {

	@Test
	public void test1() {
		LinkedList list = new LinkedList();
		list.head = new LinkedList.Node(2); // Linked list is assumed 2-> 3-> 4-> 5-> 6->2
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.rotateSubList(2, 5, 2);

		int[] expectedArr = { 2, 5, 6, 3, 4 };

		assertArrayEquals(expectedArr, list.convertListToArray(list));

	}

}