package controllers;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import utils.Counter;
import utils.Node;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) throws Exception {
		HashMap<Character, String> codeMap = new HashMap<Character, String>();

		Counter c = new Counter();

		Counter.ImportString();
		c.stringAnalyse();

		Node root = c.createNode();
		generateCodes(root, codeMap);
		String s = binaryConvert(Counter.s, codeMap);

	}
	

	public static void generateCodes(Node root, HashMap<Character, String> codeMap) {

		generateCodesRec("", root, codeMap);
		System.out.println("code Map: "+codeMap);
		

	}

	public static void generateCodesRec(String prefix, Node root, HashMap<Character, String> codeMap) {

		if (root.getLeft() != null) {
			generateCodesRec(prefix + "0", root.getLeft(), codeMap);
		}

		if (root.getRight() != null) {
			generateCodesRec(prefix + "1", root.getRight(), codeMap);
		}

		if (root.getLeft() == null && root.getRight() == null) {
			codeMap.put(root.getLetter(), prefix);
		}

	}
	
	public static String binaryConvert(String str, HashMap<Character, String> codeMap) throws IOException {
		String binaryString = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			String value = codeMap.get(c);
			binaryString += value;
		}

		binaryExport(binaryString, codeMap);
		return binaryString;
	}

	public static void binaryExport(String binaryString, HashMap<Character, String> codeMap) throws IOException {

		try {
			FileOutputStream fos = new FileOutputStream(new File("compressed.dat"));
			ByteArrayOutputStream binaryOutput = new ByteArrayOutputStream();

			byte[] codes = { (byte) 0x0C, (byte) 0xAD, (byte) 0xD0, (byte) 0x99 };
			binaryOutput.write(codes);

			for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
				Character key = entry.getKey();
				String value = entry.getValue();

				//Write Key
				byte[] byteKey = new byte[1];
				byteKey[0] = (byte) key.charValue();
				binaryOutput.write(byteKey);
				
				// Write Value
				for (int i = 0; i < value.length(); i += 8) {
					System.out.println("Value: "+value+"   index: "+i);
					String s = value.substring(i, i + 7);	
					
					byte b = Byte.parseByte(s, 2);
					byteKey[0] = b;
//					BitSet bitSet = BitSet.valueOf(b);
//					bitSet.clear(41, 56); //This will clear 41st to 56th Bit
//					b = bitSet.toByteArray();
					binaryOutput.write(b);
					//Pad
				}

			}

			binaryOutput.writeTo(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");

	}

}
