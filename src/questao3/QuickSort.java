package questao3;

public class QuickSort {
    BubbleSort bubbleSort = new BubbleSort();
    public void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            if ((right - left) <= MOMENTO_BUBBLE){
                bubbleSort.ordenar(arr, left, right);
                return;
            }

            int pivo = partition(arr, left, right); // Esse pivo retorna o indice que o pivo deve ocupar na lista (nesse caso, mediana de 3)
            quicksort(arr, left, pivo - 1); // Agora o right (ultimo elemento desse arr), vai ser o elemento que vem antes do pivo.
            quicksort(arr, pivo + 1, right); // Agora o left (primeiro elemento desse arr), vai ser o elemento que vem depois do pivo.
        }
    }

    private int partition(int[] arr, int left, int right) {
        int meio = arr[(left + right) / 2];
        int inicio = arr[left];
        int fim = arr[right];

        int mediana = indexMediana(inicio, meio, fim, left, right);
        trocarPosicaoPivo(arr, mediana, right);

        int pivo = arr[right];
        int i = left - 1;
        int temp;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivo) {
                temp = arr[j];
                arr[j] = arr[++i];
                arr[i] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    private int indexMediana(int inicio, int meio, int fim, int left, int right) {
        if (inicio < meio) {
            if (meio < fim)
                return (left + right) / 2;
            else if (inicio < fim)
                return right;
            else
                return left;
        } else {
            if (fim < meio)
                return (left + right) / 2;
            else if (fim < inicio)
                return right;
            else
                return left;
        }
    }

    private void trocarPosicaoPivo(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}