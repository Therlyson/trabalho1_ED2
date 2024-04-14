package questao1;

import classesGerais.CriaVetor;
import classesGerais.Generic;

import java.util.ArrayList;
import java.util.Collections;
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

        List<Generic> auxiliar = new ArrayList<>(Collections.nCopies(vetorCriado.size(), null));

        MergeInsert mergeInsert = new MergeInsert();
        long startTime = System.currentTimeMillis();
        mergeInsert.mergeSort(vetorCriado, auxiliar, 0, vetorCriado.size()-1);
        long endTime = System.currentTimeMillis();

        System.out.println("\nVetor ordenado: ");
        for(Generic v: vetorCriado){
            System.out.print(v.getValue() + " ");
        }
        System.out.println();
        long temp = endTime-startTime;
        System.out.println("Tempo de execução em milissegundos: " + temp);
    }
}
