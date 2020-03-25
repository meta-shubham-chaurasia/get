package que2;

import static org.junit.Assert.*;

import org.junit.Test;

import que1.LinkedList;

/**
 * This class contains the test methods for testing methods of class DetectLoop
 */
public class DetectLoopTest {

	@Test
	public void testDetectLoop1() // Positive test case
	{
		LinkedList list = new LinkedList();
		list.head = new LinkedList.Node(2); // Linked list is assumed 2-> 3-> 4-> 5-> 6->2
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.head.next.next.next.next.next = list.head.next;
		DetectLoop isLoop = new DetectLoop();
		assertEquals(true, isLoop.foundLoop(list.head));
	}

	@Test
	public void testDetectLoop2() // Negative test case
	{
		LinkedList list = new LinkedList();
		list.head = new LinkedList.Node(2); // Linked list is assumed 2-> 3-> 4-> 5-> 6
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.head.next.next.next.next.next = list.head.next;
		DetectLoop isLoop = new DetectLoop();
		assertEquals(false, isLoop.foundLoop(list.head));
	}

}