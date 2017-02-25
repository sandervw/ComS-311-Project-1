import java.util.Random;

/* 
 * This class represents a random hash function that can be used in a hash table 
 */
public class HashFunction {
	
	private int a, b, p;
	
	/**
	 * Constructor for the hash function.
	 * @param range The range of the hash function.
	 */
	public HashFunction(int range){
		
		this.p = HelperClass.getPrime(range);
		if (p<0) p = p*-1;
		Random rn = new Random();
		this.b = rn.nextInt(p);
		this.a = rn.nextInt(p);
		
	}
	
	/**
	 * Returns the hashed value of x.
	 * @param x The value to be hashed.
	 * @return The hashed value.
	 */
	public int hash(int x){
		int val = (a*x + b)%p;
		if (val < 0) {

		    val += p;

		}
		return val;
	}

	public int getA(){
		
		return a;
		
	}
	
	public int getB(){
		
		return b;
		
	}
	
	public int getP(){
		
		return p;
		
	}

	public void setA(int x){
		
		a = x%p;
		
	}
	
	public void setB(int y){
		
		b = y%p;
		
	}

	public void setP(int x){
		
		p = HelperClass.getPrime(x);
		Random rn = new Random();
		this.b = rn.nextInt(p);
		this.a = rn.nextInt(p);
		
	}

}
