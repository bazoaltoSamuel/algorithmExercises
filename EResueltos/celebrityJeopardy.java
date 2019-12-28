package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class celebrityJeopardy {
    //1124
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String cad;
        while( (cad = br.readLine()) != null){
            pw.println(cad);
        }
        pw.flush();
        pw.close();
    }

}
