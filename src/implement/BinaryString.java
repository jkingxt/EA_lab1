package implement;

import java.util.Random;


public class BinaryString implements Constants {
	
	//This class is used to generator a binary string with length of 25
	public String nextBinaryString () {
		int next = generator.nextInt(MAX_BINARY);
		StringBuffer sb = new StringBuffer(Integer.toBinaryString(next));
		int length = sb.length();
		for (int i = 0 ; i < 25 - length ; i ++) {
			sb.insert(0, '0');
		}
		return sb.toString();
	}
}
