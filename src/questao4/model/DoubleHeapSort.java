package questao4.model;

import utils.Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleHeapSort {
    private Heap heap = new Heap();

    public void heapSort(List<Generic> array){
        List<Generic> minimo = new ArrayList<>(array);
        List<Generic> maximo = new ArrayList<>(array);
        int n = array.size();

        for(int i = n/2-1; i>=0; i--){
            heap.maxHeapify(maximo, i, n);
            heap.minHeapify(minimo, i, n);
        }

        doubleOrganization(array, maximo, minimo);
    }

    private void doubleOrganization(List<Generic> array, List<Generic> maximo, List<Generic> minimo){
        int esq = 0;
        for(int dir = array.size()-1; dir >= array.size()/2; dir--){
            Collections.swap(maximo, 0, dir);
            Collections.swap(minimo, 0, dir);

            array.set(esq, minimo.get(dir));
            array.set(dir, maximo.get(dir));

            if(esq!=dir){
                heap.maxHeapify(maximo, 0, dir);
                heap.minHeapify(minimo, 0, dir);
            }
            esq++;
        }
    }

}
