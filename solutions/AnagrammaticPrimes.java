import java.util.*;
import java.io.*;
import java.math.*;



public class Main {

	static int[] set;// = {2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131, 199, 311, 337, 373, 733, 919, 991};
	// This set of permutable primes is the finite set from 2 to 100,000
	static ArrayList<Integer> sieve;
	static ArrayList<Integer> ana;

	private static void sieve(int n) {
		boolean[] list = new boolean[n + 1];
		Arrays.fill(list, true);
		list[0] = false;
		list[1] = false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(list[i]) {
				for(int j = i * i; j <= n; j+=i) {
					list[j] = false;
				}
			}
		}
		for(int i =0; i <= n; i++) {
			if(list[i]) sieve.add(i);
		}
		
	}
	
	private static void ana() {
		for(int i: sieve) {
			if(i < 10) ana.add(i);
			else {
				if(checkAnagram(i)) ana.add(i);
			}
		}
	}
	
	private static boolean checkAnagram(int n) {
		char[] arr = (n + "").toCharArray();
		return isAnagram(arr, new char[arr.length], 0, new boolean[arr.length]);
	}
	
	private static boolean isAnagram(char[] arr, char[] chars, int ind, boolean[] used) {
		if(ind == arr.length) {
			return sieve.contains(Integer.parseInt(new String(chars)));
		}
		else {
			boolean flag = true;
			for(int i = 0; i < arr.length; i++) {
				if(!used[i]) {
					used[i] = true;
					chars[ind] = arr[i];
					flag = flag && isAnagram(arr, chars, ind+1, used);
					used[i] = false;
				}
				
			}
			return flag;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        
    	sieve = new ArrayList<Integer>();
    	ana = new ArrayList<Integer>();
    	sieve(1000);
        ana();
        set = new int[ana.size()];
        for(int i = 0;i < ana.size();i++) {
        	set[i] = ana.get(i);
        }
        while(true) {
        	int n = scan.nextInt();
        	if(n == 0) break;
        	int len  = (n + "").toCharArray().length;
        	int ans = 0;
        	for(int i = 0; i < set.length; i++) {
        		if(n < set[i] && set[i] < Math.pow(10, len)) {
        			ans = set[i];
        			break;
        		}
        	}
        	System.out.println(ans);
        }
	}
}
 