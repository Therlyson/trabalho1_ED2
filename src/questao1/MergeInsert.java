package questao1;

import java.util.List;

public class MergeInsert {
//    int[] auxiliar = new int[array.length];
//    mergeSort(array, auxiliar, 0, array.length-1);

    public void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim){
        if(inicio < fim){
            if(vetor.length <= 2){
                insertSort(vetor, inicio, fim);
                return;
            }
            int meio = (inicio+fim)/2;
            mergeSort(vetor, auxiliar, inicio, meio);
            mergeSort(vetor, auxiliar, meio+1, fim);

            int chave = 0;
            for(int i=inicio; i<fim; i++){
                if(vetor[i] > vetor[i+1]){
                    chave = 1;
                    break;
                }
            }
            if(chave == 1){
                intercalar(vetor, auxiliar, inicio, meio, fim);
            }
        }
    }

    private void intercalar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {
        for(int i = inicio; i<=fim; i++){
            auxiliar[i] = vetor[i]; 
        }
        int esq = inicio;
        int dir = meio+1;

        for(int i = inicio; i<=fim; i++){
            if(esq>meio){
                vetor[i] = auxiliar[dir++];
            }
            else if(dir > fim){
                vetor[i] = auxiliar[esq++];
            }
            else if(auxiliar[esq] <= auxiliar[dir]){
                vetor[i] = auxiliar[esq++]; // vetor[0] = auxiliar[0]
            }
            else if(auxiliar[dir] < auxiliar[esq]) {
                vetor[i] = auxiliar[dir++];
            }
        }
    }

    // 1, 5, 14, 5, 7 ---> 1, 5, 7, 5, 7 ---> 1, 5, 7, 12, 7 ---> 1, 5, 7, 12, 14

    public void insertSort(int[] array, int inicio, int fim){
        int aux2, j;
        for(int i=inicio; i<=fim; i++){
            aux2 = array[i];
            j = i-1;
            while(j>=0 && array[j] > aux2){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = array[aux2];
        }
    }

}
