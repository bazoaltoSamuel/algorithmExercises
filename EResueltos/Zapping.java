package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Zapping {
    //12468
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        while (!(cad = br.readLine()).equals("-1 -1")){
            String [] cadTemp = cad.split(" ");
            int a,b,c,d;
            a = Integer.parseInt(cadTemp[0]);
            b = Integer.parseInt(cadTemp[1]);
            if(b>a) {
                c = b - a;
                d = (a + 1) + (99 - b);
            }
            else{
                c = a-b;
                d = (b+1)+(99-a);
            }
            if (c < d) pw.println(c);
            else pw.println(d);
        }
        pw.flush();
        pw.close();
    }
}
