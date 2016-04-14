import java.util.*;
import java.io.*;
 
public class Main {

	static int[][][] dp;
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        while(true) {
        	counter++;
        	int l = scan.nextInt(); // length
        	int s = scan.nextInt(); // sum
        	if(l == 0 && s == 0) break;
        	dp = new int[27][27][s+1];
        	for(int[][] a: dp) {
        		for(int[] b: a) {
        			Arrays.fill(b, -1);
        		}
        	}
        	System.out.println("Case " + counter + ": " + process(l, s, 0, 0, 0));
        }
	}
	
	static int process(int l, int s, int len, int sum, int index) {
		if(sum > s) return 0;
		if(len >= dp.length) return 0;
		if(len == l){
			if(sum == s) return 1;
			else return 0;
		}
		if(dp[len][index][sum] != -1) return dp[len][index][sum];
		dp[len][index][sum]++;
		for(int i = index + 1; i <= 26; i++) {
			dp[len][index][sum] += process(l, s, len + 1, sum + i, i);
		}
		return dp[len][index][sum];
		
	}
}
 