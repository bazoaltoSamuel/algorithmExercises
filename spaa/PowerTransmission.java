package spaa;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class PowerTransmission {

    int V;
    int matriz [][];

    public void solve(Scanner in, PrintWriter out){
        while(in.hasNextInt()){
            int v = in.nextInt();
            V = (v*2)+2;

            matriz = new int[V][V];

            for(int i=1;i<=v;i++){
                matriz[(i*2)-1][i*2] = in.nextInt();
            }

            int m = in.nextInt();
            while(m-->0){
                int a,b,c;
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
                a = a*2;
                b = (b*2)-1;
                matriz[a][b] = c;
            }
            int d,b;
            d = in.nextInt();
            b = in.nextInt();
            while(d-->0){
                int e = in.nextInt();
                matriz[0][(e*2)-1] = Integer.MAX_VALUE;
            }
            while(b-->0){
                int s = in.nextInt();
                matriz[s*2][matriz[0].length-1] = Integer.MAX_VALUE;
            }
            //int res = fordFulkerson(matriz,0,matriz[0].length-1);
            //out.println(res);

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
    }
    */

}