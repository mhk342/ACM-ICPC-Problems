import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	int key = scan.nextInt();
        	if(key == 0) break;
        	String word = scan.next();
        	char[] carr = word.toCharArray();
        	int[] iarr = new int[carr.length];
        	int[] plainArr = new int[carr.length];
        	for(int i = 0; i < carr.length; i++) {
        		if(carr[i] == '_') iarr[i] = 0;
        		else if (carr[i] == '.') iarr[i] = 27;
        		else {
        			iarr[i] = (int) carr[i] - 96;
        		}
        	}
        	for(int i = 0; i < carr.length; i++) {
        		plainArr[(key * i) % carr.length] = iarr[i] + i;
        	}
        	for(int i: plainArr) {
        		System.out.printf("%c", hash(i));
        	}
        	System.out.println();
        }
	}
	
	private static char hash(int i) {
		int n = i % 28;
		if(n == 0) return '_';
		else if( n == 27) return '.';
		else {
			return (char) (n + 96);
		}
	}
}
 