package questao1;

import questao1.model.MergeInsert;
import utils.Generic;
import utils.Vetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeInsertController {
    private List<Generic> vetor;
    private List<Generic> vetorAuxiliar;
    private List<Generic> vetorCopia;
    private long tempo;

    public MergeInsertController(int tamanho, int tipo) {
        Vetor vetorController = new Vetor();
        vetor = vetorController.criar(tamanho, tipo);
        vetorCopia = vetorController.copiarVetor(vetor);
        vetorAuxiliar = new ArrayList<>(Collections.nCopies(vetor.size(), null));
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
        MergeInsert mergeInsert = new MergeInsert();
        long inicio = System.currentTimeMillis();
        mergeInsert.mergeSort(vetor, vetorAuxiliar,0 , vetor.size()-1);
        long fim = System.currentTimeMillis();

        tempo = fim - inicio;
        return tempo;
    }
}
