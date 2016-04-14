import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
	static String[] cities;
	static boolean[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        while(true) {
        	int n = scan.nextInt();
        	if(n == 0) break;
        	counter++;
           	if(counter> 1)System.out.println();
        	cities = new String[n];
        	map = new boolean[n][n];
        	for(int i = 0; i < n; i++) {
        		Arrays.fill(map[i], false);
        		cities[i] = scan.next();
        	}
        	int m = scan.nextInt();
        	for(int i = 0; i < m; i++ ){
        		String s = scan.next();
        		String ss = scan.next();
        		int origin = Arrays.asList(cities).indexOf(s);
        		int end = Arrays.asList(cities).indexOf(ss);
        		map[origin][end] = true;
        		map[end][origin] = true;
        	}
        	ArrayList<String> ci = new ArrayList<String>();
        	for(int i = 0; i < n; i++) {
        		visited = new boolean[n];
        		Arrays.fill(visited, false);
    			dfs(i, -1);
    			visited[i] = true;
    			boolean[] possible = visited.clone();
        		visited[i] = true;
    			Arrays.fill(visited, false);
    			int start = -1;
    			for(int k = 0; k < n; k++) {
    				if(map[i][k] && k!=i) {
    					start = k;
    					k = n;
    				}
    			}
    			if(start == -1) continue;
    			dfs(start, i);
        		visited[i] = true;
        		
        		for(int j = 0; j < visited.length; j++) {
        			if (visited[j] != possible[j]) {
        				ci.add(cities[i]);
        				break;
        			}
        		}
        	}
        	Collections.sort(ci);
        	System.out.println("City map #" +  counter +  ": " + ci.size() + " camera(s) found");
        	for(String s: ci) {
        		System.out.println(s);
        	}
        }
	}
	
	static void dfs(int index, int n) {
		if (index == n || visited[index]) return;
		visited[index] = true;
		for(int i = 0; i < map[index].length; i++) {
			if(map[index][i]) {
				dfs(i, n);
			}
		}
		return;
	}
}
 