import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int rounds = scan.nextInt();
		while(rounds-- > 0) {
			int height = scan.nextInt();
			int width = scan.nextInt();
			char[][] map = new char[height][width];
			String skip = scan.nextLine();
			int x = -1; int y = -1;
			for(int i = 0; i < height; i++) {
				map[i] = scan.nextLine().toCharArray();
			}
			for(int i = 0; i < width; i++) {
				if(map[height -1][i] == '@') {
					x = i;
					y = height - 1;
					break;					
				}
			}
			char[] target = "IEHOVA#".toCharArray();
			int index = 0;
			StringBuffer s = new StringBuffer("");
			while(index < 7) {
				if(index > 0) s.append(" ");
				boolean found = false;
				if(x > 0) {
					if(map[y][x-1] == target[index]) {
						index++;
						x--;
						s.append("left");
						found = true;
					}
				}
				if(x < width - 1 && !found) {
					if(map[y][x+1] == target[index]) {
						index++;
						x++;
						s.append("right");
						found = true;
					}
				}
				if (!found){
					index++;
					y--;
					s.append("forth");
				}
			}
			
		}
	}
}