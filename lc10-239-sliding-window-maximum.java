// 239. Sliding Window Maximum
// Hard

// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

// Example:

// Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
// Output: [3,3,5,5,6,7] 
// Explanation: 

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

// Follow up:
// Could you solve it in linear time?

class Solution {
    PriorityQueue<Integer> q;
    int k;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0){
            return nums;
        }
        this.k = k;
        this.q = new PriorityQueue(k, 
             new Comparator<Integer>(){
                 public int compare(Integer a, Integer b){
                     return b - a;
                 }
             });
        
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            
            if (i < k - 1){
                add(nums, i);
            }else{//i >= k-1
                result[i - k + 1] = add(nums, i);
            }
        }
        
        return result;
        
    }
    public int add(int[] nums, int i){
        if (q.size() < k){
            q.offer(nums[i]);
        }else {
            q.remove(nums[i - k]);
            q.offer(nums[i]);
        }
        return q.peek();
    }
}