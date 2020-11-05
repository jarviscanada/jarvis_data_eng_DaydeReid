package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to swap two numbers' positions
 * Relevant Ticket: https://www.notion.so/Swap-two-numbers-f9176f5724904039a34a7e267f8ed9c6
 */
public class NumberSwap {

  /**
   * Swap the numbers' positions using bit operations
   * Time Complexity: O(1)
   * Justification: Fixed number of bit operations
   */
  public int[] swapNumbersBitwise(int[] numbers) throws IllegalArgumentException {
    if (numbers.length != 2)
      throw new IllegalArgumentException("ERROR: Array must contain exactly 2 numbers");
    numbers[0] = numbers[0] ^ numbers[1];
    numbers[1] = numbers[0] ^ numbers[1];
    numbers[0] = numbers[0] ^ numbers[1];
    return numbers;
  }

  /**
   * Swap the numbers' positions using arithmetic operations
   * Time Complexity: O(1)
   * Justification: Fixed number of arithmetic operations
   */
  public int[] swapNumbersArithmetic(int[] numbers) throws IllegalArgumentException {
    if (numbers.length != 2)
      throw new IllegalArgumentException("ERROR: Array must contain exactly 2 numbers");
    numbers[0] = numbers[0] + numbers[1];
    numbers[1] = numbers[0] - numbers[1];
    numbers[0] = numbers[0] - numbers[1];
    return numbers;
  }
}
