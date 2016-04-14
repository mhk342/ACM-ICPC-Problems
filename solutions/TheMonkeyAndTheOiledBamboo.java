import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int rounds = scan.nextInt();
		for (int z = 0; z < rounds; z++) {
			int size = scan.nextInt();
			int[] a = new int[size + 1];
			a[0] = 0;
			for(int i = 0; i < size; i++) {
				a[i+1] = scan.nextInt();
			}
			int str = 0;

			int max = -1;
			for(int i = 1; i < size + 1; i++) {
				int dif = a[i] - a[i-1];
				max = Math.max(dif, max);
			}
			str = max;
			for(int i = 1; i < size + 1; i++) {
				int dif = a[i] - a[i-1];
				if(dif == max) max--;
				else if(dif > max) {
					str++;
					break;
				}
				
			}
			System.out.println("Case " + (z + 1) + ": " + str);
		}
	}
}