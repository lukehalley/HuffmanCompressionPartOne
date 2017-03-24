package controllers;

import utils.Counter;
import utils.Node;

//import utils.Counter;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		Counter c = new Counter();
		Counter.ImportString();
		c.stringAnalyse();
		Node root = c.createNode();
		
		Node.generateCodes(root);
		
		
	}

}
