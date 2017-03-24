package utils;

import java.util.HashMap;

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
		
		for (Character name: codeMap.keySet()){

            String key = name.toString();
            String value = codeMap.get(name).toString();  
            System.out.println(key + " " + value);  


} 

	}

	@Override
	public int compareTo(Object node2) {
		return weight - ((Node) node2).weight;
	}
	
	public String toString() {
		return letter.toString();
	}
	
}
