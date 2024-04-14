package questao4;

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

        System.out.print("\n0 - Desejo utilizar threads no doubleHeapSort\n1 - Sem threads\nDigite sua opção: ");
        int op = scanner.nextInt();

        CriaVetor vetor = new CriaVetor();
        List<Generic> vetorCriado = vetor.criar(tamanho, opcao);
        System.out.println("\nVetor não ordenado: ");
        for(Generic v: vetorCriado){
            System.out.print(v.getValue() + " ");
        }

        if(op == 0){
            HeapThread doubleHeap = new HeapThread();
            long inicio = System.currentTimeMillis();
            doubleHeap.doubleHeapSort(vetorCriado);
            long fim = System.currentTimeMillis();
            long temp = fim - inicio;
            //System.out.println(temp);
        }else{
            DoubleHeapSort doubleHeap = new DoubleHeapSort();
            long inicio = System.currentTimeMillis();
            doubleHeap.heapSort(vetorCriado);
            long fim = System.currentTimeMillis();
            long temp = fim - inicio;
           // System.out.println(temp);
        }

        System.out.println("\nVetor ordenado: ");
        for(Generic v: vetorCriado){
            System.out.print(v.getValue() + " ");
        }
    }
}
