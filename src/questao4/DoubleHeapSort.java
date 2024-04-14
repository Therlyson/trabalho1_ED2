package questao4;

import java.util.Arrays;

public class DoubleHeapSort {

    public void heapSort(int[] array){
        int[] minimo = Arrays.copyOf(array, array.length);
        int[] maximo = Arrays.copyOf(array, array.length);
        int n = array.length;
        for(int i = n/2-1; i>=0; i--){
            maxHeapify(maximo, i, n);
            minHeapify(minimo, i, n);
        }

        doubleOrganization(array, maximo, minimo);
    }

    private void maxHeapify(int[] array, int i, int tamanho) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if(esquerda < tamanho && array[esquerda] > array[raiz]){
            raiz = esquerda;
        }
        if(direita < tamanho && array[direita] > array[raiz]){
            raiz = direita;
        }

        if(raiz != i){
            int aux = array[i];
            array[i] = array[raiz];
            array[raiz] = aux;

            maxHeapify(array, raiz, tamanho);
        }
    }

    private void minHeapify(int[] array, int i, int tamanho) { //ordena decrescente
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if(esquerda < tamanho && array[esquerda] < array[raiz]){
            raiz = esquerda;
        }
        if(direita < tamanho && array[direita] < array[raiz]){
            raiz = direita;
        }

        if(raiz != i){
            int aux = array[i];
            array[i] = array[raiz];
            array[raiz] = aux;

            minHeapify(array, raiz, tamanho);
        }
    }

    private void doubleOrganization(int[] array, int[] maximo, int[] minimo){
        int i = 0;
        for(int j = array.length-1; j >= array.length/2; j--){
            int aux = maximo[0];
            maximo[0] = maximo[j];
            maximo[j] = aux;

            int aux2 = minimo[0];
            minimo[0] = minimo[j];
            minimo[j] = aux2;

            array[i] = minimo[j];
            array[j] = maximo[j];

            if(i!=j){
                maxHeapify(maximo, 0, j);
                minHeapify(minimo, 0, j);
            }
            i++;
        }
    }

}
