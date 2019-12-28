package contestAA;

import java.io.IOException;
import java.util.Scanner;

public class The3nMas1 {
        public static void main(String [] args)throws IOException {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //PrintWriter pw = new PrintWriter(System.out);
            int a,b,res;
            Scanner in = new Scanner(System.in);

            while(in.hasNextInt()){
                int n = in.nextInt();
                int m = in.nextInt();
                res = 0;
                a = Math.max(n,m);
                b = Math.min(n,m);
                if(b>0 && b<1000000 && a>0 && a<1000000 ) {
                    for (int i = b; i <= a; i++) {
                        res = Math.max(res, ciclo(i, 1));
                    }
                    System.out.println(n + " " + m + " " + res);
                }
            }
        }

        static int ciclo(int n,int cont){
            if(n > 1){
                if(n%2 == 0){
                    n = n/2;
                }else{
                    n = (3 * n) + 1;
                }

                cont++;

                return ciclo(n, cont);
            }else{
                return cont;
            }
        }
    }

