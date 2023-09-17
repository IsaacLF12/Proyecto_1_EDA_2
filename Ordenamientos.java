import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

/**
 * En este archivo se encuentran todos los algoritmos de ordenamiento utilizados en el proyecto
 * @author Daniel H., Isaac L., Sebastian J.
 * @version 1.0
 */

public class Ordenamientos {
    /**
    * Implementa el algoritmo de ordenamiento insertionSort
    * @param array Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int insertionSort(int array[]){
        int operations = 0;
        int n = array.length;
        int key, i;
        operations = operations+4;
        for (int j = 1; j < n; j++){  
            key = array[j];  
            i = j-1;  
            while ((i>-1)&&(array[i]>key)){  
                array [i+1] = array [i];  
                i--;  
                operations = operations+2;
            }  
            array[i+1] = key;  
            operations = operations+4;
        }  
        return operations;
    }
    /**
    * Implementa el algoritmo de ordenamiento selectionSort
    * @param arr Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int selectionSort(int[] arr){  
        int operations = 0;
        int n = arr.length;
        operations = operations+2;
        for (int i = 0; i < n - 1; i++){  
            int min = i;  
            for (int j = i + 1; j < n; j++){  
                if (arr[j] < arr[min]){  
                    min = j;  
                    operations = operations+1;
                }   
                operations = operations+1;                  
            }  
            Utilerias.swap(arr, i,min);
            operations = operations+5;
        }  
        return operations;
    } 
    /**
    * Implementa el algoritmo de ordenamiento bubbleSort
    * @param array Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int bubbleSort(int[] array){
        int operations = 0;
        int z;
        operations = operations+2;
        for(int i=array.length-1; i>0; i--){
            z = 0;
            for(int j=0; j<i; j++){
                if(array[j]>array[j+1]){
                    Utilerias.swap(array, j, j+1);
                    operations = operations+3;
                }else{
                    z++;
                    operations = operations+1;
                }
                operations = operations+1;
            }
            if(z==i)
                return operations+3;
            operations = operations+3;
        }
        return operations;
    }
    /**
    * Implementa el algoritmo de ordenamiento insertionSort
    * @param arr Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int heapSort(int[] arr){
        int operations = 0;
        int n = arr.length;
        operations = operations+3;
        for (int i = n / 2 - 1; i >= 0; i--)
            operations = heapify(arr, n, i, operations);
        for (int i = n - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            operations = heapify(arr, i, 0, operations);
            operations = operations+3;
        }
        return operations;
    }
    /**
    * Forma parte del algoritmo heapSort, sirve para crear el heap
    * @param arr Arreglo en el cual se crea el heap
    * @param n Tamaño del arreglo
    * @param i Indice del padre del ultimo hijo
    * @param operations Variable que almacena las operaciones realizadas
    * @return Numero de operaciones realizadas por la funcion
    */
    public static int heapify(int[] arr, int n, int i, int operations){
        int largest = i; 
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
            operations = operations+1;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
            operations = operations+1;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            operations = heapify(arr, n, largest, operations);
            operations = operations+3;
        }
        operations = operations+6;
        return operations;
    }
    /**
    * (Pivot Median of Three)
    * Implementa el algoritmo de ordenamiento quickSort en su version de pivote meadiana de tres
    * @param arr Arreglo a ordenar
    * @param low Indice del inicio del arreglo
    * @param high Indice del final del arreglo
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int QuickSort(int arr[], int low, int high){
        int[] pi_operations = new int[2];
        pi_operations[0] = 0;
        pi_operations[1] = 0;
        Quick(arr, low, high, pi_operations);
        return pi_operations[1];
    }
    /**
    * Funcion principal del quickSort
    * @param arr Arreglo a ordenar
    * @param low Indice del inicio del arreglo
    * @param high Indice del final del arreglo
    * @param pi_operations Arreglo que contiene el indice del pivote y el numero de operaciones
    */
    public static void Quick(int arr[], int low, int high, int pi_operations[]){
        if (low < high){
            pi_operations[0] = choosePivot(arr, low, high, pi_operations);
            partition(arr, low, high, pi_operations[0], pi_operations);
            Quick(arr, low, pi_operations[0] - 1, pi_operations);
            Quick(arr, pi_operations[0] + 1, high, pi_operations);
        }
        pi_operations[1] = pi_operations[1] + 1;
    }
    /**
    * Esta funcion se encarga de elegir cual sera el pivote
    * @param arr Arreglo a ordenar
    * @param low Indice del inicio del arreglo
    * @param high Indice del final del arreglo
    * @param pi_operations Arreglo que contiene el indice del pivote y el numero de operaciones
    * @return Indice del pivote
    */
    public static int choosePivot(int arr[], int low, int high,  int pi_operations[]) {
        int mid = low + (high - low) / 2;
        int a = arr[low];
        int b = arr[mid];
        int c = arr[high];
        pi_operations[1]+=4;
        if ((a <= b && b <= c) || (c <= b && b <= a)) {
                pi_operations[1]+=4;
            return mid;
        } else if ((b <= a && a <= c) || (c <= a && a <= b)) {
                pi_operations[1]+=8;
            return low;
        } else {
                pi_operations[1]+=8;
            return high;
        }
    }
    /**
    * Parte la lista y encuentra el nuevo pivote
    * @param arr Arreglo a ordenar
    * @param low Indice del inicio del arreglo
    * @param high Indice del final del arreglo
    * @param pivotIndex Indice del pivote
    * @param pi_operations Arreglo que contiene el indice del pivote y el numero de operaciones
    */
    public static void partition(int arr[], int low, int high, int pivotIndex, int pi_operations[]){
        int pivot = arr[pivotIndex];
        pi_operations[0] = low - 1;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;
        pi_operations[1] = pi_operations[1] + 3;
    
        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                pi_operations[0]++;
                Utilerias.swap(arr, pi_operations[0], j);
                pi_operations[1] = pi_operations[1] + 4;
            }
            pi_operations[1]++;
        }
        temp = arr[pi_operations[0] + 1];
        arr[pi_operations[0] + 1] = arr[high];
        arr[high] = temp;
        pi_operations[0]++;
        pi_operations[1] = pi_operations[1] + 4;
    }
    /**
    * (Pivote Random)
    * Implementa el algoritmo de ordenamiento quickSort en su version de pivote aleatorio
    * @param array Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int QuickSort2(int[] array){
        int[] pointer_operations = new int[2];
        pointer_operations[0] = 0;
        pointer_operations[1] = 0;
        Quick2(array, 0, array.length - 1, pointer_operations);
        return pointer_operations[1];
    }
    /**
    * Funcion principal del quickSort2
    * @param array Arreglo a ordenar
    * @param lowIndex Indice del inicio del arreglo
    * @param highIndex Indice del final del arreglo
    * @param pointer_operations Arreglo que contiene el indice del pivote y el numero de operaciones
    */
    public static void Quick2(int[] array, int lowIndex, int highIndex, int[] pointer_operations){
        if (lowIndex >= highIndex) {
            pointer_operations[1] += 1;
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        Utilerias.swap(array, pivotIndex, highIndex);
        pointer_operations[1] += 6;

        partition2(array, lowIndex, highIndex, pivot, pointer_operations);
        int leftPointer = pointer_operations[0];
        pointer_operations[1] += 1;

        Quick2(array, lowIndex, leftPointer - 1, pointer_operations);
        Quick2(array, leftPointer + 1, highIndex, pointer_operations);

    }
    /**
    * Parte la lista y encuentra el nuevo pivote
    * @param array Arreglo a ordenar
    * @param lowIndex Indice del inicio del arreglo
    * @param highIndex Indice del final del arreglo
    * @param pivot Indice del pivote
    * @param pointer_operations Arreglo que contiene el indice del pivote y el numero de operaciones
    */
    public static void partition2(int[] array, int lowIndex, int highIndex, int pivot, int[] pointer_operations) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
                pointer_operations[1] += 1;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
                pointer_operations[1] += 1;
            }
            Utilerias.swap(array, leftPointer, rightPointer);
            pointer_operations[1] += 7;
        }
        if(array[leftPointer] > array[highIndex]) {
            Utilerias.swap(array, leftPointer, highIndex);
            pointer_operations[1] += 3;
        }
        else {
            leftPointer = highIndex;
            pointer_operations[1] += 1;
        }
        pointer_operations[1] += 4;
        pointer_operations[0] = leftPointer;
    }
    /**
    * Implementa el algoritmo de ordenamiento mergeSort
    * @param arr Arreglo a ordenar
    * @param l Indice del inicio de la lista (indice izquierdo)
    * @param r Indice del final de la lista (indice derecho)
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int sort(int arr[], int l, int r){
        int operations = 0; 
        if (l < r) { 
            int m = (l+r)/2; 
  
            operations+=sort(arr, l, m); 
            operations+=sort(arr , m+1, r); 
            operations+=merge(arr, l, m, r); 
            operations+=1;
        } 
        operations+=1;
        return operations;
    }
    /**
    * Funcionq que forma parte del algoritmo mergeSort, se encarga de ir uniendo las sublistas mientras ordena sus contenidos
    * @param arr Arreglo a ordenar
    * @param l Inicio de la lista
    * @param m Mitad de la lista
    * @param r Final de la lista
    * @return Numero de operaciones realizadas por la funcion
    */
    public static int merge(int arr[], int l, int m, int r){ 
        int operations = 0;
        int n1 = m - l + 1; 
        int n2 = r - m; 
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        for (int i=0; i<n1; ++i){
            L[i] = arr[l + i]; 
            operations+=1;
        }
        for (int j=0; j<n2; ++j){
            R[j] = arr[m + 1+ j];
            operations+=1;
        } 
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2){ 
            if (L[i] <= R[j]){ 
                arr[k] = L[i]; 
                i++; 
                operations+=2;
            }else{ 
                arr[k] = R[j]; 
                j++; 
                operations+=2;
            } 
            k++; 
            operations+=2;
        } 
        while (i < n1){ 
            arr[k] = L[i]; 
            i++; 
            k++; 
            operations+=3;
        } 
        while (j < n2){ 
            arr[k] = R[j]; 
            j++; 
            k++; 
            operations+=3;
        } 
        operations+=11;
        return operations;
    } 
    /**
    * Implementa el algoritmo de ordenamiento countingSort
    * @param arr Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int countingSort(int[] arr){
        int operations = 0;
        int[] operationsArr = new int[1];
        operationsArr[0]=0;
        int countSize = Utilerias.mayorArr(arr, operationsArr)+1;
        operations+=operationsArr[0];
        int[] count = new int[countSize];
        int[] newArr = new int[arr.length];
        for(int i : arr){
            count[i]++;
            operations+=1;
        }
        for(int i=1; i<countSize; i++){
            count[i] = count[i-1] + count[i];
            operations+=1;
        }
        for(int i=arr.length-1; i>=0; i--){
            newArr[(count[arr[i]]--)-1] = arr[i];
            operations+=1;
        }
        for(int i = 0; i<arr.length; i++){
            arr[i] = newArr[i];
            operations+=1;
        }
        operations+=7;
        return operations;
    }
    /**
    * Implementa el algoritmo de ordenamiento radixSort
    * @param arr Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int radixSort(int[] arr){
        int operations = 0;
        Queue[] queues = new Queue[10];
        for(int i = 0; i < 10; i++) 
            queues[i] = new LinkedList<Integer>();
        int n=0, j, cola0Size=0;
        while(cola0Size < arr.length){
            for(int i : arr){
                queues[(i/(int)Math.pow(10, n))%10].add(i);
                operations+=1;
            }
            j=0;
            cola0Size = queues[0].size();
            for(int i=0; i<10; i++){
                while(queues[i].isEmpty()!=true){
                    arr[j++] = (int)queues[i].poll();
                    operations+=1;
                }
                operations+=1;
            }
            n++;
            operations+=5;
        }
        operations+=16;
        return operations;
    }
    /**
    * Implementa el algoritmo de ordenamiento shellSort
    * @param arr Arreglo a ordenar
    * @return Numero de operaciones realizadas por el algoritmo
    */
    public static int shellSort(int arr[]){
        int operations = 0;
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                    arr[j] = arr[j - gap];
                    operations+=1;
                }
                arr[j] = temp;
                operations+=4;
            }
            operations+=1;
        }
        operations+=2;
        return operations;
    }
}