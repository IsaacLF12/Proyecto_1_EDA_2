import java.util.Random;
import java.util.Scanner;

/**
 * En este archivo se encuentran funciones de utileria asi como modulos del menu para subdividir el programa principal
 * @author Daniel H., Isaac L., Sebastian J.
 * @version 1.0
 */

public class Utilerias {
    /**
    * Permite imprimir un arreglo en pantalla.
    * @param arr Arreglo a imprimir
    */
    public static void printArray(int[] arr){
        for(int i : arr)
            System.out.print("\t " + i);
        System.out.print("\n");
    }
    /**
    * Intercambia dos elementos de un arreglo.
    * @param arr Arreglo en el que se intercambiaran los elementos
    * @param x Indice del primer elemento a intercambiar
    * @param y Indice del segundo elemento a intercambiar
    */
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];   
        arr[x] = arr[y];  
        arr[y] = temp;
    }
    /**
    * Encuentra el elemento mas grande en el arreglo.
    * @param arr Arreglo a ordenar
    * @param operations Arreglo que guarda el numero de operaciones realizadas por la funcion
    * @return Elemento mas grande del arreglo
    */
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
    /**
    * Limpia la pantalla
    */ 
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    /**
    * Pausa la ejecucion del programa hasta que el usuario presiona alguna tecla
    */ 
    public static void pause(){
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }
    /**
    * Muestra el menu 1 del proyecto
    */ 
    public static void menu1(){
        clearScreen();
        System.out.println("--------------------- PROYECTO 1 EDA 2 ---------------------");
        System.out.println("Elige la opcion que desees:\n\t1. Probar un algoritmo de forma individual\n\t2. Comparar todos los algoritmos");
        System.out.println("Ingresa cualquier otro numero para Salir");
    }
    /**
    * Muestra el menu 2 del proyecto
    */ 
    public static void menu2(){
        String[] nombresAlgoritmos = {"insertionSort", "selectionSort", "bubbleSort", "heapSort", "quickSort (p.m.o.t)", "quickSort (p.r.)",
                                                    "mergeSort", "countingSort", "radixSort", "shellSort"};
        clearScreen();
        System.out.println("Elige el algoritmo a probar");
        for(int i=0; i<nombresAlgoritmos.length; i++)
            System.out.println("\t"+(i+1)+". "+nombresAlgoritmos[i]);
    }
    /**
    * Se encarga de pedir al usuario las preferencias para crear el arreglo
    * @return Arreglo llenado con la informacion que el usuario haya escogido
    */ 
    public static int[] crearArray(){
        Scanner In = new Scanner(System.in);
        Random aleatorio = new Random();
        clearScreen();
        System.out.print("Elige el tamanio del arreglo (numero de valores a ordenar): ");
        int op2 = In.nextInt();
        int[] array = new int[op2];
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
        return array;
    }
    /**
    * Muestra la interfaz para hacer pruebas individuales de los algoritmos
    * @param op2 Opcion para elegir que algoritmo ejecutar
    */ 
    public static void pruebaIndividual(int op2){
        int[] array;
        switch(op2){
            case 1:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por insertionSort en " + Ordenamientos.insertionSort(array) + " operaciones:");
                printArray(array);
                break;
            case 2:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por selectionSort en " + Ordenamientos.selectionSort(array) + " operaciones:");
                printArray(array);
                break;
            case 3:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por bubbleSort en " + Ordenamientos.bubbleSort(array) + " operaciones:");
                printArray(array);
                break;
            case 4:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por heapSort en " + Ordenamientos.heapSort(array) + " operaciones:");
                printArray(array);
                break;
            case 5:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por quickSort (pivot method of three) en " + Ordenamientos.QuickSort(array, 0, array.length-1) + " operaciones:");
                printArray(array);
                break;
            case 6:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por quickSort (pivote aleatorio) en " + Ordenamientos.QuickSort2(array) + " operaciones:");
                printArray(array);
                break;
            case 7:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por mergeSort en " + Ordenamientos.sort(array, 0, array.length) + " operaciones:");
                printArray(array);
                break;
            case 8:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por countingSort en " + Ordenamientos.countingSort(array) + " operaciones:");
                printArray(array);
                break;
            case 9:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por radixSort en " + Ordenamientos.radixSort(array) + " operaciones:");
                printArray(array);
                break;
            case 10:
                array = crearArray();
                System.out.println("Este es el arreglo a ordenar: ");
                printArray(array);
                System.out.println("Este es el arreglo ya ordenado por shellSort en " + Ordenamientos.shellSort(array) + " operaciones:");
                printArray(array);
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }
}