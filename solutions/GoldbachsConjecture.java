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
		for(int i = 2; i < primeSet.length; i++) {
			if(primeSet[i]) list.add(i);
		}
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        primeSet = new boolean[1000001];
        list = new ArrayList<Integer>();
        Arrays.fill(primeSet, true);
        fillPrime();
        while(scan.hasNext()) {	
        	int n = scan.nextInt();
        	if (n == 0) break;
        	int a = 0;
        	int b = 0;
        	for(Integer i: list) {
        		if(primeSet[n-i]) {
        			a = i;
        			b = n-i;
        			break;
        		}
        		if(i > n) break;
        	}
        	if(a == 0) System.out.println("Goldbach's conjecture is wrong.");
        	else System.out.println(n + " = " + a + " + " + b);
        }   
	}
}
 