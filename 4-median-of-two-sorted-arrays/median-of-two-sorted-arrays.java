class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length > nums2.length ? nums2 : nums1;
        int[] larger = nums1.length > nums2.length ? nums1 : nums2;
        int totalLength = nums1.length + nums2.length;

        //using binary search 
        int low = 0;
        int high = smaller.length;
        //make a while loop
        while(low <= high){
            // x for smaller array and Y for larger array
            int partitionX = (high + low)/2;
            int partitionY = (totalLength + 1)/2 - partitionX;

            //evaluating the value of l1,r1 and l2,r2 which is the most important part
            int l1 = partitionX == 0 ? Integer.MIN_VALUE : smaller[partitionX -1];
            int r1 = partitionX == smaller.length ? Integer.MAX_VALUE : smaller[partitionX];

            int l2 = partitionY == 0 ?  Integer.MIN_VALUE : larger[partitionY - 1];
            int r2 = partitionY == larger.length ? Integer.MAX_VALUE : larger[partitionY];

            //checking condition
            if(l1 <= r2 && l2 <= r1){
                if(totalLength % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }

            //if above condition is wrong then check
            if(l1 > r2) high = partitionX -1;
            else low = partitionX+1;
        }
        return 0;
    }
}