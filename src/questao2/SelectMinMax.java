package questao2;

import classesGerais.Generic;

import java.util.List;

public class SelectMinMax {

    public List<Generic> selectSort(List<Generic> array) {

        for (int i = 0; i < array.size() / 2; i++) {
            int posMenor = i;
            int posMaior = i;
            for (int j = i+1; j < array.size() - i; j++) {
                if (array.get(j).compareTo(array.get(posMenor)) < 0) {
                    posMenor = j;
                } else if (array.get(j).compareTo(array.get(posMaior)) > 0) {
                    posMaior = j;
                }
            }

            Generic min = array.get(posMenor);
            array.set(posMenor, array.get(i));
            array.set(i, min);

            // Se o menor estiver na posição posMaior, atualiza posMaior
            if (posMaior == i) {
                posMaior = posMenor;
            }

            Generic max = array.get(posMaior);
            array.set(posMaior, array.get(array.size() - (i + 1)));
            array.set(array.size() - (i + 1), max);
        }
        return array;
    }

}