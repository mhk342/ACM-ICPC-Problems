import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0) {
        	int height = scan.nextInt();
        	int len = scan.nextInt();
        	int x = scan.nextInt();
        	int y = scan.nextInt();
        	int ans = solve(height, len, y, x);
        	if(ans == 0) System.out.println("Hansel");
        	else System.out.println("Gretel");
        	
        }
	}
	

	
	static int solve(int height, int len, int y, int x) {
		int nim = x ^ y;
		nim ^= height - x - 1;
		nim ^= len - y - 1;
		return nim;
	}

	

}
 