import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int rounds =  scan.nextInt();
		for(int i  = 0; i < rounds; i ++) {
			int size = scan.nextInt();
			int n = scan.nextInt();
			int[] a = new int[n];
			String skip = scan.nextLine();
			
			for (int j = 0; j < n; j++) {
				String s = scan.nextLine();
				s = s.replaceAll("\\s+", "");
				a[j] = Integer.parseInt(s, 2);
			}
			
			int counter = 100;
			for(int j = 0; j < (1 << size); j++) {
				Set<Integer> set = new HashSet<Integer>();
				for(int aa: a) set.add(aa & j);
				if(set.size() == n)  counter = Math.min(counter, Integer.bitCount(j));
			}
			System.out.println(counter);
		}
	}
}