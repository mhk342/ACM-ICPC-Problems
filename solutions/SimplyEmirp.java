import java.util.*;
import java.io.*;
import java.math.*;



public class Main {
	static boolean[] primeSet;
	static ArrayList<Integer> list;
	
	private static void fillPrime() {
		primeSet[0] = false;
		primeSet[1] = false;
		for(int i = 2; i < Math.sqrt(primeSet.length); i++) {
			if(primeSet[i]) {
				for(int j = i * i; j < primeSet.length; j+=i) {
					primeSet[j] = false;
				}
			}
		}
	}
	
	private static boolean em(int n) {
		String s = (n + "");
		String r = new StringBuilder(s).reverse().toString();
		if (s.equals(r)) return false;
		if(primeSet[Integer.parseInt(r)]) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        primeSet = new boolean[1000001];
        list = new ArrayList<Integer>();
        Arrays.fill(primeSet, true);
        fillPrime();
        while(scan.hasNext()) {	
        	int n = scan.nextInt();
        	if(!primeSet[n]) System.out.println(n + " is not prime."); 
        	else {
        		if(em(n)) System.out.println(n + " is emirp.");
        		else System.out.println(n + " is prime.");
        	}
        }
	}
}
 