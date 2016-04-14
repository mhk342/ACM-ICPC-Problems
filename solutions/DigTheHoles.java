import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int rounds =  scan.nextInt();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('R', 0);
		hm.put('O', 1);
		hm.put('Y', 2);
		hm.put('G', 3);
		hm.put('B', 4);
		hm.put('V', 5);
		
		
		while(rounds-- > 0) {
			
			char[] c1 = scan.next().toCharArray();
			int[] i1 = new int[4];
			for(int i = 0; i < 4; i++) {
				i1[i] = hm.get(c1[i]);
			}
			int a1 = scan.nextInt();
			int a2 = scan.nextInt();
			int a3 = a1 + a2;
			char[] c2 = scan.next().toCharArray();
			int[] i2 = new int[4];
			for(int i = 0; i < 4; i++) {
				i2[i] = hm.get(c2[i]);
			}
			int b1 = scan.nextInt();
			int b2 = scan.nextInt();
			int b3 = b1 + b2;
			boolean flag = false;
			
			for(int i = 0; i < 6; i++)
			for(int j = 0; j < 6; j++)
			for(int k = 0; k < 6; k++)
			for(int m = 0; m < 6; m++){
				if(i == j || i == k || i == m || j == k || j == m || k == m) continue;
				int[] arr = {i, j, k, m};
				int a = 0; int b = 0;
				
				for(int n = 0; n < 4; n++) {
					if(i1[n] == arr[n]) {
						a++;
						arr[n] = -1;
					}
				}
				
				for(int n = 0; n < 4; n++) {
					if(i1[n] == arr[n]) continue;
					for(int o = 0; o < 4; o++) {
						if(i1[n] == arr[o] && i1[o] != arr[o]) {
							arr[o] = -1;
							b++;
						}
					}
				}
				if(a == a1 && b == a2) {
					a = 0;
					b = 0;
					arr[0] = i; arr[1] = j; arr[2] = k; arr[3] = m;
					for(int n = 0; n < 4; n++) {
						if(i2[n] == arr[n]) {
							a++;
							arr[n] = -1;
						}
					}
					
					for(int n = 0; n < 4; n++) {
						if(i2[n] == arr[n]) continue;
						for(int o = 0; o < 4; o++) {
							if(i2[n] == arr[o] && i2[o] != arr[o]) {
								arr[o] = -1;
								b++;
							}
						}
						
					}
					if(a == b1 && b == b2) {
						flag = true;
						i = 10; j = 10; k = 10; m = 10;
					}
				}
			}
			
			System.out.println(flag? "Possible": "Cheat");
		}
	}
}