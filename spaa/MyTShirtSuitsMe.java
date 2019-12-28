package spaa;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MyTShirtSuitsMe {
    //My T-shirt suits me
    int V ;
    public void solve(Scanner in, PrintWriter out) {
        int c = in.nextInt();
        while (c-- > 0) {
            int n, m, cont = 0, acum, i = 1, nT1, nT2;
            String t1, t2;
            n = in.nextInt();
            m = in.nextInt();
            V = m+8;
            acum = m + 1;
            int matriz[][] = new int[V][V];
            HashMap<String, Integer> map = new HashMap<>();
            int w = n/6;
            while (i <= m) {
                matriz[0][i] = 1;
                t1 = in.next();
                t2 = in.next();
                if (map.containsKey(t1)) nT1 = map.get(t1);
                else {
                    map.put(t1,acum);
                    nT1 = acum;
                    acum++;
                }
                if (map.containsKey(t2)) nT2 = map.get(t2);
                else {
                    map.put(t2,acum);
                    nT2 = acum;
                    acum++;
                }
                matriz[i][nT1] = 1;
                matriz[i][nT2] = 1;
                matriz[nT1][V-1] = w;
                matriz[nT2][V-1] = w;
                i++;
            }

            //int res = fordFulkerson(matriz,0,V-1);
            //if(res == m) out.println("YES");
            //else{
            //    out.println("NO");
            //}
        }
    }

    /*boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        // Create a visited array and mark all vertices as not
        // visited
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop
        while (queue.size() != 0) {
            int u = queue.poll();
            if(u!=t) {
                for (int v = 0; v < V; v++) {
                    if (visited[v] == false && rGraph[u][v] > 0) {
                        queue.add(v);
                        parent[v] = u;
                        visited[v] = true;
                    }
                }
            }
        }

        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }

    // Returns tne maximum flow from s to t in the given graph
    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;
        // This array is filled by BFS and to store path
        int parent[] = new int[V];

        int max_flow = 0;  // There is no flow initially

        // Augment the flow while tere is path from source
        // to sink
        while (bfs(graph, s, t, parent)) {
            // Find minimum residual capacity of the edhes
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, graph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                graph[u][v] -= path_flow;
                graph[v][u] += path_flow;
            }

            // Add path flow to overall flow
            max_flow += path_flow;
        }

        // Return the overall flow
        return max_flow;
    }*/

}