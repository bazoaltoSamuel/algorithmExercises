package contestAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IntervalProduct {
    //no funca runtime error
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String cad;
        int t,q,e,a,b;
        char o;
        Nodo [] T,A;
        T = new Nodo[100000];
        A = new Nodo[400000];

        while((cad = br.readLine())!=null && !cad.isEmpty()){
            String cadTemp[] = cad.split(" ");
            t = Integer.parseInt(cadTemp[0]);
            q = Integer.parseInt(cadTemp[1]);
            cadTemp = br.readLine().split(" ");
            for(int i=0;i<t;i++){
                e = Integer.parseInt(cadTemp[i]);
                if(e==0) A[i] = new Nodo(0);
                else if(e>0) A[i]= new Nodo(1);
                else A[i] = new Nodo(-1);
            }
            init(0,t-1,0,T,A);
            while(q>0){
                cadTemp = br.readLine().split(" ");
                o = cadTemp[0].charAt(0);
                a = Integer.parseInt(cadTemp[1]);
                b = Integer.parseInt(cadTemp[2]);
                if(o == 'C'){
                    if(b > 0){
                        update(0,t-1,0,a-1,new Nodo(1),T,A);
                    }
                    else if(b<0){
                        update(0,t-1,0,a-1,new Nodo(-1),T,A);
                    }
                    else update(0,t-1,0,a-1,new Nodo(0),T,A);

                }
                else{
                    int r = query(0,t-1,0,a-1,b-1,T).x;
                    if(r > 0){
                        System.out.print("+");
                    }
                    else if(r<0){
                        System.out.print("-");
                    }
                    else System.out.print("0");

                }
                q--;
            }
            System.out.println("");
        }





        pw.flush();
        pw.close();
    }

    public static Nodo join(Nodo a,Nodo b){
        return new Nodo(a.x*b.x);
    }

    public static void init(int b,int e, int node,Nodo [] T,Nodo[]A){
        if(b == e){
            T[node] = A[b];
            return;
        }
        int m = (b+e)/2 ,iz = node*2+1 ,de = iz+1;
        init(b,m,iz,T,A);
        init(m+1,e,de,T,A);
        T[node] = join(T[iz],T[de]);
    }

    public static Nodo query(int b,int e,int node,int i,int j,Nodo[]T){
        if(b >= i && e<= j){
            return T[node];
        }
        int m = (b+e)/2 ,iz = node*2+1 ,de = iz+1;
        if(i> m)return query(m+1,e,de,i,j,T);
        if(j<=m) return query(b,m,iz,i,j,T);
        return (join(query(m+1,e,de,i,j,T),query(b,m,iz,i,j,T)));
    }
    public static void update(int b,int e,int node,int pos,Nodo val,Nodo []T,Nodo[]A){
        if(b==e){
            T[node] = val;
            A[b] = val;
            return;
        }
        int m = (b+e)/2 ,iz = node*2+1 ,de = iz+1;
        if(pos> m)update(m+1,e,de,pos,val,T,A);
        else update(b,m,iz,pos,val,T,A);
        T[node] = join(T[iz],T[de]);
    }

    public static class Nodo{
        int x;
        public Nodo(){
            x = 0;
        }

        public Nodo(int x){
            this.x = x;
        }


    }
}
