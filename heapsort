import java.util.*;

public class heap
{
    public static void main(String args[])
    {
        Scanner ob = new Scanner(System.in);
        String str = ob.nextLine();
        String arr[] = str.split(" ");
        heapsort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapsort (String[]arr)
    {
        int l = arr.length;
        for(int i = l / 2 - 1; i >=0; i--)
        {
            heap.maxheap(arr, l, i);
        }
        for(int i = l - 1; i > 0; i--)
        {
            swap(arr, 0, i);
            heap.maxheap(arr, --l, 0);
        }
    }

    private static void maxheap(String[]arr, int heaps, int parent)
    {
        int max = parent;
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;

        if(left < heaps && 0 < arr[left].compareTo(arr[max]))
        {
            max = left;
        }
        if(right < heaps && 0 < arr[right].compareTo(arr[max]))
        {
            max = right;
        }
        if(max != parent)
        {
            swap(arr, max, parent);
            maxheap(arr, heaps, max);
        }
    }

    public static void swap(String[]arr, int i1, int i2)
    {
        String temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
