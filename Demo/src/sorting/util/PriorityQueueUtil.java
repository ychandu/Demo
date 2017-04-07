package sorting.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import sorting.HeapSort;
import sorting.PriorityQueue;

public class PriorityQueueUtil {

	public static void main(String[] args) {
		
		
		System.out.println("Heap Sort");

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

                int[] A = new int[array_elements];
                
                for (int i = 0; i < A.length; i++)
                        A[i] = random.nextInt(1000);

                System.out.println("Input array");
                for (int i : A)
                {
                        System.out.print(String.format("%5d", i));
                }
                System.out.println();

                PriorityQueue pq = new PriorityQueue();
                pq.build_max_heap(A);
                

                System.out.println("Heap array");
                for (int i : A)
                {
                        System.out.print(String.format("%5d", i));
                }
                System.out.println();
                int max = pq.heap_extract_max(A, A.length-1);
                System.out.print("heap_extract_max result" + String.format("%5d", max));
                System.out.println();
                max = pq.heap_maximum(A);
                System.out.print("heap_maximum result" + String.format("%5d", max));
                System.out.println();
                
                int new_key = random.nextInt(1000);
                System.out.print("max_heap_insert new_key" + String.format("%5d", new_key));
                pq.max_heap_insert(A, A.length, new_key);
                
                System.out.println("Final Heap array");
                for (int i : A)
                {
                        System.out.print(String.format("%5d", i));
                }
        }
	
	}

}
