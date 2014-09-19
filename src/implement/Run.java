package implement;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Run implements Constants {

	public static void main(String[] args) throws IOException {
		//This is the main function that runs genetic algorithm.
		
		// TODO Auto-generated method stub
		BinaryString binaryString = new BinaryString();
		Initialisation initialisation = new Initialisation();
		List<String> population = new ArrayList<String>();
		Value value = new Value();
		
		List<Double> fitnessP =  new ArrayList<Double>();
		ParentsSelection parentsSelector = new ParentsSelection();
		List<String> matingPool = new ArrayList<String>();
		List<String> populationAfterRecombine = new ArrayList<String>();
		List<String> populationAfterMutate = new ArrayList<String>();
		
		Recombination recombinator = new Recombination();
		Mutation mutator = new Mutation();
		
		int best = 0;
		
		//Open an outstream and write statistics into a txt file.
		FileOutputStream fos=new FileOutputStream("c:\\Xiatao\\abc.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		BufferedWriter bw=new BufferedWriter(osw);
		
		//The fucntion needs to run 10 times.
		for (int run = 0 ; run < 10 ; run ++) {
			population.clear();
			population = initialisation.initPopulation(binaryString);
			best = 0;
			for (int i = 0 ; i < MAX_GENERATION && best != MAX_LENGTH ; i ++) {
				//set population
				value.setPopulation(population);
	
				//SELECT parents
				fitnessP = value.getFitnessProportionate();
				matingPool = parentsSelector.selectParents(population, fitnessP);
				
				//RECOMBINE pairs of parents
				populationAfterRecombine.clear();
				for (int j = 0 ; j < POPULATION_NUM ; j = j +2) {
					recombinator.setParentsAndCombine(matingPool.get(j), matingPool.get(j+1));
					populationAfterRecombine.add(recombinator.getFirstChild());
					populationAfterRecombine.add(recombinator.getSecondChild());
				}
				
				//MUTATE the resulting offspring
				populationAfterMutate.clear();
				for (int j = 0 ; j < POPULATION_NUM ; j ++) {
					populationAfterMutate.add(mutator.mutateParent(populationAfterRecombine.get(j)));
				}
				
				//GENERATE next population
				population = new ArrayList<String>(populationAfterMutate);
				
				//print out best, worst, mean
				System.out.println(run + "\t" + i + '\t' + value.getBest() + '\t' + 
						value.getWorst() +'\t' + value.getMean());
				bw.write(run + "\t" + i + '\t' + value.getBest() + '\t' + 
						value.getWorst() +'\t' + value.getMean());
				bw.newLine();
				best = value.getBest();
			}
		}
		bw.close();
	}

}
