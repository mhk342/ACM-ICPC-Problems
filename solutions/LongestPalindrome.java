import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
 
      static int[][] map;
      static String s;
     
      public static void main(String[] args) throws IOException{
    	  Scanner scan = new Scanner(System.in);
    	  int cases = scan.nextInt();
    	  String skip = scan.nextLine();
    	  while(cases-- > 0) {
    		  s = scan.nextLine();
    		  if(s.equals("")) {
    			  System.out.println(0);
    			  continue;
    		  }
    		  map = new int[s.length()][s.length()];
//    		  Arrays.fill(map[0], 1);
    		  for(int i = 0; i < s.length(); i++) {
    			  Arrays.fill(map[i], -1);
    		  }
    		  int max = 1;
    		  for(int i = 0; i < map.length; i++) {
    			  for(int j = 0; j < map.length; j++) {
    				  if(j > i) max = Math.max(max, longestPalindromeLength(i, j));
    			  }
    		  }
    		  System.out.println(max);
    	  }
      }
      
      static int longestPalindromeLength(int l, int r) {
    	  if(map[l][r] != -1) return map[l][r];
    	  if(l > r) {
    		  map[l][r] = 0;
    		  return 0;
    	  }
    	  if(l == r) {
    		  map[l][r] = 1;
    		  return 1;
    	  }
    	  if(s.charAt(l) == s.charAt(r)) {
    		  map[l][r] = 2 + longestPalindromeLength(l+1, r-1);
    		  return map[l][r];
    	  }
    	  else {
    		  map[l][r] = Math.max(longestPalindromeLength(l+1,r),longestPalindromeLength(l, r-1));
    		  return map[l][r];
    	  }
      }
      
}