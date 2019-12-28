package spaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem10100 {
        static String[] arr1,arr2;
        static int[][] memo;

        public void solve(BufferedReader br, PrintWriter out)throws IOException {
            int cases = 1;
            while(br.ready()) {
                String s1 = br.readLine();
                String s2 = br.readLine();
                if(s1.isEmpty() || s2.isEmpty())
                {
                    out.printf("%2d. Blank!%n",cases++);
                    continue;
                }
                arr1 = parse(s1);
                arr2 = parse(s2);
                memo = new int[arr1.length][arr2.length];
                for (int i = 0; i < memo.length; i++)
                    Arrays.fill(memo[i], -1);

                out.printf("%2d. Length of longest match: %d%n",cases++,dp(0,0));
            }
            out.flush();
        }

        static String[] parse(String s)
        {
            StringBuilder cur = new StringBuilder();
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0;i<s.length();i++)
            {
                char c = s.charAt(i);
                if(Character.isAlphabetic(c) || Character.isDigit(c))
                    cur.append(c);
                else
                {
                    if(!cur.toString().isEmpty())
                        list.add(cur.toString().trim());
                    cur = new StringBuilder();
                }
            }
            if(cur.length()>0)
                list.add(cur.toString().trim());
            String[] arr = new String[list.size()];
            for (int i = 0; i < list.size(); i++)
                arr[i] = list.get(i);

            return arr;
        }

        static int dp(int i,int j)
        {
            if(i==arr1.length || j==arr2.length)
                return 0;
            if(memo[i][j]!=-1)
                return memo[i][j];

            int ans = dp(i+1,j);
            ans = Math.max(ans, dp(i,j+1));
            if(arr1[i].equals(arr2[j]))
                ans = Math.max(ans, 1 + dp(i+1,j+1));

            return memo[i][j] = ans;
        }
    }