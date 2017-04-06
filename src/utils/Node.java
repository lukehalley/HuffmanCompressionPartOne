package utils;

public class Node implements Comparable<Object> {

	private Character letter;
	Integer weight;
	Node left;
	Node right;

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public Node(Character c, Integer weight) {
		this.setLetter(c);
		this.weight = weight;
	}


	@Override
	public int compareTo(Object node2) {
		return weight - ((Node) node2).weight;
	}

	public String toString() {
		return getLetter().toString();
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}

}
