import java.util.Random;
import java.util.Scanner;



public class nthSmallestNumber
{
    public static int n = 500;
    public static int[] A = new int[n];
 
    public static void swap(int dex1, int dex2) 
    {
        int temp = A[dex1];
        A[dex1] = A[dex2];
        A[dex2] = temp;
    }
 
    public static int partition(int start, int end) 
    {
        int i = start + 1;
        int j = i;
        int pivot = start;
        for (; i < end; i++) 
        {
            if (A[i] < A[pivot]) 
            {
                swap(i, j);
                j++;
            }
        }
        if (j <= end)
            swap(pivot, (j - 1));
 
        return j - 1;
    }
 
    public static void quick_sort(int start, int end, int N) {
        int part;
        if (start < end) 
        {
            part = partition(start, end);
            if (part == N - 1)
                System.out.println("nth smallest element : " + A[part]);
            if (part > N - 1)
                quick_sort(start, part, N);
            else
                quick_sort(part + 1, end, N);
        }
        return;
    }
 
    public static void main(String args[]) 
    {
        Random random = new Random();
        for (int i = 0; i < n; i++)
            A[i] = random.nextInt(1000);
 
        System.out.println("The random numbers are:  ");
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " , ");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the nth smallest you want to find: ");
        int k = sc.nextInt();
 
        quick_sort(0, n, k);
        sc.close();
    }
}
	


