package spaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class sqrtlogsin {

    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        dp = new int[1000001];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        int n;
        while((n = Integer.parseInt(br.readLine())) != -1){
            long res = solve(n);
            pw.println(res);
        }
        pw.flush();
        pw.close();
    }

    private static int solve(int n){
        if(dp[n] != -1) return dp[n];
        dp[n] = solve((int) (n - Math.sqrt(n)+ 1e-7));
        dp[n] += solve((int) (Math.log( n)+1e-7));
        dp[n] %=1000000;
        dp[n] += solve((int)(n*Math.sin(n)*Math.sin(n)));
        dp[n] %=1000000;
        return dp[n];
    }
}