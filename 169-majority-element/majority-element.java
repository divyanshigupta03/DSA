class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }

        // int max  =  0;
        // for(int i=0; i<nums.length; i++){
        //     int count = map.get(nums[i]);
        //     max = Math.max(max,count);
        // }

        // int ans = 0;
        // for(int i=0; i<nums.length; i++){
        //     if(map.get(nums[i]) == max){
        //         ans = nums[i];
        //     }
        // }
        // return ans;

        //MOORE'S ALGORITHM MORE OPTIMIZED
        int ele = 0;
        int count = 0;
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                count = 1;
                ele = nums[i];
            }else if(nums[i] == ele){
                count++;
            }else{
                count--;
            }
        }

        //verify
        count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == ele) count++;
        }

        if(count > n/2) return ele;
        return -1;
    }
}