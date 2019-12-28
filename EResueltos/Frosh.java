package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Frosh {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n ;
        while((n = Integer.parseInt(br.readLine()))!=0){

            HashMap<String,Integer> cadenas = new HashMap<>();
            while(n>0) {
                String cadTemp[] = br.readLine().split(" ");
                int a, b, c, d, e;
                a = Integer.parseInt(cadTemp[0]);
                b = Integer.parseInt(cadTemp[1]);
                c = Integer.parseInt(cadTemp[2]);
                d = Integer.parseInt(cadTemp[3]);
                e = Integer.parseInt(cadTemp[4]);
                int arr[] = {a, b, c, d, e};
                String s = "";
                Arrays.sort(arr);
                for (int num : arr) {
                    s += String.valueOf(num);
                }
                if (!cadenas.containsKey(s)) {
                    cadenas.put(s,1);
                } else {
                    cadenas.replace(s,cadenas.get(s)+1);
                }
                n--;
            }
            int arreglo[] = new int[cadenas.size()-1];
            int max = 0;
            for (Map.Entry<String, Integer> entry : cadenas.entrySet()) {
                max = Math.max(max,entry.getValue());
            }
            int repMax = 0;
            for (Map.Entry<String, Integer> entry : cadenas.entrySet()) {
                if(max == entry.getValue()) repMax++;
            }

            pw.println(max*repMax);
        }

        pw.flush();
        pw.close();
    }

}