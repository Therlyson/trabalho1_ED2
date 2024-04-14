package questao4;

public class Teste {
    public static void main(String[] args) {
        int[] array = new int[100];
        for(int i =0; i<array.length; i++){
            array[i] = (int) (Math.random() * array.length);
        }
        int tamanho = array.length;

        // Criar dois heaps vazios
        int[] heapMinimo = new int[tamanho];
        int[] heapMaximo = new int[tamanho];
        int tamanhoHeapMinimo = 0;
        int tamanhoHeapMaximo = 0;

        System.out.println("Não ordenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

        // Alternar entre a inserção de elementos nos heaps mínimo e máximo
        for (int i = 0; i < tamanho; i++) {
            if (i % 2 == 0) {
                insertHeapMinimo(heapMinimo, array[i], tamanhoHeapMinimo);
                tamanhoHeapMinimo++;
            } else {
                insertHeapMaximo(heapMaximo, array[i], tamanhoHeapMaximo);
                tamanhoHeapMaximo++;
            }
        }

        // Intercale os elementos dos dois heaps para formar o vetor ordenado final
        int indice = 0;
        while (tamanhoHeapMinimo > 0 && tamanhoHeapMaximo > 0) {
            array[indice++] = extractMin(heapMinimo, tamanhoHeapMinimo--);
            array[indice++] = extractMax(heapMaximo, tamanhoHeapMaximo--);
        }

        // Se algum heap ainda tiver elementos, adicione-os ao vetor ordenado
        while (tamanhoHeapMinimo > 0) {
            array[indice++] = extractMin(heapMinimo, tamanhoHeapMinimo--);
        }
        while (tamanhoHeapMaximo > 0) {
            array[indice++] = extractMax(heapMaximo, tamanhoHeapMaximo--);
        }

        System.out.println("\nordenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

    }

    private static void insertHeapMinimo(int[] heap, int valor, int tamanho) {
        heap[tamanho] = valor;
        int indice = tamanho;
        while (indice > 0 && heap[(indice - 1) / 2] > heap[indice]) {
            // Trocar pai e filho
            int temp = heap[(indice - 1) / 2];
            heap[(indice - 1) / 2] = heap[indice];
            heap[indice] = temp;
            indice = (indice - 1) / 2;
        }
    }

    private static void insertHeapMaximo(int[] heap, int valor, int tamanho) {
        heap[tamanho] = valor;
        int indice = tamanho;
        while (indice > 0 && heap[(indice - 1) / 2] < heap[indice]) {
            // Trocar pai e filho
            int temp = heap[(indice - 1) / 2];
            heap[(indice - 1) / 2] = heap[indice];
            heap[indice] = temp;
            indice = (indice - 1) / 2;
        }
    }

    private static int extractMin(int[] heap, int tamanho) {
        int minimo = heap[0];
        heap[0] = heap[tamanho - 1];
        tamanho--;
        minHeapify(heap, 0, tamanho);
        return minimo;
    }

    private static int extractMax(int[] heap, int tamanho) {
        int maximo = heap[0];
        heap[0] = heap[tamanho - 1];
        tamanho--;
        maxHeapify(heap, 0, tamanho);
        return maximo;
    }

    private static void maxHeapify(int[] array, int i, int tamanho) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if(esquerda < tamanho && array[esquerda] > array[raiz]){
            raiz = esquerda;
        }
        if(direita < tamanho && array[direita] > array[raiz]){
            raiz = direita;
        }

        if(raiz != i){
            int aux = array[i];
            array[i] = array[raiz];
            array[raiz] = aux;

            maxHeapify(array, raiz, tamanho);
        }
    }

    private static void minHeapify(int[] array, int i, int tamanho) { //ordena decrescente
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if(esquerda < tamanho && array[esquerda] < array[raiz]){
            raiz = esquerda;
        }
        if(direita < tamanho && array[direita] < array[raiz]){
            raiz = direita;
        }

        if(raiz != i){
            int aux = array[i];
            array[i] = array[raiz];
            array[raiz] = aux;

            minHeapify(array, raiz, tamanho);
        }
    }
}
