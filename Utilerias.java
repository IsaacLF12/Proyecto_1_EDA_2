
public class Utilerias{
    public static void printArray(int[] arr){
        for(int i : arr)
            System.out.print("\t " + i);
        System.out.print("\n");
    }
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];   
        arr[x] = arr[y];  
        arr[y] = temp;
    }
    public static int mayorArr(int[] arr, int[] operations){
        int M = arr[0];
        for(int i : arr){
            if(M<i){
                M = i;
                operations[0]+=1;
            }
            operations[0]+=1;
        }
        operations[0]+=3;
        return M;
    }
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void pause(){
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }
    public static void menu1(){
        clearScreen();
        System.out.println("--------------------- PROYECTO 1 EDA 2 ---------------------");
        System.out.println("Elige la opcion que desees:\n\t1. Probar un algoritmo de forma individual\n\t2. Comparar todos los algoritmos");
    }
    public static void menu2(){
        String[] nombresAlgoritmos = {"insertionSort", "selectionSort", "bubbleSort", "heapSort", "quickSort (p.m.o.t)", "quickSort (p.r.)",
                                                    "mergeSort", "countingSort", "radixSort", "shellSort"};
        clearScreen();
        System.out.println("Elige el algoritmo a probar");
        for(int i=0; i<nombresAlgoritmos.length; i++)
            System.out.println("\t"+(i+1)+". "+nombresAlgoritmos[i]);
    }
    public static void menu3(){
        clearScreen();
        System.out.print("Elige el tamanio del arreglo (numero de valores a ordenar): ");
    }
}