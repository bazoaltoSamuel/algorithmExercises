package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AutomaticAnswer {
    //11547
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t,n;
        t = Integer.parseInt(br.readLine());
        while(t>0){
            int a,b;
            n = Integer.parseInt(br.readLine());
            a = ((((((n*567)/9)+7492)*235)/47)-498);
            b = (a/10)%10;
            if(b<0) b = b*-1;
            pw.println(b);
            t--;
        }
        pw.flush();
        pw.close();
    }
}
