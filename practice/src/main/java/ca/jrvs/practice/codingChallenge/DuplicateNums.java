package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class containing functions to determine which number in an array is duplicated
 * Relevant Ticket: https://www.notion.so/Find-the-Duplicate-Number-343e1f35c117463da2f098959a5b3612
 */
public class DuplicateNums {

  /**
   * Find the duplicate number in the list by sorting it
   * Time Complexity: O(n*log(n))
   * Justification: Java sort has O(n*log(n)) time complexity
   */
  public int duplicateNum(Integer[] array) {
    List<Integer> numList = Arrays.asList(array);
    Collections.sort(numList);
    int prev = -9999;
    for(int num : numList) {
      if(num == prev) {
        return num;
      }
      prev = num;
    }
    throw new IllegalArgumentException("ERROR: List contains no duplicate numbers");
  }

  /**
   * Find the duplicate number in the list by using a set
   * Time Complexity: O(n)
   * Justification: Each number is visited once, set.contains is constant time
   */
  public int fastDuplicateNum(Integer[] array) {
    Set<Integer> numSet = new HashSet<>();
    for(int num : array) {
      if (numSet.contains(num)) {
        return num;
      }
      numSet.add(num);
    }
    throw new IllegalArgumentException("ERROR: List contains no duplicate numbers");
  }
}
