import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 1; i <= cases; i++) {
        	int length = scan.nextInt();
        	int[] heights = new int[length];
        	int widths[] = new int[length];
        	int[] longestInc = new int[length];
        	int[] longestDec = new int[length];
        	Arrays.fill(longestInc, 0);
        	Arrays.fill(longestDec, 0);
        	int longestIncRec = 0;
        	int longestDecRec = 0;
        	for(int j = 0; j < length; j++) {
        		heights[j] = scan.nextInt();
        	}
        	for(int j = 0; j < length; j++) {
        		widths[j] = scan.nextInt();
        	}
        	int pos = 0;
        	for(int j = 0; j< length; j++) {
        		int tmp = 0;
        		int height = heights[j];
        		for (int k = j-1; k >= 0; k--) {
        			if(heights[k] < height) {
        				tmp = Math.max(longestInc[k], tmp);
        			}
        		}
        		longestInc[j] = tmp + widths[j];
        		longestIncRec = Math.max(longestIncRec, longestInc[j]);
        	}
        	for(int j = 0; j< length; j++) {
        		int tmp = 0;
        		int height = heights[j];
        		for (int k = j-1; k >= 0; k--) {
        			if(heights[k] > height) {
        				tmp = Math.max(longestDec[k], tmp);
        			}
        		}
        		longestDec[j] = tmp + widths[j];
        		longestDecRec = Math.max(longestDecRec, longestDec[j]);
        	}
        	
        	if(longestDecRec > longestIncRec) System.out.println("Case " + i + ". Decreasing (" + longestDecRec + "). Increasing (" + longestIncRec + ").");
        	else System.out.println("Case " + i + ". Increasing (" + longestIncRec + "). Decreasing (" + longestDecRec + ").");
        	
        }
	}
}
 