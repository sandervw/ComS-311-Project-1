import java.util.ArrayList;

public class NearestPoint {

	// The variable dataFile holds the absolute path of the file that contains the set of points S.
	public NearestPoint(String dataFile) {

	}

	//The array list pointSet contains the set of points S.
	public NearestPoint(ArrayList<Float> pointSet) {

	}

	/*
	Returns an array list of points (from the set S) that are close
	to p. This method must implement the naive approach. Note that the type of this method must
	be ArrayList<float>
	*/
	public ArrayList<Float> naiveNearestPoints(float p) {
		return null;
	}

	/*
	Builds the data structure that enables to quickly answer nearest point
	queries. Your data structure must use the notion of neighbor preserving hashing and along with
	the class HashTable. Otherwise, you will receive zero credit.*/
	public void buildDataStructure() {

	}

	/*
	Returns an array list of points (from the S) that are close to
	p. This method must use the data structure that was built. The expected run time of this method
	must be O(N(p)); otherwise you will receive zero credit.*/
	public ArrayList<Tuple> npHashNearestPoints(float p) {
		return null;
	}

	/*For every point p in S, compute the list of all points from S that
	are close to p by calling the method NaiveNearestPoints(p). Write the results to a file named
	NaiveSolution.txt*/
	public void allNearestPointsNaive(){
		
	}

	/*
	For every point p in S, compute the list of all points from S that
	are close to p by calling the method NPHashNearestPoints(p). Write the results to a file named
	HashSolution.txt. The expected time of this method must be O(n+PS N(p)); otherwise you
	will receive zero credit.*/
	public void allNearestPointsHash(){
		
	}

}
