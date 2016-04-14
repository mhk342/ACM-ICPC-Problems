import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int n  = scan.nextInt();
        int max = Integer.MIN_VALUE;
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		arr[i][j] = scan.nextInt();
        	}
        }
        for(int i = 0; i < n; i++) {	
        	for(int j = 0; j < n; j++) {
        		int[] cols = new int[n-j];
        		int[] rows = new int[n-j];
        		for(int k = i; k < n; k++) {
        			for(int m = j; m < n; m++) {
        				if(m-j-1 >= 0) cols[m-j] = cols[m-j-1] + arr[k][m];
        				else cols[m-j] = arr[k][m];
        				rows[m-j] += cols[m-j];
        				max = Math.max(max, rows[m-j]);
        			}
        		}
        	}
        }    
        System.out.println(max);
	}
}
 