package questao2;

import classesGerais.Generic;

import java.util.List;

public class SelectMinMax {
    private double tempo;
    public List<Generic> selectSort(List<Generic> array) {
        // Loop para percorrer metade do array
        for (int i = 0; i < array.size() / 2; i++) {
            // definicao da posicao do Menor e do Maior
            int posMenor = i;
            int posMaior = i;
            // for para encontrar o menor e o maior elemento dentro do intervalo não ordenado
            for (int j = i + 1; j < array.size() - i; j++) {
                // Compara e atualiza a posição do menor elemento
                if (array.get(j).compareTo(array.get(posMenor)) < 0) {
                    posMenor = j;
                }
                // Compara e atualiza a posição do maior elemento
                else if (array.get(j).compareTo(array.get(posMaior)) > 0) {
                    posMaior = j;
                }
            }
            // Troca de posição o menor com o primeiro elemento não ordenado
            Generic min = array.get(posMenor);
            array.set(posMenor, array.get(i));
            array.set(i, min);

            // Se o menor estiver na posição posMaior, atualiza posMaior
            if (posMaior == i) {
                posMaior = posMenor;
            }

            // Troca de posição o maior elemento com o último elemento não ordenado
            Generic max = array.get(posMaior);
            array.set(posMaior, array.get(array.size() - (i + 1)));
            array.set(array.size() - (i + 1), max);
        }
        return array;
    }
}