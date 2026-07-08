class Solution {
    public int search(int[] nums, int target) {
        int ans = BinarySearch(nums,target,0,nums.length-1);
        return ans;
    }

    public int BinarySearch(int[] nums, int target,int left,int right){
        if(left > right) return -1;

        int mid = left + ((right-left)/2);

        if(nums[mid] == target) return mid;

        if(nums[mid] >= nums[left]){
            //key in left
            if(nums[left] <= target && target <= nums[mid]){
                return BinarySearch(nums,target,left,mid-1);
            }else{
                return BinarySearch(nums,target,mid+1,right);
            }
        }else{
            if(nums[mid] <= target && target <= nums[right]){
                 return BinarySearch(nums,target,mid+1,right);
            }else{
                return BinarySearch(nums,target,left,mid-1);
            }
        }
    }
}