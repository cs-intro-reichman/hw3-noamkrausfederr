// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(10,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int x3 = 0;

		// I calculated the result of the addition of the two numbers according
		// to every possible input
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

		// I returned a result of the reduction, according to every possible 
		// input
		if (x2 > 0) {
			x3 = x1;
			for(int i = 0; i < x2; i++) {
				x3--;
			}	
		} else if ((x1 > 0) && (x2 < 0)) {		
			x3 = x1;
			for(int i = 0; i < Math.abs(x2); i++) {
				x3++;
			}
		} else if ((x2 < 0) && (x1 < 0)) {
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

		// I add 1 to a sum, (x1*x2) times
		for(int i = 0; i < Math.abs(x1); i++) {
			for(int j = 0; j < Math.abs(x2); j++) {
				x3++;
			}
		}

		// If one of the numbers was negative, i disregarded it during the calculations
		// and added a minus sign infront of the result to return a correct answer
		String minus = "-";
		if (((x1<0) && (x2 > 0)) || ((x1 > 0) && (x2 < 0))) {
			minus += x3;
			x3 = Integer.parseInt(minus);
		}
		return x3;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int x3 = Math.abs(x);

		// If the power of the number is zero, the result is always 1
		if (n == 0) {
			return 1;
		}

		// I multiplied the number by itself n times
		for(int i = 1; i < n; i++) {
				x3 = times(x3,Math.abs(x));
		}

		// If one of the numbers was negative, i disregarded it during the calculations
		// and added a minus sign infront of the result to return a correct answer
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
		if (x2 == 0) {
			return -1;
		}
		// I kept adding x2 to itself until the sum was larger than x1, and counted
		// how many times it took to reach x1, and returned that count, which is the
		// integer result of the division 
		while(x3 < Math.abs(x1)) {
			if ((plus(x3,Math.abs(x2))) > Math.abs(x1)) {
				break;
			}
			x3 = plus(x3,Math.abs(x2));
			count++;
		}

		// If one of the numbers was negative, i disregarded it during the calculations
		// and added a minus sign infront of the result to return a correct answer
		String minus = "-";
		if (((x1 < 0) && (x2 > 0)) || ((x1 > 0) && (x2 < 0))) {
			minus += count;
			count = Integer.parseInt(minus);
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int x3 = 0;
		int remainder = 0;
		// I kept adding x2 to a sum, while it was smaller than x1. The result 
		// of the reduction of x1 by the sum is the remainder
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
		int l = 1;
		// I calculated the square root using the bi-section method
		int h = x;
		int result = 0;
		while (l <= h) {
			int mid = plus(l, div(minus(h,l),2));
			if (mid <= div(x,mid)) {
				result = mid;
				l = plus(mid,1);
			} else {
				h = minus(mid,1);
			}
		} 
		return result;
	}
}