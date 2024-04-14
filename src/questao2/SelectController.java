package questao2;

import questao2.model.SelectMinMax;
import utils.Generic;
import utils.Vetor;

import java.util.List;

public class SelectController {
    private List<Generic> vetor;
    private List<Generic> vetorCopia;
    private long tempo;
    public SelectController(int tamanho, int tipo) {
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

    public List<Generic> ordenar(){
        SelectMinMax selectMinMax = new SelectMinMax();
        long inicio = System.currentTimeMillis();
        List<Generic>vetorOrdenado = selectMinMax.selectSort(vetor);
        long fim = System.currentTimeMillis();

        tempo = fim - inicio;
        return vetorOrdenado;
    }
}
