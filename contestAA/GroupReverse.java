package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GroupReverse {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            int n;
            String cad;
            String []cadTemp;
            while(( cadTemp = (br.readLine()).split(" ")).length>1){
                n = Integer.parseInt(cadTemp[0]);
                cad = cadTemp[1];
                n = cad.length()/n;
                for(int i=0;i<cad.length();i++){
                    if(i%n==0){
                        for(int j =i+(n-1);j>=i;j--){
                            pw.print(cad.charAt(j));
                        }
                    }
                }
                pw.println("");
            }

            pw.flush();
            pw.close();
        }
    }

