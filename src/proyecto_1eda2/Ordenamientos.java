
public class Ordenamientos{
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
    public static int QuickSort(int arr[], int low, int high){
        int[] pi_operations = new int[2];
        pi_operations[0] = 0;
        pi_operations[1] = 0;
        Quick(arr, low, high, pi_operations);
        return pi_operations[1];
    }
    public static void Quick(int arr[], int low, int high, int pi_operations[]){
        if (low < high){
            partition(arr, low, high, pi_operations);
            Quick(arr, low, pi_operations[0]-1, pi_operations);
            Quick(arr, pi_operations[0]+1, high, pi_operations);
        }
        pi_operations[1] = pi_operations[1]+1;
    }
    public static void partition(int arr[], int low, int high, int pi_operations[]){
        int pivot = arr[high];
        pi_operations[0] = (low-1);
        for (int j=low; j<high; j++){
            if (arr[j] <= pivot){
                pi_operations[0]++;
                Utilerias.swap(arr, pi_operations[0],j);
                pi_operations[1] = pi_operations[1]+4;
            }
            pi_operations[1] = pi_operations[1]+1;
        }
        int temp = arr[pi_operations[0]+1];
        arr[pi_operations[0]+1] = arr[high];
        arr[high] = temp;
        pi_operations[0]++;
        pi_operations[1] = pi_operations[1]+7;
    }
    

}