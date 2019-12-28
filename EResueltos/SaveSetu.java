package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SaveSetu {
    //12403
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int c=0,t = Integer.parseInt(br.readLine());
        while (t>0){
            int m;
            String [] cadTemp = br.readLine().split(" ");
            if(cadTemp.length == 1){
                pw.println(c);
            }
            else{
                m = Integer.parseInt(cadTemp[1]);
                c +=m;
            }
            t--;
        }
        pw.flush();
        pw.close();
    }
}
