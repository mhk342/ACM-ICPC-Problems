import java.util.*;
import java.io.*;
import java.math.*;

// This is actually an Aizu problem
public class Main {
	
	private static long gcd(long n, long m) {
		while(n != m) {
			if(n > m) {
				n -= m;
			}
			else {
				m-= n;
			}
		}
		return n;
	}


	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	long n = scan.nextInt();
        	long m = scan.nextInt();
        	long gcd = gcd(n, m);
        	System.out.println(gcd + " " + n * m / gcd);
        }
	}
}
 