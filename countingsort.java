import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {1,4,1,2,7,11,5,2};
        int n = arr.length;
        int max = findmax(arr);
        counting(arr, max);
        for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    public static int findmax(int arr[]) {
        int n = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > n) {
                n = arr[i];
            }
        }
    return n;
    }

    public static void counting(int arr[], int max) {
        int emptyarr[] = new int[max + 1];
        int outputarr[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            emptyarr[arr[i]] += 1;
        }
        for(int i = 1; i < emptyarr.length; i++) {
            emptyarr[i] += emptyarr[i-1];
        }
        for(int i = 0; i < outputarr.length; i++) {
            outputarr[emptyarr[arr[i]] - 1] = arr[i];
            emptyarr[arr[i]] -= 1;
        }
        System.out.print(Arrays.toString(outputarr));
    }
}
