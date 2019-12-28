package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SecretResearch {
    //621
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while (n>0){
            String a = br.readLine();
            if(a.equals("1") ||a.equals("4") || a.equals("78") )pw.println("+");
            else if(a.length()>=2)if( a.charAt(a.length()-2)=='3' && a.charAt(a.length()-1)=='5' )pw.println("-");
            else if(a.charAt(0)=='9' && a.charAt(a.length()-1)=='4'  ) pw.println("*");
            else pw.println("?");
            n--;
        }
        pw.flush();
        pw.close();
    }
}
