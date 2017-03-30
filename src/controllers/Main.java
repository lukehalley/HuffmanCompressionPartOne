package controllers;

import utils.Counter;
import utils.Node;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) throws Exception {

		Counter c = new Counter();

		Counter.ImportString();
		c.stringAnalyse();

		Node root = c.createNode();
		Node.generateCodes(root);
		String s = Node.binaryConvert(Counter.s);

	}

}
