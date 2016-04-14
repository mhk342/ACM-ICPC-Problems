import java.util.*;
import java.io.*;
 
public class Main {

	static char[][] map;
	static boolean[][] visited;
	static int gold;
	
	static boolean nearTrap(int x, int y) {
		if(x > 0) {
			if(map[y][x-1] == 'T') return true;
		}
		if(x < map[0].length - 1) {
			if(map[y][x+1] == 'T') return true;
		}
		if(y > 0) {
			if(map[y-1][x] == 'T') return true;
		}
		if(y < map.length -1 ) {
			if(map[y+1][x] == 'T') return true;
		}
		return false;
	}
	
	static void search(int x, int y) {
		if(x < 0 || y >= map.length || y < 0 || x >= map[0].length || visited[y][x]) return;
		char key = map[y][x];
		visited[y][x] = true;
		switch(key) {
		case '#':
			return;
		case 'G':
			gold++;
			if(nearTrap(x,y)) return;
			else {
				search(x-1, y);
				search(x+1, y);
				search(x, y-1);
				search(x, y+1);
				return;
			}
		case 'P':
		case '.':
			if(nearTrap(x,y)) return;
			else {
				search(x-1, y);
				search(x+1, y);
				search(x, y-1);
				search(x, y+1);
				return;
			}
		case 'T':
			System.out.println('T');
			return;
		default:
			System.out.println("default" + key);
			return;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
        	int length = scan.nextInt();
        	int height = scan.nextInt();
        	gold = 0;
        	map = new char[height][length];
        	visited = new boolean[height][length];
        	String skip = scan.nextLine();
        	for(int i = 0; i < height; i++) {
        		String line = scan.nextLine();
        		map[i] = line.toCharArray();
        		Arrays.fill(visited[i], false);
        	}
        	int x = 0, y = 0;
        	for(int i = 0; i < height; i++) {
        		for(int j = 0; j < length; j++) {
        			if(map[i][j] == 'P'){
        				x = j;
        				y = i;
        				i = height;
        				j = length;
        			}
        		}
        	}
        	search(x,y);
        	System.out.println(gold);
        }
	}
}