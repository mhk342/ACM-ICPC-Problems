import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
 

      public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            if(n == 0) break;
            Integer[] arr = new Integer[n + 1];
            for(int i = 1; i <= n; i++) {
                  arr[i] = scan.nextInt();
            }
            String skip = scan.nextLine();
            while(true){
                  int k = scan.nextInt();
                  if(k == 0) break;
                  Integer[] code = process(arr, k);
                  String s = scan.nextLine();
                  s = s.substring(1);
                  System.out.println(process(format(s,n + 1), code, arr, k));
                 
            }
            System.out.println();
           
        }
      }
     
      static String format(String s, int n) {
            while(s.length() < n) {
                  s = s + " ";
            }
            return s;
      }
      static Integer[] process(Integer[] arr, int k) {
    	  Integer[] tmp = new Integer[arr.length];
    	  for(int i = 1; i < arr.length; i++) {
    		  int marker= arr[i];
    		  int counter = 1;
    		  while(i != marker) {
    			  marker = arr[marker];
    			  counter++;
    		  }
    		  tmp[i] = counter;
    	  }
    	  
    	  return tmp;
      }
      static String process(String s, Integer[] code, Integer[] nArr, int k) {
            char[] arr = new char[code.length];
            for(int i = 1; i < arr.length; i++) {
                int cycles = (k-1) % code[i]+1;
                int cur = i;
                for(int j = 0; j < cycles; j++) {
                	cur = nArr[cur];
                }
            	arr[cur] = s.charAt(i-1);
            }
            return new String(arr).substring(1);
      }
 
}