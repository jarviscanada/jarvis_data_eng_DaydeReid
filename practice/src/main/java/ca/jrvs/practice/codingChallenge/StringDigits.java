package ca.jrvs.practice.codingChallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containing functions to determine if a string contains only digits
 * Relevant Ticket: https://www.notion.so/Check-if-a-String-contains-only-digits-e088f906c2de446a80748cd44180fe6d
 */
public class StringDigits {

  /**
   * Determine if a string contains only digits using ASCII
   * Time Complexity:
   * Justification:
   */
  public boolean isOnlyDigitsAscii(String string) {
    if(string == null)
      return false;
    for(int i = 0; i < string.length(); i ++) {
      int charAscii = (int) string.charAt(i);
      if (charAscii < ((int) '0') || charAscii > ((int) '9'))
        return false;
    }
    return true;
  }

  /**
   * Determine if a string contains only digits using Java APIs
   * Time Complexity: O(n)
   * Justification: Running time of valueOf for both Integer and Long is O(n)
   */
  public boolean isOnlyDigitsApi(String string) {
    try {
      Integer.valueOf(string);
      return true;
    } catch (NumberFormatException ex) {
      try {
        Long.valueOf(string);
        return true;
      } catch (NumberFormatException ex2) {
        return false;
      }
    }
  }

  /**
   * Determine if a string contains only digits using a regex
   * Time Complexity: O(n)
   * Justification: Java regex use a finite state machine, which accepts the string, going through each character in it
   */
  public boolean isOnlyDigitsRegex(String string) {
    Pattern pattern = Pattern.compile("^[0-9]+$");
    Matcher matcher = pattern.matcher(string);
    return matcher.matches();
  }
}
