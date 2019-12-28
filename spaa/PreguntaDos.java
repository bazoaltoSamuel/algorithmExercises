package spaa;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PreguntaDos {char [][]patron;
    char [][]text;
    public void solve(Scanner in, PrintWriter out){
        String cad;
        //Leemos el patron
        int tp = in.nextInt();
        patron = new char[tp][tp];
        for(int i=0;i<tp;i++){
            cad = in.next();
            patron[i] = cad.toCharArray();
        }

        //Leemos el texto;
        int tt = in.nextInt();
        text = new char[tt][tt];
        for(int i=0;i<tt;i++){
            cad = in.next();
            text[i] = cad.toCharArray();
        }

        ArrayList<Par> lista = new ArrayList<>();

        for(int i=0;i<=(tt-tp);i++){
            for(int j=0;j<=(tt-tp);j++){
                if(esIgual(i,j)){
                    lista.add(new Par(i,j));
                }
            }
        }

        out.println(lista.size());
        for(Par p :lista){
            out.println(p.toString());
        }




        out.flush();
    }

    public boolean esIgual(int x,int y){
        int i = x;
        boolean esIgual = true;
        for(int k=0;k<patron.length;k++){
            int j = y;
            for(int h=0;h<patron[k].length;h++){
                esIgual &= patron[k][h] == text[i][j];
                j++;
            }
            i++;
        }
        return esIgual;
    }
    class Par{
        int x;
        int y;
        public Par(int x,int y){
            this.x =x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String toString(){
            return getX()+" "+getY();
        }
    }
}


