import java.util.Arrays;import java.util.Scanner;

public class Quicksort {
    public static void main(String args[])
    {
        Scanner ob = new Scanner(System.in);
        String str = ob.nextLine();
        String arr[] = str.split(" ");
        int n = arr.length;
        Sort(arr, 0, n - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void Sort(String arr[], int low, int high) {
        if(low<high) {
            int part = Partition(arr, low, high);
            Sort(arr, low, part - 1);
            Sort(arr, part + 1, high);
        }
    }

    public static int Partition(String arr[], int low, int high) {
        String pivot = arr[high];
        int border = low - 1;
        for(int j = low; j <= high - 1; j++) {
            if(0 < pivot.compareTo(arr[j])) {
                border++;
                swap(arr, border, j);
            }
        }
        swap(arr, border + 1, high);
        return (border + 1);
    }

    public static void swap(String arr[], int i1, int i2) {
        String temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
