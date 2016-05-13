import java.util.*;
import java.io.*;
import java.math.*;





public class Main {
	static boolean[] map;
	
	
	private static void sieve() {
		map = new boolean[(int)Math.pow(2,  20) + 1];
		Arrays.fill(map, false);
		for(int i = 2; i <= Math.sqrt(map.length); i++) {
			if(!map[i]) {
				for(int j = i * i; j < map.length; j+= i) {
					map[j] = true;
				}
			}
		}
		for(int i = 4; i < map.length; i++) {
			if(map[i]) {
				for(int j = i * 2; j < map.length; j+=i) {
					map[j] = false;
				}
			}
		}
	}
	
	
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
	
	private static int countBits(int n) {
		if(n == 0) return 0;
		if((n & 1) == 1) return 1 + countBits(n >> 1);
		else return countBits(n >> 1);
	}
	
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = 1;
        while(scan.hasNext()) {
        	int n = scan.nextInt();
        	int r = scan.nextInt();
        	double total = 0;
        	double[] arr = new double[n];
        	double[] sum = new double[n];
        	Arrays.fill(sum, 0);
        	for(int i = 0; i < n; i++) {
        		arr[i] = scan.nextDouble();
//        		total += arr[i];
        	} 	
        	
        	for(int i = 0; i < Math.pow(2, n); i++) {
        		if(countBits(i) == r) {
        			double d = 1;
        			for(int j = 0; j < n; j++) {
        				if(((1 << j) & i) > 0){
        					d *= arr[j];
        					
        				}
        				else {
        					d *= 1-arr[j];
        				}
        			}
        			for(int j = 0; j < n; j++) {
        				if(((1 << j) & i) > 0){
        					sum[j] += d;
        				}
        				
        			}
        			total += d;
        		}
        	}
        	
        	System.out.println("Case " + cases + ":");
        	for(double d: sum) {
        		System.out.printf("%.6f\n", d/total);
        	}        	
        	cases++;
        	
        }
	}

}
 