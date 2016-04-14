import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

	static int[] a;
	static int[] b;
	static ArrayList<Integer>[] adj;
	static int[][] caps;
	static int source;
	static int sink;
	static double[][] map;
	static double[][] dist;
	
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int count = 0;
        while(scan.hasNext()) {
        	count++;
        	int size = scan.nextInt();
        	if(size == 0) break;
        	HashMap<String, Integer> hm = new HashMap<String, Integer>();
        	double[][] dist = new double[size][size];
        	
        	for(int i = 0; i < size; i++) {
        		hm.put(scan.next(), i);
        		Arrays.fill(dist[i], 0);
        		dist[i][i] = 1;
        	}
        	
        	int rels = scan.nextInt();
        	
        	for(int i = 0; i < rels; i++) {
        		String start = scan.next();
        		double rate = scan.nextDouble();
        		String end = scan.next();
        		dist[hm.get(start)][hm.get(end)] = rate;
        	}
        	
        	for(int k =0; k < size; k++) {
        		for(int i = 0; i < size; i++) {
        			for(int j = 0; j < size; j++) {
        				dist[i][j] = Math.max(dist[i][j], dist[i][k] * dist[k][j]);
        			}
        		}
        	}
        	
        	boolean flag = false;
        	for(int i = 0; i < size; i++) {
        		if(dist[i][i] > 1.0) {
        			flag = true;
        			break;
        		}
        	}
        	if(flag) System.out.println("Case " + count + ": Yes");
        	else System.out.println("Case " + count + ": No");
        }
	}
}
 