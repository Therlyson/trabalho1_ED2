import questao1.MergeInsertController;
import questao2.SelectController;
import questao3.QuickBubbleController;
import questao4.DoubleHeapController;
import utils.Generic;

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
        System.out.print("\n1 - MergeInsert\n2 - SelectMinMax\n3 - QuickBubble\n4 - DoubleHeap\n" +
                "Digite a opção de algoritmo que você deseja utilizar: ");
        int algoritmo = scanner.nextInt();
        switch (algoritmo) {
            case 1:
                System.out.println("MergeInsert Sort: ");
                MergeInsertController mergeInsertController = new MergeInsertController(tamanho, opcao);
                System.out.println("Vetor não ordenado: ");
                for (Generic v : mergeInsertController.getVetorCopia())
                    System.out.print(v.getValue() + " ");
                System.out.println("\nVetor ordenado: ");
                mergeInsertController.ordenar();
                for (Generic v : mergeInsertController.getVetor())
                    System.out.print(v.getValue() + " ");
                System.out.println("\nTempo de execução em milissegundos: " + mergeInsertController.getTempo());
                break;
            case 2:
                System.out.println("SelectMinMax Sort: ");
                SelectController selectController = new SelectController(tamanho, opcao);
                System.out.println("Vetor não ordenado: ");
                for (Generic v : selectController.getVetorCopia())
                    System.out.print(v.getValue() + " ");
                System.out.println("\nVetor ordenado: ");
                List<Generic> vetor = selectController.ordenar();
                for (Generic v : vetor)
                    System.out.print(v.getValue() + " ");
                System.out.println("\nTempo de execução em milissegundos: " + selectController.getTempo());
                break;
            case 3:
                System.out.println("QuickBubble sort: ");
                QuickBubbleController quickBubbleController = new QuickBubbleController(tamanho, opcao);
                System.out.println("Vetor não ordenado: ");
                for (Generic v : quickBubbleController.getVetorCopia())
                    System.out.print(v.getValue() + " ");
                System.out.println("\nVetor ordenado: ");
                quickBubbleController.ordenar();
                for (Generic v : quickBubbleController.getVetor()){
                    System.out.print(v.getValue() + " ");
                }
                System.out.println("\nTempo de execução em milissegundos: " + quickBubbleController.getTempo());

                break;
            case 4:
                System.out.println("DoubleHeap sort: ");
                DoubleHeapController doubleHeapController = new DoubleHeapController(tamanho, opcao);
                System.out.println("1 - Sem Thread\n2 - Com Thread\n" + "Escolha uma opção: ");
                int tipo = scanner.nextInt();
                if (tipo == 1){
                    System.out.println("Vetor não ordenado: ");
                    for (Generic v : doubleHeapController.getVetorCopia())
                        System.out.print(v.getValue() + " ");
                    System.out.println("\nVetor ordenado: ");
                    doubleHeapController.ordenarSemThread();
                    for (Generic v : doubleHeapController.getVetor())
                        System.out.println(v.getValue() + " ");
                }
                else if (tipo == 2) {
                    System.out.println("Vetor não ordenado: ");
                    for (Generic v : doubleHeapController.getVetorCopia())
                        System.out.print(v.getValue() + " ");
                    System.out.println("\nVetor ordenado: ");
                    doubleHeapController.ordenarComThread();
                    for (Generic v : doubleHeapController.getVetor())
                        System.out.println(v.getValue() + " ");
                }
                System.out.println("\nTempo de execução em milissegundos: " + doubleHeapController.getTempo());
                break;
            default:
                System.out.println("Opção de algoritmo inválida.");
        }
    }
}
