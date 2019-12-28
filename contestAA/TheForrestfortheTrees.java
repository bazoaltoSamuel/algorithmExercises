package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class TheForrestfortheTrees {

    public static void main(String [] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String cad;
    int a,b;
    int t = Integer.parseInt(br.readLine());
    //char [] abc = {'A','B','C','D','E','F','G','H','I','J','K','L','M','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',0);  map.put('B',1);   map.put('C',2);   map.put('D',3);   map.put('E',4);
        map.put('F',5);  map.put('G',6);   map.put('H',7);   map.put('I',8);   map.put('J',9);
        map.put('K',10);  map.put('L',11);   map.put('M',12);   map.put('N',13);   map.put('O',14);
        map.put('P',15);  map.put('Q',16);   map.put('R',17);   map.put('S',18);   map.put('T',19);
        map.put('U',20);  map.put('V',21);   map.put('W',22);   map.put('X',23);   map.put('Y',24);  map.put('Z',25);

        while(t>0){

        ArrayList[] g = new ArrayList[26];
        while(!(cad = br.readLine()).contains("*")) {
            a = map.get(cad.charAt(1));
            b = map.get(cad.charAt(3));
            if(g[a]==null){
                ArrayList<Integer> ady = new ArrayList<>();
                ady.add(b);
                g[a] = ady;
            }
            else{
                g[a].add(b);
            }
            if(g[b]==null){
                ArrayList<Integer> ady = new ArrayList<>();
                ady.add(a);
                g[b] = ady;
            }
            else{
                g[b].add(a);
            }
        }
        cad = br.readLine();
        ArrayList<Integer> ls =new ArrayList<>();
        for(int i=0;i<cad.length();i++){
            if(cad.charAt(i)!=','){
                ls.add(map.get(cad.charAt(i)));
            }
        }
        int arb=0,acor=0,res;
        boolean [] visit = new boolean[26];
        for(Integer i : ls){
            res = dfs(i,visit,g);
            if(res ==1) acor++;
            else if(res>1)arb++;
        }
        pw.println("There are "+arb+" tree(s) and "+acor+" acorn(s).");
        t--;
    }


        pw.flush();
        pw.close();
}

    public static int dfs(int v,boolean []visit,ArrayList<Integer> [] g){
        int r = 0;
        if(!visit[v]) {
            visit[v] = true;
            r = 1;
            if(g[v]!=null) {
                for (int i = 0; i < g[v].size(); i++) {
                    int adj = (int) g[v].get(i);
                    if (!visit[adj]) r += dfs(adj, visit, g);
                }
            }
        }
        return r;
    }

}