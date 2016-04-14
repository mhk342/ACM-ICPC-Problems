import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine() && scan.hasNextInt()) {
			int elems = scan.nextInt();
			int rounds = scan.nextInt();
			Integer[] map = new Integer[elems + 1];
			Arrays.fill(map, 0);
			
			for(int i = 0; i < elems; i++) {
				int x = scan.nextInt();
				if(x == 0) {
					int tmp = i + 1;
					while(tmp <= elems) {
						map[tmp] += -100000;
						tmp += (tmp & -tmp);
					}
				}
				else if (x < 0) {
					int tmp = i + 1;
					while(tmp <= elems) {
						map[tmp] += 1;
						tmp += (tmp & -tmp);
					}
				}	
			}
			
			for(int i = 0; i < rounds; i++) {
				if(scan.next().equals("C")) {
					int x = scan.nextInt();
					int y = scan.nextInt();
					int sum = 0;
					int tmp = x;
					while(tmp  > 0) {
						sum += map[tmp];
						tmp -= (tmp & -tmp);
					}
					int xtmp = sum;
					sum = 0;
					tmp = x - 1;
					while(tmp  > 0) {
						sum += map[tmp];
						tmp -= (tmp & -tmp);
					}
					int xval = -1 * (xtmp - sum);
					tmp = x;
					while(tmp <= elems) {
						map[tmp] += xval;
						tmp += (tmp & -tmp);
					}
					tmp = x;
					if(y < 0) {
						while(tmp <= elems) {
							map[tmp] += 1;
							tmp += (tmp & -tmp);
						}
					}
					else if (y == 0) {
						while(tmp <= elems) {
							map[tmp] += -100000;
							tmp += tmp & -tmp;
						}
					}
				}
				
				else {
					int start = scan.nextInt();
					int end = scan.nextInt();
					int sum = 0;
					int tmp = end;
					while(tmp  > 0) {
						sum += map[tmp];
						tmp -= (tmp & -tmp);
					}
					int endtmp = sum;
					sum = 0;
					tmp = start - 1;
					while(tmp  > 0) {
						sum += map[tmp];
						tmp -= (tmp & -tmp);
					}
					int val = endtmp - sum;
					if(val >= 0) {
						if(val % 2 == 0)System.out.print("+");
						else System.out.print("-");
					}
					else System.out.print("0");
				}
			}
			System.out.println();
			
		}
		
	}
}