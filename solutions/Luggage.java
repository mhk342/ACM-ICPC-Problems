import java.util.*;
import java.io.*;
 
public class Main {
	static Integer[][] dp = new Integer[1000][1000];
	static int[] list; 
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        String skip = scan.nextLine();
        while(m-- > 0) {
        	String s = scan.nextLine();
        	String[] ar = s.split(" ");
        	int size = ar.length;
        	list = new int[1000];
        	int count=0;
        	for(String ss: ar) {
        		list[count++] = (Integer.parseInt(ss));
        	}
        	int sum = 0;
        	for(int i: list) {
        		sum += i;
        	}
        	if(sum % 2 == 1 ){
        		System.out.println("NO");
        		continue;
        	}
        	else {
        		for(Integer[] array : dp) {
        			Arrays.fill(array, -1);
        		}
        		int goal = sum / 2;
        		if(process(goal, size -1) != goal) System.out.println("NO");
        		else System.out.println("YES");
        	}
        }
	}
	
	static int process(int x, int y){
		if ( y < 0 )	return 0;
		if ( dp[x][y] != -1 ) return dp[x][y];
		if ( x >= list[y]){
			return dp[x][y] = Math.max(list[y] + process(x - list[y], y - 1), process(x, y - 1));
		}else{
			return dp[x][y] = process(x, y - 1);
		}
	}
}
 