package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Vetor {

    public List<Generic> criar(int tam, int tipo){
        Random random = new Random();
        List<Generic> list = new ArrayList<>();

        switch(tipo) {
            case 1:
                for(int i = 0 ; i<tam;i++) {
                    list.add(new Generic<Integer>(random.nextInt(tam)));
                }
                break;
            case 2:
                for(int i = 0 ; i<tam;i++) {
                    list.add(new Generic<String>(generateRandomString()));
                }
                break;
            case 3:
                for(int i = 0 ; i<tam;i++) {
                    list.add(new Generic<Double>(random.nextDouble(tam)));
                }
                break;
            default:
                System.out.println("Seleção inválida! Apenas 1,2 ou 3.");
        }
        return list;
    }

    private String generateRandomString() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(7);

        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public List<Generic> copiarVetor(List<Generic> vetor) {
        List<Generic> copia = new ArrayList<>();

        for (Generic elemento : vetor) {
            // Cria uma cópia do elemento e adiciona à lista de cópias
            copia.add(new Generic<>(elemento.getValue()));
        }

        return copia;
    }


}