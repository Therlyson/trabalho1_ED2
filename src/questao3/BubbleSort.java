package questao3;

public class BubbleSort {


    public void ordenar(int[] array, int left, int right){
        int aux;
        for(int i = left; i<right; i++){
            for(int j = i+1; j <= right; j++){
                if(array[i] > array[j]){
                    aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                }
            }
        }
    }
}
