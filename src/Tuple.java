
/* 
 * This class represents tuples in the form of a key value pair 
 */
public class Tuple {
	
	private int key;
	private float value;
	
	/* Constructor */
	public Tuple(int keyP, float valueP){
		
		this.key = keyP;
		this.value = valueP;
		
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

}
