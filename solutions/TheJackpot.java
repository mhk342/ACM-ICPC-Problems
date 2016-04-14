import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int n = scan.nextInt();
        	if(n == 0) System.exit(0);
        	int max = 0;
        	int localMax = 0;
        	for(int i = 0; i < n; i++) {
        		int m = scan.nextInt();
        		if(m < 0) localMax = Math.max(localMax + m, 0);
        		else {
        			localMax += m;
        			max = Math.max(localMax, max);
        		}
        	}
        	if(max == 0) System.out.println("Losing streak.");
        	else  System.out.println("The maximum winning streak is " + max + ".");
        }
	}
}
 