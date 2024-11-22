// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,3));   // 2 + 3
	    //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(3,4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(12,3));   // 12 / 3    
   		//System.out.println(div(10,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int x3 = 0;
		if (x1 >= 0) {
			x3 = x2;
			for(int i = 0; i < x1; i++) {
				x3++;
			}
			return x3;	
		}
		else if ((x1 < 0) && (x2 >= 0)) {
			x3 = x1;
			for(int i = 0; i < x2; i++) {
				x3++;
			}
			return x3;	
		}
		else if ((x1 < 0) && (x2 <= 0)) {
			x3 = x1;
			for(int i = 0; i < Math.abs(x2); i++) {
				x3--;
			}	
		}
		return x3;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int x3 = 0;
		if (x2 > 0) {
			x3 = x1;
			for(int i = 0; i < x2; i++) {
				x3--;
			}	
		}
		else if ((x1 > 0) && (x2 < 0)) {		
			x3 = x1;
			for(int i = 0; i < Math.abs(x2); i++) {
				x3++;
			}
		}
		else if ((x2 < 0) && (x1 < 0)) {
			x3 = x1;
			for(int i = 0; i < Math.abs(x2); i++) {
				x3++;
			}	
		}
		return x3;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int x3 = 0;
		for(int i = 0; i < Math.abs(x1); i++) {
			for(int j = 0; j < Math.abs(x2); j++) {
				x3++;
			}
		}
		String minus = "-";
		if (((x1<0) && (x2 > 0))||((x1 > 0)&&(x2 < 0))) {
			minus += x3;
			x3 = Integer.parseInt(minus);
		}
		return x3;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int x3 = Math.abs(x);
		if (n == 0) {
			return 1;
		}
		for(int i = 1; i < n; i++) {
				x3 = times(x3,Math.abs(x));
		}
		String minus = "-";
		if ((x < 0) && (mod(n, 2) != 0)) {
			minus += x3;
			x3 = Integer.parseInt(minus);
		}
		return x3;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int x3 = 0;
		int count = 0;
		while(x3 < Math.abs(x1)) {
			if ((plus(x3,Math.abs(x2))) > Math.abs(x1)) {
				break;
			}
			x3 = plus(x3,Math.abs(x2));
			count++;
		}
		String minus = "-";
		if (((x1 < 0) && (x2 > 0))||((x1 > 0) && (x2 < 0))) {
			minus += count;
			count = Integer.parseInt(minus);
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int x3 = 0;
		int remainder = 0;
		while(x3 < x1) {
			if ((plus(x3,x2)) > x1) {
				break;
			}
			x3 = plus(x3,x2);
		}
		remainder = minus(x1, x3);
		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		double epsilon = 0.01;
		int squareRoot = div(x, 2);
		while (Math.abs(minus(pow(squareRoot,2),x)) > epsilon) {
			squareRoot = minus(squareRoot,div(minus(pow(squareRoot,2),x),times(2, squareRoot)));
		}
		return squareRoot;
	}	  	  
}