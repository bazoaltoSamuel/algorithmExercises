package spaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class luggage {
    static int[][] memo;
    static int[] nums;

    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numTest = Integer.parseInt(br.readLine());
        while(numTest-- >0) {

            String[] cadTemp = br.readLine().split(" ");
            nums = new int[cadTemp.length];
            memo = new int[250][250];

            for (int i = 0; i < cadTemp.length; i++) {
                nums[i] = Integer.parseInt(cadTemp[i]);
            }

            int sum =0;
            for (int i = 0; i < cadTemp.length; i++) {
                sum +=nums[i];
            }

            for (int i = 0; i < 250; i++) {
                for (int j = 0; j < 250; j++) {
                    memo[i][j] = -1;
                }
            }

            if(sum%2!=0)pw.println("NO");
            else if ( Solve(sum / 2, cadTemp.length - 1) != sum / 2)
                pw.println("NO");
            else
                pw.println("YES");
        }

        pw.flush();
        pw.close();
    }

    private static int Solve(int W, int Index){
        if ( Index < 0 )	return 0;
        if ( memo[W][Index] != -1 )		return memo[W][Index];
        if ( W >= nums[Index]){
            return memo[W][Index] = Math.max(nums[Index] + Solve(W - nums[Index], Index - 1), Solve(W, Index - 1));
        }else{
            return memo[W][Index] = Solve(W, Index - 1);
        }
    }
}