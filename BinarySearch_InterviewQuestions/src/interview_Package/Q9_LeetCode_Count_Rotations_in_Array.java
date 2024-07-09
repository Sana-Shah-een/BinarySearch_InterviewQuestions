package interview_Package;

public class Q9_LeetCode_Count_Rotations_in_Array {

	public static void main(String[] args) {
		int[] arr= {4,5,6,7,7,0,1,2};
		System.out.print(CountRotations(arr));
	}

	static int CountRotations(int[] arr) {
		int pivot=findPivot(arr);
//		if (pivot==-1) {
//			//array is not rotated
//			return 0;
//		}
		return pivot+1;
	}
	
	// USE THIS FOR NON DUPLICATES:
		static int findPivot(int[]arr) {
			int start=0;
			int end=arr.length-1;
			while(start<=end) {
			int mid=start+(end-start)/2;
			
			//4 cases over here
			
			if(mid<end && arr[mid]>arr[mid+1]) {
				return mid;
			}
			if (mid>start && arr[mid]<arr[mid-1]) {
				return mid-1;
			}
			if(arr[mid]<=arr[start]) {
				end=mid-1;
			}else {
				start=mid+1;
			}
			
		}
		return -1;

	}


}
