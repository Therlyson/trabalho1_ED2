package questao4.model;

import utils.Generic;

import java.util.Collections;
import java.util.List;

public class Heap{

    public void maxHeapify(List<Generic> array, int i, int tamanho) {
        int raiz = i;
        int esquerda = 2 * i + 1;  //cálculo para saber os filhos da raiz.
        int direita = 2 * i + 2;
        if(esquerda < tamanho && array.get(esquerda).compareTo(array.get(raiz)) > 0){
            raiz = esquerda;  //se o filho for maior que o pai, o filho passa a ser raiz
        }
        if(direita < tamanho && array.get(direita).compareTo(array.get(raiz)) > 0){
            raiz = direita;  //se o filho for maior que o pai, o filho passa a ser a raiz
        }

        if(raiz != i){  //se a raiz mudou durante a execução, troca o filho(nova raiz) e o pai de posição.
            Collections.swap(array, i, raiz);
            maxHeapify(array, raiz, tamanho); //chama novamente o método para saber se esse novo pai ainda é maior que os filhos.
        }
    }

    //mesma lógica do maxHeapify, só que agora testa se o pai é menor que os filhos
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
