package ca.jrvs.practice.codingChallenge;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Class containing functions to ensure a string's parentheses all match
 * Relevant Ticket: https://www.notion.so/Valid-Parentheses-c92aa2039f5a4bc0afa0d8470fa87e18
 */
public class ValidParentheses {

  /**
   * Ensure all instances of (, [, and { have a matching closing parenthesis afterwards in the string
   * Time Complexity: O(n)
   * Justification: Must go through each char in the string
   */
  public boolean hasValidParentheses(String string) {

    Map<Character, Stack<Character>> map = new HashMap<>();
    map.put('(', new Stack<Character>());
    map.put('[', new Stack<Character>());
    map.put('{', new Stack<Character>());

    for (int i = 0; i < string.length(); i ++) {
      char c = string.charAt(i);
      switch(c) {
        case '(':
          map.get(c).push(c);
          break;
        case '[':
          map.get(c).push(c);
          break;
        case '{':
          map.get(c).push(c);
          break;
        case ')':
          try {
            map.get('(').pop();
          } catch (EmptyStackException ex) {
            return false;
          }
          break;
        case ']':
          try {
            map.get('[').pop();
          } catch (EmptyStackException ex) {
            return false;
          }
          break;
        case '}':
          try {
            map.get('{').pop();
          } catch (EmptyStackException ex) {
            return false;
          }
          break;
        default:
          break;
      }
    }

    return (map.get('(').empty() && map.get('[').empty() && map.get('{').empty());
  }
}
