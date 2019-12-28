package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DivisionOfNlogonia {
    //11498
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int k,n,m,a,b;
        while((k = Integer.parseInt(br.readLine()))!=0){
            String [] cadTemp = br.readLine().split(" ");
            n = Integer.parseInt(cadTemp[0]);
            m = Integer.parseInt(cadTemp[1]);
            while(k>0){
                String cad = "";
                String [] cadTemp1 = br.readLine().split(" ");
                a = Integer.parseInt(cadTemp1[0]);
                b = Integer.parseInt(cadTemp1[1]);
                if(n==a || m==b) cad = "divisa";
                else if(a>n && b>m) cad = "NE";
                else if(a>n&& b<m) cad = "SE";
                else if(a<n && b>m) cad = "NO";
                else if(a<n&& b<m) cad = "SO";
                pw.println(cad);
                k--;
            }

        }
        pw.flush();
        pw.close();
    }
}
