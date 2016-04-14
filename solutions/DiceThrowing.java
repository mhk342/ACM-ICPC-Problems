import java.util.*;
import java.io.*;
import java.math.*;



public class Main {
	static boolean[] primeSet;
	static ArrayList<Integer> list;
	static long[][] map;
	
	private static void solve() {
		for(int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 0);
		}
		map[1][0] = 1;
		map[2][0] = 1;
		map[3][0] = 1;
		map[4][0] = 1;
		map[5][0] = 1;
		map[6][0] = 1;
		
		for(int i = 0; i < 23; i++) {
			for(int j = 0; j < map.length; j++) {
				if(map[j][i] == 0) continue;
				for(int k = 1; k <= 6; k++) {
					map[k+j][i + 1] += map[j][i];
				}
			}
		}
	}
	private static long gcd(BigInteger n, long m) {
		if(m == 0 || n.intValue() == 0) return 1;
		BigInteger b2 = BigInteger.valueOf(m);
		BigInteger gcd = n.gcd(b2);
		return gcd.longValue();
	}

	static long[] six;
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        six = new long[25];
        six[0] = 6;
        for(int i = 1; i < six.length; i++) {
        	six[i] = 6 * six[i-1]; 
        }
        map = new long[24 * 6 + 1][24];

        solve();
        while(scan.hasNext()) {	
        	int n = scan.nextInt(); //dice
        	int m = scan.nextInt(); //goal
        	if(n == 0 && m == 0) break;
        	BigInteger count = BigInteger.valueOf(0);
        	if(n == 0) {
        		System.out.println(0);
        		continue;
        	}
        	if(m == 0) {
        		System.out.println(1);
        		continue;
        	}
        	for(int i = m; i < map.length; i++) {
    			count = count.add(BigInteger.valueOf( map[i][n-1]));
        	}
        	if(count.equals(BigInteger.valueOf(0))) {
        		System.out.println(0);
        	}
        	else if(count.equals(BigInteger.valueOf( six[n-1]))) {
        		System.out.println(1);
        	}
        	else {
        		long gcd = gcd(count, six[n-1]);
        		System.out.println(count.divide(BigInteger.valueOf(gcd)) +"/" + six[n-1]/gcd);
        	}
        }
	}
}
 