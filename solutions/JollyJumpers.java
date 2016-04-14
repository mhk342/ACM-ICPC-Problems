import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			int n = scan.nextInt();
			ArrayList<Integer> a = new ArrayList<Integer>();
			int x = scan.nextInt();
			int y;
			
			if( n == 1 ) {
				System.out.println("Jolly");
				continue;
			}
			
			for (int i = 0; i < n - 1; i++) {
				y = x;
				x = scan.nextInt();
				a.add(Math.abs(x-y));
			}
			
			if ( n != 1) {
				Integer[] aa = new Integer[a.size()];
				aa = a.toArray(aa);
				Arrays.sort(aa);
				boolean flag = true;
				for (int i = 1; i < n; i++) {
					if (aa[i-1] != i){
						flag = false;
						break;
					}
				}
				if (flag) System.out.println("Jolly");
				else System.out.println("Not jolly");
			}
			
		}
		
	}
}