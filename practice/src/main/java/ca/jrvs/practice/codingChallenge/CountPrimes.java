package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to count the number of prime between 0 and the given variable
 * Relevant Ticket: https://www.notion.so/Count-Primes-5d6b8e2fc1f04decb1155c447fb958e5
 */
public class CountPrimes {

  /**
   * Count the number of primes between zero and n
   * Time Complexity: O(n^2)
   * Justification: For each number between 0 and n, need to see if it is divisible by every number already looked at
   */
  public int countPrimes(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("ERROR: n must be greater than 0");
    } else if (n < 3) {
      return 0;
    }
    int count = 1;
    for (int i = 3; i < n; i++) {
      int prime = 1;
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          prime = 0;
          break;
        }
      }
      count += prime;
    }
    return count;
  }
}
