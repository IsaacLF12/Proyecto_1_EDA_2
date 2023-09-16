import java.util.Random;

public class Principal{
    public static void main(String[] args){
        Random aleatorio = new Random();
        int[] arr = new int[10000];
        for(int i=0; i<arr.length; i++)
        //    arr[i] = i;
        //   arr[i] = aleatorio.nextInt(1000);
            arr[i] = arr.length-i;
        System.out.println("Este es el arreglo:");
        Utilerias.printArray(arr);
        System.out.println("El numero de operaciones fue: " + Ordenamientos.shellSort(arr));
    //    Utilerias.printArray(arr);
    }
}