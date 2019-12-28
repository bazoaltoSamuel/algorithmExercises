package ETocaPelotas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EmoogleBalance {
    //Me da Runtime error
    //12279
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n,m =1;
        while((n=Integer.parseInt(br.readLine()))  != 0){
            int c=0,d=0,e=0;
            String [] cadTemp = br.readLine().split(" ");
            for(int i =0;i<n;i++){
                if(Integer.parseInt(cadTemp[i])==0)c++;
                else d++;
            }
            e = d-c;
            pw.println("Case "+String.valueOf(m)+": "+String.valueOf(e));
            m++;
        }
        pw.flush();
        pw.close();
    }
}
