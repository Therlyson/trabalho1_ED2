package questao1;

import classesGerais.Generic;

import java.util.List;

public class MergeInsert {
    private final int MOMENTO_INSERT = 20;

    public void mergeSort(List<Generic> vetor, List<Generic> auxiliar, int inicio, int fim){
        if(inicio < fim){
            if((fim-inicio) < MOMENTO_INSERT){  //caso base o vetor tem 3 vetores
                insertSort(vetor, inicio, fim);
                return;
            }
            int meio = (inicio+fim)/2;
            mergeSort(vetor, auxiliar, inicio, meio);
            mergeSort(vetor, auxiliar, meio+1, fim);

            if(vetor.get(meio).compareTo(vetor.get(meio+1)) <= 0){
                return;
            }

            intercalar(vetor, auxiliar, inicio, meio, fim);
        }
    }

    private void intercalar(List<Generic> vetor, List<Generic> auxiliar, int inicio, int meio, int fim) {
        for(int i = inicio; i<=fim; i++){
            auxiliar.set(i, vetor.get(i));
        }
        int esq = inicio;
        int dir = meio+1;

        for(int i = inicio; i<=fim; i++){
            if(esq>meio){
                vetor.set(i, auxiliar.get(dir++));
            }
            else if(dir > fim){
                vetor.set(i, auxiliar.get(esq++));
            }
            else if(auxiliar.get(esq).compareTo(auxiliar.get(dir)) <= 0){
                vetor.set(i, auxiliar.get(esq++));
            }
            else if(auxiliar.get(dir).compareTo(auxiliar.get(esq)) < 0) {
                vetor.set(i, auxiliar.get(dir++));
            }
        }
    }

    // 1, 5, 14, 5, 7 ---> 1, 5, 7, 5, 7 ---> 1, 5, 7, 12, 7 ---> 1, 5, 7, 12, 14

    private void insertSort(List<Generic> array, int inicio, int fim){
        Generic aux2;
        int j;
        for(int i=inicio+1; i<=fim; i++){
            aux2 = array.get(i);
            j = i-1;
            while(j>=inicio && array.get(j).compareTo(aux2) > 0){  //j >= inicio e não j>=0
                array.set(j+1, array.get(j));
                j--;
            }
            array.set(j+1, aux2);
        }
    }
}
