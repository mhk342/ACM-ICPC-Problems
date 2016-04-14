import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int rounds = scan.nextInt();
		while(rounds-- > 0) {
			int n = scan.nextInt(); // capcacity
			int t = scan.nextInt(); // time to to across river
			int m = scan.nextInt(); // # of cars
			int[] a = new int[m];
			for(int i = 0; i < m; i++) {
				a[i] = scan.nextInt();
			}
			int i = m % n;
			int time, trips;
			if(i > 0) {
				time = a[i - 1] + 2 * t;
				trips = 1;
				for(int j = i + n - 1; j < m; j += n) {
					time = Math.max(time, a[j]) + 2 * t;
					trips++;
				}
			}
			else {
				time = 0;
				trips = 0;
				for(int j = i + n - 1; j < m; j += n) {
					time = Math.max(time, a[j]) + 2 * t;
					trips++;
				}
			}
			
			System.out.println(time - t + " " + trips);
		}
	}
}