package spaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//No funca ... en cuarentena xd xdxdxdxdx
public class PaythePrice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int A[][] = new  int[5000][5000];
        for(int i=0;i<5000;i++){
            A[i][0] = 1;
        }
        for(int i =1;i<5000;i++){
            A[0][i] = 0;
        }

        for(int j=1;j<5000;j++){
            for(int i=1;i<5000;i++){
                int v,w;
                if(i<j){
                    v = A[j-1][i];
                }
                else{
                    v = A[j][i-j];
                }
                w = A[j-1][i];
                A[i][j] =  v+w;
            }
        }
        String cad;
        while((cad = br.readLine())!= null && !(cad.isEmpty())){
            String [] cadTemp =cad.split(" ");
            switch (cadTemp.length){
                case 1 :int a = Integer.parseInt(cadTemp[0]);
                    pw.println(A[a][a]);
                    break;
                case 2 :int b = Integer.parseInt(cadTemp[0]);
                    int c = Integer.parseInt(cadTemp[1]);
                    pw.println(A[c][b]);
                    break;
                case 3 :int d = Integer.parseInt(cadTemp[0]);
                    int e = Integer.parseInt(cadTemp[1]);
                    int f = Integer.parseInt(cadTemp[2]);
                    int sum=0;
                    for(int i=e;i<=f;i++){
                        sum +=A[i][d];
                    }
                    pw.println(sum);
            }
        }


        pw.flush();
        pw.close();
    }

}