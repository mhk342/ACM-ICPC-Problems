import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	HashMap<String, Integer> hm = new HashMap<String, Integer>();
        	int size = scan.nextInt();
        	String word = scan.next();
        	for(int i = 0; i < word.length() - size; i++) {
        		if(hm.containsKey(word.substring(i, i + size))) {
        			hm.put(word.substring(i, i + size), hm.get(word.substring(i, i + size)) + 1 );
        		}
        		else {
        			hm.put(word.substring(i, i + size), 1);
        		}
        		
        	}
        	int max = -1;
        	String maxStr = "";
        	for(String key: hm.keySet()) {
        		if(hm.get(key) > max) {
        			max = hm.get(key);
        			maxStr = key;
        		}
        		
        	}
        	System.out.println(maxStr);
        	
        }
	}

}
 