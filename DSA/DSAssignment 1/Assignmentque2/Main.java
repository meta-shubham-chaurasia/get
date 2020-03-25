package que2;

import java.util.InputMismatchException;
import java.util.Scanner;

import que1.LinkedList;

/**
 * This is the main method from where the program begins execution. It contains user interface for generating linked list containing loop
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LinkedList llistRef = null;
		int choice = 0;
		do {
			printInstructions();
			System.out.println("Enter your choice: ");
			try {
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Inserting nodes... ");
					llistRef = insertNode();
					break;
				case 2:
					System.out.println("Detect a loop ");
					DetectLoop isLoop = new DetectLoop();
					if (!isLoop.foundLoop(llistRef.head)) {
						System.out.println("Loop not found");
						llistRef.printList();
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Enter between 1 and 2, and press 3 to exit");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter integer only!");
				choice = -1;
				sc.nextLine();
			}

		} while (choice != 3);
	}

	/**
	 * It will display instructions on screen
	 */
	public static void printInstructions() {
		System.out.println("\n1.Insert auto-generated nodes");
		System.out.println("2.Detect loop in link list");
	}

	/**
	 * The method to create a circular linked list
	 * 
	 * @return
	 */
	public static LinkedList insertNode() {

		LinkedList llist = new LinkedList();
		llist.head = new LinkedList.Node(2); // Linked list is assumed fixed 2-> 3-> 4-> 5-> 6
		llist.append(3);
		llist.append(4);
		llist.append(5);
		llist.append(6);
		llist.head.next.next.next.next.next = llist.head.next; // 6-> 3

		return llist;

	}
}