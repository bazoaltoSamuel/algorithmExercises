package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class futbolorden {public static void main(String [] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int n,m,z=0;
    String cad;
    while(!(cad = br.readLine()).equals("0 0")){
        if(z>0) pw.println("");
        String cadTemp[] = cad.split(" ");
        n = Integer.parseInt(cadTemp[0]);
        m = Integer.parseInt(cadTemp[1]);
        ArrayList<Equipo> lista = new ArrayList<>();
        while(n>0){
            cad = br.readLine();
            lista.add(new Equipo(cad));
            n--;
        }

        while(m >0){
            cadTemp = br.readLine().split(" ");
            String t1 = cadTemp[0];
            int r1 = Integer.parseInt(cadTemp[1]);
            int r2 = Integer.parseInt(cadTemp[3]);
            String t2 = cadTemp[4];
            for(int i =0;i<lista.size();i++){
                Equipo eq = lista.get(i);
                if(eq.getName().equals(t1)){
                    eq.regPart(r1,r2);
                }
                else if(eq.getName().equals(t2)){
                    eq.regPart(r2,r1);
                }
            }

            m--;
        }

        Collections.sort(lista);
        for(int i =0;i<lista.size();i++){
            if(i>0){
                if(lista.get(i).iguales(lista.get(i-1))==0){
                    String cad1 = "%3s"+lista.get(i).toString();
                    cad1 = String.format(cad1,"");
                    pw.println(cad1);
                }
                else {
                    String cad1 = "%2s."+lista.get(i).toString();
                    cad1 = String.format(cad1,String.valueOf(i+1));
                    pw.println(cad1);
                }
            }
            else{
                String cad1 = "%2s."+lista.get(i).toString();
                cad1 = String.format(cad1,String.valueOf(i+1));
                pw.println(cad1);
            }
        }
        z++;
    }

    pw.flush();
    pw.close();
}

    static class Equipo implements Comparable<Equipo>{

        private String name;
        private int puntos,partJug,golFavor,golContra,difGol;
        private double porcentaje;

        public Equipo(String name){
            this.name = name;
            puntos = 0;
            partJug = 0;
            golFavor = 0;
            golContra = 0;
            difGol = 0;
            porcentaje = 0.00;
        }

        public void regPart(int goles,int golesRec){
            if(goles == golesRec){
                setPuntos(1);
            }
            else if(goles > golesRec){
                setPuntos(3);
            }
            else setPuntos(0);
            setPartJug(1);
            setGolFavor(goles);
            setGolContra(golesRec);
            setDifGol(this.golFavor-this.golContra);
            setPorcentaje(Math.round(((100.00*(double)this.puntos)/((double)this.getPartJug()*3.00))*100)/100d);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPuntos() {
            return puntos;
        }

        public void setPuntos(int puntos) {
            this.puntos += puntos;
        }

        public int getPartJug() {
            return partJug;
        }

        public void setPartJug(int partJug) {
            this.partJug += partJug;
        }

        public int getGolFavor() {
            return golFavor;
        }

        public void setGolFavor(int golFavor) {
            this.golFavor += golFavor;
        }

        public int getGolContra() {
            return golContra;
        }

        public void setGolContra(int golContra) {
            this.golContra += golContra;
        }


        public int getDifGol() {
            return difGol;
        }

        public void setDifGol(int difGol) {
            this.difGol = difGol;
        }

        public double getPorcentaje() {
            return porcentaje;
        }

        public void setPorcentaje(double porcentaje) {
            this.porcentaje = porcentaje;
        }

        @Override
        public String toString() {
            String cad =  "%16s  %2s  %2s  %2s  %2s  %2s %6s";
            if(this.puntos==0&&this.partJug==0 && this.golFavor==0&&this.golContra==0 && this.difGol==0){
                cad = String.format(cad,this.name,String.valueOf(this.puntos),String.valueOf(this.partJug),String.valueOf(this.golFavor),String.valueOf(this.golContra),
                        String.valueOf(this.difGol),"N/A");
            }
            else if(porcentaje%10 ==0.0) {
                String cadA = "";
                switch (String.valueOf(porcentaje)){
                    case "100.0" : cadA="100.00";break;
                    case "90.0" : cadA = "90.00";break;
                    case "80.0" : cadA="80.00";break;
                    case "70.0" : cadA = "70.00";break;
                    case "60.0" : cadA="60.00";break;
                    case "50.0" : cadA = "50.00";break;
                    case "40.0" : cadA="40.00";break;
                    case "30.0" : cadA = "30.00";break;
                    case "20.0" : cadA="20.00";break;
                    case "10.0" : cadA = "10.00";break;
                    case "0.0" : cadA = "0.00";break;

                }
                cad = String.format(cad,this.name,String.valueOf(this.puntos),String.valueOf(this.partJug),String.valueOf(this.golFavor),String.valueOf(this.golContra),
                        String.valueOf(this.difGol),cadA);
            }
            else{
                cad = String.format(cad,this.name,String.valueOf(this.puntos),String.valueOf(this.partJug),String.valueOf(this.golFavor),String.valueOf(this.golContra),
                        String.valueOf(this.difGol),String.valueOf(this.porcentaje));
            }
            return cad;
        }

        public int iguales(Equipo o) {
            int res = 0;
            if(this.puntos>o.getPuntos()||this.getDifGol()>o.getDifGol()||this.golFavor>o.getGolFavor()){
                res = 1;
            }
            else if(this.puntos<o.getPuntos()||this.getDifGol()<o.getDifGol()||this.golFavor<o.getGolFavor()){
                res = -1;
            }
            return res;
        }

        @Override
        public int compareTo(Equipo o) {
            int res = 0;
            if(this.puntos>o.getPuntos()||this.getDifGol()>o.getDifGol()||this.golFavor>o.getGolFavor()){
                res = -1;
            }
            else if(this.puntos<o.getPuntos()||this.getDifGol()<o.getDifGol()||this.golFavor<o.getGolFavor()){
                res = 1;
            }

            if(res==0) {
                res = this.name.toLowerCase().compareTo(o.getName().toLowerCase());
            }
            return res;
        }
    }

}