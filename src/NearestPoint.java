import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NearestPoint {
	
	private int p;
	private ArrayList<Float> list;
	private HashTable table;

	// The variable dataFile holds the absolute path of the file that contains the set of points S.
	public NearestPoint(String dataFile) {
		
		int tempSize = 0;
		
		//add the lines to an array
		Scanner s = null;
		try {
			s = new Scanner(new File(dataFile));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		list = new ArrayList<Float>();
		while (s.hasNextLine()){
			float temp = Float.parseFloat(s.nextLine());
		    list.add(temp);
		    tempSize++;
		}
		s.close();
		
		System.out.println(tempSize);
		//initialize p
		this.p = tempSize;
	}

	//The array list pointSet contains the set of points S.
	public NearestPoint(ArrayList<Float> pointSet) {
		int tempSize = 0;
		list = new ArrayList<Float>();
		for(int i = 0; i < pointSet.size(); i++){
		    list.add(pointSet.get(i));
		    tempSize++;
		}
		//initialize p
		this.p = tempSize;
	}

	/*
	Returns an array list of points (from the set S) that are close
	to p. This method must implement the naive approach. Note that the type of this method must
	be ArrayList<float>
	*/
	public ArrayList<Float> naiveNearestPoints(float p) {
		ArrayList<Float> results = new ArrayList<Float>();
		for(int i = 0; i < list.size(); i++){
			if(Math.abs(p-list.get(i))<=1) results.add(list.get(i));
		}
		return results;
	}

	/*
	Builds the data structure that enables to quickly answer nearest point
	queries. Your data structure must use the notion of neighbor preserving hashing and along with
	the class HashTable. Otherwise, you will receive zero credit.*/
	public void buildDataStructure() {
		//Initialize the hashTable, and add the elements
		table = new HashTable(p);
		for(int i = 0; i < list.size(); i++){
			int key = (int)Math.floor(list.get(i));
			Tuple t = new Tuple(key, list.get(i));
			table.add(t);
			System.out.println("Added tuple number " + i);
		}	
	}

	/*
	Returns an array list of points (from the S) that are close to
	p. This method must use the data structure that was built. The expected run time of this method
	must be O(N(p)); otherwise you will receive zero credit.*/
	public ArrayList<Float> npHashNearestPoints(float p) {
		int key = (int)Math.floor(p);
		ArrayList<Tuple> tempResults1 = table.search(key-1);
		ArrayList<Tuple> tempResults2 = table.search(key);
		ArrayList<Tuple> tempResults3 = table.search(key+1);
		ArrayList<Float> results = new ArrayList<Float>();
		for(int i = 0; i < tempResults1.size(); i++){
			if (Math.abs(tempResults1.get(i).getValue() - p) <=1) results.add(tempResults1.get(i).getValue());
		}
		for(int i = 0; i < tempResults2.size(); i++){
			if (Math.abs(tempResults2.get(i).getValue() - p) <=1) results.add(tempResults2.get(i).getValue());
		}
		for(int i = 0; i < tempResults3.size(); i++){
			if (Math.abs(tempResults3.get(i).getValue() - p) <=1) results.add(tempResults3.get(i).getValue());
		}
		return results;
	}

	/*For every point p in S, compute the list of all points from S that
	are close to p by calling the method NaiveNearestPoints(p). Write the results to a file named
	NaiveSolution.txt*/
	public void allNearestPointsNaive(){
		for(int i = 0; i < list.size(); i++){
			ArrayList<Float> tempResults = naiveNearestPoints(list.get(i));
			//System.out.println("Points near " + list.get(i) + " are: ");
			//for(int j = 0; j<tempResults.size(); j++){
				//System.out.println(tempResults.get(j) + ", ");
			//}
			//System.out.println("\n");
		}
	}

	/*
	For every point p in S, compute the list of all points from S that
	are close to p by calling the method NPHashNearestPoints(p). Write the results to a file named
	HashSolution.txt. The expected time of this method must be O(n+PS N(p)); otherwise you
	will receive zero credit.*/
	public void allNearestPointsHash(){
		for(int i = 0; i < list.size(); i++){
			ArrayList<Float> tempResults = npHashNearestPoints(list.get(i));
			//System.out.println("Points near " + list.get(i) + " are: ");
			//for(int j = 0; j<tempResults.size(); j++){
				//System.out.println(tempResults.get(j) + ", ");
			//}
			//System.out.println("\n");
		}
	}

}
