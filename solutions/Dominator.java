import java.util.*;
import java.io.*;
 
public class Main {

	static int[][] graph;
	static boolean[][] dom;
	static boolean[] visited;
	static boolean[] reachable;
	static ArrayList<Integer> queue;
	static ArrayList<List<Integer>> parents;
	
	
	// this is actually dfs; made a typo and didn't fix
    static void bfs(int n, int prev) {
		if(prev == -1) {
			visited[n] = true;
			for(int i = 0; i < graph[n].length; i++) {
				if(graph[n][i] == 1 && !visited[i]) {
					bfs(i, prev);
				}
			}
		}
		else {
			if(n == prev) return;
			visited[n] = true;
			for(int i = 0; i < graph[n].length; i++) {
				if(graph[n][i] == 1 && !visited[i]) {
					bfs(i, prev);
				}
			}
		}
    }
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int round = 1; round <= cases; round++) {
        	int size = scan.nextInt();
        	graph = new int[size][size];
        	boolean[][] trans = new boolean[size][size];
        	dom = new boolean[size][size];
        	visited = new boolean[size];
        	
        	Arrays.fill(visited, false);
        	queue = new ArrayList<Integer>();
        	parents = new ArrayList<List<Integer>>(size);
        	for(int i = 0; i < size; i++) {
        		for(int j = 0; j < size; j++) {
        			int tmp = scan.nextInt();
        			graph[i][j] = tmp;
        		}
        		parents.add(new ArrayList<Integer>());
        		Arrays.fill(dom[i], false);
        		dom[i][i] = true;
        	}
        	bfs(0, -1);
        	reachable =  visited.clone();
        	for(int i = 0; i < size; i++) {
        		Arrays.fill(visited, false);
        		bfs(0, i);
        		for(int j = 0; j < size; j++) {
        			dom[i][j] = reachable[j] && !visited[j];
        		}
        	}
        	System.out.println("Case " + round +":");
        	String s = "";
    		for(int i = 0; i < ((size-1) * 2) + 1; i++) {
    			s += "-";
    		}
        	for(boolean[] arr: dom) {
        		System.out.println("+" + s + "+");
        		for(boolean b: arr) {
        			if(b) System.out.printf("|Y");
        			else System.out.printf("|N");
        		}
        		System.out.println("|");
        		
        	}
        	System.out.println("+" + s + "+");
        }
	}
}
 