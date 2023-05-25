import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество элементов: ");
        int N = input.nextInt();
        int[] arr = new int[N];
        arr = FillArray(arr);
        System.out.println("Изначальный массив");
        PrintArray(arr);
        System.out.println("Отсортированный массив");
        HeapSort(arr);
        PrintArray(arr);
    }
    private static int LeftChild(int i){
        return (2*i+1);
    }
    private static int RightChild(int i){
        return (2*i+2);
    }
    private static void ChElement(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void heap(int[] arr, int i, int n){
        int left = LeftChild(i);
        int right = RightChild(i);
        int large = i;
        if(left<n && arr[left]>arr[i]){
            large = left;
        }
        if(right<n && arr[right]>arr[large]){
            large = right;
        }
        if(large != i){
            ChElement(arr, i, large);
            heap(arr, large, n);
        }
    }
    public static int pop(int[] arr, int n){
        if (n<=0){
            return -1;
        }
        int top = arr[0];
        arr[0] = arr[n-1];
        heap(arr,0, n - 1);
        return top;
    }
    public static void HeapSort(int[] arr){
        int n = arr.length;
        int i = (n-2)/2;
        while (i>=0){
            heap(arr, i--,n);
        }
        while (n>0){
            arr[n-1] = pop(arr,n);
            n--;
        }
    }
    public static int[] FillArray(int[] arr){

        for(int i=0; i< arr.length; i++){
            arr[i] = (int)(Math.random() * 100);
        }
        return arr;
    }
    public static void PrintArray(int[] arr){
        System.out.printf("%s, ", Arrays.toString(arr));
    }

}