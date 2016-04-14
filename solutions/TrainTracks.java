import java.util.*;
import java.io.*;


public class TrainTracks {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String s = scan.nextLine();
		for (int i = 0; i < n; i++) {
			char[] c = scan.nextLine().toCharArray();
			int mcount = 0;
			int fcount = 0;
			for (char j: c) {
				if (j == 'F') fcount++;
				if (j == 'M') mcount++;
			}
			if (mcount == fcount && mcount % 2 == 0) System.out.println("LOOP");
			else System.out.println("NO LOOP");
			
		}
		
	}
}
	