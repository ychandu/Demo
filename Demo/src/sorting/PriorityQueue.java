package sorting;

public class PriorityQueue {
	
	
	public int heap_maximum(int[] A){
		return A[0];
	}
	
	public int heap_extract_max(int[] A, int heap_size){
		 if (heap_size < 1){
			 System.out.println("Heap underflow");
         }
		int max = A[0];
		A[0] = A[heap_size];
		max_heapify(A, 0, heap_size);
		return max;
	}
	
	void max_heapify(int[] A, int i, int heap_size){
		
		int l = left(i);
		int r = right(i);
		int largest;
		if(l <  heap_size && A[l] > A[i]){
			largest = l;
		}else{
			largest = i;
		}
		
		if(r < heap_size && A[r] > A[largest]){
			largest = r;
		}

		if(largest != i){
			int exchange = A[i];
			A[i] = A[largest];
			A[largest] = exchange;
			max_heapify(A, largest,heap_size);
		}
	}
	
	public void heap_increase_key(int[] A, int i, int key){
		if(key < A[i]){
			System.out.println("new key is smaller than current key");
		}
		A[i] = key;
		int exchange;
		while (i > 1 && A[parent(i)] < A[i]){
			exchange = A[i];
			A[i] =  A[parent(i)];
			 A[parent(i)] = exchange;
			 i = parent(i);
		}
		
	}
	
	public void max_heap_insert(int[] A, int heap_size, int key){
		heap_size = heap_size +1;
		A[heap_size] = Integer.MIN_VALUE;
		heap_increase_key(A, heap_size, key);
	}
	
	public void build_max_heap(int[] arr){
		for(int i = arr.length /2 ; i >= 0; i--){
			max_heapify(arr, i,arr.length);
		}
	}
	
	int parent(int i){
		return i/2;
	}
	
	int left(int i){
		return 2*i;
	}
	
	int right (int i){
		return 2*i + 1;
	}
}