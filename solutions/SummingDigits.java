import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int n;
		while((n = scan.nextInt()) != 0) {
			int sum = 0;
			while(n != 0) {
				sum += n%10;
				n /= 10;
				if(n == 0 && sum >= 10) {
					n = sum;
					sum = 0;
				}
			}
			System.out.println(sum);
		}
	}
}