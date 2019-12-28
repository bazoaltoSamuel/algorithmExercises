import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(outputStream);
        Do solver = new Do();
        solver.solve(in, out);
        out.close();
    }


    static class Do {

        public void solve(Scanner in, PrintWriter out) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = in.nextInt();
            while(n-->0){
                list.add(in.nextInt());
            }

            int p = 0;
            ArbolBin<Integer> arbol = new ArbolBin<>();
            arbol.fillTree(arbol,list);
            int o = arbol.getNivel();
            for(int i =1;i<list.size();i++){
                ArrayList<Integer> cpList = new ArrayList<>();
                cpList.addAll(list);
                ArrayList<Integer> listAux = new ArrayList<>();
                cpList.remove(0);
                listAux.addAll(cpList);
                listAux.add(list.get(0));
                arbol = new ArbolBin<>();
                arbol.fillTree(arbol,listAux);
                int niv = arbol.getNivel();
                if(o>niv) {
                    o = niv;
                    p = i;
                }
                list = listAux;
            }
            out.println(o+" "+p);
            out.flush();
        }
    }

    public static class ArbolBin <T> {
        private T raiz;
        private ArbolBin<T> izq;
        private ArbolBin<T> der;

        public ArbolBin(){
            this.raiz = null;
            this.izq = null;
            this.der = null;
        }

        public void fillTree(ArbolBin<T> arbol,ArrayList<Integer> elem){
            if(elem.size() != 0){
                arbol.raiz = (T)(elem.get(0));
                ArrayList<Integer> men = new ArrayList<>(), may = new ArrayList<>();
                for(int i =1;i<elem.size();i++){
                    T e = (T)elem.get(i);
                    if((Integer)e > elem.get(0)) may.add((Integer)e);
                    else men.add((Integer)e);
                }
                Collections.sort(may);
                Collections.sort(men);
                if(!men.isEmpty()){
                    arbol.der = new ArbolBin<>();
                    fillTree(arbol.der,men);
                }
                if(!may.isEmpty()){
                    arbol.izq = new ArbolBin<>();
                    fillTree(arbol.izq,may);
                }

            }
        }

        public int getNivel(){
            int res = 0;
            int resIzq = 0;
            int resDer = 0;
            if(this.raiz != null){
                if(this.izq != null){
                    resIzq = this.izq.getNivel();
                }
                if(this.der != null){
                    resDer = this.der.getNivel();
                }
            }
            res = 1+Math.max(resIzq,resDer);
            return res;
        }

    }

}