import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = scan.readLine()) != null){
			ArrayDeque<StringBuilder> arr = new ArrayDeque<StringBuilder>();
			StringBuilder ss = new StringBuilder();
			StringBuilder frag = new StringBuilder();
			boolean end = true;
			for(char c: s.toCharArray()) {
				if(c == '[') {
					if(end) arr.add(frag);
					else arr.addFirst(frag);
					end = false;
					frag = new StringBuilder();
				}
				else if (c == ']') {
					if(end) arr.add(frag);
					else arr.addFirst(frag);
					end = true;
					frag = new StringBuilder();
				}
				else frag.append(c);
			}
			if(end) arr.add(frag);
			else arr.addFirst(frag);
			for (StringBuilder sss: arr){
				ss.append(sss);
			}
			System.out.println(ss);	
		}
	}
}