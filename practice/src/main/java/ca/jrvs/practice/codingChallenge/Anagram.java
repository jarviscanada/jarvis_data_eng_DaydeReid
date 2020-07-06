package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class containing functions to determine if a string is a valid anagram of another
 * Relevant Ticket: https://www.notion.so/Valid-Anagram-0909957df9634eec827cc216006656ff
 */
public class Anagram {

  /**
   * Determine if the first string is an anagram of the second by sorting both
   * Time Complexity: O(n*log(n))
   * Justification: Java's sort algorithm has O(n*log(n)) time complexity
   */
  public boolean sortedIsAnagram(String s1, String s2) {
    char[] s1Array = s1.toLowerCase().toCharArray();
    char[] s2Array = s2.toLowerCase().toCharArray();
    Arrays.sort(s1Array);
    Arrays.sort(s2Array);
    return Arrays.equals(s1Array, s2Array);
  }

  /**
   * Determine if the first string is an anagram of the second in O(n) time
   * Time Complexity: O(n)
   * Justification: Map inserts/reads have O(1) time, so read/writing each char in each string is O(n) for both, which combined makes O(n)
   */
  public boolean fastIsAnagram(String s1, String s2) {
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    Map<Character, Integer> map = new HashMap<>();
    if(s1.length() != s2.length())
      return false;

    for(int i = 0; i < s1.length(); i ++) {
      char c = s1.charAt(i);
      if(map.containsKey(c))
        map.put(c, map.get(c) + 1);
      else
        map.put(c, 1);
    }

    for(int i = 0; i < s2.length(); i ++) {
      char c = s2.charAt(i);
      if(!map.containsKey(c))
        return false;
      else {
        map.put(c, map.get(c) - 1);
        if (map.get(c) < 0)
          return false;
      }
    }
    return true;
  }
}
