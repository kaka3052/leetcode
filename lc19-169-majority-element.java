// 169. Majority Element
// Easy

// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.

// Example 1:

// Input: [3,2,3]
// Output: 3
// Example 2:

// Input: [2,2,1,1,1,2,2]
// Output: 2


// O(n) Solution using Moore's voting Algorithm:
// Best Solution as far as I know
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==majority)
                count++;
            else
            {
                count--;
                if(count==0)
                {
                    count = 1;
                    majority = nums[i];
                }
            }
        }
        return majority;  
    }
}

// O(n) solutions using HashMaps
class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int num:nums)
        {
            int val = 1;
            if(hm.containsKey(num))
            {
                val += hm.get(num);
            }
            hm.put(num,val);
            if(hm.get(num)>nums.length/2)
                return num;
        }
        return 0;
    }
}

// O(nlogn) Solution using Sorting:
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length/2]);
    }
}