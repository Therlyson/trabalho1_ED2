package questao4;

import classesGerais.CriaVetor;
import classesGerais.Generic;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] array = new int[100000];
//        for(int i =0; i<array.length; i++){
//            array[i] = (int) (Math.random() * array.length);
//        }
//
////        System.out.println("Não ordenado: ");
////        for(int i =0; i<array.length; i++){
////            System.out.print(array[i] + " ");
////        }
//
//        DoubleHeapSort doubleHeapSort = new DoubleHeapSort();
//        long startTime = System.currentTimeMillis();
//        doubleHeapSort.heapSort(array);
//        long endTime = System.currentTimeMillis();
//        long temp = endTime-startTime;
//
////        System.out.println("\n\n\n");
////        System.out.println("\nOrdenado: ");
////        for(int i =0; i<array.length; i++){
////            System.out.print(array[i] + " ");
////        }
//
//        System.out.println();
//        System.out.println();
//        System.out.println(temp);

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

        DoubleHeapSort heap = new DoubleHeapSort();
        heap.heapSort(vetorCriado);
        System.out.println("\nVetor ordenado: ");
        for(Generic v: vetorCriado){
            System.out.print(v.getValue() + " ");
        }
    }
}
