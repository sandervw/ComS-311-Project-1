
public class RecSys {
	
	private HashTable h;
	
	/**
	 * The string mrMatrix is contains the absolute path name of the file that
	 * contains the mapped ratings matrix.
	 * 5
	 */
	public RecSys(String mrMatrix){
		int p = 0;
		h = new HashTable(p);
	}
	
	/**
	 * If the user u has rated movie m, then it returns that rating; otherwise
	 * it will predict the rating based on the approach described above, and returns the predicted rating.
	 * The type of this method must be float.
	 * @param u
	 * @param m
	 * 
	 * @return
	 */
	public double ratingOf(int u, int m){
		return -1;
	}
}
