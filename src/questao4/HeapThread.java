package questao4;

import java.util.Arrays;

public class HeapThread implements Runnable {
    private int[] array;
    private int tamanho;
    private boolean isMaxHeap;

    public HeapThread(int[] array, int tamanho, boolean isMaxHeap) {
        this.array = array;
        this.tamanho = tamanho;
        this.isMaxHeap = isMaxHeap;
    }

    @Override
    public void run() {
        for(int i = tamanho/2-1; i>=0; i--){
            if(isMaxHeap){
                maxHeapify(array, i, tamanho);
            } else {
                minHeapify(array, i, tamanho);
            }
        }
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

    private void minHeapify(int[] array, int i, int tamanho) {
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
}
