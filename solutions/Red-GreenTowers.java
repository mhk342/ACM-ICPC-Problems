import java.util.*;
import java.io.*;
 
public class Main {
	
	static long[][] dp;

	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int g = scan.nextInt();
        long h = 1000000007;
        int size = r + g + 5;
        dp = new long[2][size];
        Arrays.fill(dp[0], 0);
        Arrays.fill(dp[1], 0);
        dp[0][0] = 1;
        dp[1][0] = 1;
        int max = 0;
        for(int i = 1; i < size; i++) {        	
        	int height = i * (i + 1) / 2;
        	if(height > r + g) break;
        	int red = i & 1;
        	int green = 1 - red;
        	for(int j = 1; j <= height; j++) {
        		dp[red][j] = dp[green][j];
        		if(j >= i) {
        			dp[red][j] += dp[green][j-i];
        			dp[red][j] %= h; 
        		}
        		else dp[red][j] %= h;
        	}
        	max = i;
        }
        long count = 0;
        long height = max * (max + 1) / 2;
        for(int i = 0; i <= r; i++){ 
        	if(height - i > g) continue;
        	int color = max & 1;
        	count += dp[color][i];
        	count %= h;
        }
		System.out.println(count);
	}
}