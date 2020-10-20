package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to determine if one string can become another after a number of shifts
 * Relevant Ticket: https://www.notion.so/Rotate-String-f859beb3d711418aa9af858778964bff
 */
public class RotateString {

  /**
   * Determine the the first string can become the second after any number of shifts
   * Time Complexity: O(n)
   * Justification: Must check every possible shift position, of which there is one for each char in the string
   */
  public boolean isRotatable(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.equals(s2)) {
      return true;
    }
    for (int i = 0; i < s1.length(); i++) {
      s1 = shift(s1);
      if (s1.equals(s2)) {
        return true;
      }
    }
    return false;
  }

  private String shift(String s) {
    return s.substring(1) + s.charAt(0);
  }
}
