
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
}