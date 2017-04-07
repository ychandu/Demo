package divideAndConquer;

public class MaximumSubArray {
	
	// Find max crossing sub-array that crosses the mid point.
	int maxCrossingSum(int arr[], int l, int m, int h){
		 int sum = 0;
		 int leftSum = Integer.MIN_VALUE;
		 for(int i = m; i>= l; i--){
			 sum = sum + arr[i];
			 if(sum > leftSum){
				 leftSum = sum;
				 System.out.println("maxCrossingSum: Max Left:"+i);
			 }
		 }
		 
		 sum = 0;
		 int rightSum = Integer.MIN_VALUE;
		 for(int i = m+1; i<=h;i++){
			 sum = sum + arr[i];
			 if(sum > rightSum){
				 rightSum = sum;
				 System.out.println("maxCrossingSum: Max Right:"+i);
			 }
		 }
		 return leftSum + rightSum;
	}
	
	/* Return maximum of following three possible cases
	    a) Maximum sub array sum in left half
	    b) Maximum sub array sum in right half
	    c) Maximum sub array sum such that the sub array crosses the midpoint */
	int maxSubArraySum(int arr[], int l, int h){
		//Base Case: only one element
		if(l == h){
			return arr[1];
		}
		//Calculate mid Point
		int m = (l + h)/2;
		System.out.println("maxSubArraySum: low:"+l);
		System.out.println("maxSubArraySum: high:"+h);
		System.out.println("maxSubArraySum: mid:"+m);
		return max(maxSubArraySum(arr,l,m),
				maxSubArraySum(arr,m+1,h),
				maxCrossingSum(arr,l,m,h));
		
	}

	/*
	 * Utility Functions
	 */
	// function to find max of two integers 
	int max(int a, int b){
		return (a>b)?a:b;
	}
	
	// function to fine max of three integers
	int max(int a, int b, int c){
		return max(max(a,b),c);
	}
	
	public static void main(String[] args){
		System.out.println("Divide - and - Conquer: The Maximum - subarray problem");
		MaximumSubArray maxiumSubArray = new MaximumSubArray();
		int[] arr =  {-2,-5,6,-2,-3,1,5,-6};
		int maxSum = maxiumSubArray.maxSubArraySum(arr,0,arr.length-1);
		System.out.println("The Maximum - subarray:"+maxSum);
		
	}

}
