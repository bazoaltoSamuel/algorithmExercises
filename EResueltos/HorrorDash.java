package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HorrorDash {
    //11799

    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int m=1,n = Integer.parseInt(br.readLine());
        while(n>0){
            String [] cadTemp = br.readLine().split(" ");
            int b = 0,a = Integer.parseInt(cadTemp[0]);
            for(int i =1;i<cadTemp.length;i++){
                int c = Integer.parseInt(cadTemp[i]);
                if(c>b)b = c;
            }
            pw.println("Case "+m+": "+b);
            m++;
            n--;
        }

        pw.flush();
        pw.close();
    }
}
