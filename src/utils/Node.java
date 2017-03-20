package utils;

public class Node {

	Character c;
	Integer weight;
	Node root;
	Node left;
	Node right;

	public Node(Character c, Integer weight) {
		this.c = c;
		this.weight = weight;
	}
	
	public void addNode(Character c, Integer weight) {
		
		// Creates a new node
		Node newNode = new Node(c, weight); 

		// If there is no root make one
		if (root == null) { 

			root = newNode;

		} else {
			
			// Set the root
			Node currentNode = root;
			
			// Future parent node
			Node parent;

			while (true) {

				// The root is the top parent, start there
				parent = currentNode;

				// Check if the node created should go on the left
				if (weight < currentNode.c) {

					// Focus on the left child
					currentNode = currentNode.left;

					// Check if the the left node has no children
					if (currentNode == null) {

						// Put a node on the left
						parent.left = newNode;
						return;

					}

				} else { // If the left node does not run go here

					currentNode = currentNode.right;

					// If right child has no children
					if (currentNode == null) {

						// Put a new node to the right of it
						parent.right = newNode;
						return;

					}

				}

			}
		}
	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.left);
			postOrderTraverseTree(focusNode.right);

			System.out.println(focusNode);

		}

	}
	
}
