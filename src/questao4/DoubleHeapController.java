package questao4;

import questao4.model.DoubleHeapSort;
import questao4.model.HeapThread;
import utils.Generic;
import utils.Vetor;

import java.util.List;

public class DoubleHeapController {
    private List<Generic> vetor;
    private List<Generic> vetorCopia;
    private long tempo;

    public DoubleHeapController(int tamanho, int tipo) {
        Vetor vetorController = new Vetor();
        vetor = vetorController.criar(tamanho, tipo);
        vetorCopia = vetorController.copiarVetor(vetor);
    }

    public List<Generic> getVetor() {
        return vetor;
    }

    public List<Generic> getVetorCopia() {
        return vetorCopia;
    }

    public long getTempo() {
        return tempo;
    }

    public long ordenarSemThread(){
        DoubleHeapSort doubleHeapSort =  new DoubleHeapSort();
        long inicio = System.currentTimeMillis();
        doubleHeapSort.heapSort(vetor);
        long fim = System.currentTimeMillis();
        tempo = fim - inicio;
        return tempo; //tempo em milissegundos para ordenar o vetor
    }

    public long ordenarComThread(){
        HeapThread heapThread = new HeapThread();
        long inicio = System.currentTimeMillis();
        heapThread.doubleHeapSort(vetor);
        long fim = System.currentTimeMillis();
        tempo = fim - inicio;
        return tempo;
    }
}
