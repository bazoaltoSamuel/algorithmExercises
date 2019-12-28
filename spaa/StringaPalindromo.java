package spaa;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class StringaPalindromo {
    char [] arr;
    int[][]memo;
    public void solve(Scanner in, PrintWriter out){
        int cases = 1;
        int n = in.nextInt();
        while(n-->0){
            String cad = in.next();
            arr = cad.toCharArray();

            memo = new int[arr.length+1][arr.length+1];
            for(int i= 0;i<memo.length;i++){
                Arrays.fill(memo[i],-1);
            }
            out.println("Case "+cases+": "+dp(0,arr.length-1));
            cases++;
        }
        out.flush();
    }

    public int dp(int i,int j)
    {
        if(i>=j)
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(arr[i]==arr[j])
            return memo[i][j] = dp(i+1,j-1);
        return memo[i][j] = 1 + Math.min(dp(i+1,j),Math.min(dp(i+1,j-1), dp(i,j-1)));
    }

}
