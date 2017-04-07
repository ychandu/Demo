/**
 * 
 */
package sorting;

/**
 * @author chandu
 *
 */



public class HeapSort {
	
	public void heapsort(int[] arr){
		
		build_max_heap(arr);
		
		int heap_size = arr.length;
        int exchange;
        
        for(int i = arr.length-1; i >= 1; i--)
        {
                exchange = arr[i];
                arr[i] = arr[0];
                arr[0] = exchange;
                
                heap_size --;
                max_heapify(arr, 0,heap_size);
        }
	}
	
	public void build_max_heap(int[] arr){
		for(int i = arr.length /2 ; i >= 0; i--){
			max_heapify(arr, i,arr.length);
		}
	}
	
	void max_heapify(int[] arr, int i, int heap_size){
		
		int l = left(i);
		int r = right(i);
		int largest;
		if(l <  heap_size && arr[l] > arr[i]){
			largest = l;
		}else{
			largest = i;
		}
		
		if(r < heap_size && arr[r] > arr[largest]){
			largest = r;
		}

		if(largest != i){
			int exchange = arr[i];
			arr[i] = arr[largest];
			arr[largest] = exchange;
			max_heapify(arr, largest,heap_size);
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
