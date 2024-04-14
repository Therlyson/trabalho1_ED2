package questao4;

import classesGerais.Generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DoubleHeapSort {

    public void heapSort(List<Generic> array){
        List<Generic> minimo = new ArrayList<>(array);
        List<Generic> maximo = new ArrayList<>(array);
        int n = array.size();

        for(int i = n/2-1; i>=0; i--){
            maxHeapify(maximo, i, n);
            minHeapify(minimo, i, n);
        }


//UMA IMPLEMENTAÇÃO DE THREAD
//        Thread thread1 = new Thread(() -> {
//            for(int i = n/2-1; i>=0; i--){
//                maxHeapify(maximo, i, n);
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            for(int i = n/2-1; i>=0; i--){
//                minHeapify(minimo, i, n);
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        doubleOrganization(array, maximo, minimo);
    }

    private void maxHeapify(List<Generic> array, int i, int tamanho) {
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
            Generic aux = array.get(i);
            array.set(i, array.get(raiz));
            array.set(raiz, aux);

            maxHeapify(array, raiz, tamanho);
        }
    }

    private void minHeapify(List<Generic> array, int i, int tamanho) { //ordena decrescente
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
            Generic aux = array.get(i);
            array.set(i, array.get(raiz));
            array.set(raiz, aux);

            minHeapify(array, raiz, tamanho);
        }
    }

    private void doubleOrganization(List<Generic> array, List<Generic> maximo, List<Generic> minimo){
        int esq = 0;
        for(int dir = array.size()-1; dir >= array.size()/2; dir--){
            Generic aux = maximo.get(0);
            maximo.set(0, maximo.get(dir));
            maximo.set(dir, aux);

            Generic aux2 = minimo.get(0);
            minimo.set(0, minimo.get(dir));
            minimo.set(dir, aux2);

            array.set(esq, minimo.get(dir));
            array.set(dir, maximo.get(dir));

            if(esq!=dir){
                maxHeapify(maximo, 0, dir);
                minHeapify(minimo, 0, dir);
            }
            esq++;
        }
    }

//    private void buscarThread(int[] maximo, int[] minimo, int tam){
//        Thread thread1 = new Thread(new HeapThread(maximo, tam, true));
//        Thread thread2 = new Thread(new HeapThread(minimo, tam, false));
//
//        thread1.start();
//        thread2.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
