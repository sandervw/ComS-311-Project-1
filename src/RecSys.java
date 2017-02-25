import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecSys {
	
	private HashTable h;
	
	/**
	 * The string mrMatrix is contains the absolute path name of the file that
	 * contains the mapped ratings matrix.
	 * 5
	 */
	public RecSys(String mrMatrix){
		
		int tempSize = 0;
		int u;
		int m;
		//add the lines to an array
		Scanner s = null;
		try {
			s = new Scanner(new File(mrMatrix));
			String[] line = s.nextLine().split(" ", 2);
			
			u = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			float[] users = new float[u];
			int[] movieRatings = new int[m];
			for(int i = 0; i < u; i++){
				line = s.nextLine().split(" ", m+1);
				users[i] = Float.parseFloat(line[0]);
				for(int j = 1; j < line.length; j++){
					movieRatings[j-1] = Integer.parseInt(line[j]);
				}
			}
			s.close();
			//initialize p
			h= new HashTable(tempSize);
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
		ArrayList<Tuple> ratings = h.search(u);
		NearestPoint np = 
		
		return -1;
	}
}
