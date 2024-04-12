package questao2;

import classesGerais.CriaVetor;
import classesGerais.Generic;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual o tamanho do vetor que você deseja ordenar: ");
        int tamanho = scanner.nextInt();
        System.out.print("\n1 - inteiro\n2 - String\n3 - double\n" +
                "Digite a opção do tipo de vetor que deseja ordenar: ");
        int opcao = scanner.nextInt();

        CriaVetor vetor = new CriaVetor();
        List<Generic> vetorCriado = vetor.criar(tamanho, opcao);
        System.out.println("\nVetor não ordenado: ");
        for(Generic v: vetorCriado){
            System.out.print(v.getValue() + " ");
        }

        SelectMinMax selectMinMax = new SelectMinMax();
        List<Generic> vetorOrdenado = selectMinMax.selectSort(vetorCriado);
        System.out.println("\nVetor ordenado: ");
        for(Generic v: vetorOrdenado){
            System.out.print(v.getValue() + " ");
        }
    }
}
