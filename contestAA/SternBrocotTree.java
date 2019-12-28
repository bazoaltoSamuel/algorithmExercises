package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SternBrocotTree {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad,res;
        Tree t;
        int n = Integer.parseInt(br.readLine());
        while(n>0){
            t = new Tree();
            cad = br.readLine();
            res = t.generar(t,cad);
            pw.println(res);
            n--;
        }

        pw.flush();
        pw.close();
    }

    static class Tree{
        long raizA,raizB;
        long refAI,refBI, refAD,refBD;

        Tree ramaIzq,ramaDer;

        public Tree(){
            raizA = 1;
            raizB = 1;
            refAI = 0; refBI = 1;
            refAD = 1; refBD = 0;
            ramaDer = null;
            ramaIzq = null;
        }

        public Tree(long a,long b,long ai,long bi,long ad,long bd){
            raizA = a;
            raizB = b;
            refAI = ai; refBI = bi;
            refAD = ad; refBD = bd;
            ramaDer = null;
            ramaIzq = null;
        }

        public String generar(Tree arb, String cad){
            String res;
            if(cad.length()>0) {
                char c = cad.charAt(0);
                if(c=='R'){
                    arb.ramaDer = new Tree(arb.refAD + arb.raizA, arb.refBD + arb.raizB,arb.raizA,arb.raizB,arb.refAD,arb.refBD);
                    res = generar(arb.ramaDer,cad.substring(1,cad.length()) );
                }
                else {
                    arb.ramaIzq = new Tree(arb.refAI + arb.raizA, arb.refBI + arb.raizB, arb.refAI, arb.refBI, arb.raizA, arb.raizB);
                    res = generar(arb.ramaIzq, cad.substring(1,cad.length()));
                }
            }
            else res = res = String.valueOf(arb.raizA)+"/"+String.valueOf(arb.raizB);
            return res;
        }


    }
}
