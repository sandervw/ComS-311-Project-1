
public class Main {
	
	public static void main(String[] args) {
		
		NearestPoint test = new NearestPoint("points.txt");
		
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
		
		//test.allNearestPointsNaive();

	}

}
