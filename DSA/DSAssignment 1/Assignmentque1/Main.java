package que1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main method contains the UI for substring generation and further its output after rotations
 */
public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		LinkedList llistRef = null;
		int choice = 0;
		do {
			printInstructions();
			System.out.println("Enter your choice: ");
			try {
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Insert node... ");
					llistRef = insertNode(scanner);
					break;
				case 2:
					System.out.println("Rotate subList... ");
					subList(llistRef, scanner);
					break;
				case 3:
					llistRef.printList();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter integer only!");
				choice = -1;
				scanner.nextLine();
			}

		} while (choice != 5);
	}

	/**
	 * Prints instructions for the user
	 */
	public static void printInstructions() {
		System.out.println("\n1.Insert a new node");
		System.out.println("2.To rotate a sublist of linkedList");
		System.out.println("3.Print the list");
	}

	/**
	 * The function creates a link list by inserting nodes
	 * 
	 * @param scanner
	 * @return
	 */
	public static LinkedList insertNode(Scanner scanner) {
		int entry, count = 1;
		LinkedList llist = new LinkedList();

		System.out.println("Enter " + " node value " + count);
		llist.head = new LinkedList.Node(scanner.nextInt());
		do {
			try {
				System.out.println("Enter " + " node value " + (count + 1));
				System.out.println("....Enter 911 to terminate linked list");
				entry = scanner.nextInt();
				if (entry == 911)
					break;
				llist.append(entry);
				count++;
			} catch (InputMismatchException e) {
				System.out.println("Enter integer only!");
				entry = -1;
				scanner.nextLine();
			}

		} while (entry != -2);
		return llist;

	}

	/**
	 * The method is a helper method to subListRotate(), asks user to input
	 * leftIndex, rightIndex and N, the no. of rotations
	 * 
	 * @param llistRef
	 *            is a object reference to LinkedList type
	 * @param scanner
	 *            Scanner object
	 */
	public static void subList(LinkedList llistRef, Scanner scanner) {
		do {
			try {
					System.out.println("Enter left index of linked list(starting from 1)");
					int lIndex = scanner.nextInt();
					System.out.println("Enter right index of linked list(starting from 1)");
					int rIndex = scanner.nextInt();
					System.out.println("Enter N, no.of rotations for the subList");
					int N = scanner.nextInt();
					llistRef.rotateSubList(lIndex, rIndex, N);
					break;
				}
				catch (InputMismatchException e) {
				System.out.println("Enter integer only!");
				scanner.nextLine();
			}
		} while (true);

	}
}