
/**
 * This program implements a word indexer using a binary or an avl tree. It reads an input text file and creates a tree
 * where each node is a unique word found in the input text along with all the indices where the word occurs in the 
 * text. Then the user can input words and the program outputs how many times and where each word occurs. The program
 * terminates when the user types the command exit(). The index of a word is the total number of characters found in the
 * input file until the beginning of the word. The words are case sensitive.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import tree.*;

public class WordIndexer {

	public static void main(String[] args) {

		if (args.length != 2 || (!args[0].equals("-avl") && !args[0].equals("-binary"))) {
			System.out.println("Usage:\njava WordIndexer -avl <input_file>: build a work indexer using an avl tree.\n"
					+ "java WordIndexer -binary <input_file>: build a work indexer using a binary tree.\n");
			System.exit(0);
		}
		String filePath = args[1];
		long startTime = 0;
		double buildTime = 0;
		Tree tree;
		if (args[0].equals("-avl")) {
			tree = new AvlTree();
		} else {
			tree = new BinaryTree();
		}
		// Create the tree
		try {
			Scanner scanner = new Scanner(new FileInputStream(filePath));
			int index = 1;
			System.out.println("\nBuilding the tree...");
			startTime = System.currentTimeMillis();
			while (scanner.hasNext()) {
				String word = scanner.next();
				tree.insert(word.replaceAll("[^a-zA-Z0-9_-]", ""), index); // Remove all non alphanumeric characters
				index += word.length() + 1;
			}
			buildTime = (System.currentTimeMillis() - startTime) / 1000.0;
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nThe file " + filePath + " was not found!\nThe program will terminate.\n");
			System.exit(0);
		}
		System.out.printf("Total building time: %.2f seconds.\n", buildTime);
		// Search in the tree for words given from the user
		System.out.print("\nSearch for words in the text by typing a word and pressing the ENTER button (type exit() for terminating the program)\n\n>");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		while (!word.equals("exit()")) {
			tree.find(word);
			System.out.print("\n> ");
			word = scanner.nextLine();
		}
		scanner.close();
		System.out.println("\nThank you for using my program, Bye!\n");
	}
}
