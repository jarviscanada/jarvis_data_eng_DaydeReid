package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to print a string of letters with their numeric IDs
 * Relevant Ticket: https://www.notion.so/Print-letter-with-number-90d0684d0bb240a1968c9fba9845b30c
 */
public class LetterWithNumber {

  /**
   * Print the numeric ID for each letter in the string after the char
   * Time Complexity: O(n)
   * Justification: Single loop through all characters in the string
   */
  public void printWithNumbers(String letters) throws IllegalArgumentException {
    char[] chars = letters.toCharArray();
    String out = "";
    for (char ch : chars) {
      int chInt = ch;
      if(chInt >= (int) 'a' && chInt <= (int) 'z') {
        out = out + ch + (chInt - 96);
      } else if (chInt >= (int) 'A' && chInt <= (int) 'Z') {
        out = out + ch + (chInt - 64 + 26);
      } else {
        throw new IllegalArgumentException("ERROR: String contains non-letter characters");
      }
    }
    System.out.print(out);
  }

}
