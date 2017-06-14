package Karatsuba;

import java.util.Scanner;

public class karatsuba {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a, b;
		a = in.nextLong();
		b = in.nextLong();
		System.out.println(karatsuba(a,b));

	}

	private static long karatsuba(final long n, final long m){
		if(n<10 ||m<10){
			return (n*m);
		}
		int n1, n2;
		long divisor;
		n1 = Long.toString(n).length();
		n2 = Long.toString(m).length();
		divisor = (long) (Math.pow(10,Math.max(n1, n2)/2));
		long a,b,c,d;
		a = (long) (n / divisor);
		b = (long) (n % divisor);
		c = (long) (m / divisor);
		d = (long) (m % divisor);
		
		long ac, y, bd;
		
		ac = karatsuba(a, c);
		y = karatsuba(a + b, c + d);
		bd = karatsuba(b, d);
		
		return (ac*divisor*divisor + (y-ac-bd)*divisor + bd);
		
		
	}
}
