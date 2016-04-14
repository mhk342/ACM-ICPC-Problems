import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        float pos = 0;
        float gas = 0;
        float driveRate = 0;
        ArrayList<Float> gasUsage = new ArrayList<Float>();
        float leakRate = 0;
        boolean flag = true;
        while(scan.hasNext()) {
            float newPos = (float)scan.nextInt();
            float dif = newPos - pos;

            pos = newPos;
            gas += driveRate * dif;
            gas += leakRate * dif;
            String s = scan.next();

            switch(s) {
            case "Fuel":
                String skip = scan.next();
                float n = (float)scan.nextInt();
                if(n == 0) System.exit(0);
                driveRate = n / 100;
                break;
            case "Goal":
                gasUsage.add(gas);
                System.out.printf("%.3f\n", Collections.max(gasUsage));
                pos = 0;
                gasUsage = new ArrayList<Float>();
                gas = 0;
                driveRate = 0;
                leakRate = 0;
                break;
            case "Leak":
                leakRate++;
                break;
            case "Mechanic":
                leakRate = 0;
                break;
            case "Gas":
                String skip2 = scan.next();
                gasUsage.add(gas);
                gas = 0;
                break;    
            }                                 
        }
	}
}
 