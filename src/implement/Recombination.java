package implement;

import java.util.Random;

public class Recombination implements Constants {
	//This class is used to recombine parents into children.
	//Main function uses getFirstChild () and getSecondChild () to get children.
	
	protected String father;
	protected String mother;
	protected String firstChild;
	protected String secondChild;
	public void setParentsAndCombine (String father, String mother) {
		if (generator.nextDouble() < 0.7){
			StringBuffer f = new StringBuffer(father);
			StringBuffer m = new StringBuffer(mother);
			this.father = father;
			this.mother = mother;
			int cutIndex = generator.nextInt(MAX_LENGTH);
			String fHead = f.substring(0, cutIndex);
			String mHead = m.substring(0, cutIndex);
			String fTail = f.substring(cutIndex, MAX_LENGTH);
			String mTail = m.substring(cutIndex, MAX_LENGTH);
			firstChild = fHead.concat(mTail);
			secondChild = mHead.concat(fTail);
		}
		else {
			this.father = father;
			this.mother = mother;
			firstChild = father;
			secondChild = mother;
		}
	}
	public String getFirstChild () {
		return firstChild;
	}
	public String getSecondChild () {
		return secondChild;
	}
}
