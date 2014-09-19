package implement;

import java.util.Random;

public interface Constants {
	//This interface is implemented by all of other classes, 
	//which means that they can share these constants.

	public static final int MAX_BINARY = 0x1FFFFFF;
	public static final int POPULATION_NUM = 100;
	public static final double MUTATION_P = 0.04;
	public static final int MAX_LENGTH = 25;
	public static final double COMBINATION_P = 0.7;
	public static final int SEED_NUMBER = 1234;
	public static final int MAX_GENERATION = 100;
	public Random generator = new Random(1234);
}
