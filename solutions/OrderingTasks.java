import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
	static int[][] map;
	static int[] count;
	static int[] before;
	
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(true) {
        	int n  = scan.nextInt();
        	int m = scan.nextInt();
        	if(n == 0 && m == 0) break;
        	map = new int[n][n];
        	count = new int[n];
        	before = new int[n];
        	for(int i = 0; i < n; i++)
        	{
        		Arrays.fill(map[i], 0);
        	}
        	Arrays.fill(before, 0);
        	for(int i = 0; i < m; i++) {
        		int x = scan.nextInt();
        		int y = scan.nextInt();
        		map[x -1 ][y - 1] = 1;
        		before[y - 1]++;
        	}
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	int counter = 0;
        	while(counter < n) {
        		for(int i = 0; i < n; i++) {
        			if(before[i] == 0 && !list.contains(i)) {
        				list.add(i);
        				counter++;
        				for(int j = 0; j < n; j++) {
        					if(map[i][j] == 1) before[j] -= 1; 
        				}
        			}
        		}
        	}
        	for(int i = 0; i < n; i++) {
        		if(i != n - 1)System.out.print((list.get(i) + 1) + " ");
        		else System.out.print((list.get(i) + 1));
        	}
        	System.out.println();
        }
	}
}
 