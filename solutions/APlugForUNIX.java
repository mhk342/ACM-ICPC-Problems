import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[] map;
	
	private static int maxFlow(int[][] caps, int source, int sink) {
		int[] root = new int[caps.length];
		Arrays.fill(root, -1);
		int flow = 0;
		int max= 0;
		while((flow = augment(root, caps, source, sink)) != 0) {
			max+=flow;
			update(root, caps, flow, source, sink);
			Arrays.fill(root, -1);
		}
		return max;
	}
	
	private static void update(int[] root, int[][] caps, int flow, int source, int sink) {
		int cur = source;
		while(cur != sink) {
			caps[root[cur]][cur] -= flow;
			caps[cur][root[cur]] += flow;
			cur = root[cur];
		}
	}
	
	private static int augment(int[] root, int[][] caps, int source, int sink) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(sink);
		q.add(Integer.MAX_VALUE);
		while(!q.isEmpty()) {
			int n = q.poll();
			int f= q.poll();
			if(n == source) return f;
			else {
				for(int i = 0; i < caps[n].length; i++) {
					if(caps[n][i] != 0 && root[i] == -1) {
						q.add(i);
						q.add(Math.min(f, caps[n][i]));
						root[i] = n;
					}
				}
			}
			
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0) {
        	int plugs = scan.nextInt();
        	int rank = 1;
        	ArrayList<String> in = new ArrayList<String>();
        	ArrayList<String> out = new ArrayList<String>();
        	HashMap<String, Integer> hm = new HashMap<String, Integer>();
        	for(int i = 1 ; i <= plugs; i++) {
        		String plug = scan.next();
        		hm.put(plug, rank);
        		rank++;
        		out.add(plug);
        	}
        	int devices = scan.nextInt();
        	for(int i = 0; i < devices; i++) {
        		String device = scan.next();
        		String plug  = scan.next();
        		in.add(plug);
        		if(!hm.containsKey(plug)) {
        			hm.put(plug, rank);
        			rank++;
        		}
        	}
        	int adaps = scan.nextInt();
        	int[] from = new int[adaps];
        	int[] to = new int[adaps];
        	for(int i = 0; i < adaps; i++) {
        		String f = scan.next();
        		String t = scan.next();
        		if(!hm.containsKey(f)) {
        			hm.put(f, rank);
        			rank++;
        		}
        		from[i] = hm.get(f);
        		if(!hm.containsKey(t)) {
        			hm.put(t, rank);
        			rank++;
        		}
        		to[i] = hm.get(t);
        	}
        	int[][] caps = new int[rank+1][rank+1];
        	for(int i = 0; i < in.size();i++) {
        		caps[0][hm.get(in.get(i))]++;
        	}
        	for(int i = 0; i < out.size(); i++) {
        		caps[hm.get(out.get(i))][rank]++;
        	}
        	for(int i = 0; i < adaps; i++) {
        		caps[from[i]][to[i]] = Integer.MAX_VALUE;
        	}
        	int ans  = maxFlow(caps, rank ,0);
        	System.out.println(devices - ans);
        	if(cases > 0)System.out.println();
        }
        
	}

}
 