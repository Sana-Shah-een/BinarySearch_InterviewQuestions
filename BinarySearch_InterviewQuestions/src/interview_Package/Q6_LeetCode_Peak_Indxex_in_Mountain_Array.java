package interview_Package;

//https://leetcode.com/problems/peak-index-in-a-moutain-array/

public class Q6_LeetCode_Peak_Indxex_in_Mountain_Array {

	// Mountain Array Also called Bi_tonic Array
	
	public static void main(String[] args) {
		int[] arr= {0,1,2,4,1,0};
		int ans=peakIndex(arr);
		System.out.print(ans);

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


}

