import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Principal{
    public static void main(String[] args){
        int op = 0, op2 = 0;
        Scanner In = new Scanner(System.in);
        while(true){
            Utilerias.menu1();
            op = In.nextInt();
            switch(op){
                case 1:
                    Utilerias.menu2();
                    break;
                case 2:
                    Utilerias.menu3();
                    op2 = In.nextInt();
                    Random aleatorio = new Random();
                    String[] nombresAlgoritmos = {"insertionSort", "selectionSort", "bubbleSort", "heapSort", "quickSort (p.m.o.t)", "quickSort (p.r.)",
                                                    "mergeSort", "countingSort", "radixSort", "shellSort"};
                    int[] array = new int[op2];
                    int[] resultados = new int[10];
                    System.out.println("Elige el caso que desees probar:\n\t1. Mejor Caso (Arreglo ordenado)");
                    System.out.println("\t2. Caso Promedio (Arreglo aleatorio valores entre 0 y 1000)\n\t3. Peor Caso (Arreglo ordenado al reves)");
                    op2 = In.nextInt();
                    switch(op2){
                        case 1: 
                            for(int i=0; i<array.length; i++)
                                array[i] = i;
                            break;
                        case 2:
                            for(int i=0; i<array.length; i++)
                                array[i] = aleatorio.nextInt(1001);
                            break;  
                        case 3:
                            for(int i=0; i<array.length; i++)
                                array[i] = array.length-i;
                            break;
                    }
                    int[] arrayTest = Arrays.copyOf(array, array.length);
                    resultados[0] = Ordenamientos.insertionSort(arrayTest);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[1] = Ordenamientos.selectionSort(arrayTest);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[2] = Ordenamientos.bubbleSort(arrayTest);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[3] = Ordenamientos.heapSort(arrayTest);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[4] = Ordenamientos.QuickSort(arrayTest, 0, array.length-1);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[5] = Ordenamientos.QuickSort2(arrayTest);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[6] = Ordenamientos.sort(arrayTest, 0, arrayTest.length-1);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[7] = Ordenamientos.countingSort(arrayTest);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[8] = Ordenamientos.radixSort(arrayTest);
                    arrayTest = Arrays.copyOf(array, array.length);
                    resultados[9] = Ordenamientos.shellSort(arrayTest);

                

                    System.out.println("Estos son los resultados:");
                    System.out.println("\tAlgoritmo\t\t\t\t\tNumero de Operaciones\n");
                    for(int i=0; i<resultados.length; i++){
                        System.out.print("\t" + nombresAlgoritmos[i] + "\t\t\t\t\t\t");
                        System.out.format("%,8d%n", resultados[i]);
                    }
                    //System.out.format("%15s%80\n", nombresAlgoritmos[i], resultados[i]);
//                    Utilerias.printArray(array);
//                    Utilerias.printArray(arrayTest);
                    Utilerias.pause();
                    break;
                default:
                    return;
            }
        }








        /*
        Random aleatorio = new Random();
        int[] arr = new int[10000];
        for(int i=0; i<arr.length; i++)
        //    arr[i] = i;
        //    arr[i] = aleatorio.nextInt(1000);
        //    arr[i] = arr.length-i;
        System.out.println("Este es el arreglo:");
        Utilerias.printArray(arr);
        System.out.println("El numero de operaciones fue: " + Ordenamientos.sort(arr, 0, arr.length-1));
        Utilerias.printArray(arr);*/
    }
}