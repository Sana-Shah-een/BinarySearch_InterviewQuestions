package interview_Package;

import java.util.Arrays;

public class Q4_LeetCode_FindFirstAndLastPositionOfElement {

	public static void main(String[] args) {
		int[] arr= {5,7,7,7,8,8,9,10};
		int target=8;
		int[] answer=searchRange(arr,target);
		System.out.println(Arrays.toString(answer));		
	}
	
	static int[] searchRange(int[] nums,int target) {
		
		int[] ans= {-1,-1};
		ans[0]=search(nums,target,true);
		if(ans[0]!=1) {
		ans[1]=search(nums,target,false);
		}
		
		
		return ans;
	}
	
//	this function just returns the index value of the target
	
	static int search(int[] nums,int target,boolean findStartIndex) {
		int ans=-1;
		int start=0;
		int end=nums.length-1;
		
//	check for the first occurrence of the target first
		 
		
		while(start<=end) {
//			int mid=(start+end)/2; //might be some cases(start+end) exceeds the range of integer in Java
			
			int mid=start+(end-start)/2;
			if(target<nums[mid]) {
				end=mid-1;
			}
			else if(target>nums[mid]) {
				start=mid+1;
			}else {
//				potential ans found
				ans=mid;
				if(findStartIndex) {
					end=mid-1; // Adjust end to find the first occurrence
				}
				else {
					start=mid+1; // Adjust start to find the last occurrence
				}
			}
			
		}
		return ans;
	}

}

