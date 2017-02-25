/**
 * @author Sander VanWilligen
 * @author Zackery Lovisa
 */


public class Main {
	
	public static void main(String[] args) {
		
		NearestPoints test = new NearestPoints("points.txt");
		
		long startTime = System.currentTimeMillis();
		test.buildDataStructure();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		
		startTime = System.currentTimeMillis();
		test.allNearestPointsNaive();
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		startTime = System.currentTimeMillis();
		test.allNearestPointsHash();
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		/*
		RecSys test2 = new RecSys("mrMatrix1.txt");
		
		long startTime = System.currentTimeMillis();
		System.out.println(test2.ratingOf(2, 1));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		*/
	}

}
