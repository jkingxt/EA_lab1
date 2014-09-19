package implement;

import java.util.Random;

public class Mutation implements Constants {
	//This class is used to mutate a parent. What it returns is a binary string after mutation. 
	
	public String mutateParent (String parent) {
		StringBuffer sb = new StringBuffer(parent);
		for (int i = 0 ; i < MAX_LENGTH ; i ++) {
			double pro = generator.nextDouble();
			if (pro < MUTATION_P) {
				sb.setCharAt(i, (parent.charAt(i) == '1') ? '0' : '1');
			}
		}
		return sb.toString();
	}
}
