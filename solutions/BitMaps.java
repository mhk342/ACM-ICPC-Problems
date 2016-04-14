import java.util.*;
import java.io.*;
 
public class Main {
	static char[][] map = new char[256][256];
	static char[] linearMap = new char[256*256];
	static int index;
	
	static void dfs(int lx, int ly, int rx, int ry) {
		if(lx > rx || ly > ry) return; 
		char n = map[lx][ly];
		int tmp = 1;
	    for(int i = lx; i <= rx; i++) {
	        for(int j = ly; j <= ry; j++) {
	            if(map[i][j] != n) {
	            	tmp = 0;
	            	j = ry;
	            	i = rx;
	            }
	        }
	    }
	    if(tmp == 1) {
	    	System.out.printf("%c",n);
	    	index++;
	    	if(index%50 == 0)System.out.println(""); 
	    	return;
	    }
	    int x = (lx+rx)/2;
	    int y = (ly+ry)/2;
	    System.out.printf("D");
	    index++;
	    if(index%50 == 0)System.out.println(""); 
	    dfs(lx, ly, x, y);
	    dfs(lx, y+1, x, ry);
	    dfs(x+1, ly, rx, y);
	    dfs(x+1, y+1, rx, ry);
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(true) {
        	boolean b;
        	String s = scan.next();
        	if(s.equals("B")) b = true;
        	else if(s.equals("D")) b = false;
        	else break;
        	int rows = scan.nextInt();
        	int cols  = scan.nextInt();
        	index = 0;
        	if(b){
        		String line = "";        		
        		line = scan.next();
        		while(line.length() % 50 == 0 && line.length() < rows * cols) {
        			line += scan.next();
        		}
        		line.replaceAll("\\s+", "");
        		while(index < cols * rows) {
        			if(line.charAt(index) != '\n') linearMap[index] = line.charAt(index++);
        		}
        		index = 0;
        		System.out.printf("D%4d%4d\n", rows, cols);
        		for(int i = 0; i < rows; i++) {
        			for(int j = 0; j < cols; j++) {
        				map[i][j] = (char)linearMap[index++];
        			}
        		}
        		index = 0;
        		dfs(0, 0, rows-1, cols-1);
        		if(index%50!=0) System.out.printf("");
        		System.out.println();
        	}
        	else {
        		index = 0;
        		String line = scan.next();
        		while(line.length() % 50 == 0 && line.length() < rows * cols) {
        			line += scan.next();
        		}
        		line.replaceAll("\\s+", "");
        		for(char c: line.toCharArray()) {
        			linearMap[index++] = c;
        		}
        		System.out.printf("B%4d%4d\n", rows, cols);
        		index = 0;
        		dfs2(0, 0, rows-1, cols-1);
        		index = 0;
        		for(int i = 0; i < rows; i++) {
        			for(int j = 0; j < cols; j++) {
        				System.out.printf("%s",map[i][j]);
        				index++;
        				if(index % 50 == 0) System.out.println();
        			}
        		}
        		if(index % 50 != 0) {
        			System.out.println();
        		}
        	}
        }

	}
    static void dfs2(int lx, int ly, int rx, int ry) {
    	if(lx > rx || ly > ry) return; 
		if(linearMap[index] == '0') {
			for(int i = lx; i <= rx; i++) {
				for(int j = ly; j <= ry; j++) {
					map[i][j] = '0';
				}
			}
			index++;
			return;
		}
		if(linearMap[index] == '1') {
			for(int i = lx; i <= rx; i++) {
				for(int j = ly; j <= ry; j++) {
					map[i][j] = '1';
				}
			}
			index++;
			return;
		}
	    int x = (lx+rx)/2;
	    int y = (ly+ry)/2;
	    index++;
	    dfs2(lx, ly, x, y);
	    dfs2(lx, y+1, x, ry);
	    dfs2(x+1, ly, rx, y);
	    dfs2(x+1, y+1, rx, ry);
    	
    	
    }

}
 