package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Birthday {

    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int l = n-1;
        ArrayList<Cumple> dates = new ArrayList<>();

        while(n>0){
            String cadTemp[] = br.readLine().split(" ");
            String name = cadTemp[0];
            int d = Integer.parseInt(cadTemp[1]);
            int m = Integer.parseInt(cadTemp[2]);
            int a = Integer.parseInt(cadTemp[3]);
            Date f = new Date(a,m,d);
            dates.add(new Cumple(name,f));
            n--;
        }
        Collections.sort(dates);
        pw.println(dates.get(l).getName());
        pw.println(dates.get(0).getName());

        pw.flush();
        pw.close();
    }

    static class Cumple implements Comparable<Cumple>{

        private String name;
        private Date fecha;

        public Cumple (String name,Date fecha){
            this.fecha = fecha;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Date getFecha() {
            return fecha;
        }

        @Override
        public int compareTo(Cumple o) {
            return this.fecha.compareTo(o.getFecha());
        }
    }

}