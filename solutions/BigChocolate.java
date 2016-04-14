import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int n = scan.nextInt();
        	int m = scan.nextInt();
        	System.out.println(n*m-1);
        }
	}
}
 