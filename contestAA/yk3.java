package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class yk3 {

        static int dd, mm, aa, d;


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);


            while (true) {
                String[] cadTemp = br.readLine().split(" ");
                d = Integer.parseInt(cadTemp[0]);
                dd = Integer.parseInt(cadTemp[1]);
                mm = Integer.parseInt(cadTemp[2]);
                aa = Integer.parseInt(cadTemp[3]);
                if (d == 0 && dd == 0 && mm == 0 && aa == 0) {
                    break;
                }
                GregorianCalendar date = new GregorianCalendar(aa, mm - 1, dd);
                date.add(Calendar.DATE, d);
                pw.println(date.get(Calendar.DATE) + " " + (date.get(Calendar.MONTH) + 1) + " " + date.get(Calendar.YEAR));
            }

            pw.flush();
            pw.close();
        }
    }

