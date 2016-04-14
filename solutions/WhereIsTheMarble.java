import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int round = 0;
		while(true) {
			round++;
			int n = scan.nextInt(); // # marbles
			int q = scan.nextInt(); // # queries
			if(n == 0 && q == 0) {
				break;
			}
			int[] list = new int[n];
			for(int i = 0; i < n; i++) {
				list[i] = scan.nextInt();
			}
			Arrays.sort(list);

			System.out.println("CASE# " + round + ":");
			int pos = -1;
			for(int j = 0; j < q; j++) {
				int query = scan.nextInt();
				int index = Arrays.binarySearch(list, query);
				while(index > 0) {
					if(list[index - 1] == query) index--;
					else break;
				}
				if(index >= 0) System.out.println(query + " found at " + (index + 1));
				else System.out.println(query + " not found");
			}
			
		}
	}
}