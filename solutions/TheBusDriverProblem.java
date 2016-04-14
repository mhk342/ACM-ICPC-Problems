import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);

		while(true) {
			int n =  scan.nextInt(); // # buses
			int d = scan.nextInt(); // # hours
			int r = scan.nextInt(); // rate
			if(n == 0 && d == 0 && r == 0) {
				break;
			}
			int[] am = new int[n];
			int[] pm = new int[n];
			for(int i  = 0; i < n; i++) {
				am[i] = scan.nextInt();
			}
			for(int i  = 0; i < n; i++) {
				pm[i] = scan.nextInt();
			}
			Arrays.sort(am);
			Arrays.sort(pm);
			int hours = 0;
			for(int i = 0; i < n; i++) {
				int sum = am[i] + pm[n - 1 - i];
				hours += Math.max(0, sum - d);
			}
			System.out.println(r * hours);
			
		}
	}
}