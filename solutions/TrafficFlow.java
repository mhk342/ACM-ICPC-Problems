import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
	static String[] cities;
	static boolean[][] map;
	static boolean[] visited;
	
	static void dfs(int i) {
		
		if(visited[i] || i < 0) return;
		visited[i] = true;
		for(int k = 0; k < map[i].length; k++) {
			if(k == i) continue;
			if(map[k][i]) dfs(k);
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int round = 1; round <= cases; round++) {
        	int dist = scan.nextInt();
        	int roads = scan.nextInt();
        	int[][] vals = new int[roads][3];
        	for(int i = 0; i < roads; i++) {
        		vals[i][0] = scan.nextInt();
        		vals[i][1] = scan.nextInt();
        		vals[i][2] = scan.nextInt();
        	}
        	visited = new boolean[dist];
        	map = new boolean[dist][dist];
        	for(int i = 0; i < dist; i++) {
        		Arrays.fill(map[i], false);
        	}
        	Arrays.sort(vals, new Comparator<int[]>() {
        		@Override
        		public int compare(int[] x, int[] y) {
        			return x[2] > y[2] ? -1 : x[2] == y[2] ? 0 : 1;
        		}
        	});
        	int max = 1;
        	boolean done = true;
        	for(int[] arr: vals) {
        		Arrays.fill(visited, false);
        		map[arr[0]][arr[1]] = true;
        		map[arr[1]][arr[0]] = true;
        		dfs(arr[0]);
        		max = arr[2];
        		done = true;
        		for(boolean b: visited) {
        			if(!b) done = false;
        		}
        		if(done) break;
        	}
        	if(done && dist > 1) System.out.println("Case #" + round + ": " + max);
        	else System.out.println("Case #" + round + ": " + Integer.MAX_VALUE);
        }
	}

}
 