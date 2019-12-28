package busqueda;

public class Busqueda {

    int arr[] = new int[]{2,5,3,6,3,5,2,7,1,2,8,2,15,2,5,142,55};
    int arrOrd[] = new int[]{1,2,3,4,5,6,7,8,9,30,32,36};
    //Secuencial O(n)
    public boolean busSec(int d){
        boolean res = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==d){
                res = true;
                break;
            }
        }
        return res;
    }

    //Binaria O(log n)
    public boolean busBin(int d){
        boolean res = false;
        int ini = 0;
        int fin = arrOrd.length;
        while(ini<=fin && !res){
            int med = (fin+ini)/2;
            if(arrOrd[med]==d){
                res = true;
            }
            else if(d<arrOrd[med]){
                fin = med-1;
            }
            else ini = med+1;
        }
        return res;
    }

}
