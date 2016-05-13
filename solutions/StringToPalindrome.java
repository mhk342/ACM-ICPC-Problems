import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
 
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
     
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
    	int cases = scan.nextInt();
    	for(int round = 1; round <= cases; round++) {
    		String s = scan.next();
    		System.out.println("Case " + round +": " + solve(s));
    		  
    	}
    }

    static Integer solve(String s) {
    	if(hm.containsKey(s)) return hm.get(s);  
    	if(s.length() < 2) {
    		hm.put(s, 0);
    		return 0;
    	}
    	if(s.length() == 2) {
    		if(s.charAt(0) == s.charAt(1)) {
    			hm.put(s, 0);
    			return 0;
    		}
    		hm.put(s, 1);
    		return 1;
    	}
    	if(s.charAt(0) == s.charAt(s.length() - 1)) {
    		hm.put(s, solve(s.substring(1, s.length() - 1)));
    		return hm.get(s);
    	}
    	Integer min = Math.min(solve(s.substring(1)), solve(s.substring(0, s.length() - 1)));
    	min = Math.min(min, solve(s.substring(1, s.length() - 1)));
    	min++;
    	hm.put(s, min);
    	return hm.get(s);
    }
      
}