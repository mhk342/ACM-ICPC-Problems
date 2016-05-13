import java.util.*;
import java.io.*;
import java.math.*;





public class Main {
	
	private static double c(int n, int k) {
		if(k == 0) return 1;
		return fact(n)/(fact(k)*fact(n-k));
	}
	private static double fact(int n) {
//		if(n <= 0) return 1;
		double sum = 1;
		for(int i = 1; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0) {
        	int n = scan.nextInt();
        	double p = scan.nextDouble();
        	double q = 1 - p;
        	double sum = 0;
        	for(int i = 0; i <  n; i++ ) {
//        		System.out.println(c(n-1+i, i));
        		sum += c(n-1+i, i) * Math.pow(q, i) * Math.pow(p, n);
//        		System.out.println(sum);
//        		sum /= fact(n);
        	}
        	System.out.printf("%.2f\n", sum);
        	
        }
	}

}
 