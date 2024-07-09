package interview_Package;

//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
// Amazon Question

public class Q5_GeeksforGeeks_InfiniteArrayTargetPosition {

	public static void main(String[] args) {
			int[] arr= {3,5,7,9,10,90,100,130,1999};
			int target=10;
			System.out.println(ans(arr,target));
	}
		static int ans(int[] arr,int target) {
//			first find the range
//			first start with the box of size 2
			int start=0;
			int end=1;
//			condition for the target to lie in the range
			while(target>arr[end]) {
				int newStart=end+1;
//				double the box value
//				formula for new end=previous end + size of box * 2
				 end=(end-start+1)*2;
				 start=newStart;
			}
			
			return binarysearch(arr,target,start,end);
		}

		static int binarysearch(int[] arr,int target,int start,int end) {
			
			while(start<=end) {
//				int mid=(start+end)/2; //might be some cases(start+end) exceeds the range of int in Java
				
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

