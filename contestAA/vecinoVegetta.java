package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class vecinoVegetta {


    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        String cadTem[];
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n;
            while(true) {
                if((cad = br.readLine())!= null && !(cad.isEmpty())){
                    n = Integer.parseInt(cad);
                    break;
                }
            }
            ArrayList<String[]> lista = new ArrayList<>();
            while(n>0) {
                cadTem = br.readLine().split(" ");
                lista.add(cadTem);
                n--;
            }
            //cad = br.readLine();
            int min = 1000000;
            String res = "";
            for(String [] arr:lista){
                min = Math.min(min,arr.length);
            }
            for(int i=0;i<lista.size();i++){
                if(lista.get(i).length==min) res +=  String.valueOf(i+1)+" ";
            }
            res = res.substring(0,res.length()-1);

            pw.println(res);
            t--;
        }

        pw.flush();
        pw.close();
    }

}
