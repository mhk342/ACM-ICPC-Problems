import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0) {
        	System.out.println(solve(scan.next()));
        	if(cases > 0) System.out.println();
        }
	}
	
	private static int solve(String s) {
		int len = s.length();
		int per = len;
		for(int i = 1; i < len; i++) {
			if(len % i != 0) continue;
			String test = s.substring(0, i);
			boolean flag = true;
			for(int j = i; j < len; j+= i) {
				if(!test.equals(s.substring(j, j + i))){
					flag = false;
					break;
				}
			}
			if(flag) {
				return i;
			}
		}
		return per;
	}
	

}
 