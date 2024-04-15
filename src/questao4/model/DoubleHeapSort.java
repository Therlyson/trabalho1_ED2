package questao4.model;

import utils.Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleHeapSort {
    private Heap heap = new Heap();

    public void heapSort(List<Generic> array){
        List<Generic> minimo = new ArrayList<>(array); //cria uma cópia do vetor original
        List<Generic> maximo = new ArrayList<>(array);
        int n = array.size();

        for(int i = n/2-1; i>=0; i--){
            heap.maxHeapify(maximo, i, n);  //vetor que os pais são maiores que os filhos
            heap.minHeapify(minimo, i, n);  //vetor que os pais são menores que os filhos
        }

        doubleOrganization(array, maximo, minimo);
    }

    private void doubleOrganization(List<Generic> array, List<Generic> maximo, List<Generic> minimo){
        int esq = 0;
        //dir >= array.size()/2, pois agora vamos ordenar o último e o primeiro ao mesmo tempo, sendo necessário percorrer apenas até a metade do vetor
        for(int dir = array.size()-1; dir >= array.size()/2; dir--){
            Collections.swap(maximo, 0, dir); //inverte a posição final com a inicial e coloca o maior elemento para o final do vetor
            Collections.swap(minimo, 0, dir); //inverte a posição final com a inicial e coloca o menor elemento para o final do vetor

            //adiciona o menor elemento do vetor que se encontra na última posição do vetor minimo, ao inicio do original
            array.set(esq, minimo.get(dir));
            //adiciona o maior elemento do vetor que se encontra na última posição do vetor maximo, ao fim do vetor original
            array.set(dir, maximo.get(dir));

            //enquanto não chegarem na mesma posição, faz o maxHeapify adicionando o próximo maior elemento do vetor ao inicio do vetor maximo
            //e o minHeapify adicionando o próximo menor elemento ao inicio do vetor minimo.
            if(esq!=dir){
                heap.maxHeapify(maximo, 0, dir);
                heap.minHeapify(minimo, 0, dir);
            }
            esq++;
        }
    }

}
