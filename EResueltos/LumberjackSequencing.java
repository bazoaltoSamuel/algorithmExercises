
package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LumberjackSequencing {
    //11942
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Lumberjacks:");
        int n = Integer.parseInt(br.readLine());
        while(n>0){
            String [] cadTemp = br.readLine().split(" ");
            boolean asc = false,desc=false;
            int a = Integer.parseInt(cadTemp[0]);
            for(int i=1;i<cadTemp.length;i++){
                if(Integer.parseInt(cadTemp[i])>=a)asc = true;
                else if(Integer.parseInt(cadTemp[i])<=a)desc = true;
                a = Integer.parseInt(cadTemp[i]);
            }
            if(asc && desc)pw.println("Unordered");
            else pw.println("Ordered");
            n--;
        }
        pw.flush();
        pw.close();
    }
}
