package questao1;

import classesGerais.Generic;

import java.util.List;

public class InsertSort {
    public void ordenar(List<Generic> array, int inicio, int fim){
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
