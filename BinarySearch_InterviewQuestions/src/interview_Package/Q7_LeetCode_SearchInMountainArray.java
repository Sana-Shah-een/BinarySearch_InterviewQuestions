package interview_Package;

public class Q7_LeetCode_SearchInMountainArray {

//	https://leetcode.com/problems/find-in-mountain-array/
	
	public static void main(String[] args) {
		int[] arr= {1,2,4,6,7,3,2,1};
		int target=3;
		int ans=search(arr,target);
		System.out.print(ans);
	}
	
	static int search(int[] arr,int target) {
		int peak=peakIndex(arr);
		int firsthalf=orderAgnosticBS(arr,target,0,peak);
		if(firsthalf!=-1) {
			return firsthalf;
		}
//		try to search in second half
		
		return orderAgnosticBS(arr,target,peak+1,arr.length-1);
	}
	

	static int peakIndex(int[] arr){
		int start=0;
		int end=arr.length-1;
		
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>arr[mid+1]) {
//				you are in the dec part of the array
//				this may be the answer, but look at left
//				that is why end!=mid-1;
				end=mid;
			 }else {
//				you are in the Asc part of the Array
				start=mid+1;
//				because we know that mid+1 element > mid element
			}
		}
//		in the end, start==end and pointing to the largest number bcz of the two above checks
//		start and end are always trying to find max element in the above two checks
//		hence, when they are pointing to just one element that is the max one because that is what the checks say
//		more elaboration ->> at every point of time for start and end, they have the best possible answer till that time
//		and if we are saying that only one item is remaining, hence bcz of the above line that is the best possible answer.
		return start; // or return end as both are equal
	}

	static int orderAgnosticBS(int[] arr,int target,int start,int end) {
		
//		find whether the array is sorted in ascending or descending
		boolean isAsc;   //boolean isAsc=arr[start]<arr[end] ->>same thing
		if(arr[start]<arr[end]) {
			isAsc=true;
		}else {
			isAsc=false;
		}
		while(start<=end) {
//			int mid=(start+end)/2; //might be some cases(start+end) exceeds the range of int in Java
			
			int mid=start+(end-start)/2;
			
			if(arr[mid]==target) {
				return mid;
			}
			if(isAsc) {
				if(target<arr[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}else {
				if(target>arr[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}		
		}
		return -1;	
	}
}
