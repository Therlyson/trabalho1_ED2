package questao3.model;

import questao3.model.BubbleSort;
import utils.Generic;

import java.util.Collections;
import java.util.List;

public class QuickBubbleSort {
    // Valor limite para utilizar o bubble
    private final int MOMENTO_BUBBLE = 100;
    private BubbleSort bubbleSort = new BubbleSort  ();
    public void quicksort(List<Generic> arr, int left, int right) {
        if (left < right) {
            // Verifica se o tamanho da parte do array é menor ou igual ao limite, se for, usa Bubble Sort para ordenar
            if ((right - left) <= MOMENTO_BUBBLE){
                bubbleSort.ordenar(arr, left, right);
                return;
            }

            int pivo = partition(arr, left, right); // Esse pivo retorna o indice que o pivo deve ocupar na lista (nesse caso, mediana de 3)

            // Recursivamente ordena as subpartes à esquerda e à direita do pivô
            quicksort(arr, left, pivo - 1); // Agora o right (ultimo elemento desse arr), vai ser o elemento que vem antes do pivo.
            quicksort(arr, pivo + 1, right); // Agora o left (primeiro elemento desse arr), vai ser o elemento que vem depois do pivo.
        }
    }

    private int partition(List<Generic> arr, int left, int right) {
        // Encontra a mediana de três elementos como pivô
        Generic meio = arr.get((left + right)/2);
        Generic inicio = arr.get(left);
        Generic fim = arr.get(right);
        int mediana = indexMediana(inicio, meio, fim, left, right);

        // Troca o elemento da posição da mediana com o último elemento do array
        trocarPosicaoPivo(arr, mediana, right);
        Generic pivo = arr.get(right);

        // Faz a partição do array em torno do pivô
        int i = left - 1;
        Generic temp;
        // Loop para percorrer a sublista da esquerda para a direita
        for (int j = left; j < right; j++) {
            // Verifica se o elemento atual é menor ou igual ao pivô
            if (arr.get(j).compareTo(pivo) <= 0) {
                // troca as posições entre os elementos no indice j e no indice ++i
                temp = arr.get(j);
                arr.set(j, arr.get(++i));
                arr.set(i, temp);
            }
        }
        // Coloca o pivô na posição correta, após todos os elementos menores ou iguais a ele
        temp = arr.get(i+1);
        arr.set(i+1, arr.get(right));
        arr.set(right, temp);
        return i + 1;
    }

    // Método para calcular o índice da mediana de três elementos
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

    // Método para trocar a posição do pivô com o último elemento do array
    private void trocarPosicaoPivo(List<Generic> arr, int i, int j) {
        Collections.swap(arr, i, j);
    }
}