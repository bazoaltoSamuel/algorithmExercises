package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LanguageDetection {
    //12250
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        int n = 1;
        while(!(cad = br.readLine()).equals("#")){
            String l = "UNKNOWN";
            if(cad.equals("HOLA")) l = "SPANISH";
            else if(cad.equals("HELLO")) l = "ENGLISH";
            else if(cad.equals("HALLO")) l = "GERMAN";
            else if(cad.equals("BONJOUR")) l = "FRENCH";
            else if(cad.equals("CIAO")) l = "ITALIAN";
            else if(cad.equals("ZDRAVSTVUJTE")) l = "RUSSIAN";
            pw.println("Case "+String.valueOf(n)+": "+l);
            n++;
        }
        pw.flush();
        pw.close();
    }
}
