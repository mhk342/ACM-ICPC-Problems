import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {

	static boolean[][] map;
	static String[] drinks;
	static int[] weakerCount;
	static boolean[] used;
	
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int round = 0;
        while(scan.hasNext()) {
        	round++;
        	int drinksCount = scan.nextInt();
        	drinks = new String[drinksCount];
        	map = new boolean[drinksCount][drinksCount];
        	weakerCount = new int[drinksCount];
        	used =  new boolean[drinksCount];
        	Arrays.fill(used, false);
        	Arrays.fill(weakerCount, 0);
        	for(int i = 0; i < drinksCount; i++) {
        		drinks[i] = scan.next();
        		Arrays.fill(map[i], false);
        	}
        	int relCount = scan.nextInt();
        	for(int i = 0; i < relCount; i++) {
        		String weaker = scan.next();
        		String stronger = scan.next();
        		int weakIndex = Arrays.asList(drinks).indexOf(weaker);
        		int strongIndex = Arrays.asList(drinks).indexOf(stronger);
        		if(!map[weakIndex][strongIndex]){
        			map[weakIndex][strongIndex] = true;
        			weakerCount[strongIndex]++;
        		}
        		
        	}
        	
        	System.out.printf("Case #" + round + ": Dilbert should drink beverages in this order:");
        	for(int i = 0; i < drinksCount; i++) {
    			if(chain(i)) {
    				System.out.printf(" %s", drinks[i]);
    				i = -1;
    			}
        	}
        	System.out.println(".\n");
        }
	}
	
	
	static boolean chain(int drink) {
		if(!used[drink] && weakerCount[drink] == 0) {
			used[drink] = true;
			for(int i = 0; i < weakerCount.length; i++) {
				if(map[drink][i]) weakerCount[i]--;
			}
			return true;
		}
		return false;
	}
