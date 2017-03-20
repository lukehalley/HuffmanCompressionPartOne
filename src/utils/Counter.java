package utils;

import java.util.HashMap;
import java.util.Map;

public class Counter {

	static String test = "sjhdgfkjfhwefhwehjbfsjkdfhshjdbf";
	static HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
	Counter leftChild;
	Counter rightChild;

	public static void stringAnalyse() {

		for (int i = 0; i < test.length(); i++) {

			char c = test.charAt(i);
			Integer val = characterMap.get(new Character(c));

			if (val != null) {
				characterMap.put(c, new Integer(val + 1));
			} else {
				characterMap.put(c, 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
		    System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	
	
}
