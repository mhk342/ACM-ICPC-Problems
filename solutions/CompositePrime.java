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
	
	
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
//        int cases = scan.nextInt();
        sieve();
        while(scan.hasNext()) {
        	int n = scan.nextInt();
        	int count = 0;
        	for(int i = 0; i < n; i++) {
        		if(map[scan.nextInt()]) count++;
        	}
        	System.out.println(count);
        }
	}

}
 