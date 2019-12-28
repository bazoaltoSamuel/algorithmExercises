package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ejercicioF {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //PrintWriter pw = new PrintWriter(System.out);
            String s;

            while ((s=br.readLine())!=null) {
                LinkedList<Character> linkList =new LinkedList<>();
                int ultimaPos=0;
                for (char c : s.toCharArray()) {
                    if (c=='[') ultimaPos=0;
                    else if (c==']') ultimaPos=linkList.size();
                    else linkList.add(ultimaPos++,c);
                }

                StringBuilder sb=new StringBuilder();
                for (char c : linkList) sb.append(c);
                System.out.println(sb.toString());
            }
            //pw.flush();
            //pw.close();
        }
    }


