package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SearchingForNessy {
    //11044
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int a,b,n;
        n = Integer.parseInt(br.readLine());
        while (n>0){
            String [] cadTemp = br.readLine().split(" ");
            int p;
            a = Integer.parseInt(cadTemp[0]);
            b = Integer.parseInt(cadTemp[1]);
            while(a%3 != 0)a--;
            while(b%3 != 0)b--;
            p = (a*b)/9;
            pw.println(p);
            n--;
        }

        pw.flush();
        pw.close();
    }
}
