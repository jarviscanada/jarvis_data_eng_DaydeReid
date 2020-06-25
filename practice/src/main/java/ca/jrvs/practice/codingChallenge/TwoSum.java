package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class containing functions to find the indices of values in a list that add up to a given sum
 * Relevant Ticket: https://www.notion.so/Two-Sum-f023dca5106a4bffbe58db0e4341b0c7
 */
public class TwoSum {

  /**
   * Determine two indices in the nums array that add up to the target using brute force (i.e. nested loops)
   * Time Complexity: O(n^2)
   * Justification: For each entry in the array, the function compares it to every other entry in the array
   */
  public int[] bruteForceTwoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i ++) {
      for(int j = i + 1; j < nums.length; j ++) {
        if (nums[i] + nums[j] == target)
          return new int[]{i, j};
      }
    }
    return null;
  }

  /**
   * Determine two indices in the nums array that add up to the target using built in sorting methods
   * Time Complexity: O(n*log(n))
   * Justification: Java's sorting algorithm is O(n*log(n))
   */
  public int[] sortedTwoSum(int[] nums, int target) {
    int[] sortedNums = nums.clone();
    Arrays.sort(sortedNums);
    int left = 0;
    int right = sortedNums.length - 1;
    while(left < right) {
      if (sortedNums[left] + sortedNums[right] == target) {
        int i = Arrays.binarySearch(nums, sortedNums[left]);
        int j = Arrays.binarySearch(nums, sortedNums[right]);
        return new int[]{i, j};
      }
      else if(sortedNums[left] + sortedNums[right] == target)
        right --;
      else
        left ++;
    }
    return null;
  }

  /**
   * Determine two indices in the nums array that add up to the target in O(n) times
   * Time Complexity: O(n)
   * Justification: Single loop through all values in the array, and Map.containsKey is constant time
   */
  public int[] fastTwoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i  ++) {
      if (map.containsKey((target - nums[i])))
        return (map.get((target - nums[i])) > i) ? new int[]{i, map.get((target - nums[i]))} : new int[]{map.get((target - nums[i])), i};
      else
        map.put(nums[i],i);
    }
    return null;
  }
}
