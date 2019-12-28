package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CostCutting {
    //11727
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t,n = 1;
        t = Integer.parseInt(br.readLine());
        while(t>0){
            int a,b,c,aux;
            String [] cadTemp = br.readLine().split(" ");
            a = Integer.parseInt(cadTemp[0]);
            b = Integer.parseInt(cadTemp[1]);
            c = Integer.parseInt(cadTemp[2]);
            if(a<b){
                aux = a;
                a = b;
                b = aux;
            }
            if(a<c){
                aux = a;
                a = c;
                c = aux;
            }
            if(b<c){
                aux = b;
                b = c;
                c = aux;
            }
            pw.println("Case "+String.valueOf(n)+": "+String.valueOf(b));
            t--;
            n++;
        }
        pw.flush();
        pw.close();
    }
}
