import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

	static int[] map;
	static ArrayList<Integer> list;
	
	public static int solve(int n) {
			int sum = 0;
			int tmp = n;
			while(tmp > 0) {
				sum += (tmp%10) * (tmp % 10);
				tmp /= 10;
			}
			return sum;
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int rounds = scan.nextInt();
        for(int i = 1; i <= rounds;i++) {
        	list = new ArrayList<Integer>();
        	int n = scan.nextInt();
        	int ans = solve(n);
        	list.add(n);
        	while(ans != 1) {
        		if(list.contains(ans)) break;
        		list.add(ans);
        		if(ans == -1) break;
        		ans = solve(ans);
        	}
        	if(ans == 1) System.out.println("Case #" + i + ": " + n + " is a Happy number.");
        	else System.out.println("Case #" + i + ": " + n + " is an Unhappy number.");
        }
	}
}
 