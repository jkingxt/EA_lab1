package implement;

import java.util.ArrayList;
import java.util.List;

public class Initialisation implements Constants {
	//This class is used to initialize population.
	//When the function is invoked, it returns 100 binary strings which combine the population.
	
	public List<String> initPopulation (BinaryString rnd) {
		List<String> list = new ArrayList<String>();
		for (int i = 0 ; i < POPULATION_NUM ; i ++) {
			list.add(rnd.nextBinaryString());
		}
		return list;
	}
}
