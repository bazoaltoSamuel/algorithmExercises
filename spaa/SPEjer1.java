package spaa;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SPEjer1 {

    static class Primero {

        public void solve(Scanner in, PrintWriter pw) {
            int c = in.nextInt();
            while (c-- > 0) {
                int n = in.nextInt();
                ArrayList<Integer> lista = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int num = in.nextInt();
                    if (lista.contains(num)) {
                        boolean band = true;
                        while (band) {
                            int numDel = lista.remove(lista.size() - 1);
                            if (num == numDel) {
                                lista.add(numDel);
                                band = false;
                            }
                        }
                    } else {
                        lista.add(num);
                    }
                }
                if (lista.size() == 1) {
                    pw.println("Camila esto no va a dar");
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        pw.print(lista.get(i) + " ");
                    }
                    pw.println("");
                }
            }

        }


    }
}
