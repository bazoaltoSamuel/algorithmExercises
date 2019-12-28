package EResueltos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OneTwoThree {
    //12289
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while (n>0){
            String cad = br.readLine();
            if(cad.length()==5)pw.println(3);
            else{
                char a=cad.charAt(0),b=cad.charAt(1),c=cad.charAt(2);
                if(a=='o'&&b=='n')pw.println(1);
                else if(a=='o'&&c=='e')pw.println(1);
                else if(b=='n'&&c=='e')pw.println(1);
                else if(a=='t'&&b=='w')pw.println(2);
                else if(a=='t'&&c=='o')pw.println(2);
                else if(b=='w'&&c=='o')pw.println(2);
            }
            n--;
        }

        pw.flush();
        pw.close();
    }
}
