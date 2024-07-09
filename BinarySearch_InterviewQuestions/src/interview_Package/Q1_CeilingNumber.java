package interview_Package;


//	Ceiling Number = Smallest Element in array greater or equal to target element.

public class Q1_CeilingNumber {

	public static void main(String[] args) {
		int[] arr= {12,22,33,44,55,67,88,99};
		int target=100;
		int answer=ceiling(arr,target);
		System.out.print(answer);
	}
	
//	Return the index of smallest number >= target
	static int ceiling(int[] arr,int target) {
		int start=0;
		int end=arr.length-1;
		
//		but what if the target is greater than  the greatest number in the array
		
		if (target>arr[arr.length-1]) {
			return -1;
		}
		
		while(start<=end) {
			
			int mid=start+(end-start)/2;
			
			if(target<arr[mid]) {
				end=mid-1;
			}
			else if(target>arr[mid]) {
				start=mid+1;
			}else {
				return mid;
			}
		}
		return start;
	}

}
