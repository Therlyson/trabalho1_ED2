package questao3.model;

import utils.Generic;

import java.util.List;

public class BubbleSort {
    public void ordenar(List<Generic> array, int left, int right){
        Generic aux;
        // Loop para percorrer o array
        for(int i = left; i<right; i++){
            // Loop para comparar e trocar elementos
            for(int j = i+1; j <= right; j++){
                // Se o elemento atual percorrido for maior que o proximo, ocorre a troca.
                if(array.get(i).compareTo(array.get(j)) > 0){
                    aux = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, aux);
                }
            }
        }
    }
}
