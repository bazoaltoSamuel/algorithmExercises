package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HajjEAkbar {
    //12577
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        int n = 1;
        while(!(cad = br.readLine()).equals("*")){
            String res = "Hajj-e-Asghar";
            if(cad.length()==4) res = "Hajj-e-Akbar";
            pw.println("Case "+String.valueOf(n)+": "+res);
            n++;
        }
        pw.flush();
        pw.close();
    }
}
