package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.Map;

/**
 * Class containing functions to calculate the Fibonacci number at the given index
 * Relevant Ticket: https://www.notion.so/Fibonacci-Number-Climbing-Stairs-7488f6d4ca64447c83a76c62bde3ec77
 */
public class Fibonacci {

  private int[] previousArray;
  /**
   * Determine the ith Fibonacci number using recursion
   * Time Complexity: O(2^n)
   * Justification: The recursion tree for this function would have height n, with each row having double the number of nodes as the last
   */
  public int recursiveFibonacci(int i) {
    return (i == 0) ? 0 : (i == 1) ? 1 : (recursiveFibonacci(i - 1) + recursiveFibonacci(i - 2));
  }

  /**
   * Determine the ith Fibonacci number using dynamic programming
   * Time Complexity: O(n)
   * Justification: To calculate the nth Fibonacci number, each Fibonacci number before it is calculated once
   */
  public int dynamicFibonacci(int i) {
    previousArray = new int[i];
    if(i == 0) {
      return 0;
    } else if (i == 1) {
      return 1;
    } else {
      return (dynamicFibonacciHelper(i - 1) + dynamicFibonacciHelper(i - 2));
    }
  }

  private int dynamicFibonacciHelper(int i) {
    if(i == 0) {
      return 0;
    } else if (i == 1) {
      return 1;
    } else if(previousArray[i] != 0) {
      return previousArray[i];
    } else {
      int answer = dynamicFibonacciHelper(i - 1) + dynamicFibonacciHelper(i - 2);
      previousArray[i] = answer;
      return answer;
    }
  }
}
