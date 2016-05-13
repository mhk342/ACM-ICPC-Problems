import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	private static int solve(int i, long n) {
		if(n <= 1) return i;
		else {
			if(i%2 == 1) {
				return solve(i+1,(long) (n+8)/9);
			}
			else {
				return solve(i+1, (long) (n+1)/2);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	long n = scan.nextInt();
        	if(n == 1) {
        		System.out.println("Ollie wins.");
        		continue;
        	}
        	int i = solve(1, n);
        	if(i%2 == 1) System.out.println("Ollie wins.");
        	else System.out.println("Stan wins.");
        	
        }
	}
}
 