package spaa;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class SPEjer2 {public static void main(String[] args)throws IOException {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    //Scanner in = new Scanner(inputStream);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(outputStream);
    /*SPEjer2.Segundo solver = new SPEjer2.Segundo();
    solver.solve(br,out);
    out.close();*/
}



    /*static class Segundo {
        int caramelos [];
        int memo[][];

        public void solve(BufferedReader br,PrintWriter pw)throws IOException{
            int c = Integer.parseInt(br.readLine());
            while(c-->0){
                int n = Integer.parseInt(br.readLine());
                caramelos = new int[n];
                memo = new int[10000][10000];
                int pesoDesp = Integer.parseInt(br.readLine());
                int pesoAnt = 0;
                for(int i=0;i<n;i++){
                    caramelos[i] = Integer.parseInt(br.readLine());
                    pesoAnt += caramelos[i];
                }

                for(int i=0;i<10000;i++){
                    for(int j=0;j<10000;j++) {
                        memo[i][j] = -1;
                    }
                }

                if(pesoAnt == pesoDesp){
                    pw.println("-");
                }
                else{
                    if((pesoAnt-pesoDesp) == buscador((pesoAnt-pesoDesp),n-1)){
                        int cont =0;
                        for(int i=0;i<10000;i++){
                            for(int j=0;j<10000;j++) {
                                if(pesoAnt-pesoDesp == memo[i][j]){
                                    cont++;
                                }
                            }
                        }
                        if(cont >1){
                            pw.println("Brian, Kevin faltan caramelos !!!");
                        }
                        else{
                            ArrayList sol = buscDePos(pesoAnt-pesoDesp);
                            Collections.sort(sol);

                            pw.print("Brian, Kevin faltan ");
                            for(int i=0;i<sol.size();i++){
                                pw.print((sol.get(i))+" ");
                            }
                            pw.println("!!!");
                        }

                    }
                }

            }

        }

        private int buscador(int W, int Index){
            if ( Index < 0 )	return 0;
            if ( memo[W][Index] != -1 )		return memo[W][Index];
            if ( W >= caramelos[Index]){
                return memo[W][Index] = Math.max(caramelos[Index] + buscador(W - caramelos[Index], Index - 1), buscador(W, Index - 1));
            }else{
                return memo[W][Index] = buscador(W, Index - 1);
            }
        }

        public ArrayList buscDePos(int w){
            ArrayList<Integer> sol = new ArrayList<>();
            int cont;
            boolean yaEsta = false;
            for(int i=0;i<caramelos.length;i++){
                if(!yaEsta) {
                    ArrayList<Integer> posSol = new ArrayList<>();
                    cont = caramelos[i];
                    posSol.add(i+1);
                    for (int j = 0; j < caramelos.length; j++) {
                        if(i!=j) {
                            if (cont + caramelos[j] < w) {
                                posSol.add(j+1);
                                cont += caramelos[j];
                            } else if (cont + caramelos[j] == w) {
                                posSol.add(j+1);
                                sol = posSol;
                                yaEsta = true;
                                break;
                            }
                        }
                    }
                }
            }
            return sol;
        }

    }
    */

    static class Segundo {
        String caramelos[];
        int memo[][];
        ArrayList<String []> permutas;

        public void solve(Scanner in, PrintWriter pw){
            int c = in.nextInt();
            while (c-- > 0) {
                int n = in.nextInt();
                int wDes = in.nextInt();
                int wAnt = 0;
                caramelos = new String[n];
                memo = new int[n][n];
                permutas = new ArrayList<>();
                HashMap<String,Integer> map = new HashMap<>();

                for(int i=0;i<n;i++){
                    caramelos[i] = in.next();
                    map.put(caramelos[i],i+1);
                    wAnt += Integer.parseInt(caramelos[i]);
                }

                permutar(caramelos,"",n,n);

                memo  = new int[permutas.size()][n];
                for(int i=0;i<permutas.size();i++){
                    for(int j=0;j<n;j++){
                        memo[i][j] = Integer.parseInt(permutas.get(i)[j]);
                    }
                }

                ArrayList<Integer> lista = new ArrayList<>();

                for(int i=0;i<permutas.size();i++){
                    int v = verificar(i,wAnt-wDes);
                    if(v != -1) {
                        if(!lista.contains(v)) {
                            lista.add(v);
                        }
                    }
                }

                int sum =0;
                for(int i=0;i<lista.size();i++){
                    sum += lista.get(i);
                }

                if(sum==0){
                    pw.println("-");
                }
                else if(sum == wAnt-wDes){

                    pw.print("Brian, Kevin faltan ");
                    for(int i=0;i<lista.size();i++){
                        pw.print(map.get(lista.get(i)+"")+" ");
                    }
                    pw.println("!!!");

                }
                else{
                    pw.println("Brian, Kevin faltan caramelos !!!");
                }



            }

        }

        private void permutar(String[] elem, String act, int n, int r) {
            if (n == 0) {
                permutas.add(act.split(" "));
            } else {
                for (int i = 0; i < r; i++) {
                    if (!act.contains(elem[i])) {
                        permutar(elem, act + elem[i] + " ", n - 1, r);
                    }
                }
            }
        }

        public int verificar(int i,int w){
            int res = -1;
            boolean band = false;
            int wAux = memo[i][0];
            for(int j=0;j<memo[i].length;j++){
                if(!band) {
                    if (wAux < w) {
                        if(wAux+memo[i][j]<=w) {
                            wAux += memo[i][j];
                        }
                    }
                    if (wAux == w) {
                        band = true;
                    }
                }
            }
            if(band) res = memo[i][0];
            return  res;
        }
    }

}
