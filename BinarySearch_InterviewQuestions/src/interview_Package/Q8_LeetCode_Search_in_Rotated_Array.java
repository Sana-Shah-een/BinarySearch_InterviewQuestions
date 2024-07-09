package interview_Package;

// Amazon and Google Question
// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

public class Q8_LeetCode_Search_in_Rotated_Array {

	//******This not work for duplicate numbers in array*******
	
//	1-> find the pivot(largest element) in the array
//	pivot-> from where your next numbers are Ascending
//	2-> search in first half -> simple Binary Search (0,pivot)
//	3-> otherwise, search in second half (pivot+1,end)

	public static void main(String[] args) {
		int[] arr= {4,5,6,7,0,1,2,};
//		System.out.print(findPivot(arr));
		int target=0;
		System.out.println(search(arr,target));
		
		
//		for duplicates:
		int target2=7;
		int[] arr1= {5,6,7,7,7,8,9,9,9,9,4,3,2,1,0};
		System.out.print(search2(arr1,target2));
		
		
		
	}
	
	static int search(int[] arr,int target) {
		int p1=findPivot(arr);
		
//		if you did'nt find a pivot ,it means that the array is not rotated
		if(p1==-1) {
//			do simple binary search
			return binarysearch(arr,target,0,arr.length-1);
		}
//		if pivot is found you have found 2 asc sorted arrays
		if(p1==target) {
			return p1;
		}
		if(target>=arr[0]) {
			return binarysearch(arr,target,0,p1-1);
		}else {
			return binarysearch(arr,target,p1+1,arr.length-1);
		}
	}

	static int search2(int[] arr,int target){
		int pivot=findPivot(arr);
		
//		if you did'nt find a pivot ,it means that the array is not rotated
		if(pivot==-1) {
//			do simple binary search
			return binarysearch(arr,target,0,arr.length-1);
		}
//		if pivot is found you have found 2 asc sorted arrays
		if(pivot==target) {
			return pivot;
		}
		if(target>=arr[0]) {
			return binarysearch(arr,target,0,pivot-1);
		}else {
			return binarysearch(arr,target,pivot+1,arr.length-1);
		}
	}
	
	
	
	//******This not work for duplicate numbers in array*******
	
//	How to find pivot?
//	case 1:  
//	mid>mid+1  i.e pivot element
	
//	case 2:
//	if mid<mid-1 then ans= mid -1
	 
//	case 3:
//	start>mid   -> all elements from mid<start hence ignore all these elements for pivot (end=mid-1) 
//	4,5,6,3(mid),2,1,0
	
//	case 4:
//	start<mid  -> (start=mid+1)
//	3,4,5(mid),6,2 
	
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

//	USE THIS WHEN ARRAY CONTAINS DUPLICATE VALUES
	static int findPivotwithDuplicates(int[]arr) {
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
		
//		***********changing in Duplicates****************
//		if elements at middle, start, end are equal then just skip the duplicates
		if(arr[mid]==arr[start] && arr[mid]==arr[end]) {
			//skip the duplicates
//			NOTE: what if these elements at start and end were the pivot???
			
//			check if start is pivot
			if(arr[start]>arr[start+1]) {
				return mid;
			}
			start++;
			
//			check whether end is duplicate
			if(arr[end]<arr[end-1]) {
				return end-1;
			}
			end--;
			
		}
//		left side is sorted ,so pivot should be in right
		if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end]) {
			start=mid+1;
		}else {
			end=mid-1;
		}
		
	}
	return -1;

}
	static int binarysearch(int[] arr,int target,int start,int end) {
		
		while(start<=end) {
//			int mid=(start+end)/2; //might be some cases(start+end) exceeds the range of int in Java
			
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
		return -1;
		
	}
}
