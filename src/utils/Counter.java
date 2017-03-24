package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Counter {

	HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
	Queue<Node> queue = new PriorityQueue<>();
	Counter leftChild;
	Counter rightChild;
	public static String s = "";

	public static void ImportString() {

		// Scanner
		File usersFile = new File("string.dat");
		Scanner stringScanner = null;
		try {
			stringScanner = new Scanner(usersFile);

			while (stringScanner.hasNextLine()) {

				s += stringScanner.nextLine();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} finally {
			stringScanner.close();
		}

	}

	// Counts characters with a Hashmap, and then is added to an
	// Arraylist to be sorted.
	public void stringAnalyse() {

		System.out.println("String from file = " + s);

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			Integer val = characterMap.get(new Character(c));

			if (val != null) {
				characterMap.put(c, new Integer(val + 1));
			} else {
				characterMap.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {

			queue.add(new Node(entry.getKey(), entry.getValue()));
		}
	}

	// Creates Nodes
	public Node createNode() {

		while (queue.size() > 1)

		{
			Node leftNode = queue.poll();
			Node rightNode = queue.poll();
			Node newNode = new Node('-', leftNode.weight + rightNode.weight);
			newNode.setLeft(leftNode);
			newNode.setRight(rightNode);
			queue.add(newNode);
		}

		Node rootNode = queue.peek();
		System.out.println("Root Node Is: " + rootNode);
		return rootNode;

	}

}
