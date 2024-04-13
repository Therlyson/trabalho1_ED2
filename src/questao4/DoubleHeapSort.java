package questao4;

public class DoubleHeapSort {

    public void heapSort(int[] array){
        int n = array.length/2 - 1;
        for(int i = n; i>=0; i--){
            maxHeapify(array, i, n);
        }

        trocarFimEComeco(array);
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

    private void trocarFimEComeco(int[] array){
        for(int j = array.length-1; j > 0; j--){
            int aux = array[0];
            array[0] = array[j];
            array[j] = aux;

            maxHeapify(array, 0, j);
        }
    }
}
