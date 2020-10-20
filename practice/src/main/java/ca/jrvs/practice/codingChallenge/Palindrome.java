package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to determine if a string is a valid palindrome
 * Relevant Ticket: https://www.notion.so/Valid-Palindrome-08baf00094414f599fd3ab975b2fa8fd
 */
public class Palindrome {

  /**
   * Determine if the string is a valid palindrome using two pointers
   * Time Complexity: O(n)
   * Justification: TMust check compare each char in the string to another
   */
  public boolean isPalindromePointers(String s) {
    s = s.toLowerCase();
    int low = 0;
    int high = s.length() - 1;
    while (low < high) {
      if (s.charAt(low) != s.charAt(high))
        return false;
      low ++;
      high --;
    }
    return true;
  }

  /**
   * Determine if the string is a valid palindrome using recursion
   * Time Complexity: O(n)
   * Justification: One recursion for every pair of chars in the string is n/2, which becomes O(n)
   */
  public boolean isPalindromeRecursive(String s) {
    s = s.toLowerCase();
    if (s.length() == 1) {
      return true;
    } else if (s.length() == 2) {
      return (s.charAt(0) == s.charAt(1));
    } else {
      return (s.charAt(0) == s.charAt(s.length() - 1) && isPalindromeRecursive(
          s.substring(1, s.length() - 1)));
    }
  }
}
