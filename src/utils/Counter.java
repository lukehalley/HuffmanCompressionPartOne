package utils;

import java.util.HashMap;

public class Counter {

	String test = "sadhsdkjfsdufhsdkjfhs";
	HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
	
	public void stringAnalyse() {

		for (int i = 0; i < test.length(); i++) {
			char c = test.charAt(i);
			Integer val = characterMap.get(new Character(c));
			if (val != null) {
				characterMap.put(c, new Integer(val + 1));
			} else {
				characterMap.put(c, 1);
			}
		}

	}

}
