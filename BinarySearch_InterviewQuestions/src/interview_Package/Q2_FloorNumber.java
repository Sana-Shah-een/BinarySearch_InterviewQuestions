package interview_Package;

// Floor Number = Greatest Element in array lesser or equal to target element.


// Time Complexity O(logN)
public class Q2_FloorNumber {

	public static void main(String[] args) {
		int[] arr= {12,22,33,44,55,67,88,99};
		int target=10;
		int answer=floor(arr,target);
		System.out.print(answer);
	}
	
//	Return the index : greatest number <= target
	static int floor(int[] arr,int target) {
		int start=0;
		int end=arr.length-1;
		
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
		return end;
	} 
}



