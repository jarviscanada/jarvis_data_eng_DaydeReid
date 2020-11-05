package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class containing functions to determine which characters in a string are duplicated
 * Relevant Ticket: https://www.notion.so/Duplicate-Characters-ba5d97ffe2d6460eac48ec4bc760ceab
 */
class DuplicateChars {

  /**
   * Find all the duplicate chars in the string
   * Time Complexity: O(n)
   * Justification: Each char in the string is visited once, finding map keys is constant time
   */
  public Character[] duplicateChars(String s) {
    List<Character> dupes = new ArrayList<>();
    Map<Character, Boolean> charMap = new HashMap<>();
    for (int i  = 0; i < s.length(); i ++) {
      if(charMap.containsKey(s.charAt(i))) {
        dupes.add(s.charAt(i));
      } else {
        charMap.put(s.charAt(i), true);
      }
    }
    Character[] dupesList = new Character[dupes.size()];
    return dupes.toArray(dupesList);
  }
}
