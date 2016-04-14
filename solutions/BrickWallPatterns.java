import java.util.*;
import java.io.*;
 
public class Main {
	static int[] length = new int[51];
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        Arrays.fill(length, -1);
        length[0] = 0;
        length[1] = 1;
        length[2] = 2;
        length[3] = 3;
        while(scan.hasNextInt()) {
        	int n = scan.nextInt();
        	if (n==0) break;
    		System.out.println(calc(n));
        }
	}
	
	static int calc(int n) {
		if(length[n] != -1) return length[n];
		else {
			length[n] = calc(n-1) + calc(n-2);
			return length[n];
		}
	}
}
 