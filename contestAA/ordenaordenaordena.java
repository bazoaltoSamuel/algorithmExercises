package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class ordenaordenaordena {public static void main(String [] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n,m;
    String cad;
    while(!(cad = br.readLine()).equals("0 0")){
        String cadTemp[] = cad.split(" ");
        n = Integer.parseInt(cadTemp[0]);
        m = Integer.parseInt(cadTemp[1]);

        PriorityQueue<Struct> lista = new PriorityQueue<>();
        pw.println(cad);
        while(n>0){
            int num = Integer.parseInt(br.readLine());
            lista.add(new Struct(num,m));
            n--;
        }
        while (!lista.isEmpty()) {
            pw.println(lista.poll().num);
        }

    }
    pw.println("0 0");
    pw.flush();
    pw.close();
}

    static  class Struct implements Comparable<Struct>{

        int num,mod,sol;
        public Struct(int num,int mod){
            this.num = num;
            this.mod = mod;
            calcularSol();
        }

        private void calcularSol(){
            sol = num%mod;
        }

        @Override
        public int compareTo(Struct o) {
            if (this.sol < o.sol) {
                return -1;
            } else if (this.sol == o.sol) {
                if (num%2!=0 && o.num%2==0) {
                    return -1;
                } else if (num%2!=0 && o.num%2!=0) {
                    if (this.num > o.num) {
                        return -1;
                    }
                } else if (num%2==0 && o.num%2==0) {
                    if (this.num < o.num) {
                        return -1;
                    }
                }
            }
            return 1;
        }
    }


}