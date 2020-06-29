package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to convert a string to an integer Relevant Ticket:
 * https://www.notion.so/String-to-Integer-atoi-82ec747728674a5d8651dfe1addadd99
 */
public class StringToInteger {

  /**
   * Convert the given string to an integer using Integer.parseInt()
   * Time Complexity: O(n)
   * Justification: Integer.parseInt()'s complexity is O(n)
   */
  public Integer stringToIntegerParse(String string) {
    try {
      return Integer.parseInt(string);
    } catch (NumberFormatException ex) {
      return null;
    }
  }

  /**
   * Convert the given string to an integer without using Integer.parseInt()
   * Time Complexity: O(n)
   * Justification: Function must loop through every char in the string
   */
  public Integer stringToIntegerAscii(String string) {
    if (string.charAt(0) != '-' && string.charAt(0) != '+' && !isNumber(string.charAt(0))) {
      return null;
    } else {
      boolean isNegative = false;
      if (!isNumber(string.charAt(0))) {
        isNegative = (string.charAt(0) == '-');
        string = string.substring(1);
      }
      Integer answer =  0;
      for (int i = 0; i < string.length(); i ++) {
        if (isNumber(string.charAt(i))) {
          answer *= 10;
          answer += (string.charAt(i) - '0');
        } else {
          return null;
        }
      }
      return isNegative ? -answer : answer;
    }
  }

  private boolean isNumber (char c) {
    return (c >= '0' && c <= '9');
  }
}
