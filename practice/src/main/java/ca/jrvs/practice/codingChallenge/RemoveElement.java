package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to remove a specified element from an array
 * Relevant Ticket: https://www.notion.so/Remove-Element-8ad9de1dafea4027b9e03b68969dca33
 */
public class RemoveElement {

  /**
   * Remove all the entries with the given value from the array, then return the new length
   * Time Complexity: O(n)
   * Justification: Every element in the array is visited once
   */
  public int removeElement(int[] nums, int value) {
      int i = 0;
      for(int j = 0; j < nums.length; j ++) {
        if (nums[j] != value) {
          nums[i] = nums[j];
          i ++;
        }
      }
      return i;
  }
}
