import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int size = scan.nextInt();
			int scarecrows = 0;
			String skip = scan.nextLine();
			char[] field = scan.nextLine().toCharArray();
			int pos = 0;
			while (pos < size) {
				if(field[pos] == '.') {
					if(pos < size - 1) {
						pos = pos + 3;
						scarecrows++;
					}
					else {
						pos = pos + 2;
						scarecrows++;
					}
				}
				else {
					pos++;
				}
			}
			System.out.println("Case " + (i + 1) + ": " + scarecrows);
		}
	}
}