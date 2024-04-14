package questao4;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for(int i =0; i<array.length; i++){
            array[i] = (int) (Math.random() * array.length);
        }

        System.out.println("Não ordenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

        DoubleHeapSort doubleHeapSort = new DoubleHeapSort();
        doubleHeapSort.heapSort(array);

        System.out.println("\nOrdenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
