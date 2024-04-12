package questao1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[100];
        for(int i =0; i<array.length; i++){
            array[i] = (int) (Math.random() * array.length);
        }
        System.out.println("desordenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

        int[] aux = new int[array.length];

        MergeInsert mergeInsert = new MergeInsert();
        mergeInsert.mergeSort(array, aux, 0, array.length-1);
        System.out.println("\nOrdenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
