package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumTest {

  @Test
  public void bruteForceTwoSum() {
    TwoSum twoSum = new TwoSum();
    int[] testArray = new int[]{3, 6, 9, 1};
    int[] answer = twoSum.bruteForceTwoSum(testArray, 12);
    assertEquals("First index should be 0",0, answer[0]);
    assertEquals("Second index should be 2",2, answer[1]);
    assertEquals("No indices that add up to 29", null, twoSum.bruteForceTwoSum(testArray, 29));
  }

  @Test
  public void sortedTwoSum() {
    TwoSum twoSum = new TwoSum();
    int[] testArray = new int[]{3, 6, 9, 1};
    int[] answer = twoSum.sortedTwoSum(testArray, 12);
    assertEquals("First index should be 0",0, answer[0]);
    assertEquals("Second index should be 2",2, answer[1]);
    assertEquals("No indices that add up to 29", null, twoSum.sortedTwoSum(testArray, 29));
  }

  @Test
  public void fastTwoSum() {
    TwoSum twoSum = new TwoSum();
    int[] testArray = new int[]{3, 6, 9, 1};
    int[] answer = twoSum.fastTwoSum(testArray, 12);
    assertEquals("First index should be 0",0, answer[0]);
    assertEquals("Second index should be 2",2, answer[1]);
    assertEquals("No indices that add up to 29", null, twoSum.fastTwoSum(testArray, 29));
  }
}