package implement;

import java.util.ArrayList;
import java.util.List;

public class Value implements Constants {
	//This class contains attributes related to fitness, such as fitness value and  proportion.
	//Main function uses setPopulation to set next population. And the class calculate related values.
	//What's more, main function invoke getBest, getWorst and getMean to get statistics.
	
	protected List<String> list;
	protected List<Integer> valueList;
	protected int best;
	protected int worst;
	protected double mean;
	protected int sum;
	protected List<Double> fitnessProportionate;
	
	public Value() {
		list = new ArrayList<String>();
		valueList = new ArrayList<Integer>();
		fitnessProportionate = new ArrayList<Double>();
	}
	
	public void setPopulation (List<String> list) {
		best = 0;
		worst = Integer.MAX_VALUE;
		mean = 0;
		sum = 0;
		
		this.list.clear();
		this.list = list;
		
		valueList.clear();
		for (int i = 0 ; i < POPULATION_NUM ; i ++) {
			int value = getValue(list.get(i));
			valueList.add(value);
			best = Math.max(best, value);
			worst = Math.min(worst, value);
			sum += value;
		}
		mean = (double)sum / (double)POPULATION_NUM;
		
		fitnessProportionate.clear();
		for (int i = 0 ; i < POPULATION_NUM ; i ++) {
			fitnessProportionate.add(i,  ((double)valueList.get(i) / (double)sum));
		}
	}
	public int getValue (String individual) {
		int count = 0;
		for (int i = 0 ; i < individual.length() ; i ++) {
			count += (int)(individual.charAt(i) - '0');
		}
		return count;
	}
	
	public List<Double> getFitnessProportionate () {
		return fitnessProportionate;
	}
	
	public int getBest () {
		return best;
	}
	
	public int getWorst () {
		return worst;
	}
	
	public double getMean () {
		return mean;
	}
}
