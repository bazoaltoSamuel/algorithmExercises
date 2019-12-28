package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class containers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        int m = 1;
        while(!(cad = br.readLine()).equals("end")){
            ArrayList<Character> lista = new ArrayList<>();
            for(int i=0;i<cad.length();i++){
                if(lista.isEmpty()){
                    lista.add(cad.charAt(i));
                }
                else{
                    boolean band = false;
                    for(int j=0;j<lista.size();j++){
                        if(cad.charAt(i)==lista.get(j)){
                            band = true;
                            break;
                        }
                    }
                    if(!band){
                        for(int j=0;j<lista.size();j++){
                            if(cad.charAt(i)<lista.get(j)){
                                lista.set(j,cad.charAt(i));
                                band = true;
                                break;
                            }
                        }
                    }
                    if(!band)lista.add(cad.charAt(i));

                }

            }
            pw.println("Case "+m+": "+lista.size());
            m++;

        }
        pw.flush();
        pw.close();
    }
}
