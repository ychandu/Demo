package sorting.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import sorting.RandomizedPartitionQuickSort;

public class QuickSortUtil {

	public static void main(String[] args) {
		System.out.println("Quick Sort");

        System.out.println("Enter number of elements in the array");
        int array_elements = 2;
        try
        {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                array_elements = Integer.parseInt(reader.readLine());
        }
        catch (IOException e)
        {
                e.printStackTrace();
        }

        if (array_elements < 2)
        {
                System.out.println("Number of elements in the array should be greater or equal 2");
        }
        else
        {
                Random random = new Random();

                //int[] A = new int[]{2,9,8,7,1,10,3,5,6,4}; 
                //int[] A = new int[]{1,2,3,4,5,6,7,8,9,10};
                int[] A = new int[array_elements];
                
                for (int i = 0; i < A.length; i++)
                        A[i] = random.nextInt(1000);

                System.out.println("Unsorted array");
                for (int i : A)
                {
                        System.out.print(String.format("%5d", i));
                }
                System.out.println();
                long t1 = System.nanoTime();
                //QuickSort.quicksort(A, 0, A.length-1);
                RandomizedPartitionQuickSort.randomized_quicksort(A, 0, A.length-1);
                long t2 = System.nanoTime();
                System.out.println("Time Taken:"+(t2-t1));
                System.out.println("Sorted array");
                for (int i : A)
                {
                        System.out.print(String.format("%5d", i));
                }
                System.out.println();
        }
	}
}
