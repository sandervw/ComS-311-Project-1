/**
 * @author Sander VanWilligen
 * @author Zackery Lovisa
 */

import java.util.ArrayList;

public class HashTable {

	private int p;

	private Tuple[] contents;
	private HashFunction h;
	private int numElements;

	/**
	 * Finds the smallest prime integer p whose value is at least size. Creates
	 * a hash table of size p where each cell initially is NULL. It will determine the hash function to be
	 * used in the hash table by creating the object new HashFunction(p).
	 * @param size Initial size of the hash table.
	 */
	public HashTable(int size) {
		this.p = HelperClass.getPrime(size);
		contents = new Tuple[p];
		h = new HashFunction(p);
		numElements = 0;
	}

	/**
	 * Returns the maximum load of the hash table
	 * @return the max load of the hash table, ie the largest list in the table.
	 */
	public int maxLoad() {
		int result = 0;
		//for each index in the table
		for (int i = 0; i < contents.length; i++) {
			Tuple temp = contents[i];
			int counter = 0;
			//iterate through the elements in the linked list, increasing counter by 1 for each element
			while (temp != null) {
				counter++;
				temp = temp.getNext();
			}
			//if counter is greater than result, set result to counter
			if (counter >= result)
				result = counter;
		}
		return result;
	}

	/**
	 * Returns the average load of the hash table
	 * Average load is not the same as load factor
	 * Average load is sum of contents[i]/number of i, where i is not null
	 * @return The average load of the hash table.
	 */
	public float averageLoad() {
		int nonNullLists = 0;
		//for each index in the table
		for (int i = 0; i < contents.length; i++) {
			Tuple temp = contents[i];
			//if the linked list at that index is not empty, add it to the number of non-null lists
			if (temp != null)
				nonNullLists += 1;
		}
		//return the total number of elements divided by the number of non-null lists
		return (float)this.numElements() / (float)nonNullLists;
	}

	/**
	 * returns the current size of the hash table
	 * @return The size of the hash table.
	 */
	public int size() {
		return p;
	}

	/**
	 * returns the number of Tuples that are currently stored in the hash table.
	 * @return The number of Tuples in the hash table.
	 */
	public int numElements() {
		return numElements;
	}

	/**
	 * return the load factor which is numElements()/size()
	 * @return The load factor (numElements()/size()) of the hash table.
	 */
	public float loadFactor() {
		return ((float)numElements() / (float)size());
	}

	/**
	* Adds the tuple t to the hash table; places t in the list pointed by the cell h(t.getKey())
	* where h is the hash function that is being used. When the load factors becomes bigger than 0.7,
	* then it (approximately) doubles the size of the hash table and rehashes all the elements (tuples) to
	* the new hash table. The size of the new hash table must be: Smallest prime integer whose value is
	* at least twice the current size.
	* @param t Tuple to add to the hash table.
	*/
	public void add(Tuple t) {
		//Find out which linked list this is going into by hashing t.
		int hash = h.hash(t.getKey());
		//add the tuple into the hash table
		if (contents[hash] == null)
			contents[hash] = new Tuple(t.getKey(), t.getValue()); //if the linked list has no elements, set the first element to t
		else { //otherwise, iterate through the linked list until the last element is reached
			Tuple temp = contents[hash];
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new Tuple(t.getKey(), t.getValue())); //set t as the next element in the linked list
		}
		numElements++;
		//Then we find the new load factor, and see if its bigger than 0.7.
		if (this.loadFactor() > .7) {
			//re-factor p to be the first prime greater than 2p
			p = HelperClass.getPrime(2 * p);
			//clone the contents of the table into a new table
			Tuple[] newTable = contents.clone();
			h = new HashFunction(p);
			contents = new Tuple[p];
			numElements=0;
			//for each index in newTable
			Tuple temp2;
			for (int i = 0; i < newTable.length; i++) {
				Tuple temp = newTable[i];
				if(temp!= null){
					temp2 = new Tuple(temp.getKey(), temp.getValue());
					this.add(temp2);
					//iterate through the elements in the linked list in newTable, and re-add them to this hashTable
					while (temp.getNext() != null) {
						temp = temp.getNext();
						temp2 = new Tuple(temp.getKey(), temp.getValue());
						this.add(temp2);
					}
				}
			}
		}
	}

	/**
	 * 
	 * returns an array list of Tuples (in the hash table) whose key equals k. If no such
	 * Tuples exist, returns an empty list. Note that the type of this method must be ArrayList<Tuple>
	 * 
	 * @param k the element key of the tuple you are searching for.
	 */
	public ArrayList<Tuple> search(int k) {
		//hash the value of k to get the index of the hashtable
		int hash = h.hash(k);
		ArrayList<Tuple> result = new ArrayList<Tuple>();
		//if contents[hash] is empty, return an empty arraylists
		if (contents[hash] == null)
			return result;
		else {
			Tuple temp = contents[hash];
			//for each element in the linked list, add it to the arraylist
			while (temp != null) {
				if (temp.getKey() == k)
					result.add(temp);
				temp = temp.getNext();
			}
		}
		return result;
	}

	/**
	 * Removes the Tuple t from the hash table.
	 * @param t The tuple to remove from the hash table.
	 */
	public void remove(Tuple t) {
		//hash the key value of t, and use that to find the correct index
		int hash = h.hash(t.getKey());
		Tuple temp = contents[hash];
		//only try removing if the linked list has something in it
		if (temp != null) {
			//if temp doesn't have a next element
			if (temp.getNext() == null) {
				if (temp.equals(t))
					contents[hash] = null;
			}
			//else, if temp does have a child
			else {
				//if the first element = t, set temp.next as the first element
				if (temp.equals(t)) {
					contents[hash] = temp.getNext();
				}
				//else, have to unlink the child, and re-link its previous and next elements
				else {
					Tuple tempChild = temp.getNext();
					while (tempChild != null) {
						if (tempChild.equals(t)) {
							temp.setNext(tempChild.getNext());
						}
						temp = tempChild;
						tempChild = tempChild.getNext();
					}
				}
			}
		}
		numElements--;
	}

}
