package interview_Package;

public class Q10_LeetCode_SplitArray_LargestSum {

	public static void main(String[] args) {
		int[] arr= {7,2,5,10,8};
		System.out.print(SplitArray(arr,2));
	}
	
	static int SplitArray(int[] arr,int m) {
		int start=0;
		int end=0;
		
		for(int i=0;i<arr.length;i++) {
			start=Math.max(start,arr[i]); //in the end of the loop this will contain the max item from the array
			end+=arr[i];
		}
		
		//binary search
		while(start<end) {
			//try for the middle as the potential ans
			int mid = start+(end-start)/2;
			
			//calculate how many pieces you can divide this in with this max sum
			int sum=0;
			int pieces=1;
			for(int num:arr) {
				if(sum+num>mid) {
					//you cannot add this in this sub array, make new one
					//you add this in new sub array->> sum=num;
					sum=num;
					pieces++;
				}else {
					sum+=num;
				}
			}
			
			if(pieces>m) {
				start=mid+1;
			}else {
				end=mid;
			}
		}
		return end;//here start==end
	}

}
