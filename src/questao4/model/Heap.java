package questao4.model;

import utils.Generic;

import java.util.Collections;
import java.util.List;

public class Heap{

    public void maxHeapify(List<Generic> array, int i, int tamanho) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if(esquerda < tamanho && array.get(esquerda).compareTo(array.get(raiz)) > 0){
            raiz = esquerda;
        }
        if(direita < tamanho && array.get(direita).compareTo(array.get(raiz)) > 0){
            raiz = direita;
        }

        if(raiz != i){
            Collections.swap(array, i, raiz);
            maxHeapify(array, raiz, tamanho);
        }
    }

    public void minHeapify(List<Generic> array, int i, int tamanho) { //ordena decrescente
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if(esquerda < tamanho && array.get(esquerda).compareTo(array.get(raiz)) < 0){
            raiz = esquerda;
        }
        if(direita < tamanho && array.get(direita).compareTo(array.get(raiz)) < 0){
            raiz = direita;
        }

        if(raiz != i){
            Collections.swap(array, i, raiz);
            minHeapify(array, raiz, tamanho);
        }
    }
}
