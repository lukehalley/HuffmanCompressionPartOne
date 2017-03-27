package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Node implements Comparable<Object> {

	Character letter;
	Integer weight;
	Node root;
	Node left;
	Node right;
	static HashMap<Character, String> codeMap = new HashMap<Character, String>();

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(Character c, Integer weight) {
		this.letter = c;
		this.weight = weight;
	}

	public static void generateCodes(Node root) {

		generateCodesRec("", root);

	}

	public static void generateCodesRec(String prefix, Node root) {

		if (root.left != null) {
			generateCodesRec(prefix + "0", root.left);
		}

		if (root.right != null) {
			generateCodesRec(prefix + "1", root.right);
		}

		if (root.left == null && root.right == null) {
			codeMap.put(root.letter, prefix);
		}

	}

	public static String binaryConvert(String str) throws IOException {
		String binaryString = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			String value = codeMap.get(c);
			binaryString += value;
		}
		
		binaryExport(binaryString);
		return binaryString;
	}

	public static String binaryExport(String binaryString) throws IOException {

		String header = "";

		for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
			char key = entry.getKey();
			String value = entry.getValue();

			header += key + ": " + value + "\n";
		}

		System.out.println(header);
		System.out.println("Binary: " + binaryString);
		Files.write(Paths.get("binary.dat"), header.getBytes());
		return header;

	}

	@Override
	public int compareTo(Object node2) {
		return weight - ((Node) node2).weight;
	}

	public String toString() {
		return letter.toString();
	}

}
