package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class longestNap {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t=0,h1,m1,h2,m2,d=0;
        String cad;
        int []hrs;
        while((cad = br.readLine())!=null){
            if(cad.length()<4) {
                t = Integer.parseInt(cad);
                d++;
            }
            int max=0,cpyMax =0,hc=10,mc=0;
            hrs = new int [481];
            hrs[0]=1;
            while(t>0){
                String []cadTemp = br.readLine().split("");
                h1 = Integer.parseInt(cadTemp[0]+cadTemp[1]);
                m1 = Integer.parseInt(cadTemp[3]+cadTemp[4]);

                h2 = Integer.parseInt(cadTemp[6]+cadTemp[7]);
                m2 = Integer.parseInt(cadTemp[9]+cadTemp[10]);

                h1 = h1-10;
                h2 = h2-10;
                h1 = h1*60+m1;
                h2 = h2*60+m2;
                for(int i =h1+1;i<=h2;i++){
                    hrs[i]= 1;
                }

                t--;
            }
            int cont =0;
            boolean band = true;
            for(int i=480;i>=0;i--){

                if(hrs[i]==0 && band){
                    cont++;
                }
                else{
                    if(hrs[i]==1 && band){
                        band = false;
                        max = Math.max(max,cont);
                        if(max!=cpyMax) {
                            hc = (i / 60) + 10;
                            mc = i % 60;
                            cpyMax = max;
                        }
                        else if(max == cont){
                            hc = (i / 60) + 10;
                            mc = i % 60;
                            cpyMax = max;
                        }

                        cont = 0;
                    }
                    else if(hrs[i]==0 && !band){
                        band = true;
                        cont++;

                    }
                }
            }

            int hr=0,mr,cpyHr;
            if(max>=60) {
                hr = max / 60;
                cpyHr = hr;
                while(cpyHr>0){
                    max-=60;
                    cpyHr--;
                }

            }
            mr = max;

            if(hr>0){
                pw.println("Day #"+d+": the longest nap starts at "+genHrs(hc,mc)+" and will last for "+hr+" hours and "+mr+" minutes.");
            }
            else{
                pw.println("Day #"+d+": the longest nap starts at "+genHrs(hc,mc)+" and will last for "+mr+" minutes.");
            }


        }

        pw.flush();
        pw.close();
    }
    static  String genHrs(int h,int m){
        String cad ="";
        if(m <10){
            cad = h+":0"+m;
        }
        else{
            cad = h+":"+m;
        }
        return cad;
    }
}
