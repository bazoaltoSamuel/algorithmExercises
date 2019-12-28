package spaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IngenuousCubrency {

    static BigInteger[] memo;
    static int[] coins;

    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int e=1,res;
        String cad;
        coins = new int[22];
        while(e<=21){
            res = (int) Math.pow((double)e,(double) 3);
            e++;
            coins[e-1] = res;
        }

        memo = new BigInteger[10000];
        Arrays.fill(memo,BigInteger.ZERO);
        memo[0] = BigInteger.ONE;

        for(int i = 1; i<=21; i++) {
            for (int j =  coins[i]; j < memo.length; j++) {
                memo[j] = memo[j].add( memo[j - coins[i]]);
            }
        }

        while((cad = br.readLine())!=null){
            System.out.println(memo[Integer.parseInt(new StringTokenizer(cad).nextToken())]);
        }

        pw.flush();
        pw.close();
    }
}