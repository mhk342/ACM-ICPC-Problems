import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(true) {
        	int n = scan.nextInt();
        	int m = scan.nextInt();
        	if(n == 0 && m == 0) {
        		break;
        	}
        	double tax = 100 - (double)(m);
        	double threshold = n - 1;
        	double ans = threshold * 100/tax;
        	if (ans % 1 == 0) ans--;
        	long answer = (long)(ans);
        	if(answer < n || m == 100) {
        		System.out.println("Not found");
        	}
        	else System.out.println(answer);        	
        }
	}
}
 