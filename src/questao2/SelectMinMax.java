package questao2;

public class SelectMinMax {
    public static void main(String[] args) {

        int[] array = new int[10000];
        for(int i =0; i<array.length; i++){
            array[i] = (int) (Math.random() * array.length);
        }

        System.out.println("Vetor não ordenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " -> ");
        }

        for(int i=0; i<array.length/2; i++){
            int posMenor = i;
            int posMaior = array.length-(i+1);
            for(int j=i; j<array.length-i; j++){
                if(array[j] < array[posMenor]){
                    posMenor = j;
                }
                else if(array[j] > array[posMaior]){
                    posMaior = j;
                }
            }
            int min = array[posMenor];
            array[posMenor] = array[i];
            array[i] = min;

            int max = array[posMaior];
            array[posMaior] = array[array.length-(i+1)];
            array[array.length-(i+1)] = max;
        }
        
        System.out.println("\nVetor ordenado: ");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i] + " -> ");
        }
    }
}