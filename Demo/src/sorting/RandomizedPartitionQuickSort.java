package sorting;

import java.util.Random;

public class RandomizedPartitionQuickSort {

	private static Random random = new Random();
	public static void randomized_quicksort(int[] A, int p, int r){
		int q;
		if(p < r){
			q = randomized_partition(A,p,r);
			randomized_quicksort(A, p, q-1);
			randomized_quicksort(A, q+1,r);
		}
	}
	
	private static int randomized_partition(int[] A, int p, int r){
		int q = random.nextInt(r-p)+p;
		int exchange = A[q];
		A[q] = A[r];
		A[r] = exchange;
		return partition(A,p,r);
	}
	
	private static int partition (int[] A, int p, int r){
		int x = A[r];
		int i = p - 1;
		for(int j = p; j < r; j++){
			if(A[j] <= x){
				i = i + 1;
				int exchange = A[i];
				A[i] = A[j];
				A[j] = exchange;
			}
		}
		int exchange = A[i+1];
		A[i+1] = A[r];
		A[r] = exchange;
		
		return i +1;
	}
}
