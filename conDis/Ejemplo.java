package conDis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo {
    static int []arr;
    static int tree [];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int []{3,5,4,7,2,8,10,12,1,14,16,18};
        tree = new int[100];
        for (int i=0;i<arr.length;i++){
            tree[arr[i]] = arr[i];
        }
        while(true){
            String [] cadTemp = br.readLine().split(" ");
            int n = Integer.parseInt(cadTemp[0]);
            int m = Integer.parseInt(cadTemp[1]);
            union(n,m);
        }

    }

    private static int find(int n){
        if(n == tree[n]) return  tree[n];
        else {
            tree[n] = find(tree[n]);
            return tree[n];
        }
    }

    private static void union(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){
            tree[pb] = pa;
        }
    }

}
