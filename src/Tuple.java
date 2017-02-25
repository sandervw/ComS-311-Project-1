
/* 
 * This class represents tuples in the form of a key value pair 
 */
public class Tuple {
	
	private int key;
	private float value;
	private Tuple next;
	
	/**
	 *  Constructor 
	 *  @param keyP
	 *  @param valueP
	 */
	public Tuple(int keyP, float valueP){
		
		this.key = keyP;
		this.value = valueP;
		this.next = null;
		
	}
	
	public int getKey(){
		
		return key;
		
	}
	
	public float getValue(){
		
		return value;
		
	}
	
	public boolean equals(Tuple t){
		
		if(t.getKey() == this.key && t.getValue() == this.value) return true;
		else return false;
		
	}
	
	
	/**
	 * Get the tuple pointed to by this one
	 * @return The tuple that this tuple is pointing to.
	 */
	public Tuple getNext(){
		
		return next;
		
	}
	
	/**
	 * Set the tuple that this tuple points to
	 * @param t The tuple that this tuple will point to.
	 */
	public void setNext(Tuple t){
		
		this.next = t;
		
	}

}
