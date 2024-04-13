package questao4;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10000];
        for(int i =0; i<array.length; i++){
            array[i] = (int) (Math.random() * array.length);
        }

        DoubleHeapSort doubleHeapSort = new DoubleHeapSort();
        doubleHeapSort.heapSort(array);

        System.out.println("Não ordenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println("\nOrdenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
