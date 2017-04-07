package sorting;

public class QuickSort {
	
	public static void quicksort(int[] A, int p, int r){
		int q;
		if(p < r){
			q = partition(A,p,r);
			quicksort(A, p, q-1);
			quicksort(A, q+1,r);
		}
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
