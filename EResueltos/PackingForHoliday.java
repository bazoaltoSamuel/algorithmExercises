package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PackingForHoliday {
    //12372
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int m=1, n = Integer.parseInt(br.readLine());
        while (n>0){
            int l,w,h;
            String cad = "bad";
            String [] cadTemp = br.readLine().split(" ");
            l = Integer.parseInt(cadTemp[0]);
            w = Integer.parseInt(cadTemp[1]);
            h = Integer.parseInt(cadTemp[2]);
            if(l<=20 && w<=20 && h <=20) cad = "good";
            pw.println("Case "+String.valueOf(m)+": "+cad);
            m++;
            n--;
        }
        pw.flush();
        pw.close();
    }
}
