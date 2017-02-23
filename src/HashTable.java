import java.util.ArrayList;

public class HashTable {
	
	private int p;
	
	/*
	 *  Finds the smallest prime integer p whose value is at least size. Creates
	 *	a hash table of size p where each cell initially is NULL. It will determine the hash function to be
	 *	used in the hash table by creating the object new HashFunction(p).
	 */
	public HashTable(int size){
		this.p = HelperClass.getPrime(size);
	}
	
	//Returns the maximum load of the hash table
	public int maxLoad(){
		return -1;
	}
	//Returns the average load of the hash table
	public int averageLoad(){
		return -1;
	}
	//returns the current size of the hash table
	public int size() {
		return size;
	}
	//returns the number of Tuples that are currently stored in the hash table.
	public int numElements() {
		return -1;
	}
	
	// return the load factor which is numElements()/size()
	public double loadFactor(){
		return (numElements()/size());
	}
	
	/*
	 * Adds the tuple t to the hash table; places t in the list pointed by the cell h(t.getKey())
	 * where h is the hash function that is being used. When the load factors becomes bigger than 0.7,
	 * then it (approximately) doubles the size of the hash table and rehashes all the elements (tuples) to
	 * the new hash table. The size of the new hash table must be: Smallest prime integer whose value is
	 * at least twice the current size.
	 */
	public void add(Tuple t) {
		
	}
	
	/*
	 * returns an array list of Tuples (in the hash table) whose key equals k. If no such
	 * Tuples exist, returns an empty list. Note that the type of this method must be ArrayList<Tuple>
	 * 
	 * 
	 */
	public ArrayList<Tuple> search(int k) {
		ArrayList<Tuple> result = new ArrayList<Tuple>();
		return result;
	}
	
	//Removes the Tuple t from the hash table.
	public void remove(Tuple t){
		
	}
	
}
