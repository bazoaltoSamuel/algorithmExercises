package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Parking {
    //11364
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int c,t;
        c = Integer.parseInt(br.readLine());
        while(c>0){
            t = Integer.parseInt(br.readLine());
            ArrayList<Integer> tiendas = new ArrayList<>();
            String [] cadTemp = br.readLine().split(" ");
            for(int i=0;i<t;i++){
                tiendas.add(Integer.parseInt(cadTemp[i]));
            }
            Collections.sort(tiendas);
            int a,b,l,p,sd,si,h;
            l = tiendas.size();
            if(l%2 == 0){
                a = tiendas.get((l/2)-1);
                b = tiendas.get((l/2));
                p = a/b;
                sd = 0; si = 0;
                sd = tiendas.get((l/2)-1)-tiendas.get(0);
                si = tiendas.get(t-1)-tiendas.get((l/2));
                h = sd+si+(p-a)+(b-p)+(tiendas.get(t-1)-tiendas.get(0));

            }
            else{
                a = tiendas.get((l/2));
                p = a;
                sd = 0; si = 0;
                sd = tiendas.get((l/2))-tiendas.get(0);
                si = tiendas.get(t-1)-tiendas.get((l/2));
                h = sd+si+(tiendas.get(t-1)-tiendas.get(0));
            }
            pw.println(h);
            c--;
        }

        pw.flush();
        pw.close();
    }
}
