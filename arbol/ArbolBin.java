package arbol;

import java.util.ArrayList;
import java.util.Collections;

public class ArbolBin <T> {
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
            res = 1;
            if(this.izq != null){
                resIzq = 1+this.izq.getNivel();
            }
            if(this.der != null){
                resDer = 1+this.der.getNivel();
            }
        }
        res = Math.max(resIzq,resDer);
        return res;
    }

}
