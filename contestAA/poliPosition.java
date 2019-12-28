package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class poliPosition {public static void main(String [] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n;
    while((n = Integer.parseInt(br.readLine()))!=0){
        int pos[] = new int[n];
        int pas[] = new int[n];
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            String []cadTemp = br.readLine().split(" ");
            pos[i] = Integer.parseInt(cadTemp[0]);
            pas[i] = Integer.parseInt(cadTemp[1]);
        }
        boolean band = true;
        for(int i=0;i<n;i++){
            int a = i+pas[i];
            if(a>=0 && a<n){
                if(res[a]==0){
                    res[a] = pos[i];
                }
                else{
                    band = false;
                    break;
                }
            }
            else {
                band = false;
                break;
            }
        }
        if(!band){
            pw.println(-1);
        }
        else{
            for(int i=0;i<n;i++){
                if(i==n-1){
                    pw.println(res[i]);
                }
                else {
                    pw.print(res[i] + " ");
                }
            }
        }

    }

    pw.flush();
    pw.close();
}
}