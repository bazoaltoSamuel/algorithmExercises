package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ColaImpresion {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T,n,m,aux,ans,pos,print;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int prioridad[] = new int[100];
            boolean impresos[] = new boolean[100];

            String cadTemp[] = br.readLine().split(" ");
            n = Integer.parseInt(cadTemp[0]);
            m = Integer.parseInt(cadTemp[1]);

            cadTemp = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                prioridad[j] = Integer.parseInt(cadTemp[j]);
            }

            pos = 0;
            ans = 0;

            while (!impresos[m]) {
                print = -1;
                ans++;

                for (int k = 0; k < n; k++) {
                    if (!impresos[(pos + k) % n] && (print == -1 || prioridad[(pos + k) % n] > prioridad[print])){
                        print = (pos + k) % n;
                    }
                }

                impresos[print] = true;
                pos = print;
            }

            pw.println(ans);
        }

        pw.flush();
        pw.close();
    }
}
