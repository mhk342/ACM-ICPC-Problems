import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
 
      public static void main(String[] args) throws IOException{
    	  Scanner scan = new Scanner(System.in);
    	  while(scan.hasNextLine()) {
    		  char[] a = scan.nextLine().toCharArray();
    		  char[] b = scan.nextLine().toCharArray();
    		  if(a.equals("") || b.equals("")) {
    			  System.out.println();
    			  continue;
    		  }
    		  int[] aArr = new int[26];
    		  int[] bArr = new int[26];
    		  Arrays.fill(aArr, 0);
    		  Arrays.fill(bArr, 0);
    		  for(char c: a){
    			  aArr[(int)c -97]++;
    		  }
    		  for(char c: b){
    			  bArr[(int)c -97]++;
    		  }
    		  for(int i = 0; i < 26; i++) {
    			  int count = Math.min(aArr[i], bArr[i]);
    			  for(int j = 0; j < count; j++) {
    				  System.out.printf("%c", (char)(i+97));
    			  }
    			  
    		  }
    		  System.out.println();
    	  }
      }
}