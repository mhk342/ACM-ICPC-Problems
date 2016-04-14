import java.util.*;
import java.io.*;
 
public class Main {

	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int rounds = scan.nextInt();
        while(rounds-- > 0) {
        	int classes = scan.nextInt();
        	int hours = scan.nextInt();
        	int[][] schedule = new int[classes][hours+1];
        	int[][] dp = new int[classes][hours+1];
        	for(int i = 0; i < classes; i++) {
        		for(int j = 1; j <= hours; j++) {
        			schedule[i][j] = scan.nextInt();
        		}
        		Arrays.fill(dp[i], Integer.MIN_VALUE);
        	}
        	for(int i = 0; i <= hours; i++) {
        		if(schedule[classes-1][i] >= 5) dp[classes-1][i] = schedule[classes-1][i];
        	}
        	for(int i = classes-2; i >= 0; i--) {
        		for(int j = 1; j <= hours; j++) {
        			for(int k = 1; k < j; k++){
        				if(schedule[i][k] >= 5) {
        					dp[i][j] = Math.max(dp[i][j], schedule[i][k] + dp[i+1][j-k]);
        				}
        			}
        		}
        	}
        	if(dp[0][hours] >= 5*classes) System.out.printf("Maximal possible average mark - %.2f.\n", (float)dp[0][hours]/classes);
        	else System.out.println("Peter, you shouldn't have played billiard that much.");
        }
	}
}
 