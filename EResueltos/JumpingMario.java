package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JumpingMario {
    //11764
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t,n=1;
        t = Integer.parseInt(br.readLine());
        while(t>0){
            int c,b,d,e=0,f=0;
            c = Integer.parseInt(br.readLine());
            String [] cadTemp = br.readLine().split(" ");
            d = Integer.parseInt(cadTemp[0]);
            for(int i=1;i<cadTemp.length;i++){
                b = Integer.parseInt(cadTemp[i]);
                if(b>d)e++;
                else if(b<d) f++;

                d = Integer.parseInt(cadTemp[i]);
            }
            pw.println("Case "+n+": "+e+" "+f);
            n++;
            t--;
        }
        pw.flush();
        pw.close();
    }
}
