package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class friends {
    //no funca runtime error
    public static void main(String [] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int n,p,a,a1,a2;
    n = Integer.parseInt(br.readLine());
    while(n>0){
        String cadTem[] = br.readLine().split(" ");
        p = Integer.parseInt(cadTem[0]);
        a = Integer.parseInt(cadTem[1]);
        ArrayList[] g = new ArrayList[p];
        int max =0;
        while(a>0){
            cadTem = br.readLine().split(" ");
            a1 = Integer.parseInt(cadTem[0]);
            a2 = Integer.parseInt(cadTem[1]);
            if(g[a1-1]==null){
                ArrayList<Integer> ady = new ArrayList<>();
                ady.add(a2-1);
                g[a1-1] = ady;
            }
            else{
                g[a1-1].add(a2-1);
            }
            if(g[a2-1]==null){
                ArrayList<Integer> ady = new ArrayList<>();
                ady.add(a1-1);
                g[a2-1] = ady;
            }
            else{
                g[a2-1].add(a1-1);
            }
            a--;
        }
        for(int i=0;i<p;i++){
            boolean [] visit = new boolean[p];
            max = Math.max(max,dfs(i,visit,g));
        }

        pw.println(max);
        n--;
    }

    pw.flush();
    pw.close();
}

    public static int dfs(int v,boolean []visit,ArrayList<Integer> [] g){
        visit[v] = true;
        int r = 1;
        for(int i =0;i<g[v].size();i++){
            int adj = (int) g[v].get(i);
            if(!visit[adj]) r += dfs(adj,visit,g);
        }
        return r;
    }



}