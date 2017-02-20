import java.util.Random;

/* This class represents a random hash function that can be used in a hash table */
public class HashFunction {
	
	private int a, b, p;
	
	/* Constructor */
	public HashFunction(int range){
		
		this.p = getPrime(range);
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
		
		p = getPrime(x);
		
	}
	
	/* Get the first prime number who's value is >= range */
	private int getPrime(int range){
		
		//first prime number
		int x = 2;
		
		while(x<Integer.MAX_VALUE){
			if(x>=range){
				int count = 0;
		        //increase count each time x is divisible by a whole number <= x
		        for(int j = 1; j <= x; j++){
		        	if(x%j == 0) count++;
		        }
		        //if x is prime return
		        if(count == 2) return x;

			}
	        x++;
	    }
		return -1;
	}

}
