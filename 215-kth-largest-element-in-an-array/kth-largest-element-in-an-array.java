import java.util.Random;

class Solution {

    Random rand = new Random();

    void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    int quickSelect(int[] nums, int left, int right, int k){

        while(left <= right){

            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivot = nums[pivotIndex];

            int l = left, m = left, r = right;

            while(m <= r){

                if(nums[m] > pivot){
                    swap(nums, l, m);
                    l++;
                    m++;
                }
                else if(nums[m] < pivot){
                    swap(nums, m, r);
                    r--;
                }
                else{
                    m++;
                }
            }

            if(k-1 < l)
                right = l - 1;
            else if(k-1 > r)
                left = r + 1;
            else
                return pivot;
        }

        return -1;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
}