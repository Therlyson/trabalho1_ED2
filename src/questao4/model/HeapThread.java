package questao4.model;

import questao4.model.Heap;
import utils.Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapThread{
    private Heap heap = new Heap();

    public void doubleHeapSort(List<Generic> array) {
        List<Generic> minHeap = new ArrayList<>(array);
        List<Generic> maxHeap = new ArrayList<>(array);

        int n = array.size();

        Thread minHeapThread = new Thread(() -> buildMinHeap(minHeap, n)); // Thread para construir o min-heap
        Thread maxHeapThread = new Thread(() -> buildMaxHeap(maxHeap, n)); // Thread para construir o max-heap

        minHeapThread.start();
        maxHeapThread.start();

        try {
            // Aguardar término da thread do min-heap e max-heap
            minHeapThread.join();
            maxHeapThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        doubleOrganizeArray(array, maxHeap, minHeap);
    }

    // Método para construir o max-heap, começando da posição raiz em que os filhos sáo os últimos no vetor
    private void buildMaxHeap(List<Generic> array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heap.maxHeapify(array, i, size);
        }
    }
    // Método para construir o min-heap
    private void buildMinHeap(List<Generic> array, int size){
        for (int i = size / 2 - 1; i >= 0; i--) {
            heap.minHeapify(array, i, size);
        }
    }

    private void doubleOrganizeArray(List<Generic> array, List<Generic> maxHeap, List<Generic> minHeap) {
        int left = 0;
        int right = array.size() - 1;

        for (int i = right; i >= array.size() / 2; i--) {
            Collections.swap(maxHeap, 0, i);
            Collections.swap(minHeap, 0, i);

            array.set(left, minHeap.get(i));
            array.set(right, maxHeap.get(i));

            if (left != right) {
                heap.maxHeapify(maxHeap, 0, i);
                heap.minHeapify(minHeap, 0, i);
            }
            left++;
        }
    }
}
