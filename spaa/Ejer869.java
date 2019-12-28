package spaa;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ejer869 {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Ejer869.UVA869 solver = new Ejer869.UVA869();
        solver.solve(in,out);
        out.close();
    }



    static class UVA869 {
        final int INF = (int) 1e6;

        public void solve(Scanner in,PrintWriter out){
            int n = in.nextInt();
            while(n-->0){
                int [][] dist = new int[26][26];
                int [][] dist1 = new int[26][26];
                for(int i=0;i<26;i++){
                    Arrays.fill(dist[i],INF);
                    dist[i][i] =0;
                    Arrays.fill(dist1[i],INF);
                    dist1[i][i] =0;
                }

                int v = in.nextInt();

                for(int i=0;i<v;i++){
                    String uName = in.next();
                    String vName = in.next();
                    dist[uName.charAt(0)-'A'][vName.charAt(0)-'A']= 1;
                    dist[vName.charAt(0)-'A'][uName.charAt(0)-'A']= 1;//A = 64
                }
                v = in.nextInt();

                for(int i=0;i<v;i++){
                    String uName = in.next();
                    String vName = in.next();
                    dist1[uName.charAt(0)-'A'][vName.charAt(0)-'A']= 1;
                    dist1[vName.charAt(0)-'A'][uName.charAt(0)-'A']= 1;//A = 64
                }

                for(int k=0;k<26;k++){
                    for(int i=0;i<26;i++){
                        for(int j=0;j<26;j++){
                            dist[i][j] = Integer.min(dist[i][j],dist[i][k]+dist[k][j]);

                            dist1[i][j] = Integer.min(dist1[i][j],dist1[i][k]+dist1[k][j]);
                        }
                    }
                }

                boolean isSame = true;
                for(int i=0;i<26;++i){
                    for(int j=0;j<26;j++){
                        if((dist[i][j]==INF && dist1[i][j]!=INF)|| (dist[i][j]!=INF && dist1[i][j]==INF)){
                            isSame = false;
                        }
                    }
                }
                if(isSame){
                    out.println("YES");
                }
                else {
                    out.println("NO");
                }
                if(n!=0) out.println("");
            }
        }


    }
}
