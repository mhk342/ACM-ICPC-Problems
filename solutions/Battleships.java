import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	
	static boolean[][] visited;
	static char[][] map;
	
	public static boolean traverse(int x, int y) {
		if(x < 0 || y < 0|| x >= map[0].length || y >= map[0].length) return false;
		if(visited[x][y]) return false;
		if (map[x][y] == '@') {
			visited[x][y] = true;
			return(traverse(x-1, y)||
			traverse(x+1, y)||
			traverse(x, y-1)||
			traverse(x, y+1)
			);
			
		}
		else if(map[x][y] != 'x') {
			visited[x][y] = true;
			return false;
		}
		else {
			visited[x][y] = true;
			traverse(x-1, y);
			traverse(x+1, y);
			traverse(x, y-1);
			traverse(x, y+1);
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int rounds = scan.nextInt();
        for(int i = 1; i <= rounds;i++) {
        	int n = scan.nextInt();
        	map = new char[n][n];
        	visited = new boolean[n][n];
        	for(int j = 0; j < n; j++) {
        		char[] line = scan.next().toCharArray();
        		map[j] = line;
        		Arrays.fill(visited[j], false);
        	}
        	int counter = 0;
        	for(int j = 0; j <n; j++) {
        		for(int k = 0; k < n; k++) {
        			if(traverse(j,k)) counter++;
        		}
        	}
        	System.out.println("Case " + i + ": " + counter);	
        }
	}
}
 