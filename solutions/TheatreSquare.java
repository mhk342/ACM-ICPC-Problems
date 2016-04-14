import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int a= scan.nextInt();
		int x, y;
		if(n % a != 0) x = n/a + 1; 
		else x = n / a;
		if(m % a != 0) y = m/a + 1; 
		else y = m / a;
		String xs = "" + x;
		String ys = "" + y;
		BigInteger yy = new BigInteger(ys);
		BigInteger xx = new BigInteger(xs);
		System.out.println(xx.multiply(yy));
	}
}