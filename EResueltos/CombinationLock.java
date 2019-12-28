package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CombinationLock {
    //10550
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int a,b,c,d,g;
        boolean band = true;
        while( band){
            String[] cadTem= br.readLine().split(" ");
            a = Integer.parseInt(cadTem[0]);
            b = Integer.parseInt(cadTem[1]);
            c = Integer.parseInt(cadTem[2]);
            d = Integer.parseInt(cadTem[3]);
            g = 0;
            if(a==0 && b==0 && c==0 && d==0){
                band = false;
            }
            else{
                g = g+120;
                if((a-b)<0) g = g+(a-b+40);
                else g = g+(a-b);
                if((c-b)<0) g = g +(c-b+40);
                else g = g+(c-b);
                if((c-d)<0) g = g+(c-d+40);
                else g = g+(c-d);
                g = g*9;
                pw.println(g);

            }

        }
        pw.flush();
        pw.close();
    }
}
