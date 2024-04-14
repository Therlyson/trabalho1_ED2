package questao3;

import questao3.model.QuickBubbleSort;
import utils.Generic;
import utils.Vetor;

import java.util.List;

public class QuickBubbleController {
    private List<Generic> vetor;
    private List<Generic> vetorCopia;
    private long tempo;

    public QuickBubbleController(int tamanho, int tipo) {
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

    public long ordenar(){
        QuickBubbleSort quickBubbleSort = new QuickBubbleSort();
        long inicio = System.currentTimeMillis();
        quickBubbleSort.quicksort(vetor, 0, vetor.size()-1);
        long fim = System.currentTimeMillis();

        tempo = fim - inicio;
        return tempo;
    }
}
