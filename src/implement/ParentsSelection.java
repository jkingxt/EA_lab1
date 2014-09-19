package implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParentsSelection implements Constants {
	//This class is used to select parents.
	//After the function is invoked, it generates the whole mating pool.
	//And it is implemented with roulette wheel algorithm.
	
	public List<String> selectParents (List<String> list, List<Double> selP) {
		List<String> newList = new ArrayList<String>();
		
		double[] a = new double[POPULATION_NUM];
		a[0] = selP.get(0);
		for (int i = 1; i < POPULATION_NUM ; i ++) {
			a[i] = a[i-1] + selP.get(i);
		}
		
		for (int count = 0 ; count < POPULATION_NUM ; count ++) {
			double r = generator.nextDouble();
			int index = 0;
			while (a[index] < r) {
				index ++;
			}
			newList.add(list.get(index));
		}
		
		return newList;
	}
}
