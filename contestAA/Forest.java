package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Forest {

    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad,aux;
        int n,a,b;
        n = Integer.parseInt(br.readLine());
        while(n>0){
            while((cad = br.readLine())!= null && cad.isEmpty()){}

            String [] cadTemp = cad.split(" ");
            a = Integer.parseInt(cadTemp[0]);
            b = Integer.parseInt(cadTemp[1]);

            int [][] ls = new int[a][b];
            while((cad = br.readLine())!= null && !cad.isEmpty()){
                cadTemp = cad.split(" ");
                a = Integer.parseInt(cadTemp[0]);
                b = Integer.parseInt(cadTemp[1]);
                ls[a-1][b-1] = 1;
            }

            ArrayList<String> res = new ArrayList<>();

            for(int [] i : ls){
                aux = "";
                for(int j : i){
                    aux +=String.valueOf(j);
                }
                if(res.isEmpty()){
                    res.add(aux);
                }
                else{
                    if(!res.contains(aux)){
                        res.add(aux);
                    }
                }
            }
            pw.println(res.size());
            if(n!=1) {
                pw.println("");
            }

            n--;
        }
        pw.flush();
        pw.close();
    }

}
