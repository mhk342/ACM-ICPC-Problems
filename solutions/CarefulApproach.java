import java.util.*;
import java.io.*;
 
public class Main {
	static int[] planes = new int[8];
	static int[] arr = new int[8];
	static double[] intervalStart = new double[8];
	static double[] intervalEnd = new double[8];
	static double maxTime;
	static int n, i;
	static double time;
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int count = 0;
        while(true) {
        	n = scan.nextInt(); //# ariplanes
        	if(n == 0) System.exit(0);
        	for(i = 0; i < n; i++) {
        		arr[i] = i;
        		planes[i] = i;
        		intervalStart[i] = scan.nextDouble() * 60;
        		intervalEnd[i] = scan.nextDouble() * 60;
        	}
        	count++;
        	maxTime = -1;
        	process(0, (1 << n) -1);
        	
        	maxTime = (int)(maxTime + .5);
        	int minutes = (int)maxTime % 60;
        	System.out.printf("Case " + count + ": " +(int) maxTime/60 + ":");
        	if(minutes < 10) System.out.printf("0");
        	System.out.printf("%d\n", minutes);
        	
        }
	}
	static double getTime() {
		double lastTimes =  intervalStart[planes[0]];
		for(i = 1; i < n; i++) {
			double landTime = lastTimes + time;
			if(landTime <= intervalEnd[planes[i]]) {
				lastTimes = Math.max(intervalStart[planes[i]], landTime);
			}
			else return 1;
		}
		return lastTimes - intervalEnd[planes[n-1]];
	}
	
	static int bitAnd(int x) { return x & (-x); }
	
	static void process(int pos, int count) {
		if(pos == n) {
			double min = 0;
			double max = 86400;
			time = -1;
			while(Math.abs(min-max) >= .001) {
				time = (min + max) / 2.0;
				double result = getTime();
				if (result <= .01) min = time;
				else max = time;
			}
			maxTime = Math.max(maxTime, time);
			return;
		}
		int size = count;
		while(size > 0) {
			int tmp = bitAnd(size);
			size -= tmp;
			i = (int)(Math.log(tmp) / Math.log(2));
			planes[pos] = arr[i]; 
			process(pos + 1, count - tmp);
		}
	}
}
 