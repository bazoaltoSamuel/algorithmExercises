package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SummingDigits {
    //11332
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        while(!(cad = br.readLine()).equals("0")){
            while(Integer.parseInt(cad)>9){
                String [] cadTemp = cad.split("");
                int n=0;
                for(int i=0;i<cadTemp.length;i++){
                    n += Integer.parseInt(cadTemp[i]);
                }
                cad = String.valueOf(n);
            }
            pw.println(cad);
        }
        pw.flush();
        pw.close();
    }
}
