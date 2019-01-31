15. 3Sum
Medium

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> lookup = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            lookup.put(-nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                if (lookup.containsKey(key)) {
                    int k = lookup.get(key);
                    if (k != i && k != j) {
                        List<Integer> tuple = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(tuple);
                        result.add(tuple);
                    }
                }
            }
        }
        return new ArrayList(result);
    }
}