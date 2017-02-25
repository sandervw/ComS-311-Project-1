/*
 * This class has the helper methods we use in our code
 */
public class HelperClass {
	
	/**
	 *  Get the first prime number who's value is >= range.
	 *  @param range The range of the prime numbers.
	 *  @return The prime number found within the range.
	 */
	public static int getPrime(int range){
		
		//first prime number
		int x = range;
		
		while(x<Integer.MAX_VALUE){
			int count = 0;
		    //increase count each time x is divisible by a whole number <= x
		    for(int j = 1; j <= x; j++){
		      	if(x%j == 0) count++;
		    }
		    //if x is prime return
		    if(count == 2) return x;
	        x++;
	    }
		return -1;
	}

}
