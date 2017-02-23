import java.util.Random;

/* 
 * This class represents a random hash function that can be used in a hash table 
 */
public class HashFunction {
	
	private int a, b, p;
	
	/* Constructor */
	public HashFunction(int range){
		
		this.p = HelperClass.getPrime(range);
		Random rn = new Random();
		this.b = rn.nextInt(p);
		this.a = rn.nextInt(p);
		System.out.println(p + ", " + b + ", " + a);
		
	}
	
	public int hash(int x){
		int val = (a*x + b)%p;
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
		
	}

}
