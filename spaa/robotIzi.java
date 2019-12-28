package spaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class robotIzi {
    //No funca...... me falta solucionarlo.....
    static int fX;
    static int fY;
    static String fOri;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String cadTemp[] = br.readLine().split(" ");
        int n = Integer.parseInt(cadTemp[0])+1;
        int m = Integer.parseInt(cadTemp[1])+1;
        String cad;
        while((cad = br.readLine())!= null && !(cad.isEmpty())){
            String orientation = "";
            boolean lost = false;
            int x,y;
            cadTemp = cad.split(" ");
            x = Integer.parseInt(cadTemp[0]);
            y = Integer.parseInt(cadTemp[1]);
            orientation = cadTemp[2];
            cad = br.readLine();
            for(int i=0;i<cad.length();i++){
                if(!lost) {
                    char dir = cad.charAt(i);
                    fX = x;
                    fY = y;
                    fOri = orientation;
                    boolean sePuede = mov(dir,n,m);
                    if(sePuede){
                        x = fX;
                        y = fY;
                        orientation = fOri;
                    }
                    else{
                        lost = true;
                    }
                }
            }
            if(lost){
                pw.println(x+" "+y+" "+orientation+" LOST");
            }
            else{
                pw.println(x+" "+y+" "+orientation);
            }
        }

        pw.flush();
        pw.close();
    }

    private static boolean mov(char dir,int n,int m){
        boolean res = false;
        switch (fOri){
            case "E":
                switch (dir){
                    case 'L':
                        fOri = "N";
                        break;
                    case 'R':
                        fOri = "S";
                        break;
                    case 'F':
                        fY = fY+1;
                        break;
                }break;
            case "N":
                switch (dir){
                    case 'L':
                        fOri = "W";
                        break;
                    case 'R':
                        fOri = "E";
                        break;
                    case 'F':
                        fX = fX-1;
                        break;
                }break;
            case "W":
                switch (dir){
                    case 'L':
                        fOri = "S";
                        break;
                    case 'R':
                        fOri = "N";
                        break;
                    case 'F':
                        fY = fY-1;
                        break;
                }break;
            case "S":
                switch (dir){
                    case 'L':
                        fOri = "E";
                        break;
                    case 'R':
                        fOri = "W";
                        break;
                    case 'F':
                        fX = fX+1;
                        break;
                }break;
        }
        if(fX>=0 && fX<n && fY>=0 && fY<=m) res = true;
        return res;
    }

}