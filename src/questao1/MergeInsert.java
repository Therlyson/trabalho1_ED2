package questao1;

public class MergeInsert {

    public void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim){
        if(inicio < fim){
            if((fim-inicio) < 15){  //caso base o vetor tem 3 vetores
                insertSort(vetor, inicio, fim);
                return;
            }
            int meio = (inicio+fim)/2;
            mergeSort(vetor, auxiliar, inicio, meio);
            mergeSort(vetor, auxiliar, meio+1, fim);

            if(vetor[meio] <= vetor[meio+1]){
                return;
            }

            intercalar(vetor, auxiliar, inicio, meio, fim);
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

    private void insertSort(int[] array, int inicio, int fim){
        int aux2, j;
        for(int i=inicio+1; i<=fim; i++){
            aux2 = array[i];
            j = i-1;
            while(j>=inicio && array[j] > aux2){  //j >= inicio e não j>=0
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = aux2;
        }
    }
}
