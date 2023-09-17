/******************************
 * @authors  Daniel H., Isaac L., Sebastian J.
 * @date    16/09/2023
 * @purpose   Este archivo contiene el menu principal del proyecto
******************************/
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Map;

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
                    op2 = In.nextInt();
                    Utilerias.pruebaIndividual(op2);
                    Utilerias.pause();
                    break;
                case 2:
                    int[] array;
                    String[] nombresAlgoritmos = {"insertionSort        ", "selectionSort      ", "bubbleSort         ", "heapSort           ", "quickSort (p.m.o.t)", "quickSort (p.r.)   ",
                                                    "mergeSort          ", "countingSort       ", "radixSort          ", "shellSort          "};
                    array = Utilerias.crearArray();
                    int[] resultados = new int[10];
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
                    int k=0;
                    Map<Integer, String> mapaAlgoritmos = new TreeMap<>();
                    for (String nombreAlgoritmo : nombresAlgoritmos){
                        mapaAlgoritmos.put(resultados[k], nombreAlgoritmo);
                        k++;
                    }
                    System.out.println("Estos son los resultados:");
                    System.out.println("\tAlgoritmo\t\t\t\t\t\tNumero de Operaciones\n");
                    for (Map.Entry<Integer, String> entry : mapaAlgoritmos.entrySet()) {
                        System.out.print("\t" + entry.getValue() + "\t\t\t\t\t\t");
                        System.out.format("%,8d%n", entry.getKey());
                    }
//                        System.out.format("%,8d%n", resultados[i]);
//                        System.out.printf("%-15s%50s%n", nombresAlgoritmos[i], resultados[i]);
                    Utilerias.pause();
                    break;
                default:
                    return;
            }
        }
    }
}