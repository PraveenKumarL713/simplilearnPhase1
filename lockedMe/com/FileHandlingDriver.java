
package lockedMe.com;

import java.util.Scanner;

/**
 * @author Praveen Kumar L
 *
 */
public class FileHandlingDriver {

	private static Scanner scan = new Scanner(System.in);

	private static FileHandlingFunctions obj = new FileHandlingFunctions();

	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		System.out.println("LockedMe.com File Handling Application");
		System.out.println();
		
		System.out.println("Developed By: Praveen Kumar L");
		System.out.println("praveenkumarpraveen713@gmail.com");
		System.out.println();
		
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		

		do {
			System.out.println();
			System.out.println("Menu");
			System.out.println();
			System.out.println("1: Display current file names in root directory in ascending order");
			System.out.println("2. Select your option to create, delete or search File");
			System.out.println("3. Exit App");
			
			System.out.println();

			System.out.println("Enter your choice");
			System.out.println();

			byte choice = scan.nextByte();
			switch (choice) {
			case 1:
				obj.displaySortedFiles();
				break;

			case 2:
				obj.option2Functions();
				break;

			case 3:
				System.exit(0);

			default:
				System.out.println("Enter Valid Option");

			}
		} while (true);

	}

}
