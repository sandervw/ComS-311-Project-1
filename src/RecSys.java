import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class RecSys {
	
	private NearestPoints hashSolver;
	private java.util.Hashtable<Float, int[]> movieHash = new Hashtable<Float, int[]>();
	ArrayList<Float> users;
	
	/**
	 * The string mrMatrix is contains the absolute path name of the file that
	 * contains the mapped ratings matrix.
	 * 5
	 */
	public RecSys(String mrMatrix){
		
		int u;
		int m;
		//add the lines to an array
		Scanner s = null;
		try {
			s = new Scanner(new File(mrMatrix));
			String[] line = s.nextLine().split(" ", 2);
			
			u = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			users = new ArrayList<Float>();
			int[] movieRatings = new int[m];
			for(int i = 0; i < u; i++){
				line = s.nextLine().split(" ", m+1);
				users.add(Float.parseFloat(line[0]));
				for(int j = 1; j < line.length; j++){
					movieRatings[j-1] = Integer.parseInt(line[j]);
				}
				movieHash.put(Float.parseFloat(line[0]), movieRatings.clone());
			}
			hashSolver = new NearestPoints(users);
			hashSolver.buildDataStructure();
			s.close();		
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * If the user u has rated movie m, then it returns that rating; otherwise
	 * it will predict the rating based on the approach described above, and returns the predicted rating.
	 * The type of this method must be float.
	 * @param u User 
	 * @param m Movie (key) 
	 * 
	 * @return The predicted rating of the movie for this user.
	 */
	public float ratingOf(int u, int m){
		float location = users.get(u-1);
		int[] ratings = movieHash.get(location);
		if(ratings[m-1] > 0) return (float)ratings[m-1];
		ArrayList<Float> nearPoints = hashSolver.npHashNearestPoints(location);
		float sum = 0;
		float count = 0;
		for(int i=0; i < nearPoints.size(); i++){
			if(movieHash.get(nearPoints.get(i))[m-1]!=0){
				sum+= movieHash.get(nearPoints.get(i))[m-1];
				count++;
			}
		}
		return (float)sum/(float)count;
	}
}
