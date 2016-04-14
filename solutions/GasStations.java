import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			int L = scan.nextInt();
			int G = scan.nextInt();
			if(L == 0 && G == 0) break;
			int[][] pairs = new int[G][2];
			for(int i = 0; i < G; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				pairs[i][0] = a - b; // range begin
				pairs[i][1] = a + b; // range end
			}
			Arrays.sort(pairs, new java.util.Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});
			int count = 0;
			int pos = 0;
			boolean flag = true;
			while(pos < L) {
				int tmp = pos;
				for(int i = 0; i < G; i++) {
					if(pairs[i][0] > pos) break;
					tmp = Math.max(tmp, pairs[i][1]);
				}
				if(tmp == pos) break;
				pos = tmp;
				count++;
			}
			if(pos < L) System.out.println("-1");
			else System.out.println(G - count);	
		}
	}
}