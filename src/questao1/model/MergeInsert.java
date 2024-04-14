package questao1.model;

import questao1.model.InsertSort;
import utils.Generic;

import java.util.List;

public class MergeInsert {
    //Definição de um tamanho para o subvetor utilizar o Insertion Sort
    private final int MOMENTO_INSERT = 300;
    InsertSort insertSort = new InsertSort();

    //Método para utilizar o mergeSort, e também o insertionSort para casos pequenos.
    public void mergeSort(List<Generic> vetor, List<Generic> auxiliar, int inicio, int fim){
        if(inicio < fim){
            if((fim-inicio) < MOMENTO_INSERT){  //caso base, verifica se o vetor está no limite de uso do insertion
                insertSort.ordenar(vetor, inicio, fim); // Chama o método ordenar do InsertSort
                return;
            }
            //Definição do meio, e chamada recursiva do mergeSort:
            int meio = (inicio+fim)/2;
            mergeSort(vetor, auxiliar, inicio, meio); //Merge do inicio até o meio
            mergeSort(vetor, auxiliar, meio+1, fim); //Merge do meio+1 até o fim da lista

            //Condição de comparação para ver se o vetor já está ordenado:
            if(vetor.get(meio).compareTo(vetor.get(meio+1)) <= 0){
                return;
            }
            // Realiza a intercalação dos subvetores
            intercalar(vetor, auxiliar, inicio, meio, fim);
        }
    }

    private void intercalar(List<Generic> vetor, List<Generic> auxiliar, int inicio, int meio, int fim) {
        //Nesse for é definido os elementos de auxiliar baseado no vetor
        for(int i = inicio; i<=fim; i++){
            auxiliar.set(i, vetor.get(i));
        }
        //Definindo o indice do primeiro elemento do subvetor esquerdo e do subvetor direito
        int esq = inicio;
        int dir = meio+1;
        //For que incrementa +1 ao i a cada execução, rodando do inicio do vetor ate o fim
        for(int i = inicio; i<=fim; i++){
            // Se todos os elementos do subvetor esquerdo já foram inseridos, insere os elementos do subvetor direito
            if(esq>meio){
                vetor.set(i, auxiliar.get(dir++));
            }
            // Se todos os elementos do subvetor direito já foram inseridos, insere os elementos do subvetor esquerdo
            else if(dir > fim){
                vetor.set(i, auxiliar.get(esq++));
            }
            // Se o elemento do subvetor esquerdo for menor ou igual ao elemento do subvetor direito,
            // insere o elemento do subvetor esquerdo
            else if(auxiliar.get(esq).compareTo(auxiliar.get(dir)) <= 0){
                vetor.set(i, auxiliar.get(esq++));
            }
            // Se o elemento do subvetor direito for menor que o elemento do subvetor esquerdo,
            // insere o elemento do subvetor direito
            else if(auxiliar.get(dir).compareTo(auxiliar.get(esq)) < 0) {
                vetor.set(i, auxiliar.get(dir++));
            }
        }
    }
}
