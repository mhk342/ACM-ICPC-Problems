import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
	static char[][] map;
	static int[] count;
	static int[] before;
	static int counter;
	static boolean[][] visited;
	static int x, y;
	static boolean whiteVisited, blackVisited;

	static void bfs(int i, int j) {
		if(i < 0 || i > 8 || j < 0 || j > 8) return;
		if(map[i][j] == 'O') whiteVisited = true;
		else if (map[i][j] == 'X') blackVisited = true;
		if(visited[i][j]) return;
		counter++;
		visited[i][j] = true;
		bfs(i -1, j);
		bfs(i + 1, j);
		bfs(i, j - 1);
		bfs(i, j + 1);
	}

	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int rounds = scan.nextInt();
        String skip = scan.nextLine();
        while(rounds-- > 0) {
        	int size = 9;
        	map = new char[size][size];
        	int black = 0;
        	int white = 0;
        	visited = new boolean[size][size];
        	for(boolean[] b: visited) {
        		Arrays.fill(b, false);
        	}
        	for(int i = 0; i < size; i++) {
        		map[i] = scan.nextLine().toCharArray();
        		for (int j = 0; j < size; j++) {
        			if(map[i][j] == 'O') {
        				white++;
        				visited[i][j] = true;
        			}
        			else if (map[i][j] == 'X') {
        				black++;
        				visited[i][j] = true;
        			}
        		}
        	}
        	
        	for(int i = 0; i < size; i++) {
        		for(int j = 0; j < size; j++) {
        			if(!visited[i][j]) {
        				whiteVisited = false;
        				blackVisited = false;
        				counter = 0;
        				bfs(i, j);
        				if(whiteVisited && !blackVisited) white += counter;
        				else if (blackVisited && !whiteVisited) black += counter;
        			}
        		}
        	}
        	System.out.println("Black "+ black + " White " + white);
        }
	}
}
 