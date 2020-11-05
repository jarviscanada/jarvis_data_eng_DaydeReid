package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing functions to remove duplicate numbers from a sorted list
 * Relevant Ticket: https://www.notion.so/Duplicates-from-Sorted-Array-0d7ac947087a4829b9980e47de520b8b
 */
public class RemoveDuplicates {
  /**
   * Remove all duplicate numbers froma sorted list of integers
   * Time Complexity: O(n)
   * Justification: Single loop through all entries in list
   */
  public List<Integer> removeDuplicates(List<Integer> nums) {
    Integer prev = null;
    for(int i = 0; i < nums.size(); i ++) {
      if (nums.get(i) == prev) {
        nums.remove(i);
      } else {
        prev = nums.get(i);
      }
    }
    return nums;
  }
}
