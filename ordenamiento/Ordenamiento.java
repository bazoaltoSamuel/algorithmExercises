package ordenamiento;

public class Ordenamiento {

    //Burbuja O(n^2)
    public void burbuja(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

    //Insercion O(n^2)
    public void insercion(int arr[]){
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    int aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

    //Seleccion O(n^2)
    public void seleccion(int arr[]){
        for(int i=0;i<arr.length;i++){
            int menor = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[menor]) menor = j;
            }
            int aux = arr[i];
            arr[i] = arr[menor];
            arr[menor] = aux;
        }
    }

    //QuickSort O(n log n)
    public void quickSort(int arr[],int izq,int der){


        int pivote=arr[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i<j){            // mientras no se crucen las búsquedas
            while(arr[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(arr[j]>pivote) j--;         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado
                aux= arr[i];                  // los intercambia
                arr[i]=arr[j];
                arr[j]=aux;
            }
        }
        arr[izq]=arr[j]; // se coloca el pivote en su lugar de forma que tendremos
        arr[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quickSort(arr,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quickSort(arr,j+1,der); // ordenamos subarray derecho

    }

    public void mergeSort(int arr[],int izq,int der){
        if(der>izq){
            int mid = izq+(der-izq)/2;

            mergeSort(arr,izq,mid);
            mergeSort(arr,mid+1,der);
            merge(arr,izq,mid,der);
        }
    }

    private void merge(int arr[],int izq,int mid,int der){
        int i, j, k;
        int n1 = mid - izq + 1;
        int n2 =  der - mid;

        /* creamos arreglos temporales */
        int Izq[] = new int[n1];
        int Der[] = new int [n2];

        /* Copiamos datos a los arrays temporales Izq[] and Der[] */
        for (i = 0; i < n1; i++) {
            Izq[i] = arr[izq + i];
        }
        for (j = 0; j < n2; j++) {
            Der[j] = arr[mid + 1 + j];
        }
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = izq; // Initial index of merged subarray


        while (i < n1 && j < n2)
        {
            if (Izq[i] <= Der[j])
            {
                arr[k] = Izq[i];
                i++;
            }
            else
            {
                arr[k] = Der[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = Izq[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = Der[j];
            j++;
            k++;
        }
    }

    //Monticulo

}
