package que1;

/**
 * Linked List class contains functions to perform sublist rotations till given N
 */
public class LinkedList {
	public Node head; // head declared as Node type without instance

	// Nested class, static

	public static class Node {

		int data;
		public Node next;

		public Node(int d) {
			data = d;
			next = null;
		}

		public int getData() {
			return data;
		}
	}

	/**
	 * The method adds new node at the end of the linked list along with the data value
	 * 
	 * @param new_data
	 */
	public void append(int new_data) {
		Node new_node = new Node(new_data);

		if (head == null) {
			head = new Node(new_data);
			return;
		}

		new_node.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = new_node;

		return;

	}

	/**
	 * This function prints the linked list starting from the head node
	 */
	public void printList() {

		Node tempNode = head;
		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}

		while (tempNode != null) {
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}
	}

	/**
	 * The function rotates the sublist by n rotations
	 * 
	 * @param lIndex
	 *            left index of the sublist
	 * @param rIndex
	 *            right index of the sublist
	 * @param n
	 *            the no. of rotations for the sublist
	 */
	public void rotateSubList(int lIndex, int rIndex, int n) {
		int count = 1;
		n = n % (rIndex - lIndex + 1);
		Node tNode = head, tNodeLeft = null, tNodeRight = null, linkNode = null;
		do {

			if (count == (lIndex - 1)) { // (lIndex-1) in order to get its predecessor node.next value
				tNodeLeft = tNode;
			} else if (rIndex == count + n) {
				linkNode = tNode;
			} else if (count == rIndex) {
				tNodeRight = tNode;
				if (tNodeLeft == null) {
					tNodeLeft = head;
					head = linkNode.next;
					linkNode.next = tNodeRight.next;
					tNodeRight.next = tNodeLeft;
					break;
				} else {
					Node tempNode = linkNode.next;
					linkNode.next = tNodeRight.next;
					tNodeRight.next = tNodeLeft.next;
					tNodeLeft.next = tempNode;
					break;
				}

			}
			count++;
			tNode = tNode.next;
		} while (tNode != null);

	}

	/**
	 * This method converts integer list data into an integer Array
	 * 
	 * @param list
	 *            list which will be operated
	 * @return Integer Array of list data
	 */
	public int[] convertListToArray(LinkedList list) {
		int arr[] = new int[list.size()];
		Node tempHead = list.head;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = tempHead.data;
			tempHead = tempHead.next;
		}
		return arr;
	}

	/**
	 * Give us the size of linked list.
	 * 
	 * @return An integer value, Return the size of Linked List.
	 */
	public int size() {
		int count = 0;
		Node node = head;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}

}