import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int people = scan.nextInt();
			int friends = scan.nextInt();
			Integer[] money = new Integer[people];
			Integer[] map = new Integer[people];
			for(int j = 0; j < people; j++) map[j] = j; 
			for(int j = 0; j < people; j++) {
				money[j] = scan.nextInt();
			}
			
			for(int j = 0; j < friends; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				boolean found = false;
				int xsrc  = x;
				while(map[xsrc] != xsrc) xsrc = map[xsrc];
				
				while(map[x] != xsrc) {
					int tmp = x;
					x = map[x];
					map[tmp] = xsrc;
				}
				
				int ysrc  = y;
				while(map[ysrc] != ysrc) ysrc = map[ysrc];
				while(map[y] != ysrc) {
					int tmp = y;
					y = map[y];
					map[tmp] = ysrc;
				}
				if(xsrc == ysrc) continue;
				map[ysrc] = xsrc;
				money[xsrc] += money[ysrc];
			}
			
			boolean flag = true;
			
			for(int k = 0; k < people; k++) {
				int src = k;
				while(map[src] != src) src = map[src];
				if(money[src] != 0) {
					flag = false;
					System.out.println("IMPOSSIBLE");
					break;
				}
			}
			if (flag)System.out.println("POSSIBLE");
			
		}
	}
}