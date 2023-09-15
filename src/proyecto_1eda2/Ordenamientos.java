
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
}