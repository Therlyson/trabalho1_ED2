package questao3;

import classesGerais.Generic;

import java.util.Collections;
import java.util.List;

public class QuickBubbleSort {
    private final int MOMENTO_BUBBLE = 20;
    private BubbleSort bubbleSort = new BubbleSort  ();
    public void quicksort(List<Generic> arr, int left, int right) {
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

    private int partition(List<Generic> arr, int left, int right) {
        Generic meio = arr.get((left + right)/2);
        Generic inicio = arr.get(left);
        Generic fim = arr.get(right);

        int mediana = indexMediana(inicio, meio, fim, left, right);
        trocarPosicaoPivo(arr, mediana, right);

        Generic pivo = arr.get(right);
        int i = left - 1;
        Generic temp;
        for (int j = left; j < right; j++) {
            if (arr.get(j).compareTo(pivo) <= 0) {
                temp = arr.get(j);
                arr.set(j, arr.get(++i));
                arr.set(i, temp);
            }
        }
        temp = arr.get(i+1);
        arr.set(i+1, arr.get(right));
        arr.set(right, temp);
        return i + 1;
    }

    private int indexMediana(Generic inicio, Generic meio, Generic fim, int left, int right) {
        if (inicio.compareTo(meio) < 0) {
            if (meio.compareTo(fim) < 0)
                return (left + right) / 2;
            else if (inicio.compareTo(fim) < 0)
                return right;
            else
                return left;
        } else {
            if (fim.compareTo(meio) < 0)
                return (left + right) / 2;
            else if (fim.compareTo(inicio) < 0)
                return right;
            else
                return left;
        }
    }

    private void trocarPosicaoPivo(List<Generic> arr, int i, int j) {
        Collections.swap(arr, i, j);
        //Generic temp = arr.get(i);
        //arr.set(i, arr.get(j));
        //arr.set(j, temp);
    }
}