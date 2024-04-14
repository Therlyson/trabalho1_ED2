package questao1.model;

import utils.Generic;

import java.util.List;

public class InsertSort {
    public void ordenar(List<Generic> array, int inicio, int fim){
        Generic aux2;
        int j;
        // Itera sobre os elementos da lista, começando do segundo elemento
        for(int i=inicio+1; i<=fim; i++){
            aux2 = array.get(i);
            j = i-1;
            // Move os elementos maiores que o elemento atual para frente na lista
            // até encontrar a posição correta para inserir o elemento atual
            while(j>=inicio && array.get(j).compareTo(aux2) > 0){
                array.set(j+1, array.get(j));
                j--;
            }
            array.set(j+1, aux2); // Insere o elemento atual na posição correta na lista ordenada
        }
    }
}
