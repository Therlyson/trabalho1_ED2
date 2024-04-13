package questao3;

import classesGerais.Generic;

import java.util.List;

public class BubbleSort {


    public void ordenar(List<Generic> array, int left, int right){
        Generic aux;
        for(int i = left; i<right; i++){
            for(int j = i+1; j <= right; j++){
                if(array.get(i).compareTo(array.get(j)) > 0){
                    aux = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, aux);
                }
            }
        }
    }
}
