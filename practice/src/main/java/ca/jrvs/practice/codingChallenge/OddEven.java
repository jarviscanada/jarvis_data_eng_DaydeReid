package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to determine if an int is odd or even
 * Relevant Ticket: https://www.notion.so/Sample-Check-if-a-number-is-even-or-odd-acf139238b41451ba902b08cb33579e5
 */
public class OddEven {

  /**
   * Determine if an int is odd or even using modulo
   * Time Complexity: O(1)
   * Justification: It is a single modulo operation
   */
  public String oddEvenModulo(int i) {
    return (i % 2 == 1) ? "Odd" : "Even";
  }

  /**
   * Determine if an int is odd or even using the XOR operator
   * Time Complexity: O(1)
   * Justification: It is a single XOR operation
   */
  public String oddEvenXOR(int i) {
    return ((i ^ 1) != (i + 1)) ? "Odd" : "Even";
  }

}