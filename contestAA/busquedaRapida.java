package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class busquedaRapida {

    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        ArrayList<String> basura = new ArrayList<>();
        while(!(cad = br.readLine()).equalsIgnoreCase("::")){
            basura.add(cad);
        }
        ArrayList<Struct> clave = new ArrayList<>();
        while((cad = br.readLine())!= null && !cad.isEmpty()){

            cad = cad.toLowerCase();
            String c ="";
            boolean band = true;
            int i;
            for(i =0;i<cad.length();i++){
                if(cad.charAt(i)==' '){
                    if(!c.isEmpty()) {
                        if(!basura.contains(c)) {
                            clave.add(new Struct(cad, c, i - c.length()));
                        }
                    }
                    c = "";
                }
                else if(band) c +=cad.charAt(i);
            }
            if(!cad.isEmpty()) {
                if(!basura.contains(c)) {
                    clave.add(new Struct(cad, c, i - c.length()));
                }
            }
        }
        Collections.sort(clave);
        for(Struct s : clave){
            pw.println(s.toString());
        }

        pw.flush();
        pw.close();
    }


    static class Struct implements Comparable<Struct>{
        String titulo;
        String clave;
        int pos;

        public Struct(String titulo,String clave,int pos){
            this.titulo = titulo;
            this.clave = clave;
            this.pos = pos;
        }

        @Override
        public String toString() {
            String cad = titulo.substring(0,pos)+clave.toUpperCase()+titulo.substring(pos+clave.length(),titulo.length());
            return cad;
        }

        @Override
        public int compareTo(Struct o) {

            return clave.compareTo(o.clave);
        }
    }

}