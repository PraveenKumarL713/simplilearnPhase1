package lockedMe.com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Praveen Kumar L
 *
 */

public class FileHandlingFunctions {
	private static Scanner scan = new Scanner(System.in);
	private static FileHandlingFunctions object = new FileHandlingFunctions();

	public String[] sortFiles(String[] searchedFiles) {

		String temp = "";
		for (int i = 0; i < searchedFiles.length; i++) {
			for (int j = 1; j < (searchedFiles.length - i); j++) {

				if (searchedFiles[j - 1].compareToIgnoreCase(searchedFiles[j]) > 0) {
					// swap elements
					temp = searchedFiles[j - 1];
					searchedFiles[j - 1] = searchedFiles[j];
					searchedFiles[j] = temp;
				}
			}
		}

		return searchedFiles;
	}

	public void displaySortedFiles() {

		String rootDirectory = "\\";

		File dir = new File(rootDirectory);

		String[] searchedFiles = dir.list();

		if (searchedFiles == null) {
			System.out.println("No files exits in the root directory");
		} else {
			searchedFiles = sortFiles(searchedFiles);
			System.out.println("The sorted files in the root directory");
			System.out.println();
			for (int i = 0; i < searchedFiles.length; i++) {
				String filename = searchedFiles[i];
				System.out.println(filename);
			}
		}

	}

	public void option2Functions() {

		char choice;
		do {
			System.out.println();
			System.out.println("Select your choice");
			System.out.println("a. Create a File");
			System.out.println("b. Delete a File");
			System.out.println("c. Search a File");
			System.out.println("d. Go to Main Menu");
			System.out.println();
			choice = scan.next().charAt(0);

			switch (choice) {
			case 'a':
				object.createFile();
				break;
			case 'b':
				object.deleteFile();
				break;
			case 'c':
				object.searchFile();
				break;
			case 'd':
				System.out.println("Going to main menu");
				break;
			default:
				System.out.println("Enter Proper choice");

			}
		} while (choice != 'd');
	}

	private void createFile() {

		System.out.println("Enter the File Name to Create");

		String fileName = scan.next();
		String path = "C:\\";
		String name = path + fileName;
		try {
			File myObj = new File(name);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void deleteFile() {

		System.out.println("Enter the File Name to Delete");
		scan.nextLine();
		String fileName = scan.nextLine();
		String path = "C:\\";
		String name = path + fileName;
		File file = new File(name);
		try {
			if (file.delete()) {
				System.out.println(fileName + " file deleted successfully");
			} else {
				System.out.println(fileName + " file not found ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchFile() {

		String directoryName = "\\";

		System.out.println("Enter the file name to be searched");
		scan.nextLine();
		String fileName = scan.nextLine();

		File dir = new File(directoryName);

		String[] searchedFiles = dir.list();

		searchedFiles = sortFiles(searchedFiles);

		binarySearch(searchedFiles, 0, searchedFiles.length - 1, fileName);

	}

	public static void binarySearch(String[] serachedFiles, int first, int last, String fileName) {
		int mid = (first + last) / 2;
		while (serachedFiles[first].compareTo(serachedFiles[last]) <= 0) {
			if (serachedFiles[mid].compareTo(fileName) < 0) {
				first = mid + 1;
			} else if (serachedFiles[mid].equals(fileName)) {
				System.out.println(fileName + " is present in root directory");
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println(fileName + " is not found in root directory");
		}
	}

}
