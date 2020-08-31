package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Class containing functions to determine if an array contains duplicate integers
 * Relevant Ticket: https://www.notion.so/Contains-Duplicate-1bf6387207074edeb39a98872c6b7f17
 */
public class ContainsDuplicate {

  /**
   * Determine if the list contains any duplicates by looping through the for each entry
   * Time Complexity: O(n^2)
   * Justification: For each element in the array, potentially check every other element in the array
   */
  public boolean containsDuplicate(int[] nums) {
    for(int i = 0; i < nums.length; i ++) {
      for (int j = i + 1; j < nums.length; j ++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Determine if the list contains any duplicates by using a  set
   * Time Complexity: O(n)
   * Justification: For each element, check if its already in the set (O(1) time), then add it to the set
   */
  public boolean containsDuplicateSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i ++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
    }
    return false;
  }
}
