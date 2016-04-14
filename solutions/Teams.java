import java.util.*;
import java.io.*;
import java.math.*;



public class Main {
	static int[] map;
	static int mod = 1000000007;
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int rounds = scan.nextInt();
        for(int count=1; count <= rounds; count++) {
        	int n = scan.nextInt();
        	BigInteger bg = BigInteger.valueOf(n).mod(BigInteger.valueOf(mod));
        	System.out.println("Case #" + count + ": " + bg.multiply(BigInteger.valueOf(2).modPow(BigInteger.valueOf(n-1), BigInteger.valueOf(mod))).mod(BigInteger.valueOf(mod)));
        }
	}
}
 